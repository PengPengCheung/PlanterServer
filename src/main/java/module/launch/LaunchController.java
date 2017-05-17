package module.launch;

import model.DataResponse;
import model.SimpleResponse;
import module.launch.service.LaunchService;
import module.planter.model.PlanterViewModel;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.CommonUtil;

import java.util.Map;

/**
 * Created by peng on 2017/3/23.
 */
@Controller
public class LaunchController {
    private static final Logger logger = Logger.getLogger(LaunchController.class);

    @RequestMapping(value = "/mob/signup", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<PlanterViewModel> studentSignUp(@RequestBody Map<String, String> params){
        logger.info("In studentSignUp.....");
        LaunchService service = new LaunchService();
        System.out.println("ppp 1");
        DataResponse<PlanterViewModel> responseStr = service.getResultOfSignUp(params);
        System.out.println("ppp 2");
        return responseStr;
    }

//    @RequestMapping(value = "/mob/signup", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<PlanterViewModel> SignUpForStudent(@RequestBody Map<String, String> params){
//        CommonUtil.printLog("SignUpForStudent");
//        LaunchService service = new LaunchService();
//        return service.signUp(params);
//    }



}
