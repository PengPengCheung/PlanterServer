package module.course.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/29.
 */
public class ClassAddResponseViewModel {

    @JsonProperty(Resource.KEY.KEY_COURSE_ID)
    private String courseId;


    @JsonProperty(Resource.KEY.KEY_RESULT)
    private int result;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
