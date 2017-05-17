package module.attendance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/1.
 */
public class AttendanceHistoryWebRequestViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_STU_NAME)
    private String studentName;
//
//    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
//    private String studentId;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ATT_COUNT)
    private int attendanceCount;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ABS_COUNT)
    private int absenceCount;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public int getAbsenceCount() {
        return absenceCount;
    }

    public void setAbsenceCount(int absenceCount) {
        this.absenceCount = absenceCount;
    }
}
