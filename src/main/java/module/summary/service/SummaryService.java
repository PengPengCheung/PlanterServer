package module.summary.service;

import common.Resource;
import dao.logic.AttendanceDAO;
import dao.logic.ClassDAO;
import dao.logic.StudentInfoDAO;
import dao.logic.SummaryDAO;
import entity.StudentInfoEntity;
import entity.StudentSummaryEntity;
import entity.StudentTeacherClassTableEntity;
import entity.TeacherSummaryEntity;
import model.DataResponse;
import module.summary.model.SummaryAttendanceMixWebViewModel;
import module.summary.model.SummaryHistoryWebRespViewModel;
import module.summary.model.mob.SummaryViewModel;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import utils.*;

import java.util.*;

/**
 * Created by peng on 2017/3/25.
 */
public class SummaryService {

    private static Logger logger = Logger.getLogger(SummaryService.class);

    private SummaryDAO mSummaryDAO;

    public SummaryService(){
        mSummaryDAO = new SummaryDAO();
    }



    // 学生发送对应的反馈
    public DataResponse<SummaryViewModel> receiveSummaryFromStudent(Map<String, String> params){

        SummaryViewModel viewModel = constructSummaryViewModel(params);

        mSummaryDAO.storeStudentSummary(viewModel);

        DataResponse<SummaryViewModel> response = new DataResponse<SummaryViewModel>(200,"success");
//        String courseId = "0a564996-a618-45d7-bf4c-20e60a457185";
//        String courseId = params.get(Resource.KEY.KEY_COURSE_ID);
//        String summaryId = params.get(Resource.KEY.KEY_SUMMARY_ID);
        SummaryViewModel model = constructSummaryResponseViewModel(viewModel.getmSummaryId(), viewModel.getmCourseId(), viewModel.getmSummaryRequestTime());
        response.setData(model);


        return response;
    }

    private SummaryViewModel constructSummaryResponseViewModel(String summaryId, String courseId, String requestTime){
//        String summaryId = DBUtil.generateUUID();
        SummaryViewModel summaryViewModel = new SummaryViewModel();
        summaryViewModel.setmCourseId(courseId);
        summaryViewModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
        summaryViewModel.setmSummaryBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        summaryViewModel.setmSummaryBonusNum(Resource.BONUS_NUM.SUMMARY_BONUS_NUM);
        summaryViewModel.setmSummaryId(summaryId);
        summaryViewModel.setmSummaryRequestTime(requestTime);
        summaryViewModel.setmSummaryStatus(Resource.SUMMARY.SUMMARY_CHECKING);

        return summaryViewModel;
    }

    private SummaryViewModel constructSummaryViewModel(Map<String, String> params){
        String summaryContent = params.get(Resource.KEY.KEY_SUMMARY_CONTENT);
        String summaryId = params.get(Resource.KEY.KEY_SUMMARY_ID);
        String studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        String courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        String summarySendTime = params.get(Resource.KEY.KEY_SUMMARY_SEND_TIME);
        String openClassId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);

        SummaryViewModel summaryViewModel = new SummaryViewModel();
        summaryViewModel.setmSummaryContent(summaryContent);
        summaryViewModel.setmCourseId(courseId);
        summaryViewModel.setmStudentId(studentId);
        summaryViewModel.setmOpenClassId(openClassId);
        summaryViewModel.setmSummarySendTime(summarySendTime);


