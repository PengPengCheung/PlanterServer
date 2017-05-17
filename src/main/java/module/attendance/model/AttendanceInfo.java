package module.attendance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import common.Resource;

/**
 * Created by peng on 2017/3/17.
 */
public class AttendanceInfo {


    private String mAttendanceDate;


    private String mAttendanceTime;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_STATUS)
    private int mAttendanceStatus;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String mAttendanceCode;

    @JsonProperty()
    private String mAttendanceValidTime;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_BONUS_NUM)
    private int mAttendanceBonusNum;

    public String getmAttendanceDate() {
        return mAttendanceDate;
    }

    public void setmAttendanceDate(String mAttendanceDate) {
        this.mAttendanceDate = mAttendanceDate;
    }

    public String getmAttendanceTime() {
        return mAttendanceTime;
    }

    public void setmAttendanceTime(String mAttendanceTime) {
        this.mAttendanceTime = mAttendanceTime;
    }

    public int getmAttendanceStatus() {
        return mAttendanceStatus;
    }

    public void setmAttendanceStatus(int mAttendanceStatus) {
        this.mAttendanceStatus = mAttendanceStatus;
    }

    public String getmAttendanceCode() {
        return mAttendanceCode;
    }

    public void setmAttendanceCode(String mAttendanceCode) {
        this.mAttendanceCode = mAttendanceCode;
    }

    public String getmAttendanceValidTime() {
        return mAttendanceValidTime;
    }

    public void setmAttendanceValidTime(String mAttendanceValidTime) {
        this.mAttendanceValidTime = mAttendanceValidTime;
    }

    public int getmAttendanceBonusNum() {
        return mAttendanceBonusNum;
    }

    public void setmAttendanceBonusNum(int mAttendanceBonusNum) {
        this.mAttendanceBonusNum = mAttendanceBonusNum;
    }


}
