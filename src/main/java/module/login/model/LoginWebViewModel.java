package module.login.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/28.
 */
public class LoginWebViewModel {

    @JsonProperty(Resource.KEY.KEY_TEACHER_ID)
    private String teacherId;

    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
    private String studentId;

    @JsonProperty(Resource.KEY.KEY_ROLE)
    private int role;

    @JsonProperty(Resource.KEY.KEY_LOGIN_REASON)
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
