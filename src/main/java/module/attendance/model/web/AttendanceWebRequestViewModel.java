package module.attendance.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/1.
 */
public class AttendanceWebRequestViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String attendanceCode;

    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String classOpenId;

    public String getClassOpenId() {
        return classOpenId;
    }

    public void setClassOpenId(String classOpenId) {
        this.classOpenId = classOpenId;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }
}
