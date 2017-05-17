package module.launch.service;

import common.Resource;
import dao.logic.SignUpDAO;
import entity.CourseInfoEntity;
import entity.StudentInfoEntity;
import entity.TreeInfoEntity;
import model.DataResponse;
import module.launch.model.SignUpMobViewModel;
import module.planter.model.PlanterViewModel;

import java.util.Map;

/**
 * Created by peng on 2017/3/23.
 */
//@Service
public class LaunchService {

//    @javax.annotation.Resource(name="signupdao")
    private SignUpDAO mSignUpDAO;

    public LaunchService(){
        mSignUpDAO = new SignUpDAO();
    }


//    public DataResponse<PlanterViewModel> signUp(Map<String, String> params){
//        SignUpMobViewModel viewModel = constructViewModel(params);
//        StudentInfoEntity studentInfoEntity = mSignUpDAO.insertStudentInfo(viewModel);
//        PlanterViewModel planterViewModel = constructResponseModel(studentInfoEntity);
//
//        DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(200,"success");
//        response.setData();
//        return response;
//    }
//
//    private PlanterViewModel constructResponseModel(StudentInfoEntity studentInfoEntity) {
//        PlanterViewModel model = new PlanterViewModel();
//        model.setmPlanterStatus();
//        model.setmPlanterWater(tree.getTreeWater());
//        model.setmPlanterSunshine(tree.getTreeSun());
//        model.setmPlanterSoil(tree.getTreeSoil());
//        model.setmPlanterPercent(0);
//
//        return model;
//    }

    public DataResponse<PlanterViewModel> getResultOfSignUp(Map<String, String> params){

        SignUpMobViewModel model =  constructViewModel(params);
        DataResponse<PlanterViewModel> responseModel = mSignUpDAO.addStudentSignUpRecord(model);
        return responseModel;

    }



    private SignUpMobViewModel constructViewModel(Map<String, String> params){
        if(params == null){
            return new SignUpMobViewModel();
        }

        String stuId = null;
        String stuName = null;
        String stuPassword = null;
        String courseCode = null;

        SignUpMobViewModel model = new SignUpMobViewModel();

        if(params.containsKey(Resource.KEY.KEY_STU_ID)){
            stuId = params.get(Resource.KEY.KEY_STU_ID);
            model.setmNum(stuId);
        }

        if(params.containsKey(Resource.KEY.KEY_STU_NAME)){
            stuName = params.get(Resource.KEY.KEY_STU_NAME);
            model.setmName(stuName);
        }

        if(params.containsKey(Resource.KEY.KEY_STU_PASSWORD)){
            stuPassword = params.get(Resource.KEY.KEY_STU_PASSWORD);
            model.setmPassword(stuPassword);
        }

        if(params.containsKey(Resource.KEY.KEY_STU_COURSE_CODE)){
            courseCode = params.get(Resource.KEY.KEY_STU_COURSE_CODE);
            model.setmCourseCode(courseCode);
        }

        return model;
    }

}
