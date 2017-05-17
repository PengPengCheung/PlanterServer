package module.attendance.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/29.
 */
public class AttendanceWebResponseViewModel {


    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_CODE_SEND_STATUS)
    private int attendanceCodeSendStatus; // 考勤通知是否成功发出的状态码，1=成功，0=失败

    public int getAttendanceCodeSendStatus() {
        return attendanceCodeSendStatus;
    }

    public void setAttendanceCodeSendStatus(int attendanceCodeSendStatus) {
        this.attendanceCodeSendStatus = attendanceCodeSendStatus;
    }
}
