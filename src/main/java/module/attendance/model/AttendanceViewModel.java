package module.attendance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/3/19.
 */
public class AttendanceViewModel extends BaseViewModel{

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ID)
    private String mAttendanceId;

    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_TIME)
    private String mAttendanceTime = "time";

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ATT_COUNT)
    private int mAttendanceCount = 100;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ABS_COUNT)
    private int mAbsenceCount = 200;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_VALID_DURATION)
    private String mAttendanceValidDuration = "duration";

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_BONUS_NUM)
    private int mAttendanceBonusNum = 30;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String mAttendanceCode = "123455";

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_STATUS)
    private int mAttendanceStatus = Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS;

    @JsonProperty(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttendanceBonusType;

    public String getmOpenClassId() {
        return mOpenClassId;
    }

    public void setmOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public int getmAttendanceBonusType() {
        return mAttendanceBonusType;
    }

    public void setmAttendanceBonusType(int mAttendanceBonusType) {
        this.mAttendanceBonusType = mAttendanceBonusType;
    }

    public String getmAttendanceId() {
        return mAttendanceId;
    }

    public void setmAttendanceId(String mAttendanceId) {
        this.mAttendanceId = mAttendanceId;
    }

    public int getmAttendanceStatus() {
        return mAttendanceStatus;
    }

    public void setmAttendanceStatus(int mAttendanceStatus) {
        this.mAttendanceStatus = mAttendanceStatus;
    }

    public String getmAttendanceTime() {
        return mAttendanceTime;
    }

    public void setmAttendanceTime(String mAttendanceTime) {
        this.mAttendanceTime = mAttendanceTime;
    }

    public int getmAttendanceCount() {
        return mAttendanceCount;
    }

    public void setmAttendanceCount(int mAttendanceCount) {
        this.mAttendanceCount = mAttendanceCount;
    }

    public int getmAbsenceCount() {
        return mAbsenceCount;
    }

    public void setmAbsenceCount(int mAbsenceCount) {
        this.mAbsenceCount = mAbsenceCount;
    }

    public String getmAttendanceValidDuration() {
        return mAttendanceValidDuration;
    }

    public void setmAttendanceValidDuration(String mAttendanceValidDuration) {
        this.mAttendanceValidDuration = mAttendanceValidDuration;
    }

    public int getmAttendanceBonusNum() {
        return mAttendanceBonusNum;
    }

    public void setmAttendanceBonusNum(int mAttendanceBonusNum) {
        this.mAttendanceBonusNum = mAttendanceBonusNum;
    }

    public String getmAttendanceCode() {
        return mAttendanceCode;
    }

    public void setmAttendanceCode(String mAttendanceCode) {
        this.mAttendanceCode = mAttendanceCode;
    }
}
