package module.frame.controller;

import module.frame.model.FrameCourseAllMsgViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by peng on 2017/3/26.
 */
@Controller
public class FrameController {


    @RequestMapping(value = "/mob/course/courseSelect", method = RequestMethod.POST)
    public FrameCourseAllMsgViewModel getAllViewsOfCourse(@RequestBody Map<String, String> params){

        return new FrameCourseAllMsgViewModel();
    }
}
