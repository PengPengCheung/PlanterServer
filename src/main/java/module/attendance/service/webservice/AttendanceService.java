package module.attendance.service.webservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Resource;
import dao.logic.AttendanceDAO;
import entity.TeacherCourseAttendanceTableEntity;
import io.goeasy.GoEasy;
import model.DataResponse;
import module.attendance.model.AttendanceCheckWebResponseViewModel;
import module.attendance.model.AttendanceViewModel;
import module.attendance.model.web.AttendanceWebRequestViewModel;
import module.attendance.model.web.AttendanceWebResponseViewModel;
import utils.*;

import java.util.Date;
import java.util.Map;

/**
 * Created by peng on 2017/3/27.
 */
public class AttendanceService {

    // {"attendance_code":"106660","c_id":"course789","t_id":"1234", "open_class_id":"01948d36-42b5-46ed-ab7d-07b7aa3306cb"}
    public DataResponse<AttendanceWebResponseViewModel> sendAttendanceNotification(Map<String, String> params){

        final AttendanceWebRequestViewModel requestViewModel = constructAttendanceWebReqModel(params);

        final AttendanceDAO attendanceDAO = new AttendanceDAO();
        final TeacherCourseAttendanceTableEntity entity = attendanceDAO.insertTeacherSendAttendanceCodeRecord(requestViewModel);
        TimeUtil.startTimeTask(30000, new CountDownListener() {
            public void onCountDownEnd() {
                // 发送倒计时结束标志到前端
                CommonUtil.printLog("countDownEnd");
                TeacherCourseAttendanceTableEntity teacherCourseAttendanceTableEntity = attendanceDAO.getTeacherCourseAttendanceInfoByAttendanceId(entity.getTeacherAttendanceId());
                Date date = new Date();
                String endTimeStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS);
                teacherCourseAttendanceTableEntity.setAttendanceEndTime(endTimeStr);
                teacherCourseAttendanceTableEntity.setAttendanceBeginStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_END);
                attendanceDAO.updateTeacherCourseAttendanceEntity(teacherCourseAttendanceTableEntity);
                int attendanceCount = teacherCourseAttendanceTableEntity.getAttendanceCount();
                int absenceCount = teacherCourseAttendanceTableEntity.getAbsenceCount();
                CommonUtil.printLog("AttendanceService attendanceCount: " + attendanceCount + ", absenceCount: " + absenceCount);
                AttendanceCheckWebResponseViewModel webResponseViewModel = constructAttendanceWebResponseModel(teacherCourseAttendanceTableEntity, requestViewModel);
                goEasyPushToWeb(webResponseViewModel);
            }
        });
        pushToStudentUsers(entity, requestViewModel);

        return constructSuccessSendNotificationResponse();

    }

    private void goEasyPushToWeb(AttendanceCheckWebResponseViewModel model){
        String jsonStr = JsonUtil.objToJSON(model);
        GoEasy goEasy = new GoEasy(Resource.GOEASY_APP_KEY);
        goEasy.publish(Resource.GOEASY_CHANNEL, jsonStr);
    }

    private AttendanceCheckWebResponseViewModel constructAttendanceWebResponseModel(TeacherCourseAttendanceTableEntity entity, AttendanceWebRequestViewModel attendanceWebRequestViewModel) {
        AttendanceCheckWebResponseViewModel webResponseViewModel = new AttendanceCheckWebResponseViewModel();
        webResponseViewModel.setEnd(true);
        webResponseViewModel.setTotalAttendanceCount(entity.getAttendanceCount());
        webResponseViewModel.setTotalAbsentCount(entity.getAbsenceCount());

        webResponseViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        webResponseViewModel.setmCourseId(attendanceWebRequestViewModel.getmCourseId());
        webResponseViewModel.setmTeacherId(attendanceWebRequestViewModel.getmTeacherId());
        return webResponseViewModel;
    }

    private DataResponse<AttendanceWebResponseViewModel> constructSuccessSendNotificationResponse(){
        DataResponse<AttendanceWebResponseViewModel> response = new DataResponse<AttendanceWebResponseViewModel>(200, "success");
        AttendanceWebResponseViewModel responseViewModel = new AttendanceWebResponseViewModel();
        responseViewModel.setAttendanceCodeSendStatus(Resource.ATTENDANCE.ATTENDANCE_NOTIFICATION_SEND_SUCCESS);
        response.setData(responseViewModel);
        return response;
    }


    private DataResponse<AttendanceWebResponseViewModel> constructFailSendNotificationResponse(){
        DataResponse<AttendanceWebResponseViewModel> response = new DataResponse<AttendanceWebResponseViewModel>(200, "fail");
        AttendanceWebResponseViewModel responseViewModel = new AttendanceWebResponseViewModel();
        responseViewModel.setAttendanceCodeSendStatus(Resource.ATTENDANCE.ATTENDANCE_NOTIFICATION_SEND_FAIL);
        response.setData(responseViewModel);
        return response;
    }


    private static AttendanceViewModel constructAttendanceViewModel(TeacherCourseAttendanceTableEntity entity, AttendanceWebRequestViewModel webRequestViewModel){
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
        attendanceViewModel.setmDataFrom(Resource.DATA_FROM.DATA_FROM_PUSH);
        attendanceViewModel.setmCourseId(webRequestViewModel.getmCourseId());
        attendanceViewModel.setmAttendanceBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        attendanceViewModel.setmAttendanceCode(webRequestViewModel.getAttendanceCode());
        attendanceViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        CommonUtil.printLog("AttendanceService constructAttendanceViewModel: " + entity.getOpenClassId());
        attendanceViewModel.setmOpenClassId(entity.getOpenClassId());
        attendanceViewModel.setmAttendanceId(entity.getTeacherAttendanceId());
        attendanceViewModel.setmAttendanceTime(entity.getAttendanceBeginTime());
        attendanceViewModel.setmAttendanceValidDuration(TimeUtil.ATTENDANCE_TIME_LIMIT_STR);
//        attendanceViewModel.setmAttendanceCount(10);
//        attendanceViewModel.setmAbsenceCount(11);
        attendanceViewModel.setmAttendanceBonusNum(Resource.BONUS_NUM.ATTENDANCE_BONUS_NUM);
        attendanceViewModel.setmAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT);

        return attendanceViewModel;
    }

    private void pushToStudentUsers(TeacherCourseAttendanceTableEntity entity, AttendanceWebRequestViewModel webRequestViewModel){
        AttendanceViewModel model = constructAttendanceViewModel(entity, webRequestViewModel);

        String pushJsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            pushJsonStr = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        CommonUtil.printLog("pushJsonStr: " + pushJsonStr);
        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.ATTENDANCE_CHECK_NOTIFICATION);
    }

    private AttendanceWebRequestViewModel constructAttendanceWebReqModel(Map<String, String> params) {
        AttendanceWebRequestViewModel requestViewModel = new AttendanceWebRequestViewModel();

        if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_CODE)){
            requestViewModel.setAttendanceCode(params.get(Resource.KEY.KEY_ATTENDANCE_CODE));
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            requestViewModel.setmTeacherId(params.get(Resource.KEY.KEY_TEACHER_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            requestViewModel.setmCourseId(params.get(Resource.KEY.KEY_COURSE_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            requestViewModel.setClassOpenId(params.get(Resource.KEY.KEY_CLASS_OPEN_ID));
        }

        return requestViewModel;
    }

}
