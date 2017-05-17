package module.attendance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/1.
 */

// 用于学生签到，推送相关信息到网页端
public class AttendanceCheckWebResponseViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_STU_NAME)
    private String studentName; // 考勤成功的学生名字

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ATT_COUNT)
    private int studentAttendanceCount; // 该学生考勤成功次数

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ABS_COUNT)
    private int studentAbsentCount; // 该学生考勤失败次数

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_TOTAL_COUNT)
    private int totalAttendanceCount; // 全班出勤人数

    @JsonProperty(Resource.KEY.KEY_ABSENCE_TOTAL_COUNT)
    private int totalAbsentCount; // 全班缺勤人数

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_END)
    private boolean isEnd; // 以考勤时间段为标准，考勤结束时为true, 未结束时为false

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public String getStudentName() {
        return studentName;

    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAttendanceCount() {
        return studentAttendanceCount;
    }

    public void setStudentAttendanceCount(int studentAttendanceCount) {
        this.studentAttendanceCount = studentAttendanceCount;
    }

    public int getStudentAbsentCount() {
        return studentAbsentCount;
    }

    public void setStudentAbsentCount(int studentAbsentCount) {
        this.studentAbsentCount = studentAbsentCount;
    }

    public int getTotalAttendanceCount() {
        return totalAttendanceCount;
    }

    public void setTotalAttendanceCount(int totalAttendanceCount) {
        this.totalAttendanceCount = totalAttendanceCount;
    }

    public int getTotalAbsentCount() {
        return totalAbsentCount;
    }

    public void setTotalAbsentCount(int totalAbsentCount) {
        this.totalAbsentCount = totalAbsentCount;
    }
}
