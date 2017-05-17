package module.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/1.
 */
public class ClassWebResponseViewModel {

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String attendanceCode;

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }
}