        return summaryViewModel;

    }


    // {"c_id":"course789","s_id":null,"t_id":1234,"class_open_time":"2017-04-07"}  改传openClassId
    // todo：1、传入参数class_open_time改成open_class_id  2、处理找不到学生反馈信息的情况
    public DataResponse<List<SummaryHistoryWebRespViewModel>> getStudentSummaryListForSpecialClass(Map<String, String> params){
        String courseId = null;
        String teacherId = null;
        String classOpenId = null;

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            classOpenId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);
        }

        if(classOpenId == null){
            classOpenId = "";
        }

        SummaryDAO summaryDAO = new SummaryDAO();
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        List<SummaryHistoryWebRespViewModel> modelList = new LinkedList<SummaryHistoryWebRespViewModel>();
        List<StudentSummaryEntity> entityList = summaryDAO.getStudentSummaryListByOpenClassId(classOpenId);
        if(entityList != null) {
            for (StudentSummaryEntity entity : entityList){
                String studentId = entity.getsId();
                StudentInfoEntity studentInfoEntity = studentInfoDAO.getStudentInfoByStudentId(studentId);
                String studentName = null;
                if(studentInfoEntity != null){
                    studentName = studentInfoEntity.getsName();
                } else {
                    studentName = "暂无此学生姓名";
                }
                SummaryHistoryWebRespViewModel model = constructSummaryHistoryWebRespViewModel(studentId, studentName, entity.getSummaryContent(), entity.getSummaryStatus());
                modelList.add(model);
            }
        } else { // 没有对应开课的学生反馈信息

        }

        DataResponse<List<SummaryHistoryWebRespViewModel>> response = new DataResponse<List<SummaryHistoryWebRespViewModel>>(200,"success");
        response.setData(modelList);

        return response;
    }

    private SummaryHistoryWebRespViewModel constructSummaryHistoryWebRespViewModel(String studentId, String studentName, String summaryContent, int summaryResult){
        SummaryHistoryWebRespViewModel model = new SummaryHistoryWebRespViewModel();
        model.setmStudentId(studentId);
        model.setStudentName(studentName);
        model.setSummaryContent(summaryContent);
        model.setSummaryResult(summaryResult);

//        if(i/2 == 0){
//            model.setSummaryResult(Resource.SUMMARY.SUMMARY_REASONABLE);
//        } else {
//            model.setSummaryResult(Resource.SUMMARY.SUMMARY_THANKS);
//        }
//
//        if(i == 0){
//            model.setSummaryResult(Resource.SUMMARY.SUMMARY_DEFAULT);
//        }

        return model;
    }



