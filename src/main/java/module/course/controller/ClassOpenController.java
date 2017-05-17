package module.course.controller;

import common.Resource;
import model.DataResponse;
import module.attendance.AttendanceCodeGenerator;
import module.course.ClassViewModel;
import module.course.ClassWebResponseViewModel;
import module.course.service.ClassService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DataUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/27.
 */
@Controller
public class ClassOpenController {


//    @RequestMapping(value = "/web/course/classOpen", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<ClassViewModel> openClass(@RequestBody Map<String, String> params){
//
//        ClassService classService = new ClassService();
//        DataResponse<ClassViewModel> dataResponse = classService.getClassOpenResponse(params);
//        return dataResponse;
//
//    }


    //老师点击开课按钮时调用 {"class_begin_time":"2017-04-19 19:50:42","c_id":"d276a696-1956-4fb2-b193-f393e636d940","t_id":"1234"}
    // 返回 开课状态码
    @RequestMapping(value = "/web/course/classBegin", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Object>> openClass(@RequestBody Map<String, String> params){ // Map<String, String> params
//        DataUtils.printRequestBodyStr("ClassOpenController", request);
        ClassService service = new ClassService();
        return service.beginClass(params);
//        return new DataResponse<Map<String, Integer>>(200, "adsad");
    }


//    // 老师点击开课按钮时调用 {"class_open_time":"2017-04-19 19:50:42","c_id":"d276a696-1956-4fb2-b193-f393e636d940","t_id":"1234"}
//    // 返回 开课状态码
//    @RequestMapping(value = "/web/course/classBegin", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<Map<String, Integer>> openClass(HttpServletRequest request){
//        DataUtils.printRequestBodyStr("ClassOpenController", request);
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "desc");
////        ClassWebResponseViewModel responseModel = new ClassWebResponseViewModel();
////        responseModel.setAttendanceCode(AttendanceCodeGenerator.generateAttendanceCode());
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put(Resource.KEY.KEY_CLASS_BEGIN_STATUS, Resource.CLASS.CLASS_STATUS_OPEN);
//        response.setData(map);
//
//        return response;
//    }


    // {"class_end_time":"2017-04-01 14:56:41","c_id":"course789","t_id":"1234"}
    @RequestMapping(value = "/web/course/classEnd", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> closeClass(HttpServletRequest request){
        DataUtils.printRequestBodyStr("ClassOpenController closeClass", request);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "desc");
//        ClassWebResponseViewModel responseModel = new ClassWebResponseViewModel();
//        responseModel.setAttendanceCode(AttendanceCodeGenerator.generateAttendanceCode());
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_CLASS_BEGIN_STATUS, Resource.CLASS.CLASS_STATUS_CLOSE);
        response.setData(map);

        return response;

    }






}
