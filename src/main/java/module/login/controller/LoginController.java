package module.login.controller;

import entity.StudentInfoEntity;
import model.DataResponse;
import module.login.model.LoginWebViewModel;
import module.login.model.web.LoginCourseModel;
import module.login.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DBUtil;
import utils.DataUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/28.
 */
@Controller
public class LoginController {


    private String TAG = LoginController.class.getSimpleName();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<LoginWebViewModel> login(@RequestBody Map<String, String> params){

        System.out.println("login 1");

        LoginService loginService = new LoginService();

        System.out.println("login 2");

        DataResponse<LoginWebViewModel> loginResponse =  loginService.login(params);

        System.out.println("login 3");

        return loginResponse;

    }


    // {"c_id":""}
    @RequestMapping(value = "/web/login/getStudentInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<StudentInfoEntity>> getStudentInfoList(@RequestBody Map<String, String> params){
        LoginService service = new LoginService();
        return service.getStudentInfoList(params);
    }


    // {"c_id":"429f8899-d400-4ff9-8687-77aebc4e3104","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
    // 网页端学生登录后获取学生已经关联的课程信息
    @RequestMapping(value = "/web/login/getStudentCourseInfoList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<LoginCourseModel>> getStudentCourseModelList(@RequestBody Map<String, String> request){
//        DataUtils.printRequestBodyStr(TAG + ", getStudentCourseModelList", request);

//        DataResponse<List<LoginCourseModel>> response = new DataResponse<List<LoginCourseModel>>(200, "no reason");
//
//        List<LoginCourseModel> modelList = new LinkedList<LoginCourseModel>();
//
//        for(int i=0;i<10;i++){
//            LoginCourseModel model = new LoginCourseModel();
//            model.setCourseId(DBUtil.generateUUID());
//            model.setCourseName("口译 " + i);
//            modelList.add(model);
//        }
//
//        response.setData(modelList);

        LoginService service = new LoginService();
        return service.getStudentCourseList(request);


    }

//    // {"c_id":"429f8899-d400-4ff9-8687-77aebc4e3104","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
//    // 网页端学生登录后获取学生已经关联的课程信息
//    @RequestMapping(value = "/web/login/getStudentCourseInfoList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<LoginCourseModel>> getStudentCourseModelList(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + ", getStudentCourseModelList", request);
//
//        DataResponse<List<LoginCourseModel>> response = new DataResponse<List<LoginCourseModel>>(200, "no reason");
//
//        List<LoginCourseModel> modelList = new LinkedList<LoginCourseModel>();
//
//        for(int i=0;i<10;i++){
//            LoginCourseModel model = new LoginCourseModel();
//            model.setCourseId(DBUtil.generateUUID());
//            model.setCourseName("口译 " + i);
//            modelList.add(model);
//        }
//
//        response.setData(modelList);
//
//        return response;
//    }

    @RequestMapping(value = "/logintest", method = RequestMethod.POST)
    @ResponseBody
    public String loginTest(HttpServletRequest request){
        System.out.println("loginTest");

        String requestStr = null;
        try {
            requestStr = DataUtils.getRequestPostStr(request);
            System.out.println("requestStr: " + requestStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
