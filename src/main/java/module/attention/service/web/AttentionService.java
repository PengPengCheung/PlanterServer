package module.attention.service.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Resource;
import dao.logic.AttentionDAO;
import entity.TeacherCourseAttendanceTableEntity;
import entity.TeacherCourseAttentionTableEntity;
import model.DataResponse;
import module.attendance.model.AttendanceViewModel;
import module.attendance.model.web.AttendanceWebRequestViewModel;
import module.attention.model.AttentionGoingModel;
import module.attention.model.AttentionNormalWebRequestViewModel;
import module.attention.model.AttentionViewModel;
import module.attention.model.AttentionWebViewModel;
import utils.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/27.
 */
public class AttentionService {

    AttentionDAO dao;

    public AttentionService(){
        dao = new AttentionDAO();
    }





    // {"attention_duration":"5:00","attention_type":1,"t_id":"1234","c_id":"course789", "attention_time":"2017-04-07 22:12:48", "open_class_id":"01948d36-42b5-46ed-ab7d-07b7aa3306cb"}
    public DataResponse<Map<String, Integer>> beginNormalAttention(Map<String, String> params){
        AttentionNormalWebRequestViewModel webRequestViewModel = constructNormalAttentionWebRequestViewModel(params);
        TeacherCourseAttentionTableEntity entity = dao.insertTeacherNormalAttentionInfo(webRequestViewModel);
        pushToStudentUsers(entity, webRequestViewModel);
        countDown(webRequestViewModel.getAttentionDuration(), new CountDownListener() {
            public void onCountDownEnd() {
                // 结束时发送通知到前端

            }
        });
        return constructSuccessResponse();
    }

    // {"t_id":"1234","c_id":"course789","attention_end_time":"2017-04-07 22:14:45", "open_class_id":""}
    public DataResponse<Map<String, Integer>> endNormalAttention(Map<String, String> params){
        String teacherId = null;
        String courseId = null;
        String openClassId = null;
        String attentionEndTime = null;

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            openClassId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_END_TIME)){
            attentionEndTime = params.get(Resource.KEY.KEY_ATTENTION_END_TIME);
        }

        List<TeacherCourseAttentionTableEntity> entities = dao.selectTeacherAttentionListByOpenClassId(openClassId);
        if(entities != null){
            for(TeacherCourseAttentionTableEntity entity: entities){
                if(entity.getAttentionBeginTime() != null && (entity.getAttentionEndTime() == null || "".equals(entity.getAttentionEndTime()))){ // 结束时间为空，表示该专注正在持续还没结束
                    entity.setAttentionEndTime(attentionEndTime);
                    dao.updateTeacherCourseAttentionEntity(entity);
                    CommonUtil.printLog("endNormalAttention: 1");
                    return constructEndNormalAttentionSuccessResponse();
                }
            }
        }

        return constructEndNormalAttentionFailResponse();

    }

    private DataResponse<Map<String, Integer>> constructEndNormalAttentionFailResponse(){
        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "fail");
        Map<String, Integer> data = new HashMap<String, Integer>();
        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_BEGIN);
        response.setData(data);
        return response;
    }

    private DataResponse<Map<String, Integer>> constructEndNormalAttentionSuccessResponse(){
        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "success");
        Map<String, Integer> data = new HashMap<String, Integer>();
        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_END);
        response.setData(data);
        return response;
    }

    private void countDown(String timeStr, CountDownListener listener){

        if(listener == null) {
            listener = new CountDownListener() {
                public void onCountDownEnd() {
                    CommonUtil.printLog("Attention CountDown End.");
                }
            };
        }

        int milliseconds = TimeUtil.durationStrToMilliSeconds(timeStr);
        TimeUtil.startTimeTask(milliseconds, listener);
    }

    private DataResponse<Map<String, Integer>> constructSuccessResponse(){
        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "success");
        Map<String, Integer> data = new HashMap<String, Integer>();
        data.put(Resource.KEY.KEY_ATTENTION_BEGIN_SIGNAL, Resource.ATTENTION.ATTENTION_BEGIN);
        response.setData(data);
        return response;
    }

    private void pushToStudentUsers(TeacherCourseAttentionTableEntity entity, AttentionNormalWebRequestViewModel webRequestViewModel){
        AttentionViewModel model = constructAttentionViewModel(entity, webRequestViewModel);

        String pushJsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            pushJsonStr = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.ATTENTION_CHECK_NOTIFICATION);
    }


    private static AttentionViewModel constructAttentionViewModel(TeacherCourseAttentionTableEntity entity, AttentionNormalWebRequestViewModel viewModel){
        Date date = new Date();
        AttentionViewModel attentionViewModel = new AttentionViewModel();
        attentionViewModel.setmDataFrom(Resource.DATA_FROM.DATA_FROM_PUSH);
        attentionViewModel.setmCourseId(viewModel.getmCourseId());
        attentionViewModel.setmAttentionId(entity.getTeacherCourseAttentionId());
        attentionViewModel.setmAttentionBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        attentionViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        attentionViewModel.setmAttentionTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS));
        CommonUtil.printLog("AttentionService constructAttentionViewModel: " + viewModel.getAttentionType());
        attentionViewModel.setmAttentionType(viewModel.getAttentionType());
        attentionViewModel.setmAttentionDuration(viewModel.getAttentionDuration());
