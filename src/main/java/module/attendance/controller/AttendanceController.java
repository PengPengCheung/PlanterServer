package module.attendance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Resource;
import io.goeasy.GoEasy;
import model.DataResponse;
import module.attendance.AttendanceCodeGenerator;
import module.attendance.model.*;
import module.attendance.model.web.AttendanceWebResponseViewModel;
import module.attendance.service.mobservice.AttendanceMobService;
import module.course.ClassWebResponseViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import module.attendance.service.webservice.AttendanceService;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by peng on 2017/3/16.
 */

@Controller
public class AttendanceController {

    private static final String TAG = "AttendanceController: ";
    private String mAttendanceCode;



    // 教师点击发送考勤通知，设定五分钟的时间签到，超过五分钟视为缺勤，  {"attendance_code":"106660","c_id":"course789","t_id":"1234"}
    @RequestMapping(value = "/web/attendance/check", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<AttendanceWebResponseViewModel> sendAttendanceNotification(@RequestBody Map<String, String> params){
//        DataUtils.printRequestBodyStr(TAG, request);

        AttendanceService service = new AttendanceService();

        return service.sendAttendanceNotification(params);

//        DataResponse<AttendanceWebResponseViewModel> response = new DataResponse<AttendanceWebResponseViewModel>(200, "desc");
//        AttendanceWebResponseViewModel responseViewModel = new AttendanceWebResponseViewModel();
//        responseViewModel.setAttendanceCodeSendStatus(1);
//        response.setData(responseViewModel);
//        return response;
    }






//    // 教师点击发送考勤通知，设定五分钟的时间签到，超过五分钟视为缺勤，  {"attendance_code":"106660","c_id":"course789","t_id":"1234"}
//    @RequestMapping(value = "/web/attendance/check", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<AttendanceWebResponseViewModel> sendAttendanceNotification(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG, request);
//        DataResponse<AttendanceWebResponseViewModel> response = new DataResponse<AttendanceWebResponseViewModel>(200, "desc");
//        AttendanceWebResponseViewModel responseViewModel = new AttendanceWebResponseViewModel();
//        responseViewModel.setAttendanceCodeSendStatus(1);
//        response.setData(responseViewModel);
//        return response;
//    }


    // 用于查看考勤历史，  {"c_id":"course789","t_id":"1234"}
    // 可能已废弃
    @RequestMapping(value = "/web/attendance/getHistory", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<AttendanceHistoryWebRequestViewModel>> getAttendanceHistory(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG, request);
        DataResponse<List<AttendanceHistoryWebRequestViewModel>> response = new DataResponse<List<AttendanceHistoryWebRequestViewModel>>(200, "desc");
        List<AttendanceHistoryWebRequestViewModel> models = new LinkedList<AttendanceHistoryWebRequestViewModel>();

        for(int i=0;i<10;i++){
            AttendanceHistoryWebRequestViewModel model = new AttendanceHistoryWebRequestViewModel();
            model.setStudentName("韩晓娜");
            model.setmStudentId(Resource.TEST.TEST_STU_ID);
            model.setAttendanceCount(3);
            model.setAbsenceCount(2);
            models.add(model);
        }

        response.setData(models);

        return response;
    }


    // 开课后自动获取考勤码
    // request:   {"class_open_time":"2017-04-19 19:57:05","c_id":"d276a696-1956-4fb2-b193-f393e636d940","t_id":"1234"}
    // response:
    @RequestMapping(value = "/web/attendance/getAttendanceCode", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<ClassWebResponseViewModel> getAttendanceCode(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + ", getAttendanceCode", request);
        DataResponse<ClassWebResponseViewModel> response = new DataResponse<ClassWebResponseViewModel>(200, "desc");
        ClassWebResponseViewModel responseModel = new ClassWebResponseViewModel();
        responseModel.setAttendanceCode(AttendanceCodeGenerator.generateAttendanceCode());
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put(Resource.KEY.KEY_CLASS_BEGIN_STATUS, Resource.CLASS.CLASS_STATUS_OPEN);
        response.setData(responseModel);

        return response;
    }




    private void goEasyPushToWeb(AttendanceCheckWebResponseViewModel model){
        String jsonStr = JsonUtil.objToJSON(model);
        GoEasy goEasy = new GoEasy(Resource.GOEASY_APP_KEY);
        goEasy.publish(Resource.GOEASY_CHANNEL, jsonStr);
    }


    // {"attendance_time":"2017/04/20 23:22:53","c_id":"f0fd9862-c035-48f1-a2c0-6e91d618c61c","attendance_id":"6c77eb58-71f6-4e70-81fe-ccf3b7ac9d5d","attendance_code":"106660"}
    @RequestMapping(value = "/mob/attendance/StudentCheck", method = {RequestMethod.POST})
    @ResponseBody
    public DataResponse<AttendanceViewModel> checkAttendanceCode(@RequestBody Map<String, String> params){

        AttendanceMobService service = new AttendanceMobService();
        return service.checkStudentAttendance(params);


    }


//    //
//    @RequestMapping(value = "/mob/attendance/StudentCheck", method = {RequestMethod.POST})
//    @ResponseBody
//    public DataResponse<AttendanceViewModel> checkAttendanceCode(HttpServletRequest request){
//
//        DataUtils.printRequestBodyStr(TAG + ", checkAttendanceCode: ", request);
//
//        return new DataResponse<AttendanceViewModel>(200, "no reason");
////        AttendanceMobService service = new AttendanceMobService();
////        return service.checkStudentAttendance(params);
//
//
//    }










//    @RequestMapping(value = "/mob/attendance/StudentCheck", method = {RequestMethod.POST})
//    @ResponseBody
//    public DataResponse<AttendanceViewModel> checkAttendanceCode(@RequestBody Map<String, String> params){
//        System.out.println("request URL: " + "/mob/attendance/StudentCheck");
//
//
//        String studentId = null;
//        String courseId = null;
//        String attendanceCode = null;
//        String attendanceId = null;
//
//        if(params != null){
//            if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
//                studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
//            }
//            if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
//                courseId = params.get(Resource.KEY.KEY_COURSE_ID);
//            }
//            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_CODE)){
//                attendanceCode = params.get(Resource.KEY.KEY_ATTENDANCE_CODE);
//            }
//
//            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_ID)){
//                attendanceId = params.get(Resource.KEY.KEY_ATTENDANCE_ID);
//            }
//        }
//
//        System.out.println(TAG + "mob code: " + attendanceCode);
//
//        int status = validateAttendanceCode(attendanceCode, studentId, courseId);
//
//        DataResponse<AttendanceViewModel> dataResponse = new DataResponse<AttendanceViewModel>(200, "no reason");
//
//        AttendanceViewModel info = constructAttendanceViewModel(status, attendanceId, courseId);
//
//        dataResponse.setData(info);
//
//        System.out.println(TAG + "status: " + status);
//
////        Map<String, String> responseMap = new HashMap<String, String>();
////        responseMap.put(Resource.KEY.KEY_ATTENDANCE_STATUS, String.valueOf(status));
//        return dataResponse;
//
//
//
////        String requestStr;
////        try {
////           requestStr  =  DataUtils.getRequestPostStr(request);
////           System.out.println("requestStr: " + requestStr);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        Map<String, String> params = new HashMap<String, String>();
////        params.put("response", "check success!");
////        return params;
//
//    }

    private AttendanceViewModel constructAttendanceViewModel(int status, String attendanceId, String courseId){
//        AttendanceViewModel info = new AttendanceViewModel();
//        info.setmAttendanceStatus(status);
//        info.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
//        info.setmAttendanceBonusNum(5);


//        String courseId = "0894a028-5f3b-4079-b563-304022880236";

        Date date = new Date();
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
        attendanceViewModel.setmAttendanceId(attendanceId);
        attendanceViewModel.setmCourseId(courseId);
        attendanceViewModel.setmAttendanceBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        attendanceViewModel.setmDataFrom(Resource.DATA_FROM.DATA_FROM_REQUEST);
        attendanceViewModel.setmAttendanceCode("313132");
        attendanceViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        attendanceViewModel.setmAttendanceTime(TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM));
        attendanceViewModel.setmAttendanceValidDuration("05:00");
        attendanceViewModel.setmAttendanceCount(10);
        attendanceViewModel.setmAbsenceCount(11);
        attendanceViewModel.setmAttendanceBonusNum(5);
        attendanceViewModel.setmAttendanceStatus(status);

        return attendanceViewModel;

    }

