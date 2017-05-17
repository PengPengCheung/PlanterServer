package module.signup;

import model.DataResponse;
import module.signup.model.SignUpWebResponseViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by peng on 2017/3/29.
 */

@Controller
public class SignUpController {



//    @RequestMapping(value = "/web/signuptest", method = RequestMethod.POST)
//    public DataResponse<SignUpWebResponseViewModel> signUp(@RequestBody Map<String, String> params){
//        System.out.println("");
//        printParams(params);
//        return null;
//    }



//    {"userName":"20131003723","userPassword":"12345678","Rank":1}
//    @RequestMapping(value = "/web/signup", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<SignUpWebResponseViewModel> signUp(HttpServletRequest request){
//
//        DataUtils.printRequestBodyStr("SignController", request);
//        DataResponse<SignUpWebResponseViewModel> response = new DataResponse<SignUpWebResponseViewModel>(200, "desc");
//        SignUpWebResponseViewModel model = new SignUpWebResponseViewModel();
//        model.setStudentId("stu123");
//        model.setTeacherId("tea456");
//        model.setRole(1);
//        response.setData(model);
//        return response;
//    }


    //    {"userName":"20131003723","userPassword":"12345678","Rank":1}
    @RequestMapping(value = "/web/signup", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<SignUpWebResponseViewModel> signUp(@RequestBody Map<String, String> params){

        DataResponse<SignUpWebResponseViewModel> response = new DataResponse<SignUpWebResponseViewModel>(200, "desc");
        SignUpWebResponseViewModel model = new SignUpWebResponseViewModel();
        model.setStudentId("stu123");
        model.setTeacherId("tea456");
        model.setRole(1);
        response.setData(model);
        return response;
    }



    private void printParams(Map<String, String> params) {

    }
}
