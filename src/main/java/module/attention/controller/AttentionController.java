package module.attention.controller;

import common.Resource;
import model.DataResponse;
import module.attention.model.AttentionViewModel;
import module.attention.model.web.AttentionGroupInfoRespModel;
import module.attention.service.mob.AttentionMobService;
import module.attention.service.web.AttentionService;
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
public class AttentionController {

    private static final String TAG = AttentionController.class.getSimpleName();


    @RequestMapping("/attention")
    public String enterAttention(){
        System.out.println("enter attention");
        return "attention";
    }


    // 失败：{"attention_bonus_num":-5,"bonus_type":2,"attention_type":0,"attention_duration":"5:00","s_id":"","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_status":-3}
    // 成功：{"attention_bonus_num":5,"bonus_type":2,"attention_type":0,"attention_duration":"0:10","s_id":"","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_status":1}
    @RequestMapping(value = "/mob/attention/AttentionResultCheck2", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<AttentionViewModel> checkStudentAttention(HttpServletRequest request){
//
//        AttentionMobService service = new AttentionMobService();
//        return service.checkStudentAttention(params);


        DataUtils.printRequestBodyStr(TAG + ", checkStudentAttention", request);
//        String attentionType = null;
//        String attentionId = null;
//
//        if(params.containsKey(Resource.KEY.KEY_ATTENTION_ID)){
//            attentionId = params.get(Resource.KEY.KEY_ATTENTION_ID);
//        }
//
//        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
//            attentionType = params.get(Resource.KEY.KEY_ATTENTION_TYPE);
//        }

        String attentionId = "565caed7-dfa6-468f-9c1c-352adc789bb2";
        AttentionViewModel attentionViewModel = constructAttentionViewModel(attentionId);

        DataResponse<AttentionViewModel> response = new DataResponse<AttentionViewModel>(200,"success");
        response.setData(attentionViewModel);
        return response;
    }



    // 失败：{"attention_bonus_num":-5,"bonus_type":2,"attention_type":0,"attention_duration":"5:00","s_id":"","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_status":-3}
    // 成功：{"attention_bonus_num":5,"bonus_type":2,"attention_type":0,"attention_duration":"0:10","s_id":"","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_status":1}

    // {"attention_bonus_num":-5,"bonus_type":2,"attention_type":1,"open_class_id":"571549d3-c720-4fa5-b8fa-d95e2b9f7456","attention_duration":"10:00","s_id":"02230447-e12d-434f-a3ff-b9a48966397e","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_insist_time":3062,"attention_status":-3}
    @RequestMapping(value = "/mob/attention/AttentionResultCheck", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<AttentionViewModel> checkStudentAttention(@RequestBody Map<String, String> params){

        AttentionMobService service = new AttentionMobService();
        return service.checkStudentAttention(params);


//        DataUtils.printRequestBodyStr(TAG + ", checkStudentAttention", request);
//        String attentionType = null;
//        String attentionId = null;
//
//        if(params.containsKey(Resource.KEY.KEY_ATTENTION_ID)){
//            attentionId = params.get(Resource.KEY.KEY_ATTENTION_ID);
//        }
//
//        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
//            attentionType = params.get(Resource.KEY.KEY_ATTENTION_TYPE);
//        }
//
//        attentionId = "565caed7-dfa6-468f-9c1c-352adc789bb2";
//        AttentionViewModel attentionViewModel = constructAttentionViewModel(attentionId);
//
//        DataResponse<AttentionViewModel> response = new DataResponse<AttentionViewModel>(200,"success");
//        response.setData(attentionViewModel);
//        return response;
    }


    private AttentionViewModel constructAttentionViewModel(String attentionId){
        AttentionViewModel model = new AttentionViewModel();
        model.setmAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_SUCCESS);
        model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        model.setmCourseId("ae70ec5c-0a61-4275-ae7d-ad247154155b");
        model.setmDataFrom(Resource.DATA_FROM.DATA_FROM_REQUEST);
        model.setmAttentionId(attentionId);
        Date date = new Date();
        model.setmAttentionTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS));
        model.setmAttentionBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        model.setmAttentionBonusNum(Resource.BONUS_NUM.ATTENTION_BONUS_NUM);

