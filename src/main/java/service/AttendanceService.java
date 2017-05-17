package service;

import common.BaseViewModel;
import common.Resource;
import dao.IStudentInfo;
import dao.logic.AttendanceDAO;
import module.attendance.model.AttendanceViewModel;
import org.apache.ibatis.session.SqlSession;
import utils.JsonUtil;
import utils.PushUtil;
import utils.TimeUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by peng on 2017/3/22.
 */
public class AttendanceService {

    private AttendanceDAO attendanceDAO;

    public AttendanceService(){
        attendanceDAO = new AttendanceDAO();
    }

    public void attendanceCodeReceived(Map<String, String> params){
        AttendanceViewModel model = convertToViewModel(params);
        saveDataIntoDB(model);
        String pushJsonStr = constructPushModelStr(model);
        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.ATTENDANCE_CHECK_NOTIFICATION);

    }


    public AttendanceViewModel getAttendanceViewModelByAttendanceInfoRequest(Map<String, String> params){
        AttendanceViewModel model = convertToViewModel(params);
        AttendanceViewModel responseModel = attendanceDAO.getAttendanceViewModelAfterCounting(model);
        return constructViewModel(responseModel);
    }

    private String getAttendanceTimeStr(AttendanceViewModel model){
        Date date = new Date();
        model.getmAttendanceTime();
        return null;
    }

    private String constructPushModelStr(AttendanceViewModel model) {

        if(model == null){
            return "";
        }

        AttendanceViewModel avm = constructViewModel(model);
        String jsonStr = JsonUtil.objToJSON(avm);
        return jsonStr;
    }

    private AttendanceViewModel constructViewModel(AttendanceViewModel model){
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
        attendanceViewModel.setmAttendanceCode(model.getmAttendanceCode());
        attendanceViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
//        attendanceViewModel.setmAttendanceTime(model.getmAttendanceTime());
        attendanceViewModel.setmAttendanceTime("05:00");
        attendanceViewModel.setmAttendanceValidDuration(Resource.ATTENDANCE.ATTENDANCE_DURATION);
        attendanceViewModel.setmAttendanceCount(model.getmAttendanceCount());
        attendanceViewModel.setmAbsenceCount(model.getmAbsenceCount());
        attendanceViewModel.setmAttendanceBonusNum(Resource.ATTENDANCE.ATTENDANCE_BONUS_NUM);
        attendanceViewModel.setmAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT);
        return attendanceViewModel;
    }

    private void saveDataIntoDB(AttendanceViewModel model) {

    }

    private AttendanceViewModel convertToViewModel(Map<String, String> params) {
        String teacherId = null;
        String courseId = null;
        String attendanceCode = null;
        String studentId = null;
        AttendanceViewModel model = new AttendanceViewModel();
        if(params != null){
            if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
                teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
                model.setmTeacherId(teacherId);
            }
            if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
                courseId = params.get(Resource.KEY.KEY_COURSE_ID);
                model.setmCourseId(courseId);
            }
            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_CODE)){
                attendanceCode = params.get(Resource.KEY.KEY_ATTENDANCE_CODE);
                model.setmAttendanceCode(attendanceCode);
            }
            if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
                studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
                model.setmStudentId(studentId);
            }
        }

        return model;
    }
}
