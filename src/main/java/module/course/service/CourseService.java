package module.course.service;

import common.Resource;
import dao.logic.BaseConnectionDAO;
import dao.logic.CourseDAO;
import entity.BaseConnectionEntity;
import entity.CourseInfoEntity;
import model.DataResponse;
import module.course.model.ClassAddRequestViewModel;
import module.course.model.ClassAddResponseViewModel;
import module.course.model.ClassCourseCodeResponseViewModel;
import module.course.model.web.CourseInfoResponseViewModel;
import module.planter.model.PlanterViewModel;
import utils.CommonUtil;
import utils.DBUtil;
import utils.ModelUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/4/17.
 */
public class CourseService {

    private static final String TAG = CourseService.class.getSimpleName();



    public CourseService(){

    }


    public DataResponse<PlanterViewModel> joinInCourseByStudent(Map<String, String> params){
        String stuCourseCode = null;
        String studentId = null;
        if(params.containsKey(Resource.KEY.KEY_STU_COURSE_CODE)){
            stuCourseCode = params.get(Resource.KEY.KEY_STU_COURSE_CODE);
        }

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        }

        CourseInfoEntity entity = getCourseInfoByCourseCode(stuCourseCode);
        if(entity != null){ // 表示学生输入的courseCode有匹配的课程
            boolean isSuccess = updateBaseConnection(studentId, entity.getcId());

            if(isSuccess){
                PlanterViewModel planterViewModel = constructPlanterViewModelWhenSuccess(entity);
                DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(200, "success");
                response.setData(planterViewModel);
                return response;
            } else {
                PlanterViewModel planterViewModel = constructPlanterViewModelWhenFail();
                DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(200, "success");
                response.setData(planterViewModel);
                return response;
            }


        } else {
            PlanterViewModel planterViewModel = constructPlanterViewModelWhenFail();
            DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(200, "fail");
            response.setData(planterViewModel);
            return response;

        }


    }

    private boolean updateBaseConnection(String studentId, String courseId){
        BaseConnectionDAO dao = new BaseConnectionDAO();
        List<BaseConnectionEntity> entityList = dao.getBaseConnectionListByCourseId(courseId);
        if(entityList != null && entityList.size() > 0){
            String teacherId = entityList.get(0).gettId();
            BaseConnectionEntity entity = constructBaseConnectionEntity(teacherId, courseId, studentId);
            boolean success = dao.insertBaseConnection(entity);
            return success;
        } else {
            return false;
        }



    }

    private BaseConnectionEntity constructBaseConnectionEntity(String teacherId, String courseId, String studentId){
        BaseConnectionEntity entity = new BaseConnectionEntity();
        entity.settId(teacherId);
        entity.setcId(courseId);
        entity.setsId(studentId);
        entity.setBaseConnectionId(DBUtil.generateUUID());
        return entity;
    }

    private CourseInfoEntity getCourseInfoByCourseCode(String courseCode){
        CourseDAO courseDAO = new CourseDAO();
        CourseInfoEntity entity = courseDAO.getCourseByCourseCode(courseCode);
        return entity;
    }

