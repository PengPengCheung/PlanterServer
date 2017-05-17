package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/23.
 */
public class PtBaseRequest {

    @JsonProperty(Resource.KEY.KEY_TEACHER_ID)
    private String teacherId;

    @JsonProperty(Resource.KEY.KEY_COURSE_ID)
    private String courseId;

    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
    private String studentId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
