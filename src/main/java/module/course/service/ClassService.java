package module.course.service;

import common.Resource;
import dao.logic.ClassDAO;
import entity.StudentTeacherClassTableEntity;
import model.DataResponse;
import module.attendance.AttendanceCodeGenerator;
import module.course.ClassViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/27.
 */
public class ClassService {


    ClassDAO dao;

    public ClassService(){
        dao = new ClassDAO();
    }


    // {"class_begin_time":"2017-04-19 19:50:42","c_id":"d276a696-1956-4fb2-b193-f393e636d940","t_id":"1234"}
    public DataResponse<Map<String, Object>> beginClass(Map<String, String> params){
//        String classBeginTime = null;
//        String courseId = null;
//        String teacherId = null;
//
//        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_TIME)){
//            classBeginTime = params.get(Resource.KEY.KEY_CLASS_OPEN_TIME);
//        }
//
//        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
//            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
//        }
//
//        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
//            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
//        }

        ClassViewModel classViewModel = constructClassViewModel(params);

        ClassDAO classDAO = new ClassDAO();
        StudentTeacherClassTableEntity entity = classDAO.openClass(classViewModel);

        DataResponse<Map<String, Object>> response = new DataResponse<Map<String, Object>>(200, "success");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Resource.KEY.KEY_CLASS_BEGIN_STATUS, Resource.CLASS.CLASS_STATUS_OPEN);
        map.put(Resource.KEY.KEY_CLASS_OPEN_ID, entity.getOpenClassId());
        response.setData(map);

        return response;

    }




    public DataResponse<ClassViewModel> getClassOpenResponse(Map<String, String> params){

        ClassViewModel model = constructClassViewModel(params);
        dao.openClass(model);
        ClassViewModel viewModel = constructResponseClassViewModel();
        DataResponse<ClassViewModel> response = new DataResponse<ClassViewModel>(Resource.STATUS_TEST.STATUS_CLASS_OPEN_SUCCESS, "开课成功！");
        response.setData(viewModel);
        return response;
    }

    private ClassViewModel constructResponseClassViewModel() {
        String attendanceCode = AttendanceCodeGenerator.generateAttendanceCode();
        ClassViewModel model = new ClassViewModel();
        model.setAttendanceCode(attendanceCode);

        return model;
    }


    public ClassViewModel constructClassViewModel(Map<String, String> params){
        String teacherId = null;
        String courseId = null;
        String openClassTime = null;

        ClassViewModel model = new ClassViewModel();
        System.out.println("constructClassViewModel 1");
        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
            model.setmTeacherId(teacherId);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            System.out.println("constructClassViewModel 2: " + courseId);
            model.setmCourseId(courseId);
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_TIME)){
            openClassTime = params.get(Resource.KEY.KEY_CLASS_OPEN_TIME);
            model.setClassBeginTime(openClassTime);
        }

        return model;


    }


}
