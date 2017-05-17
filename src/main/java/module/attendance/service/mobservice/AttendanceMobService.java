package module.attendance.service.mobservice;

import common.Resource;
import dao.logic.AttendanceDAO;
import dao.logic.BaseConnectionDAO;
import dao.logic.StudentInfoDAO;
import entity.AttendanceInfoEntity;
import entity.BaseConnectionEntity;
import entity.StudentInfoEntity;
import entity.TeacherCourseAttendanceTableEntity;
import io.goeasy.GoEasy;
import model.DataResponse;
import module.attendance.model.AttendanceCheckWebResponseViewModel;
import module.attendance.model.AttendanceViewModel;
import utils.CommonUtil;
import utils.JsonUtil;
import utils.TimeUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by peng on 2017/4/20.
 */
public class AttendanceMobService {

    private String TAG = AttendanceMobService.class.getSimpleName();


    public DataResponse<AttendanceViewModel> checkStudentAttendance(Map<String, String> params){
        String studentId = null;
        String courseId = null;
        String attendanceCode = null;
        String attendanceId = null; // 这个考勤id是教师发起的考勤信息的id
        String openClassId = null;
        String attendanceTime = null;

        if(params != null){
            if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
                studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
            }
            if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
                courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            }
            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_CODE)){
                attendanceCode = params.get(Resource.KEY.KEY_ATTENDANCE_CODE);
            }

            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_ID)){
                attendanceId = params.get(Resource.KEY.KEY_ATTENDANCE_ID);
            }

            if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
                openClassId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);
            }

            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_TIME)){
                attendanceTime = params.get(Resource.KEY.KEY_ATTENDANCE_TIME);
            }
        }

        AttendanceDAO attendanceDAO = new AttendanceDAO();
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        BaseConnectionDAO baseConnectionDAO = new BaseConnectionDAO();
        AttendanceViewModel viewModel = null;
        AttendanceInfoEntity entity = null;

        // 校对时间，不在考勤时间内不再校对考勤码
        CommonUtil.printLog("AttendanceMobService attendanceTime: " + attendanceTime);
        Date attendanceCheckTime = TimeUtil.strToTime(attendanceTime, TimeUtil.ENG_PATTERN_YMD_HMS);
        boolean isOnTime = beforeEndTime(attendanceCheckTime.getTime(), getAttendanceNormalEndTime(attendanceId, attendanceDAO));
        if(isOnTime) {
            boolean validate = validateAttendanceCode(attendanceCode, openClassId);
            if(validate){
                // 考勤成功
                entity = attendanceDAO.insertAttendanceInfo(attendanceCode, Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS, attendanceTime);
                attendanceDAO.insertStudentAttendanceConnectionRecord(openClassId, entity);
                viewModel = constructAttendanceViewModel(entity, attendanceId, courseId);
                CommonUtil.printLog("AttendanceMobService attendanceId: " + attendanceId );
                TeacherCourseAttendanceTableEntity teacherCourseAttendanceTableEntity = attendanceDAO.getTeacherCourseAttendanceInfoByAttendanceId(attendanceId);
                int attendanceCount = teacherCourseAttendanceTableEntity.getAttendanceCount();
                attendanceCount++;
                CommonUtil.printLog("AttendanceMobService attendanceCount: " + attendanceCount);
                teacherCourseAttendanceTableEntity.setAttendanceCount(attendanceCount);
                attendanceDAO.updateTeacherCourseAttendanceEntity(teacherCourseAttendanceTableEntity);
            } else {
                entity = attendanceDAO.insertAttendanceInfo("", Resource.ATTENDANCE.ATTENDANCE_STATUS_FAIL, attendanceTime);
                attendanceDAO.insertStudentAttendanceConnectionRecord(openClassId, entity);
                viewModel = constructAttendanceViewModel(entity, attendanceId, courseId);
            }
        } else {
            entity = attendanceDAO.insertAttendanceInfo("", Resource.ATTENDANCE.ATTENDANCE_STATUS_NOT_IN_TIME, attendanceTime);
            attendanceDAO.insertStudentAttendanceConnectionRecord(openClassId, entity);
            viewModel = constructAttendanceViewModel(entity, attendanceId, courseId);
        }

        if(entity != null){
            CommonUtil.printLog("attendanceCheckReceive studentId: " + studentId);
            StudentInfoEntity studentInfoEntity = studentInfoDAO.getStudentInfoByStudentId(studentId);
            boolean isEnd = false;
            if(!isOnTime){
                isEnd = true;
            }

            BaseConnectionEntity baseConnectionEntity = baseConnectionDAO.selectBaseConnectionByCourseIdAndStudentId(courseId, studentId);

            String teacherId = "";
            if(baseConnectionEntity != null){
                teacherId = baseConnectionEntity.gettId();
            }
            CommonUtil.printLog("AttendanceMobService teacherId: " + teacherId);

            String studentName = null;
            if(studentInfoEntity != null){
                studentName = studentInfoEntity.getsName();
            } else {
                studentName = Resource.TEST.TEST_STU_NAME;
            }

            AttendanceCheckWebResponseViewModel model = constructWebResponseModel(courseId, teacherId, studentName, isEnd);
            goEasyPushToWeb(model);
            CommonUtil.printLog("attendanceCheckReceive 2: " + model.getmStudentId() + ", " +  model.getStudentName());
        }

        if(viewModel != null){
            CommonUtil.printLog("checkAttendance viewModel not null: " + viewModel.getmAttendanceCode());
            return constructAttendanceMobResponse(viewModel);
        }

        CommonUtil.printLog("checkAttendance viewModel null: ");
        return constructAttendanceMobResponse(new AttendanceViewModel());

    }

    private DataResponse<AttendanceViewModel> constructAttendanceMobResponse(AttendanceViewModel viewModel){
        DataResponse<AttendanceViewModel> response = new DataResponse<AttendanceViewModel>(200, "success");
        response.setData(viewModel);
        return response;

    }

    private void goEasyPushToWeb(AttendanceCheckWebResponseViewModel model){
        String jsonStr = JsonUtil.objToJSON(model);
        GoEasy goEasy = new GoEasy(Resource.GOEASY_APP_KEY);
        goEasy.publish(Resource.GOEASY_CHANNEL, jsonStr);
    }

    // 这里为何需要teacherId ?
    private AttendanceCheckWebResponseViewModel constructWebResponseModel(String courseId, String teacherId, String studentName, boolean isEnd){
        AttendanceCheckWebResponseViewModel model = new AttendanceCheckWebResponseViewModel();
        model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        model.setmCourseId(courseId);
        model.setmTeacherId(teacherId); // 不需要t_id
        model.setStudentName(studentName);
        model.setEnd(isEnd);
        return model;
    }


    private AttendanceViewModel constructAttendanceViewModel(AttendanceInfoEntity entity, String teacherAttendanceId, String courseId){
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
        attendanceViewModel.setmAttendanceId(teacherAttendanceId);
        attendanceViewModel.setmCourseId(courseId);
        attendanceViewModel.setmAttendanceBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        attendanceViewModel.setmDataFrom(Resource.DATA_FROM.DATA_FROM_REQUEST);
        attendanceViewModel.setmAttendanceCode(entity.getAttendanceCode());
        attendanceViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        attendanceViewModel.setmAttendanceTime(entity.getAttendanceDatetime());
        attendanceViewModel.setmAttendanceValidDuration(Resource.ATTENDANCE.ATTENDANCE_DURATION);
//        attendanceViewModel.setmAttendanceCount(10);
//        attendanceViewModel.setmAbsenceCount(11);
        attendanceViewModel.setmAttendanceBonusNum(entity.getAttendanceBonus());
        attendanceViewModel.setmAttendanceStatus(entity.getAttendanceStatus());

        return attendanceViewModel;

    }


    private long getAttendanceNormalEndTime(String attendanceId, AttendanceDAO attendanceDAO){

        CommonUtil.printLog(TAG + ", getAttendanceNormalEndTime attendanceId: " + attendanceId);

        TeacherCourseAttendanceTableEntity entity = attendanceDAO.getTeacherCourseAttendanceInfoByAttendanceId(attendanceId);
        if(entity == null){
            CommonUtil.printLog("entity null");
        }
        Date date = TimeUtil.strToTime(entity.getAttendanceBeginTime(), TimeUtil.ENG_PATTERN_YMD_HMS);
        int duration = TimeUtil.durationStrToMilliSeconds(Resource.ATTENDANCE.ATTENDANCE_DURATION);
        CommonUtil.printLog("getAttendanceNormalEndTime duration: " + duration);
        long endTime = date.getTime() + duration;
        CommonUtil.printLog("getAttendanceNormalEndTime endTime: " + endTime);
        return endTime;
    }

    private boolean beforeEndTime(long currentTime, long endTime){
        CommonUtil.printLog("beforeEndTime currentTime: " + currentTime + ", endTime: " + endTime);
        return currentTime <= endTime;
    }

    private boolean validateAttendanceCode(String attendanceCode, String openClassId){
        boolean isAttendanceCodeValidate = false;
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        String code = attendanceDAO.getAttendanceCodeByOpenClassId(openClassId);
        if(code != null && !"".equals(code)){
            if(code.equals(attendanceCode)){
                isAttendanceCodeValidate = true;
            }
        }

        return isAttendanceCodeValidate;
    }
}