//    private CourseInfoEntity getCourseInfoByCourseId(String courseId){
//        CourseDAO courseDAO = new CourseDAO();
//        CourseInfoEntity entity = courseDAO.getCourseByCourseId(courseId);
//        return entity;
//    }

    private PlanterViewModel constructPlanterViewModelWhenFail(){

        return new PlanterViewModel();
    }

    private PlanterViewModel constructPlanterViewModelWhenSuccess(CourseInfoEntity entity){
//        String courseId = DBUtil.generateUUID();
//        System.out.println("courseId: " + courseId);
        PlanterViewModel model = new PlanterViewModel();
        model.setmModuleId(Resource.Module.MODULE_FRAME_PLANTER);
        model.setmCourseId(entity.getcId());
        model.setmCourseName(entity.getCourseName());
        model.setmCourseTime(entity.getCourseTime());
        model.setmPlanterStatus(Resource.TREE_STATUS.TREE_SEED);
        model.setmPlanterSunshine(0);
        model.setmPlanterWater(0);
        model.setmPlanterSoil(0);
        model.setmPlanterPercent(0);
        model.setmDataFrom(Resource.DATA_FROM.DATA_FROM_REQUEST);

        return model;
    }


    public DataResponse<ClassCourseCodeResponseViewModel> getCourseCodeResponse(Map<String, String> params){
        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

//        BaseConnectionDAO baseConnectionDAO = new BaseConnectionDAO();
//
//        List<BaseConnectionEntity> connectionEntityList = baseConnectionDAO.selectBaseConnectionByTeacherId(teacherId);
//
//        List<String> courseIdList = new LinkedList<String>();
//        for(BaseConnectionEntity entity:connectionEntityList){
//            String courseId = entity.getcId();
//            if(courseId != null){
//                if(!courseIdList.contains(courseId)){
//                    courseIdList.add(courseId);
//                }
//            }
//        }


        String courseCode = CommonUtil.getRandomCode();
        String checkedCourseCode = checkNotTheSame(courseCode); // 获取课程码时，仅检查重复性，但仍未能插入


        ClassCourseCodeResponseViewModel model = new ClassCourseCodeResponseViewModel();
        model.setTeacherId(teacherId);
        model.setCourseCode(checkedCourseCode);

        DataResponse<ClassCourseCodeResponseViewModel> response = new DataResponse<ClassCourseCodeResponseViewModel>(200, "success");

        response.setData(model);

        return response;


    }

    private void insertCourseCode(String courseCode){

    }

    // 此处逻辑不妥，当数量很多时，多次重复，则会导致系统崩溃
    private String checkNotTheSame(String courseCode){
        CourseDAO courseDAO = new CourseDAO();
        List<CourseInfoEntity> courseInfoEntityList = courseDAO.getCourseInfoList();


        for(CourseInfoEntity entity : courseInfoEntityList){
            if(courseCode.equals(entity.getCourseCode())){
                courseCode = CommonUtil.getRandomCode();
            }
        }
        return courseCode;
    }

    private void insertBaseConnection(String teacherId, String courseId){
        BaseConnectionDAO connectionDAO = new BaseConnectionDAO();

        connectionDAO.insertBaseConnection(ModelUtil.constructConnectionEntity(teacherId, courseId, ""));
    }

    public DataResponse<ClassAddResponseViewModel> addCourseByTeacher(Map<String, String> params){
        ClassAddRequestViewModel requestViewModel = constructRequestModel(params);
        CourseInfoEntity courseInfoEntity = constructCourseInfoEntity(requestViewModel);
        CourseDAO courseDAO = new CourseDAO();
        boolean isExist = updateCourseInfoIfExist(courseDAO, requestViewModel); // 如果存在则增加开课时间，此时返回的cId为空
        if(!isExist){ // 如果不存在则插入
            courseInfoEntity.setcId(DBUtil.generateUUID());
            insertCourseInfoModel(courseDAO, courseInfoEntity);
            insertBaseConnection(requestViewModel.getTeacherId(), courseInfoEntity.getcId());
        }

        ClassAddResponseViewModel responseViewModel = new ClassAddResponseViewModel();
        responseViewModel.setCourseId(courseInfoEntity.getcId());
        responseViewModel.setResult(Resource.RESULT.RESULT_OPERATION_SUCCESS);

        DataResponse<ClassAddResponseViewModel> response = new DataResponse<ClassAddResponseViewModel>(200, "success");
        response.setData(responseViewModel);

        return response;
    }

    private void insertCourseInfoModel(CourseDAO courseDAO, CourseInfoEntity entity){
        courseDAO.insertCourseInfo(entity);
    }

    private boolean updateCourseInfoIfExist(CourseDAO courseDAO, ClassAddRequestViewModel requestViewModel){
        boolean isExist = false;
        List<CourseInfoEntity> courseInfoEntityList = courseDAO.getCourseInfoList();
        for(CourseInfoEntity entity : courseInfoEntityList){
            String courseCode = entity.getCourseCode();
            CommonUtil.printLog(TAG + ", updateCourseInfoIfExist 1 " + courseCode);
            if(courseCode != null && courseCode.equals(requestViewModel.getCourseCode())){
                CommonUtil.printLog(TAG + ", updateCourseInfoIfExist 2");
                // 表示已存在该课程, 不再创建新课程
                String requestTime = requestViewModel.getCourseDate() + " " + requestViewModel.getCourseTime();
                String time = entity.getCourseTime();
                time = time + ", " + requestTime;
                entity.setCourseTime(time);
                courseDAO.updateCourseInfoTime(entity);
                CommonUtil.printLog(TAG + ", updateCourseInfoIfExist 3");
                isExist = true;
                return isExist;
            }
        }

        return isExist;
    }

    private CourseInfoEntity constructCourseInfoEntity(ClassAddRequestViewModel model){
        CourseInfoEntity entity = new CourseInfoEntity();
//        entity.setcId(DBUtil.generateUUID());
        entity.setCourseCode(model.getCourseCode());
        entity.setCourseName(model.getCourseName());
        String courseTime = model.getCourseDate() + " " + model.getCourseTime();
        entity.setCourseTime(courseTime);
//        entity.setCourseDuration();
        return entity;
    }

    private ClassAddRequestViewModel constructRequestModel(Map<String, String> params){
        ClassAddRequestViewModel requestViewModel = new ClassAddRequestViewModel();

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            requestViewModel.setTeacherId(params.get(Resource.KEY.KEY_TEACHER_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_CODE)){
            requestViewModel.setCourseCode(params.get(Resource.KEY.KEY_COURSE_CODE));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_DATE)){
            requestViewModel.setCourseDate(params.get(Resource.KEY.KEY_COURSE_DATE));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_TIME)){
            requestViewModel.setCourseTime(params.get(Resource.KEY.KEY_COURSE_TIME));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_NAME)){
            requestViewModel.setCourseName(params.get(Resource.KEY.KEY_COURSE_NAME));
        }

        return requestViewModel;
    }



    public List<CourseInfoResponseViewModel> getTeacherCourseInfoList(Map<String, String> params){

        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
           teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        List<String> courseList = new LinkedList<String>();

        BaseConnectionDAO dao = new BaseConnectionDAO();
        List<BaseConnectionEntity> list = dao.selectAllBaseConnection();
        if(list.size() > 0){
            for(BaseConnectionEntity entity: list){
                if(entity.gettId().equals(teacherId)){ // 选取t_id相同的联系，这些联系表示已经创建了课程
                    if(!courseList.contains(entity.getcId())){
                        courseList.add(entity.getcId());
                    }

                }
            }
        } else {}

        CourseDAO courseDAO = new CourseDAO();


        // 如果该老师已经开了一些课
        if(courseList.size() > 0){
            List<CourseInfoResponseViewModel> viewModelList = new LinkedList<CourseInfoResponseViewModel>();
            for(String course:courseList){
                String courseId = course;
                CourseInfoEntity courseInfoEntity = courseDAO.getCourseByCourseId(courseId);
                CourseInfoResponseViewModel model = new CourseInfoResponseViewModel();
                model.setCourseId(courseId);
                model.setCourseName(courseInfoEntity.getCourseName());
                model.setCourseCode(courseInfoEntity.getCourseCode());
                List<String> timeList = convertToTimeList(courseInfoEntity.getCourseTime());
                if(timeList != null){ // timeList为空怎么办？
                    model.setCourseTimeList(timeList);
                }
                int openClassCount = getOpenClassTimes();
                model.setClassOpenCount(openClassCount);
                viewModelList.add(model);
            }

            return viewModelList;

        }

        return new LinkedList<CourseInfoResponseViewModel>();

    }

    private int getOpenClassTimes(){
        return 0;
    }

    private List<String> convertToTimeList(String timeStr){
        if(timeStr != null && !timeStr.equals("")){
            String[] times = timeStr.split(",");
            if(times.length > 0){
                List<String> timeList = new LinkedList<String>();
                for(int i=0;i<times.length;i++){
                    timeList.add(times[i]);
                }

                return timeList;
            }
        }

        return null;
    }
}