        return model;

    }


    // {"group_name":"队名0,队名1,队名3,","attention_duration":"5:00","attention_type":2,"t_id":"1234","c_id":"course789","attention_time":"2017-04-08 20:10:15","attention_student_need_score":true}
    //
    @RequestMapping(value = "/web/attention/groupAttentionBegin", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> beginGroupAttention(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + "beginGroupAttention", request);


        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
        Map<String, Integer> data = new HashMap<String, Integer>();
        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_BEGIN);
        response.setData(data);

        return response;
    }




    // {"attention_duration":"5:00","attention_type":1,"t_id":"1234","c_id":"course789", "attention_time":"2017-04-07 22:12:48"}
    @RequestMapping(value = "/web/attention/normalAttentionBegin", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> beginNormalAttention(@RequestBody Map<String, String> params){

        AttentionService service = new AttentionService();
        return service.beginNormalAttention(params);

//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> data = new HashMap<String, Integer>();
//        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_BEGIN);
//        response.setData(data);
//
//        return response;
    }


//    // {"attention_duration":"5:00","attention_type":1,"t_id":"1234","c_id":"course789", "attention_time":"2017-04-07 22:12:48"}
//    @RequestMapping(value = "/web/attention/normalAttentionBegin", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<Map<String, Integer>> beginNormalAttention(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + "beginNormalAttention", request);
//
//
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> data = new HashMap<String, Integer>();
//        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_BEGIN);
//        response.setData(data);
//
//        return response;
//    }



    // 用于专注的中途终止和重新一轮，无论按哪个按钮，都要先结束本轮专注，然后前端再主动调起开始专注时，和刚开始的流程一样
    // {"t_id":"1234","c_id":"course789","attention_end_time":"2017-04-07 22:14:45", "open_class_id":""}
    // 专注时间到导致的结束，先检测专注状态，对开始的专注才做修改
    @RequestMapping(value = "/web/attention/normalAttentionEnd", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> endNormalAttention(@RequestBody Map<String, String> params){

        AttentionService service = new AttentionService();
        return service.endNormalAttention(params);
    }

//    // 用于专注的中途终止和重新一轮，无论按哪个按钮，都要先结束本轮专注，然后前端再主动调起开始专注时，和刚开始的流程一样
//    // {"t_id":"1234","c_id":"course789","attention_end_time":"2017-04-07 22:14:45", "open_class_id":""}
//    // 专注时间到导致的结束，先检测专注状态，对开始的专注才做修改
//    @RequestMapping(value = "/web/attention/normalAttentionEnd", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<Map<String, Integer>> endNormalAttention(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + "endNormalAttention", request);
//
//
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> data = new HashMap<String, Integer>();
//        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_END);
//        response.setData(data);
//
//        return response;
//    }

    // {"t_id":"1234","c_id":"d276a696-1956-4fb2-b193-f393e636d940"}
    //
    @RequestMapping(value = "/web/attention/prepareGroupAttention", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<AttentionGroupInfoRespModel>> prepareGroupAttention(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + "prepareGroupAttention", request);

        DataResponse<List<AttentionGroupInfoRespModel>> response = new DataResponse<List<AttentionGroupInfoRespModel>>(200,"no reason");

        List<AttentionGroupInfoRespModel> models = new LinkedList<AttentionGroupInfoRespModel>();
        for(int i=0;i<8;i++){
            AttentionGroupInfoRespModel groupInfoRespModel = new AttentionGroupInfoRespModel();
            groupInfoRespModel.setGroupId(DBUtil.generateUUID());
            groupInfoRespModel.setGroupName("队名" + i);
            models.add(groupInfoRespModel);
        }


        response.setData(models);

        return response;
    }




//    public DataResponse<AttentionGoingModel> onAttentionGoing(HttpServletRequest request){
//
//    }








    @RequestMapping(value = "/web/focus/NormalBegin", method = {RequestMethod.POST})
    @ResponseBody
    public DataResponse<Void> attentionBegin(@RequestBody Map<String, String> params){

//        String jsonMsg = originTest(params);

        AttentionService service = new AttentionService();
        DataResponse<Void> response = service.handleAttentionBegin(params);

        return response;
    }


    private String originTest(Map<String, String> params){
        String teacherId = null;
        String courseId = null;
        String attentionDuration = null;
        int attentionType = -1;
        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_DURATION)){
            attentionDuration = params.get(Resource.KEY.KEY_ATTENTION_DURATION);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
            String typeStr = params.get(Resource.KEY.KEY_ATTENTION_TYPE);
            attentionType = Integer.valueOf(typeStr);
        }

        handleDB(teacherId, courseId, attentionDuration, attentionType);


        AttentionViewModel model = constructModel(attentionDuration, courseId, teacherId);

        String jsonMsg = JsonUtil.objToJSON(model);

        PushUtil.pushMessageAndNotification(jsonMsg, Resource.Notification.ATTENTION_CHECK_NOTIFICATION);

        return jsonMsg;
    }






    private AttentionViewModel constructModel(String duration, String courseId, String teacherId){
        AttentionViewModel model = new AttentionViewModel();
        model.setmCourseId(courseId);
        model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        model.setmAttentionBonusNum(10);
        model.setmAttentionFocusCount(10);
        model.setmAttentionLostFocusCount(3);
        model.setmAttentionDuration(duration);
        model.setmAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_NOT_PAY_ATTENTION);
        Date date = new Date();
        String timeStr = TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM);
        model.setmAttentionTime(timeStr);
        return model;
    }

    private void handleDB(String teacherId, String courseId, String attentionDuration, int type){}


    private void readDataFromParams(Map<String, String> params){
        if(params == null){
            return;
        }



    }
}
