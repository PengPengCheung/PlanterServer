package module.login.service;

import common.Resource;
import dao.logic.BaseConnectionDAO;
import dao.logic.CourseDAO;
import dao.logic.LoginDAO;
import dao.logic.StudentInfoDAO;
import entity.BaseConnectionEntity;
import entity.CourseInfoEntity;
import entity.StudentInfoEntity;
import javafx.scene.chart.PieChart;
import model.DataResponse;
import module.login.model.LoginWebRequestViewModel;
import module.login.model.LoginWebViewModel;
import module.login.model.web.LoginCourseModel;
import utils.CommonUtil;
import utils.DBUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/28.
 */
public class LoginService {

    LoginDAO dao;

    public LoginService(){
        dao = new LoginDAO();
    }


    public DataResponse<List<StudentInfoEntity>> getStudentInfoList(Map<String, String> params){
        String courseId = null;
        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        CommonUtil.printLog("LoginService getStudentInfoList courseId: " + courseId);

        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        BaseConnectionDAO baseConnectionDAO = new BaseConnectionDAO();
        List<StudentInfoEntity> list = new LinkedList<StudentInfoEntity>();
        List<BaseConnectionEntity> baseConnectionEntityList = baseConnectionDAO.getBaseConnectionListByCourseId(courseId);
        for(BaseConnectionEntity entity : baseConnectionEntityList){
            String studentId = entity.getsId();
            if(studentId != null) {
                StudentInfoEntity studentInfoEntity = studentInfoDAO.getStudentInfoByStudentId(studentId);
                list.add(studentInfoEntity);
            }
        }

        DataResponse<List<StudentInfoEntity>> response = new DataResponse<List<StudentInfoEntity>>(200,"success");
        response.setData(list);
        return response;
    }



    // {"c_id":"429f8899-d400-4ff9-8687-77aebc4e3104","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
    public DataResponse<List<LoginCourseModel>> getStudentCourseList(Map<String, String> params){
//        String courseId = null;
        String studentId = null;

//        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
//            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
//        }

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        }

        BaseConnectionDAO baseConnectionDAO = new BaseConnectionDAO();
        CourseDAO courseDAO = new CourseDAO();
        List<LoginCourseModel> modelList = new LinkedList<LoginCourseModel>();
        List<BaseConnectionEntity> entityList = baseConnectionDAO.selectBaseConnectionEntitiesByStudentId(studentId);
        for(BaseConnectionEntity entity : entityList){
            String cId = entity.getcId();
            CourseInfoEntity courseInfoEntity = courseDAO.getCourseByCourseId(cId);
            LoginCourseModel responseWebModel = constructLoginWebModel(courseInfoEntity);
            modelList.add(responseWebModel);
        }

        DataResponse<List<LoginCourseModel>> response = new DataResponse<List<LoginCourseModel>>(200,"success");
        response.setData(modelList);

        return response;
    }

    private LoginCourseModel constructLoginWebModel(CourseInfoEntity entity){
        LoginCourseModel model = new LoginCourseModel();
        model.setCourseId(entity.getcId());
        model.setCourseName(entity.getCourseName());

        return model;

    }



    public DataResponse<LoginWebViewModel> login(Map<String, String> params){
        LoginWebRequestViewModel model = constructWebViewModel(params);

        String id = dao.login(model);

        System.out.println("return id: " + id);

        if(id != null){

            LoginWebViewModel responseViewModel = constructLoginWebViewModel(id, model.getStatus());

            responseViewModel.setReason(Resource.LOGIN.LOGIN_SUCCESS);

            DataResponse<LoginWebViewModel> viewModel = new DataResponse<LoginWebViewModel>(Resource.LOGIN.STATUS_SUCCESS, Resource.LOGIN.LOGIN_SUCCESS);


            viewModel.setData(responseViewModel);

            return viewModel;

        } else {

            LoginWebViewModel responseModel = new LoginWebViewModel();

            responseModel.setReason(Resource.LOGIN.LOGIN_FAIL);

            DataResponse<LoginWebViewModel> response = new DataResponse<LoginWebViewModel>(Resource.LOGIN.STATUS_SUCCESS, Resource.LOGIN.LOGIN_FAIL);

            response.setData(responseModel);

            return response;
        }


    }

    private LoginWebViewModel constructLoginWebViewModel(String id, int role) {

        LoginWebViewModel viewModel = new LoginWebViewModel();

        viewModel.setRole(role);

        switch (role){
            case Resource.ROLE.ROLE_TEACHER:{
                viewModel.setTeacherId(id);
            }
            break;
            case Resource.ROLE.ROLE_STUDENT:{
                viewModel.setStudentId(id);
            }
            break;

        }

        return viewModel;
    }

    private LoginWebRequestViewModel constructWebViewModel(Map<String, String> params) {

        LoginWebRequestViewModel model = new LoginWebRequestViewModel();

        String name = null;
        String password = null;
        int role = -1;

        if(params.containsKey(Resource.KEY.KEY_NAME)){
            name = params.get(Resource.KEY.KEY_NAME);
            model.setName(name);
            System.out.println("name: " + name);
        }

        if(params.containsKey(Resource.KEY.KEY_PASSWORD)){
            password = params.get(Resource.KEY.KEY_PASSWORD);
            model.setPassword(password);
            System.out.println("password: " + password);
        }

        if(params.containsKey(Resource.KEY.KEY_ROLE)){
            role = Integer.parseInt(params.get(Resource.KEY.KEY_ROLE));
            model.setStatus(role);
            System.out.println("role: " + role);
        }

        return model;

    }



}
