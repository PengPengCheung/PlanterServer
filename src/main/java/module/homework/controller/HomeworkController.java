package module.homework.controller;

import com.sun.org.apache.regexp.internal.RE;
import common.Resource;
import dao.logic.HomeworkDAO;
import dao.logic.ResourceDAO;
import entity.HomeworkInfoEntity;
import model.DataResponse;
import module.homework.model.HomeworkViewModel;
import module.homework.model.web.HomeworkInfoModel;
import module.homework.model.web.HomeworkStudentInfoModel;
import module.homework.model.web.HomeworkSubmitInfoModel;
import module.homework.service.web.HomeworkWebService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by peng on 2017/3/21.
 */

@Controller
public class HomeworkController {

    private static final String TAG = HomeworkController.class.getSimpleName();


//    @RequestMapping(value = "/web/homework/studentHomeworkList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<HomeworkSubmitInfoModel>> getHomeworkSubmitInfoModelList(@RequestBody Map<String, String> params){
//        HomeworkWebService service = new HomeworkWebService();
//        return service.getStudentHomeworkSubmitInfoList(params);
//    }


    /**
     * 文件下载
     *
     * //  "/files/download/韩晓娜_面向大学英语课堂的智能教学系统_毕业设计开题报告.docx"
     * @param response
     */
    @RequestMapping(value = "/FileDownload/StudentHomeworkDownload/{homeworkSubmitId}")
    public void fileDownload_servlet(HttpServletRequest request, HttpServletResponse response, @PathVariable String homeworkSubmitId) {


//        ResourceDAO resourceDAO = new ResourceDAO();
//        String path = resourceDAO.getResourceSavedPathByResourceId(resourceId);
        HomeworkDAO homeworkDAO = new HomeworkDAO();
        String path = homeworkDAO.getHomeworkSavePathByHomeworkSubmitId(homeworkSubmitId);
        CommonUtil.printLog("TeachResourceController savedPath: " + path);
        Files_Utils_DG.FilesDownload_stream(request,response,path);
    }