    private  int validateAttendanceCode(String attendanceCode, String studentId, String courseId){
//        int status = Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT;
//        if(mAttendanceCode != null){
//            if(mAttendanceCode.equals(attendanceCode)){
//                status = Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS;
//            }
//        }
//        return status;
        return Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS;
    }

    private void saveIntoDB(String teacherId, String courseId, String attendanceCode){
        mAttendanceCode = attendanceCode;
    }


    @RequestMapping(value = "/attendance/AttendanceInfoGet", method = RequestMethod.POST)
    @ResponseBody
    public AttendanceViewModel getAttendanceInfo(@RequestBody Map<String, String> params){
//        AttendanceService service = new AttendanceService();
//        AttendanceViewModel model = service.getAttendanceViewModelByAttendanceInfoRequest(params);
//        return model;
        return null;
    }


    //接收考勤通知和考勤码，此时考勤码已经生成
    //{"code":"123456"}
//    @RequestMapping(value = "/web/attendance/Check", method = {RequestMethod.POST})
//    @ResponseBody
    public String receiveAttendanceNotification(@RequestBody Map<String, String> params){
        System.out.println(TAG + "receive Notification");
//        System.out.println(params.get("attendance_code"));

        String teacherId = null;
        String courseId = null;
        String attendanceCode = null;
        if(params != null){
            if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
                teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
            }
            if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
                courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            }
            if(params.containsKey(Resource.KEY.KEY_ATTENDANCE_CODE)){
                attendanceCode = params.get(Resource.KEY.KEY_ATTENDANCE_CODE);
            }
        }

        System.out.println(TAG + "web code: " + attendanceCode);

        saveIntoDB(teacherId, courseId, attendanceCode);

        ObjectMapper mapper = new ObjectMapper();
        String pushJsonStr = null;
        Date date = new Date();
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
        attendanceViewModel.setmAttendanceCode(attendanceCode);
        attendanceViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        attendanceViewModel.setmAttendanceTime(TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM));
        attendanceViewModel.setmAttendanceValidDuration("05:00");
        attendanceViewModel.setmAttendanceCount(10);
        attendanceViewModel.setmAbsenceCount(11);
        attendanceViewModel.setmAttendanceBonusNum(5);
        attendanceViewModel.setmAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT);

        try {
            pushJsonStr = mapper.writeValueAsString(attendanceViewModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

//        PushUtil.push(Resource.Notification.ATTENDANCE_CHECK_NOTIFICATION, PushUtil.PUSH_TYPE_NOTIFICATION);

        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.ATTENDANCE_CHECK_NOTIFICATION);
        return attendanceCode;

    }

}
