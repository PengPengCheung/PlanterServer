package module.login.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/14.
 */
public class LoginCourseModel {

    @JsonProperty(Resource.KEY.KEY_COURSE_ID)
    private String courseId;

    @JsonProperty(Resource.KEY.KEY_COURSE_NAME)
    private String courseName;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