    // 用于教师发布作业
    // {"c_id":"course789","t_id":"1234","homework_publish_time":"2017-04-09 16:19:21","homework_submit_ddl":"2017-04-22 16:18:18","homework_content":"时间紧，任务重，抓紧毕设！！！","homework_title":"777"}
    @RequestMapping(value = "/web/homework/publish", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> publishHomework(@RequestBody Map<String, String> params){

        HomeworkWebService service = new HomeworkWebService();
        return service.publishHomework(params);


//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(Resource.KEY.KEY_HOMEWORK_PUBLISH_STATUS, Resource.HOMEWORK.HOMEWORK_PUBLISHED_SUCCESS);
//        response.setData(params);
//
//        return response;
    }

//    // 用于教师发布作业
//    // {"c_id":"course789","t_id":"1234","homework_publish_time":"2017-04-09 16:19:21","homework_submit_ddl":"2017-04-22 16:18:18","homework_content":"时间紧，任务重，抓紧毕设！！！","homework_title":"777"}
//    @RequestMapping(value = "/web/homework/publish", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<Map<String, Integer>> publishHomework(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + ", publishHomework", request);
//
//
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(Resource.KEY.KEY_HOMEWORK_PUBLISH_STATUS, Resource.HOMEWORK.HOMEWORK_PUBLISHED_SUCCESS);
//        response.setData(params);
//
//        return response;
//    }


    //  {"c_id":"course789","t_id":"1234"}
    //  获取教师作业列表
    @RequestMapping(value = "/web/homework/getHomeworkInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<HomeworkInfoModel>> getHomeworkInfoModelList(@RequestBody Map<String, String> params){

        HomeworkWebService service = new HomeworkWebService();
        return service.getTeacherPublishedHomeworkInfoList(params);


//        DataResponse<List<HomeworkInfoModel>> response = new DataResponse<List<HomeworkInfoModel>>(200, "no reason");
//        List<HomeworkInfoModel> modelList = new LinkedList<HomeworkInfoModel>();
//        for(int i=0;i<10;i++){
//            Date date = new Date();
//            HomeworkInfoModel model = new HomeworkInfoModel();
//            model.setHomeworkId(DBUtil.generateUUID());
//            model.setHomeworkContent(Resource.TEST_LONG_TEXT);
//            model.setHomeworkDDL(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HM));
//            model.setHomeworkSubmitNum(10);
//            model.setHomeworkTitle("震惊！百分之九十九的人都不知道！点击速看！男人看了沉默，女人看了会流泪！不转不是好学生！");
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;

    }


    //  {"c_id":"course789","t_id":"1234"}
    //  获取教师作业列表
//    @RequestMapping(value = "/web/homework/getHomeworkInfoList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<HomeworkInfoModel>> getHomeworkInfoModelList(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + ", getHomeworkInfoModelList", request);
//
//        DataResponse<List<HomeworkInfoModel>> response = new DataResponse<List<HomeworkInfoModel>>(200, "no reason");
//        List<HomeworkInfoModel> modelList = new LinkedList<HomeworkInfoModel>();
//        for(int i=0;i<10;i++){
//            Date date = new Date();
//            HomeworkInfoModel model = new HomeworkInfoModel();
//            model.setHomeworkId(DBUtil.generateUUID());
//            model.setHomeworkContent(Resource.TEST_LONG_TEXT);
//            model.setHomeworkDDL(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HM));
//            model.setHomeworkSubmitNum(10);
//            model.setHomeworkTitle("震惊！百分之九十九的人都不知道！点击速看！男人看了沉默，女人看了会流泪！不转不是好学生！");
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;
//
//    }



    // 获取学生对应课程的作业列表,不是指学生已提交的作业，指的是教师发布的作业(网页学生端登录后获取的教师发布的作业列表)
    // {"c_id":"560b9549-e19b-4840-9607-191e06f1c5f6","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
    @RequestMapping(value = "/web/homework/getStudentHomeworkInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<HomeworkStudentInfoModel>> getStudentHomeworkInfoModelList(@RequestBody Map<String, String> request){
//        DataUtils.printRequestBodyStr(TAG + ", getStudentHomeworkInfoModelList", request);

        HomeworkWebService service = new HomeworkWebService();
        return service.getCourseHomeworkList(request);



//        DataResponse<List<HomeworkStudentInfoModel>> response = new DataResponse<List<HomeworkStudentInfoModel>>(200, "no reason");
//        List<HomeworkStudentInfoModel> modelList = new LinkedList<HomeworkStudentInfoModel>();
//        for(int i=0;i<10;i++){
//            Date date = new Date();
//            HomeworkStudentInfoModel model = new HomeworkStudentInfoModel();
//            model.setHomeworkId(DBUtil.generateUUID());
//            model.setHomeworkContent(Resource.TEST_LONG_TEXT);
//            model.setHomeworkSubmitStatus(Resource.HOMEWORK.HOMEWORK_PUBLISHED);
//            model.setHomeworkDDL(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HM));
//            model.setHomeworkSubmitNum(10);
//            model.setHomeworkTitle("震惊！百分之九十九的人都不知道！点击速看！男人看了沉默，女人看了会流泪！不转不是好学生！");
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;

    }






//    // 获取学生对应课程的作业列表,不是指学生已提交的作业，指的是教师发布的作业(网页学生端登录后获取的教师发布的作业列表)
//    // {"c_id":"560b9549-e19b-4840-9607-191e06f1c5f6","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
//    @RequestMapping(value = "/web/homework/getStudentHomeworkInfoList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<HomeworkStudentInfoModel>> getStudentHomeworkInfoModelList(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + ", getStudentHomeworkInfoModelList", request);
//
//        DataResponse<List<HomeworkStudentInfoModel>> response = new DataResponse<List<HomeworkStudentInfoModel>>(200, "no reason");
//        List<HomeworkStudentInfoModel> modelList = new LinkedList<HomeworkStudentInfoModel>();
//        for(int i=0;i<10;i++){
//            Date date = new Date();
//            HomeworkStudentInfoModel model = new HomeworkStudentInfoModel();
//            model.setHomeworkId(DBUtil.generateUUID());
//            model.setHomeworkContent(Resource.TEST_LONG_TEXT);
//            model.setHomeworkSubmitStatus(Resource.HOMEWORK.HOMEWORK_PUBLISHED);
//            model.setHomeworkDDL(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HM));
//            model.setHomeworkSubmitNum(10);
//            model.setHomeworkTitle("震惊！百分之九十九的人都不知道！点击速看！男人看了沉默，女人看了会流泪！不转不是好学生！");
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;
//
//    }


    // {"c_id":"course789","t_id":"1234","homework_id":"b0cb4ef1-2c8f-4795-929c-a94e01191c15"}
    // 教师查看已提交的作业列表
    @RequestMapping(value = "/web/homework/getHomeworkSubmitInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<HomeworkSubmitInfoModel>> getHomeworkSubmitInfoList(@RequestBody Map<String, String> params){

        HomeworkWebService service = new HomeworkWebService();
        return service.getHomeworkSubmitInfoList(params);

    }


//    // {"c_id":"course789","t_id":"1234","homework_id":"b0cb4ef1-2c8f-4795-929c-a94e01191c15"}
//    // 教师查看已提交的作业列表
//    @RequestMapping(value = "/web/homework/getHomeworkSubmitInfoList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<HomeworkSubmitInfoModel>> getHomeworkSubmitInfoList(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + ", getHomeworkSubmitInfoList", request);
//
//        DataResponse<List<HomeworkSubmitInfoModel>> response = new DataResponse<List<HomeworkSubmitInfoModel>>(200,"no reason");
//        List<HomeworkSubmitInfoModel> modelList = new LinkedList<HomeworkSubmitInfoModel>();
//
//        for(int i=0;i<10;i++){
//            HomeworkSubmitInfoModel model = new HomeworkSubmitInfoModel();
//            model.setStudentId(DBUtil.generateUUID());
//            model.setStudentName("韩晓娜 " + i);
//            model.setHomeworkSubmitId(DBUtil.generateUUID());
//            model.setHomeworkSubmitName("20131003723_韩晓娜_综英第一次作业_2017.4.9");
//            model.setHomeworkDownloadURL("http://url");
//            if(i/2==0){
//                model.setHomeworkScore(-1);
//            } else {
//                model.setHomeworkScore(90);
//            }
//
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;
//
//    }

    // {"c_id":"course789","t_id":"1234","homework_submit_id":"c67dab1f-a3bd-4465-8419-4c98a053e4e0","homework_score":"100","s_id":"ad3f2629-2938-4ca2-8c18-bb62ac6348d0"}
    // 教师对学生提交的作业打分
    @RequestMapping(value = "/web/homework/score", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> teacherScore(@RequestBody Map<String, String> params){
        HomeworkWebService service = new HomeworkWebService();
        return service.score(params);
    }










    @RequestMapping(value = "/web/Homework/HomeworkPublish", method = RequestMethod.POST, produces= "application/json;charset=UTF-8")
    @ResponseBody
    public String homeworkPublished(@RequestBody Map<String, String> params){

        String courseId = null;
        String teacherId = null;
        String homeworkContent = null;
        String homeworkTitle = null;
        String homeworkPublishTime = null;
        String homeworkSubmitDDL = null;

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_CONTENT)){
            homeworkContent = params.get(Resource.KEY.KEY_HOMEWORK_CONTENT);
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_TITLE)){
            homeworkTitle = params.get(Resource.KEY.KEY_HOMEWORK_TITLE);
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME)){
            homeworkPublishTime = params.get(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME);
        }

        if(params.containsKey(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL)){
            homeworkSubmitDDL = params.get(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL);
        }

        handleWithDB();

        Date date = new Date();
        String dateStr = TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM);

        HomeworkViewModel model = constructModel(homeworkContent, homeworkTitle, dateStr, homeworkSubmitDDL);

        String jsonMsg = JsonUtil.objToJSON(model);

        PushUtil.pushMessageAndNotification(jsonMsg, Resource.Notification.HOMEWORK_CHECK_NOTIFICATION);

        Map<String,String> map = new HashMap<String, String>();
        map.put("key", "value");

        return jsonMsg;
    }

    private HomeworkViewModel constructModel(String content, String title, String publishTime, String ddl){
        HomeworkViewModel model = new HomeworkViewModel();
        model.setmModuleId(Resource.Module.MODULE_COURSE_HOMEWORK);
        model.setmHomeworkTitle(title);
        model.setmHomeworkContent(content);
        model.setmHomeworkPublishTime(publishTime);
        model.setmHomeworkStatus(Resource.HOMEWORK.HOMEWORK_PUBLISHED);
        model.setmHomeworkSubmitDDL(ddl);

        return model;
    }

    private void handleWithDB(){}

}