//    SummaryAttendanceMixWebViewModel responseModel = new SummaryAttendanceMixWebViewModel();
//            responseModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
//            responseModel.setmCourseId(DBUtil.generateUUID());
//            responseModel.setCourseOpenDate(TimeUtil.timeToStr(new Date(), TimeUtil.ENG_PATTERN_YMD));
//            responseModel.setCourseSequence("第" + (i+1) + "次课");
//            responseModel.setAttendanceCount(20);
//            responseModel.setAbsenceCount(10);
////            responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_ALL_DONE);
//            if(i/2 == 0){
//        responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_ALL_DONE);
//    } else {
//        responseModel.setSummaryStatus(Resource.SUMMARY.SUMMARY_NO_SUMMARY);
//    }

    // 查看该课程的往期考勤和反馈情况  {"c_id":"course789","t_id":"1234"}
    // todo: 课堂反馈状态的获取未完成
    public DataResponse<List<SummaryAttendanceMixWebViewModel>> checkAttendanceAndSummaryHistory(Map<String, String> params){
        String courseId = null;
        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        SummaryDAO summaryDAO = new SummaryDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        List<SummaryAttendanceMixWebViewModel> modelList = new LinkedList<SummaryAttendanceMixWebViewModel>();
        List<StudentTeacherClassTableEntity> classOpenList = summaryDAO.getCourseOpenListByOpenClassId(courseId, teacherId);
        for(StudentTeacherClassTableEntity entity : classOpenList){
            String openClassId = entity.getOpenClassId();
            int maxAttendanceCount = attendanceDAO.getAttendanceCountByOpenClassId(openClassId);
            SummaryAttendanceMixWebViewModel model = constructSummaryAttendanceMixWebViewModel(courseId, entity.getClassBeginTime(), maxAttendanceCount, 0, Resource.SUMMARY.SUMMARY_NOT_FINISHED);
            modelList.add(model);
        }

        DataResponse<List<SummaryAttendanceMixWebViewModel>> response = new DataResponse<List<SummaryAttendanceMixWebViewModel>>(200, "success");
        response.setData(modelList);
        return response;

    }

    private SummaryAttendanceMixWebViewModel constructSummaryAttendanceMixWebViewModel(String courseId, String courseOpenDate, int attendanceCount, int absenceCount, int summaryStatus) {
        SummaryAttendanceMixWebViewModel responseViewModel = new SummaryAttendanceMixWebViewModel();
        responseViewModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
        responseViewModel.setmCourseId(courseId);
        responseViewModel.setCourseOpenDate(courseOpenDate);
        responseViewModel.setAttendanceCount(attendanceCount);
        responseViewModel.setAbsenceCount(absenceCount);
        responseViewModel.setSummaryStatus(summaryStatus);

        return responseViewModel;
    }


    public DataResponse<SummaryViewModel> receiveSummary(Map<String, String> params){
        SummaryViewModel model = constructViewModel(params);
        boolean isStored = mSummaryDAO.storeStudentSummary(model);
        logger.error("isStored: " + isStored);
        if(isStored){
            DataResponse<SummaryViewModel> viewModel = new DataResponse<SummaryViewModel>(Resource.STATUS_TEST.STATUS_SUMMARY_SEND_SUCCESS, "反馈成功");
            return viewModel;
        } else {
            DataResponse<SummaryViewModel> viewModel = new DataResponse<SummaryViewModel>(Resource.STATUS_TEST.STATUS_SUMMARY_SEND_FAIL, "反馈失败");
            return viewModel;
        }
    }

    public DataResponse<Map<String, Object>> collectSummaryRequest(Map<String, String> params){
        SummaryViewModel model = constructViewModelFromRequest(params);

        TeacherSummaryEntity summaryEntity = mSummaryDAO.storeTeacherSummaryInfo(model);

        CommonUtil.printLog("SummaryService collectSummaryRequest openClassId: " + model.getmOpenClassId());

        ClassDAO classDAO = new ClassDAO();
        StudentTeacherClassTableEntity entity = classDAO.getOpenClassEntityByOpenClassId(model.getmOpenClassId());

        model.setmCourseId(entity.getcId());
        model.setmTeacherId(entity.gettId());
        model.setmSummaryId(summaryEntity.getTeacherSummaryId());

        String message = JsonUtil.objToJSON(model);
        PushUtil.pushMessageAndNotification(message, Resource.Notification.SUMMARY_CHECK_NOTIFICATION);

        DataResponse<Map<String, Object>> response = new DataResponse<Map<String, Object>>(200,"success");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Resource.KEY.KEY_SUMMARY_STATUS, Resource.SUMMARY.SUMMARY_REQUEST_SUCCESS);
        response.setData(map);

        return response;

    }

    private SummaryViewModel constructViewModelFromRequest(Map<String, String> params){
//        String teacherId = null;
//        String courseId = null;

        String time = null;

        SummaryViewModel model = new SummaryViewModel();

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            model.setmOpenClassId(params.get(Resource.KEY.KEY_CLASS_OPEN_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_SUMMARY_REQUEST_TIME)){
            time = params.get(Resource.KEY.KEY_SUMMARY_REQUEST_TIME);
            model.setmSummaryRequestTime(time);
            System.out.println(time);
        }

//        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
//            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
//            model.setmTeacherId(teacherId);
//        }
//
//        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
//            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
//            model.setmCourseId(courseId);
//        }

//        CommonUtil.printLog("SummaryService constructSummaryViewModel: " + teacherId);

        model.setmSummaryBonusNum(Resource.BONUS_NUM.SUMMARY_BONUS_NUM);
        model.setmSummaryStatus(Resource.SUMMARY.SUMMARY_NOT_SEND);
        model.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);

        return model;
    }


    private SummaryViewModel constructViewModel(Map<String, String> params){

        if(params == null){
            return new SummaryViewModel();
        }

        String sendTime = null;
        String content = null;
        String stuId = null;
        String courseId = null;
        SummaryViewModel model = new SummaryViewModel();

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            stuId = params.get(Resource.KEY.KEY_STUDENT_ID);
            model.setmStudentId(stuId);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            model.setmCourseId(courseId);
            System.out.println("----------------courseId: " + courseId);
        }

        if(params.containsKey(Resource.KEY.KEY_SUMMARY_SEND_TIME)){
            sendTime = params.get(Resource.KEY.KEY_SUMMARY_SEND_TIME);
            model.setmSummarySendTime(sendTime);
        }

        if(params.containsKey(Resource.KEY.KEY_SUMMARY_CONTENT)){
            content = params.get(Resource.KEY.KEY_SUMMARY_CONTENT);
            model.setmSummaryContent(content);
        }


        model.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
        model.setmSummaryBonusNum(Resource.BONUS_NUM.SUMMARY_BONUS_NUM);
        model.setmSummaryStatus(Resource.SUMMARY.SUMMARY_NOT_SEND);

        return model;


    }

}
