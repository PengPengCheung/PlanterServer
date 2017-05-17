package module.randomask.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/9.
 */
public class StudentInfoModel {

    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
    private String studentId;

    @JsonProperty(Resource.KEY.KEY_STU_NAME)
    private String studentName;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
