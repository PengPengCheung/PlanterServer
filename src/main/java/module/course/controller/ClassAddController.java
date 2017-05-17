package module.course.controller;

import common.Resource;
import model.DataResponse;
import module.attendance.AttendanceCodeGenerator;
import module.course.model.ClassAddResponseViewModel;
import module.course.model.ClassCourseCodeResponseViewModel;
import module.course.model.web.CourseInfoResponseViewModel;
import module.course.service.CourseService;
import module.planter.model.PlanterViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.CommonUtil;
import utils.DBUtil;
import utils.DataUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/29.
 */

@Controller
public class ClassAddController {

    private static final String TAG = ClassAddController.class.getSimpleName();


    // {"t_id":1234}   用于点击添加课程时返回课程码
    @RequestMapping(value = "/web/getCourseCode", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<ClassCourseCodeResponseViewModel> getCourseCode(@RequestBody Map<String, String> params){

        System.out.println(TAG + " getCourseCode ");

        CourseService courseService = new CourseService();
        return courseService.getCourseCodeResponse(params);



//        DataResponse<ClassCourseCodeResponseViewModel> response = new DataResponse<ClassCourseCodeResponseViewModel>(200, "desc");
//        ClassCourseCodeResponseViewModel model = new ClassCourseCodeResponseViewModel();
//        String courseCode = AttendanceCodeGenerator.generateAttendanceCode();
//        model.setCourseCode(courseCode);
//        model.setTeacherId(Resource.TEST.TEST_TEACHER_ID);
//        response.setData(model);
//        return response;
    }

//
//    // {"t_id":1234}   用于点击添加课程时返回课程码
//    @RequestMapping(value = "/web/getCourseCode", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<ClassCourseCodeResponseViewModel> getCourseCode(HttpServletRequest request){
//        DataUtils.printRequestBodyStr("ClassAddController", request);
//        DataResponse<ClassCourseCodeResponseViewModel> response = new DataResponse<ClassCourseCodeResponseViewModel>(200, "desc");
//        ClassCourseCodeResponseViewModel model = new ClassCourseCodeResponseViewModel();
//        String courseCode = AttendanceCodeGenerator.generateAttendanceCode();
//        model.setCourseCode(courseCode);
//        model.setTeacherId(Resource.TEST.TEST_TEACHER_ID);
//        response.setData(model);
//        return response;
//    }


//    public DataResponse<List<>>

    // 用于添加课程到数据库,
    // {"course_name":"笔译","course_date":"星期二","course_time":"09:10","course_code":"312488","t_id":1234}
    @RequestMapping(value = "/web/addCourse", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<ClassAddResponseViewModel> addCourseByTeacher(@RequestBody Map<String, String> params){

        System.out.println(TAG + " addCourseByTeacher ");

        CourseService service = new CourseService();
        return service.addCourseByTeacher(params);


//        DataResponse<ClassAddResponseViewModel> response = new DataResponse<ClassAddResponseViewModel>(200, "desc");
//        ClassAddResponseViewModel model = new ClassAddResponseViewModel();
//        model.setCourseId(Resource.TEST.TEST_COURSE_ID);
//        model.setResult(Resource.RESULT.RESULT_OPERATION_SUCCESS);
//        response.setData(model);
//
//        return response;

    }


//    // 用于添加课程到数据库,   {"course_name":"笔译","course_date":"星期二","course_time":"09:10","course_code":"312488","t_id":1234}
//    @RequestMapping(value = "/web/addCourse", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<ClassAddResponseViewModel> addCourse(HttpServletRequest request){
//        DataUtils.printRequestBodyStr("ClassAddController addCourse", request);
//        DataResponse<ClassAddResponseViewModel> response = new DataResponse<ClassAddResponseViewModel>(200, "desc");
//        ClassAddResponseViewModel model = new ClassAddResponseViewModel();
//        model.setCourseId(Resource.TEST.TEST_COURSE_ID);
//        model.setResult(Resource.RESULT.RESULT_OPERATION_SUCCESS);
//        response.setData(model);
//
//        return response;
//
//    }


    // {"t_id":1234}   用于登录或者注册后获取该名教师对应的课程列表
    @RequestMapping(value = "/web/getCourseList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<CourseInfoResponseViewModel>> getCourseInfoList(@RequestBody Map<String, String> params){
//        DataUtils.printRequestBodyStr("ClassAddController getCourseInfoList", params);
        System.out.println(TAG + " getCourseInfoList ");

        CourseService service = new CourseService();
        List<CourseInfoResponseViewModel> list = service.getTeacherCourseInfoList(params);


        DataResponse<List<CourseInfoResponseViewModel>> response = new DataResponse<List<CourseInfoResponseViewModel>>(200, "desc");
//        List<CourseInfoResponseViewModel> list = new ArrayList<CourseInfoResponseViewModel>();
//        list.add(constructCourseInfoViewModel());
//        list.add(constructCourseInfoViewModel());
//        list.add(constructCourseInfoViewModel());
//        list.add(constructCourseInfoViewModel());
        response.setData(list);

        return response;

    }

    private CourseInfoResponseViewModel constructCourseInfoViewModel(){
        CourseInfoResponseViewModel model = new CourseInfoResponseViewModel();
        model.setCourseId(Resource.TEST.TEST_COURSE_ID);
        model.setCourseCode(AttendanceCodeGenerator.generateAttendanceCode());
        model.setCourseName("影视英语");
        model.setClassOpenCount(6);
        List<String> list = new ArrayList<String>();
        list.add("星期二 09:10");
        list.add("星期三 10:10");
        list.add("星期四 08:30");
        model.setCourseTimeList(list);

        return model;
    }


    // {"student_course_code":"456666","s_id":"aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41"}
    @RequestMapping(value = "/mob/addCourse", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<PlanterViewModel> addCourse(@RequestBody Map<String, String> params){

        CommonUtil.printLog(TAG + ", mob addCourse");

        CourseService service = new CourseService();
        return service.joinInCourseByStudent(params);

//        PlanterViewModel viewModel = constructViewModel();
//        DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(200,"no reason");
//        response.setData(viewModel);
//        return response;
    }

    // {"student_course_code":"456666","s_id":"aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41"}
//    @RequestMapping(value = "/mob/addCourse", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<PlanterViewModel> addCourse(HttpServletRequest request){
//
////        CommonUtil.printLog(TAG + ", mob addCourse");
//
//        DataUtils.printRequestBodyStr(TAG + ", addCourse", request);
//
//
//        PlanterViewModel viewModel = constructViewModel();
//        DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(200,"no reason");
//        response.setData(viewModel);
//        return response;
//    }

    private PlanterViewModel constructViewModel(){
        String courseId = DBUtil.generateUUID();
        System.out.println("courseId: " + courseId);
        PlanterViewModel model = new PlanterViewModel();
        model.setmModuleId(Resource.Module.MODULE_FRAME_PLANTER);
        model.setmCourseId(courseId);
        model.setmCourseName("综英");
        model.setmCourseTime("周四上午");
        model.setmPlanterStatus(Resource.TREE_STATUS.TREE_SEED);
        model.setmPlanterSunshine(0);
        model.setmPlanterWater(0);
        model.setmPlanterSoil(0);
        model.setmPlanterPercent(0);
        model.setmDataFrom(Resource.DATA_FROM.DATA_FROM_REQUEST);

        return model;
    }

}
