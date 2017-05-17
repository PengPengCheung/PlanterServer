package module.frame.service;

import common.Resource;
import dao.logic.FrameCourseDAO;
import model.DataResponse;
import module.frame.model.FrameCourseAllMsgViewModel;

import java.util.Map;

/**
 * Created by peng on 2017/3/26.
 */
public class FrameCourseService {

    FrameCourseDAO mFrameDAO;

    public FrameCourseService(){
        mFrameDAO = new FrameCourseDAO();
    }

    public DataResponse<FrameCourseAllMsgViewModel> constructCourseAllViewModel(Map<String, String> params){

        FrameCourseAllMsgViewModel model = constructViewModel(params);

        return new DataResponse<FrameCourseAllMsgViewModel>(-100, "no reason");

    }

    private FrameCourseAllMsgViewModel constructViewModel(Map<String, String> params) {
        if(params == null){
            return new FrameCourseAllMsgViewModel();
        }

        FrameCourseAllMsgViewModel model = new FrameCourseAllMsgViewModel();
        String studentId = null;
        String courseId = null;

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
            model.setmStudentId(studentId);
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
            model.setmCourseId(courseId);
        }



        return model;
    }
}
