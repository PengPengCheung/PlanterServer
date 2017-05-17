package module.attention.service.mob;

import common.Resource;
import dao.logic.AttentionDAO;
import dao.logic.StudentInfoDAO;
import entity.AttentionInfoEntity;
import entity.StudentInfoEntity;
import io.goeasy.GoEasy;
import model.DataResponse;
import module.attendance.model.AttendanceCheckWebResponseViewModel;
import module.attention.model.AttentionGoingModel;
import module.attention.model.AttentionViewModel;
import utils.CommonUtil;
import utils.JsonUtil;
import utils.PushUtil;
import utils.TimeUtil;

import java.util.Date;
import java.util.Map;

/**
 * Created by peng on 2017/4/23.
 */
public class AttentionMobService {


//    private static void pushToWebAttentionDemo(){
//        int total = 5;
//        for(int i=0;i<total;i++){
//            AttentionGoingModel model = new AttentionGoingModel();
//            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
//            model.setmStudentId(Resource.TEST.TEST_STU_ID);
//            model.setAttentionType(Resource.ATTENTION.ATTENTION_TYPE_NORMAL);
//            model.setStudentName("韩晓娜");
//            model.setAttentionInsistTime("3:00");
//            model.setAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_FAIL);
//
//            goEasyPushToWeb(model);
//            System.out.println("name: " + model.getStudentName() + " 专注失败");
//
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for(int i=0;i<total;i++){
//            AttentionGoingModel model = new AttentionGoingModel();
//            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
//            model.setmStudentId(Resource.TEST.TEST_STU_ID);
//            model.setAttentionType(Resource.ATTENTION.ATTENTION_TYPE_NORMAL);
//            model.setStudentName("朋朋");
////            model.setAttentionInsistTime("3:00");
//            model.setAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_SUCCESS);
//            goEasyPushToWeb(model);
//            System.out.println("name: " + model.getStudentName() + " 专注成功");
//        }
//    }

     // {"attention_bonus_num":-5,"bonus_type":2,"attention_type":1,"open_class_id":"571549d3-c720-4fa5-b8fa-d95e2b9f7456","attention_duration":"10:00","s_id":"02230447-e12d-434f-a3ff-b9a48966397e","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_insist_time":3062,"attention_status":-3}
     public DataResponse<AttentionViewModel> checkStudentAttention(Map<String, String> params){
        AttentionGoingModel model = constructAttentionGoingModel(params);
        AttentionDAO attentionDAO = new AttentionDAO();
        AttentionInfoEntity attentionInfoEntity = attentionDAO.insertStudentAttentionEntity(model);
        attentionDAO.insertStudentCourseAttentionConnection(attentionInfoEntity, model.getmOpenClassId(), model.getmStudentId());
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        CommonUtil.printLog("AttentionMobService checkStudentAttention sId: " + model.getmStudentId());
        String studentName = studentInfoDAO.getStudentNameByStudentId(model.getmStudentId());
        CommonUtil.printLog("AttentionMobService checkStudentAttention studentInfoEntity == null? " + studentName);
        if(studentName != null){
            CommonUtil.printLog("AttentionMobService checkStudentAttention pushToWeb ");
            AttentionGoingModel goingModel = constructAttentionGoingModelForWeb(attentionInfoEntity, model.getmStudentId(), studentName);
            goEasyPushToWeb(goingModel);
        }

        AttentionViewModel viewModel = constructMobAttentionResponseViewModel(attentionInfoEntity, model.getmCourseId());
        DataResponse<AttentionViewModel> response = new DataResponse<AttentionViewModel>(200, "success");
        response.setData(viewModel);
        return response;

    }

    private AttentionViewModel constructMobAttentionResponseViewModel(AttentionInfoEntity entity, String courseId){
        AttentionViewModel model = new AttentionViewModel();
        model.setmAttentionStatus(entity.getAttentionStatus());
        model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        model.setmCourseId(courseId);
        model.setmDataFrom(Resource.DATA_FROM.DATA_FROM_REQUEST);
        model.setmAttentionId(entity.getAttentionId());
        Date date = new Date();
        model.setmAttentionTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS));
        model.setmAttentionBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);

        if(entity.getAttentionStatus() == Resource.ATTENTION.ATTENTION_STATUS_FAIL){
            model.setmAttentionBonusNum(-Resource.BONUS_NUM.ATTENTION_BONUS_NUM);
        } else {
            model.setmAttentionBonusNum(Resource.BONUS_NUM.ATTENTION_BONUS_NUM);
        }


        return model;

    }

    private AttentionGoingModel constructAttentionGoingModelForWeb(AttentionInfoEntity entity, String studentId, String studentName){
        AttentionGoingModel model = new AttentionGoingModel();
        model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        model.setmStudentId(studentId);
        model.setAttentionType(entity.getAttentionType());
        model.setStudentName(studentName);
        CommonUtil.printLog("AttentionMobService: " + entity.getAttentionInsistTime());
        model.setAttentionInsistTime(entity.getAttentionInsistTime());
        model.setAttentionStatus(entity.getAttentionStatus());
        model.setmStartTime(entity.getAttentionTime());
        model.setmEndTime(entity.getAttentionEndTime());
        CommonUtil.printLog("startTime: "  + entity.getAttentionTime() + ", endTime: " + entity.getAttentionEndTime() + ", insistTime: " + entity.getAttentionInsistTime());

        return model;
    }


    private void goEasyPushToWeb(AttentionGoingModel model){
        String jsonStr = JsonUtil.objToJSON(model);
        GoEasy goEasy = new GoEasy(Resource.GOEASY_APP_KEY);
        goEasy.publish(Resource.GOEASY_CHANNEL, jsonStr);
    }

    // {"attention_bonus_num":-5,"bonus_type":2,"attention_type":0,"attention_duration":"5:00","s_id":"","c_id":"ae70ec5c-0a61-4275-ae7d-ad247154155b","attention_score":-1,"attention_status":-3}
    private AttentionGoingModel constructAttentionGoingModel(Map<String, String> params){

        AttentionGoingModel model = new AttentionGoingModel();

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            model.setmCourseId(params.get(Resource.KEY.KEY_COURSE_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_BONUS_NUM)){
            String bonusStr = params.get(Resource.KEY.KEY_ATTENTION_BONUS_NUM);
            int bonusNum = Integer.parseInt(bonusStr);
            model.setmAttentionBonusNum(bonusNum);
        }

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            model.setmStudentId(params.get(Resource.KEY.KEY_STUDENT_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TYPE)){
            String attentionTypeStr =  params.get(Resource.KEY.KEY_ATTENTION_TYPE);
            int type = Integer.parseInt(attentionTypeStr);
            model.setAttentionType(type);
        }

        if(params.containsKey(Resource.KEY.KEY_BONUS_TYPE)){
            String typeStr = params.get(Resource.KEY.KEY_BONUS_TYPE);
            int type = Integer.parseInt(typeStr);
            model.setmAttentionBonusType(type);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_DURATION)){
            model.setmAttentionDuration(params.get(Resource.KEY.KEY_ATTENTION_DURATION));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_STATUS)){
            String statusStr = params.get(Resource.KEY.KEY_ATTENTION_STATUS);
            int status = Integer.parseInt(statusStr);
            model.setAttentionStatus(status);
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_SCORE)){
            String scoreStr = params.get(Resource.KEY.KEY_ATTENTION_SCORE);
            int score = Integer.parseInt(scoreStr);
            model.setScore(score);
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            model.setmOpenClassId(params.get(Resource.KEY.KEY_CLASS_OPEN_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_END_TIME)){
            model.setmEndTime(params.get(Resource.KEY.KEY_ATTENTION_END_TIME));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_TIME)){
            model.setmStartTime(params.get(Resource.KEY.KEY_ATTENTION_TIME));
        }

        if(params.containsKey(Resource.KEY.KEY_ATTENTION_INSIST_TIME)){
            String insistTimeStr = params.get(Resource.KEY.KEY_ATTENTION_INSIST_TIME);
            CommonUtil.printLog("insistTime: " + insistTimeStr);
            int insistTime = Integer.parseInt(insistTimeStr);
            String insistDuration = TimeUtil.getTimeText(insistTime);
            model.setAttentionInsistTime(insistDuration);
        }

        return model;

    }
}
