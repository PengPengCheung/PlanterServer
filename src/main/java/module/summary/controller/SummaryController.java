package module.summary.controller;

import common.Resource;
import model.DataResponse;
import module.summary.model.SummaryAttendanceMixWebViewModel;
import module.summary.model.SummaryHistoryWebRespViewModel;
import module.summary.model.mob.SummaryViewModel;
import module.summary.service.SummaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by peng on 2017/3/20.
 */
@Controller
public class SummaryController {

    private static String TAG = SummaryController.class.getSimpleName();


    // 查看该课程的往期考勤和反馈情况  {"c_id":"course789","t_id":"1234"}
    @RequestMapping(value = "/web/summary/getSummaryAndAttendanceHistory", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<SummaryAttendanceMixWebViewModel>> getSummaryAndAttendanceHistoryList(@RequestBody Map<String, String> params){

        SummaryService service = new SummaryService();
        return service.checkAttendanceAndSummaryHistory(params);




//        DataResponse<List<SummaryAttendanceMixWebViewModel>> response = new DataResponse<List<SummaryAttendanceMixWebViewModel>>(200, "no reason");
//        List<SummaryAttendanceMixWebViewModel> models = new LinkedList<SummaryAttendanceMixWebViewModel>();
//        for(int i=0;i<10;i++){
//            SummaryAttendanceMixWebViewModel responseModel = new SummaryAttendanceMixWebViewModel();
//            responseModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
//            responseModel.setmCourseId(DBUtil.generateUUID());
//            responseModel.setCourseOpenDate(TimeUtil.timeToStr(new Date(), TimeUtil.ENG_PATTERN_YMD));
//            responseModel.setCourseSequence("第" + (i+1) + "次课");
//            responseModel.setAttendanceCount(20);
//            responseModel.setAbsenceCount(10);
////            responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_ALL_DONE);
//            if(i/2 == 0){
//                responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_ALL_DONE);
//            } else {
//                responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_NO_SUMMARY);
//            }
////            responseModel.setSummaryNewFiles(10);
//            models.add(responseModel);
//        }
//
//        response.setData(models);
//
//        return response;
    }




//    // 查看该课程的往期考勤和反馈情况  {"c_id":"course789","t_id":"1234"}
//    @RequestMapping(value = "/web/summary/getSummaryAndAttendanceHistory", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<SummaryAttendanceMixWebViewModel>> getSummaryAndAttendanceHistoryList(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG, request);
//
//        DataResponse<List<SummaryAttendanceMixWebViewModel>> response = new DataResponse<List<SummaryAttendanceMixWebViewModel>>(200, "no reason");
//        List<SummaryAttendanceMixWebViewModel> models = new LinkedList<SummaryAttendanceMixWebViewModel>();
//        for(int i=0;i<10;i++){
//            SummaryAttendanceMixWebViewModel responseModel = new SummaryAttendanceMixWebViewModel();
//            responseModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
//            responseModel.setmCourseId(DBUtil.generateUUID());
//            responseModel.setCourseOpenDate(TimeUtil.timeToStr(new Date(), TimeUtil.ENG_PATTERN_YMD));
//            responseModel.setCourseSequence("第" + (i+1) + "次课");
//            responseModel.setAttendanceCount(20);
//            responseModel.setAbsenceCount(10);
////            responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_ALL_DONE);
//            if(i/2 == 0){
//                responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_ALL_DONE);
//            } else {
//                responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_NO_SUMMARY);
//            }
////            responseModel.setSummaryNewFiles(10);
//            models.add(responseModel);
//        }
//
//        response.setData(models);
//
//        return response;
//    }


    // 获取某次课所有学生的反馈  {"c_id":"course789","s_id":null,"t_id":1234,"class_open_time":"2017-04-07"}
    // {"c_id":"f0fd9862-c035-48f1-a2c0-6e91d618c61c","s_id":null,"t_id":1234,"open_class_id":"43e63916-7a00-4bcc-8546-2953d2b025a2"}
    @RequestMapping(value = "/web/summary/getStudentSummaryList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<SummaryHistoryWebRespViewModel>> getAllStudentSummaryList(@RequestBody Map<String, String> params){
        SummaryService service = new SummaryService();
        return service.getStudentSummaryListForSpecialClass(params);
    }


//    // 获取某次课所有学生的反馈  {"c_id":"course789","s_id":null,"t_id":1234,"class_open_time":"2017-04-07"}
//    @RequestMapping(value = "/web/summary/getStudentSummaryList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<SummaryHistoryWebRespViewModel>> getAllStudentSummaryList(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG, request);
//
//        DataResponse<List<SummaryHistoryWebRespViewModel>> response = new DataResponse<List<SummaryHistoryWebRespViewModel>>(200, "no reason");
//        List<SummaryHistoryWebRespViewModel> modelList = new LinkedList<SummaryHistoryWebRespViewModel>();
//        for(int i=0;i<10;i++){
//
//            SummaryHistoryWebRespViewModel model = constructModel(i);
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//        return response;
//    }

    private SummaryHistoryWebRespViewModel constructModel(int i){
        SummaryHistoryWebRespViewModel model = new SummaryHistoryWebRespViewModel();
        model.setmStudentId(Resource.TEST.TEST_STU_ID);
        model.setStudentName("韩晓娜");
        model.setSummaryContent(Resource.TEST_LONG_TEXT);

        if(i/2 == 0){
            model.setSummaryResult(Resource.SUMMARY.SUMMARY_REASONABLE);
        } else {
            model.setSummaryResult(Resource.SUMMARY.SUMMARY_THANKS);
        }

        if(i == 0){
            model.setSummaryResult(Resource.SUMMARY.SUMMARY_DEFAULT);
        }

        return model;
    }


    // 教师处理某次反馈时调用，处理成功/失败 则返回一状态码
    // {"c_id":"course789","s_id":"student456","t_id":1234,"summary_result":1}
    @RequestMapping(value = "/web/summary/handleSummary", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> handleSummary(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + "handleSummary",  request);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");

        Map<String, Integer> responseParams = new HashMap<String, Integer>();

        responseParams.put(Resource.KEY.KEY_SUMMARY_WEB_HANDLE_RESULT, Resource.SUMMARY.SUMMARY_HANDLE_SUCCESS);

        response.setData(responseParams);

        return response;

    }


//    // 用于查看某位学生的总结反馈历史  {"c_id":"course789","s_id":"student456","t_id":"1234"}
//    @RequestMapping(value = "/web/summary/getSummaryHistory", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<SummaryHistoryWebRespViewModel>> getSummaryHistory(HttpServletRequest request){
//        DataUtils.printRequestBodyStr("SummaryController", request);
//        DataResponse<List<SummaryHistoryWebRespViewModel>> response = new DataResponse<List<SummaryHistoryWebRespViewModel>>(200,"desc");
//
//        List<SummaryHistoryWebRespViewModel> modelList = new LinkedList<SummaryHistoryWebRespViewModel>();
//
//        for(int i=0;i<10;i++){
//            SummaryHistoryWebRespViewModel model = new SummaryHistoryWebRespViewModel();
//            model.setmStudentId(Resource.TEST.TEST_STU_ID);
//            model.setSummaryContent(Resource.TEST_LONG_TEXT);
//            model.setSummaryResult(Resource.SUMMARY.SUMMARY_DEFAULT);
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;
//    }




    // 用于教师收集反馈
    @RequestMapping(value = "/web/summary/summarySend", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Object>> collectSummaryRequest(@RequestBody Map<String, String> params){

        SummaryService service = new SummaryService();
//        service.receiveSummary(params);
//

        return service.collectSummaryRequest(params);


//        String teacherId = null;
//        String courseId = null;
//
//        String time = null;
//
//        if(params.containsKey(Resource.KEY.KEY_SUMMARY_REQUEST_TIME)){
//            time = params.get(Resource.KEY.KEY_SUMMARY_REQUEST_TIME);
//            System.out.println(time);
//        }
//
//        handleWithDB();
//
//        SummaryViewModel model = constructViewModel();
//
//        String message = JsonUtil.objToJSON(model);
//
//        PushUtil.pushMessageAndNotification(message, Resource.Notification.SUMMARY_CHECK_NOTIFICATION);

//        return message;
    }

    //
    @RequestMapping(value = "/mob/summary/summaryReceive", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<SummaryViewModel> receiveSummary(@RequestBody Map<String, String> params){
        SummaryService service = new SummaryService();
        return service.receiveSummaryFromStudent(params);




////        SummaryService service = new SummaryService();
////        DataResponse<SummaryViewModel> model = service.receiveSummary(params);
//        DataResponse<SummaryViewModel> response = new DataResponse<SummaryViewModel>(200,"no reason");
////        String courseId = "0a564996-a618-45d7-bf4c-20e60a457185";
//        String courseId = params.get(Resource.KEY.KEY_COURSE_ID);
//        String summaryId = params.get(Resource.KEY.KEY_SUMMARY_ID);
//        SummaryViewModel model = constructSummaryViewModel(courseId, summaryId);
//        response.setData(model);
//        return response;
    }

    private SummaryViewModel constructSummaryViewModel(String courseId, String summaryId){
//        String summaryId = DBUtil.generateUUID();
        SummaryViewModel summaryViewModel = new SummaryViewModel();
        summaryViewModel.setmCourseId(courseId);
        summaryViewModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
        summaryViewModel.setmSummaryBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        summaryViewModel.setmSummaryBonusNum(10);
        summaryViewModel.setmSummaryId(summaryId);
        summaryViewModel.setmSummaryRequestTime(TimeUtil.timeToStr(new Date(), TimeUtil.CHN_PATTERN_YMD_HM));
        summaryViewModel.setmSummaryStatus(Resource.SUMMARY.SUMMARY_CHECKING);

        return summaryViewModel;
    }

    private SummaryViewModel constructViewModel(){
        SummaryViewModel model = new SummaryViewModel();
        model.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
        model.setmSummaryStatus(Resource.SUMMARY.SUMMARY_WAIT_FOR_SENDING);
        model.setmSummaryBonusNum(5);
        Date date = new Date();
        model.setmSummaryRequestTime(TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM));
        return model;
    }

    private void handleWithDB(){}



}
