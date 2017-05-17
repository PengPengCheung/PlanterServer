package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_performance_attendance_table", schema = "PlanterDatabase", catalog = "")
public class StudentPerformanceAttendanceTableEntity {
    private String studentPerformanceAttendanceId;
    private String openClassId;
    private String attendanceId;

    @Id
    @Column(name = "student_performance_attendance_id")
    public String getStudentPerformanceAttendanceId() {
        return studentPerformanceAttendanceId;
    }

    public void setStudentPerformanceAttendanceId(String studentPerformanceAttendanceId) {
        this.studentPerformanceAttendanceId = studentPerformanceAttendanceId;
    }

    @Basic
    @Column(name = "open_class_id")
    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    @Basic
    @Column(name = "attendance_id")
    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentPerformanceAttendanceTableEntity that = (StudentPerformanceAttendanceTableEntity) o;

        if (studentPerformanceAttendanceId != null ? !studentPerformanceAttendanceId.equals(that.studentPerformanceAttendanceId) : that.studentPerformanceAttendanceId != null)
            return false;
        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;
        if (attendanceId != null ? !attendanceId.equals(that.attendanceId) : that.attendanceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentPerformanceAttendanceId != null ? studentPerformanceAttendanceId.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (attendanceId != null ? attendanceId.hashCode() : 0);
        return result;
    }
}
