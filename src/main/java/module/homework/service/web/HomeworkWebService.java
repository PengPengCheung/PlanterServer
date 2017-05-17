package module.homework.service.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Resource;
import dao.logic.HomeworkDAO;
import dao.logic.StudentInfoDAO;
import entity.HomeworkInfoEntity;
import entity.StudentCourseHomeworkTableEntity;
import entity.StudentInfoEntity;
import model.DataResponse;
import module.homework.model.HomeworkViewModel;
import module.homework.model.web.HomeworkInfoModel;
import module.homework.model.web.HomeworkPublishRequestModel;
import module.homework.model.web.HomeworkStudentInfoModel;
import module.homework.model.web.HomeworkSubmitInfoModel;
import utils.*;

import java.util.*;

/**
 * Created by peng on 2017/4/21.
 */
public class HomeworkWebService {

    public HomeworkWebService(){

    }

//    // 获取学生已提交的作业列表
//    public DataResponse<List<HomeworkSubmitInfoModel>> getStudentHomeworkSubmitInfoList(Map<String, String> params){
//
//    }

    // {"c_id":"course789","t_id":"1234","homework_submit_id":"c67dab1f-a3bd-4465-8419-4c98a053e4e0","homework_score":"100","s_id":"ad3f2629-2938-4ca2-8c18-bb62ac6348d0"}
    // 教师对学生提交的作业打分
    public DataResponse<Map<String, Integer>> score(Map<String, String> params){
        String homeworkSubmitId = null;
        int homeworkScore = -1;
        String studentId = null;

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_SUBMIT_ID)){
            homeworkSubmitId = params.get(Resource.KEY.KEY_HOMEWORK_SUBMIT_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_SCORE)){
            String scoreStr = params.get(Resource.KEY.KEY_HOMEWORK_SCORE);
            homeworkScore = Integer.parseInt(scoreStr);
        }

        CommonUtil.printLog("HomeworkWebService score homeworkScore: " +  homeworkScore);

        HomeworkDAO homeworkDAO = new HomeworkDAO();
        homeworkDAO.scoreToStudentHomework(homeworkSubmitId, homeworkScore);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"success");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_GROUP_TEACHER_SCORE_STATUS, Resource.HOMEWORK.HOMEWORK_TEACHER_SCORE_SUCCESS);
        response.setData(map);

        return response;

    }


    // {"c_id":"560b9549-e19b-4840-9607-191e06f1c5f6","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
    public DataResponse<List<HomeworkStudentInfoModel>> getCourseHomeworkList(Map<String, String> params){
        String courseId = null;
        String studentId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        }

        HomeworkDAO homeworkDAO = new HomeworkDAO();
        List<HomeworkStudentInfoModel> models = new LinkedList<HomeworkStudentInfoModel>();
        List<HomeworkInfoEntity> homeworkInfoEntityList = homeworkDAO.getHomeworkInfoListByCourseId(courseId);
        for(HomeworkInfoEntity entity : homeworkInfoEntityList){
            int submitNum = homeworkDAO.getSubmitNumByHomeworkIdAndCourseId(entity.getHomeworkId(), courseId);
            HomeworkStudentInfoModel homeworkStudentInfoModel = constructHomeworkStudentInfoModel(entity, submitNum);
            models.add(homeworkStudentInfoModel);
        }

        DataResponse<List<HomeworkStudentInfoModel>> response = new DataResponse<List<HomeworkStudentInfoModel>>(200,"success");
        response.setData(models);

        return response;
    }


    private HomeworkStudentInfoModel constructHomeworkStudentInfoModel(HomeworkInfoEntity entity, int submitNum){
        HomeworkStudentInfoModel model = new HomeworkStudentInfoModel();
        model.setHomeworkId(entity.getHomeworkId());
        model.setHomeworkContent(entity.getHomeworkContent());
        model.setHomeworkSubmitStatus(entity.getHomeworkStatus());
        model.setHomeworkDDL(entity.getHomeworkCommitDdl());
        model.setHomeworkSubmitNum(submitNum);
        model.setHomeworkTitle(entity.getHomeworkTitle());

        return model;
    }



    // 教师端获取学生提交作业的情况
    // {"c_id":"course789","t_id":"1234","homework_id":"b0cb4ef1-2c8f-4795-929c-a94e01191c15"}
    public DataResponse<List<HomeworkSubmitInfoModel>> getHomeworkSubmitInfoList(Map<String, String> params){
        String courseId = null;
        String teacherId = null;
        String homeworkId = null; // 指的是教师发布的作业id

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_ID)){
            homeworkId = params.get(Resource.KEY.KEY_HOMEWORK_ID);
        }

        HomeworkDAO homeworkDAO = new HomeworkDAO();
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        List<HomeworkSubmitInfoModel> modelList = new LinkedList<HomeworkSubmitInfoModel>();
        CommonUtil.printLog("HomeworkService 1");
        List<StudentCourseHomeworkTableEntity> homeworkSubmitList = homeworkDAO.getStudentSubmitHomeworkList(homeworkId);
        CommonUtil.printLog("HomeworkService 2");
        for(StudentCourseHomeworkTableEntity entity : homeworkSubmitList){
            CommonUtil.printLog("HomeworkService 3");
            String studentId = entity.getsId();
            StudentInfoEntity studentInfoEntity = studentInfoDAO.getStudentInfoByStudentId(studentId);
            CommonUtil.printLog("HomeworkService 4 studentId: " + studentId);
            CommonUtil.printLog("HomeworkService 5 " + (studentInfoEntity != null));
            if(studentInfoEntity != null){
                CommonUtil.printLog("HomeworkService 6 " + studentInfoEntity.getsId());
                HomeworkSubmitInfoModel model = constructHomeworkSubmitInfoModel(entity, studentInfoEntity.getsName());
                modelList.add(model);
            } else { // 找不到对应学生时

            }
        }

        DataResponse<List<HomeworkSubmitInfoModel>> response = new DataResponse<List<HomeworkSubmitInfoModel>>(200, "success");
        response.setData(modelList);

        return response;
    }

    private HomeworkSubmitInfoModel constructHomeworkSubmitInfoModel(StudentCourseHomeworkTableEntity entity, String studentName){
        HomeworkSubmitInfoModel model = new HomeworkSubmitInfoModel();
        model.setStudentId(entity.getsId());
        model.setStudentName(studentName);
        model.setHomeworkSubmitId(entity.getStudentSubmitHomeworkId());
//        model.setHomeworkSubmitName("20131003723_韩晓娜_综英第一次作业_2017.4.9");
        model.setHomeworkSubmitName(entity.getHomeworkSubmitName());
        model.setHomeworkDownloadURL(entity.getHomeworkDownloadUrl());
        model.setHomeworkScore(entity.getHomeworkScore()); // -1 表示未打分
        CommonUtil.printLog("HomeworkWebService constructHomeworkSubmitInfoModel homeworkId: " + entity.getHomeworkId());
        model.setHomeworkTeacherPublishedId(entity.getHomeworkId());

        return model;
    }

    // {"c_id":"course789","t_id":"1234"}
    public DataResponse<List<HomeworkInfoModel>> getTeacherPublishedHomeworkInfoList(Map<String, String> params){
        String courseId = null;
        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        HomeworkDAO homeworkDAO = new HomeworkDAO();
        List<HomeworkInfoModel> modelList = new LinkedList<HomeworkInfoModel>();
        List<HomeworkInfoEntity> entityList = homeworkDAO.getHomeworkInfoList(teacherId, courseId);
        for(HomeworkInfoEntity entity : entityList){
            int submitNum = homeworkDAO.getSubmitNumByHomeworkIdAndCourseId(entity.getHomeworkId(), courseId);
            HomeworkInfoModel model = constructHomeworkInfoModel(entity, submitNum);
            modelList.add(model);
        }

        DataResponse<List<HomeworkInfoModel>> response = new DataResponse<List<HomeworkInfoModel>>(200, "success");
        response.setData(modelList);

        return response;
    }

    private HomeworkInfoModel constructHomeworkInfoModel(HomeworkInfoEntity entity, int submitNum){
        HomeworkInfoModel model = new HomeworkInfoModel();
        model.setHomeworkId(entity.getHomeworkId());
        model.setHomeworkTitle(entity.getHomeworkTitle());
        model.setHomeworkDDL(entity.getHomeworkCommitDdl());
        model.setHomeworkContent(entity.getHomeworkContent());
        model.setHomeworkSubmitNum(submitNum);
        return model;
    }

    // {"c_id":"course789","t_id":"1234","homework_publish_time":"2017-04-09 16:19:21","homework_submit_ddl":"2017-04-22 16:18:18","homework_content":"时间紧，任务重，抓紧毕设！！！","homework_title":"777"}
    public DataResponse<Map<String, Integer>> publishHomework(Map<String, String> params){
        HomeworkPublishRequestModel publishRequestModel = constructHomeworkPublishModel(params);
        HomeworkDAO homeworkDAO = new HomeworkDAO();
        HomeworkInfoEntity entity = homeworkDAO.publishHomework(publishRequestModel);
        homeworkDAO.insertTeacherCourseHomeworkRecord(publishRequestModel.getmTeacherId(), publishRequestModel.getmCourseId(), entity.getHomeworkId());

        HomeworkViewModel viewModel = constructHomeworkViewModelToMob(entity, publishRequestModel.getmCourseId());
        pushToMobClients(viewModel);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "success");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_HOMEWORK_PUBLISH_STATUS, Resource.HOMEWORK.HOMEWORK_PUBLISHED_SUCCESS);
        response.setData(map);

        return response;

    }

    private void pushToMobClients(HomeworkViewModel model){
        String pushJsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            pushJsonStr = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.HOMEWORK_CHECK_NOTIFICATION);
    }

    private static HomeworkViewModel constructHomeworkViewModelToMob(HomeworkInfoEntity entity, String courseId){
        HomeworkViewModel homeworkViewModel = new HomeworkViewModel();
        homeworkViewModel.setmCourseId(courseId);
        homeworkViewModel.setmModuleId(Resource.Module.MODULE_COURSE_HOMEWORK);
        homeworkViewModel.setmHomeworkSubmitDDL(entity.getHomeworkCommitDdl());
        homeworkViewModel.setmHomeworkContent(entity.getHomeworkContent());
        homeworkViewModel.setmHomeworkPublishTime(entity.getHomeworkPublishTime());
        homeworkViewModel.setmHomeworkTitle(entity.getHomeworkTitle());
        homeworkViewModel.setmHomeworkId(entity.getHomeworkId());
        homeworkViewModel.setmHomeworkStatus(Resource.HOMEWORK.HOMEWORK_PUBLISHED);

//        Date date = new Date();
//        homeworkViewModel.setmHomeworkBonusNum(5);
//        homeworkViewModel.setmHomeworkItemCurrentTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD));
//        homeworkViewModel.setmHomeworkRank(2);
//        homeworkViewModel.setmHomeworkScore(90);

        return homeworkViewModel;

    }

    private HomeworkPublishRequestModel constructHomeworkPublishModel(Map<String, String> params) {

        HomeworkPublishRequestModel model = new HomeworkPublishRequestModel();

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            model.setmCourseId(params.get(Resource.KEY.KEY_COURSE_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            model.setmTeacherId(params.get(Resource.KEY.KEY_TEACHER_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME)){
            model.setHomeworkPublishTime(params.get(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME));
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL)){
            model.setHomeworkDDL(params.get(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL));
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_CONTENT)){
            model.setHomeworkContent(params.get(Resource.KEY.KEY_HOMEWORK_CONTENT));
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_TITLE)){
            model.setHomeworkTitle(params.get(Resource.KEY.KEY_HOMEWORK_TITLE));
        }

        return model;
    }

}
