package module.course.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/29.
 */
public class ClassCourseCodeResponseViewModel {


    @JsonProperty(Resource.KEY.KEY_COURSE_CODE)
    private String courseCode;

    @JsonProperty(Resource.KEY.KEY_TEACHER_ID)
    private String teacherId;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