//        attentionViewModel.setmAttentionFocusCount(10);
//        attentionViewModel.setmAttentionLostFocusCount(11);
        attentionViewModel.setmAttentionBonusNum(Resource.BONUS_NUM.ATTENTION_BONUS_NUM);
        attentionViewModel.setmAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_DEFAULT);
        CommonUtil.printLog("AttentionService constructAttentionViewModel: " + entity.getOpenClassId());
        attentionViewModel.setmOpenClassId(entity.getOpenClassId());

        return attentionViewModel;
    }



    private AttentionNormalWebRequestViewModel constructNormalAttentionWebRequestViewModel(Map<String, String> params){
        AttentionNormalWebRequestViewModel model = new AttentionNormalWebRequestViewModel();

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            model.setmTeacherId(params.get(Resource.KEY.KEY_TEACHER_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            model.setmCourseId(params.get(Resource.KEY.KEY_COURSE_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
            String typeStr = params.get(Resource.KEY.KEY_ATTENTION_TYPE);
            int type = Integer.parseInt(typeStr);
            model.setAttentionType(type);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_DURATION)){
            model.setAttentionDuration(params.get(Resource.KEY.KEY_ATTENTION_DURATION));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TIME)){
            model.setAttentionTime(params.get(Resource.KEY.KEY_ATTENTION_TIME));
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            model.setOpenClassId(params.get(Resource.KEY.KEY_CLASS_OPEN_ID));
        }

        return model;

    }

    public DataResponse<Void> handleAttentionBegin(Map<String, String> params){

        AttentionWebViewModel webModel = constructWebViewModel(params);
        dao.insertAttentionDAO(webModel);

        AttentionViewModel mobViewModel = constructMobViewModel(params);
        String jsonNotify = JsonUtil.objToJSON(mobViewModel);

        PushUtil.pushMessageAndNotification(jsonNotify, Resource.Notification.ATTENTION_CHECK_NOTIFICATION);

        DataResponse<Void> response = new DataResponse<Void>(Resource.STATUS_TEST.STATUS_ATTENTION_RECEIVED_SUCCESS, "专注通知已发送");

        return response;
    }



    private AttentionViewModel constructMobViewModel(Map<String, String> params){

        AttentionViewModel mobViewModel = new AttentionViewModel();
        mobViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        mobViewModel.setmAttentionBonusNum(Resource.BONUS_NUM.ATTENTION_BONUS_NUM);
        mobViewModel.setmAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_DEFAULT);

        String teacherId = null;
        String courseId = null;
        String attentionDuration = null;
        String time = null;
        int attentionType = -1;


        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
            mobViewModel.setmTeacherId(teacherId);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            mobViewModel.setmCourseId(courseId);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_DURATION)){
            attentionDuration = params.get(Resource.KEY.KEY_ATTENTION_DURATION);
            mobViewModel.setmAttentionDuration(attentionDuration);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
            String typeStr = params.get(Resource.KEY.KEY_ATTENTION_TYPE);
            attentionType = Integer.valueOf(typeStr);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TIME)){
            time = params.get(Resource.KEY.KEY_ATTENTION_TIME);
            mobViewModel.setmAttentionTime(time);
        }



        return mobViewModel;

    }

    public AttentionWebViewModel constructWebViewModel(Map<String, String> params){
        String teacherId = null;
        String courseId = null;
        String duration = null;
        String type = null;
        String time = null;

        AttentionWebViewModel model = new AttentionWebViewModel();

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
            model.setmTeacherId(teacherId);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            model.setmCourseId(courseId);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_DURATION)){
            duration = params.get(Resource.KEY.KEY_ATTENTION_DURATION);
            model.setAttentionDuration(duration);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
            type = params.get(Resource.KEY.KEY_ATTENTION_TYPE);
            int t = Integer.parseInt(type);
            model.setAttentionType(t);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TIME)){
            time = params.get(Resource.KEY.KEY_ATTENTION_TIME);
            model.setAttentionTime(time);
        }

        return model;
    }
}
