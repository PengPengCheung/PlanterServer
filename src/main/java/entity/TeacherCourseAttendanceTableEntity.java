package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/4/19.
 */
@Entity
@Table(name = "teacher_course_attendance_table", schema = "PlanterDatabase", catalog = "")
public class TeacherCourseAttendanceTableEntity {
    private String teacherAttendanceId;
    private String openClassId;
    private String attendanceBeginTime;
    private String attendanceEndTime;
    private int attendanceBeginStatus;
    private String attendanceCode;
    private Integer attendanceCount;
    private Integer absenceCount;

    public void setAttendanceBeginStatus(Integer attendanceBeginStatus) {
        this.attendanceBeginStatus = attendanceBeginStatus;
    }

    @Id
    @Column(name = "teacher_attendance_id")
    public String getTeacherAttendanceId() {
        return teacherAttendanceId;
    }

    public void setTeacherAttendanceId(String teacherAttendanceId) {
        this.teacherAttendanceId = teacherAttendanceId;
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
    @Column(name = "attendance_begin_time")
    public String getAttendanceBeginTime() {
        return attendanceBeginTime;
    }

    public void setAttendanceBeginTime(String attendanceBeginTime) {
        this.attendanceBeginTime = attendanceBeginTime;
    }

    @Basic
    @Column(name = "attendance_end_time")
    public String getAttendanceEndTime() {
        return attendanceEndTime;
    }

    public void setAttendanceEndTime(String attendanceEndTime) {
        this.attendanceEndTime = attendanceEndTime;
    }

    @Basic
    @Column(name = "attendance_begin_status")
    public int getAttendanceBeginStatus() {
        return attendanceBeginStatus;
    }

    public void setAttendanceBeginStatus(int attendanceBeginStatus) {
        this.attendanceBeginStatus = attendanceBeginStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherCourseAttendanceTableEntity entity = (TeacherCourseAttendanceTableEntity) o;

        if (attendanceBeginStatus != entity.attendanceBeginStatus) return false;
        if (teacherAttendanceId != null ? !teacherAttendanceId.equals(entity.teacherAttendanceId) : entity.teacherAttendanceId != null)
            return false;
        if (openClassId != null ? !openClassId.equals(entity.openClassId) : entity.openClassId != null) return false;
        if (attendanceBeginTime != null ? !attendanceBeginTime.equals(entity.attendanceBeginTime) : entity.attendanceBeginTime != null)
            return false;
        if (attendanceEndTime != null ? !attendanceEndTime.equals(entity.attendanceEndTime) : entity.attendanceEndTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherAttendanceId != null ? teacherAttendanceId.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (attendanceBeginTime != null ? attendanceBeginTime.hashCode() : 0);
        result = 31 * result + (attendanceEndTime != null ? attendanceEndTime.hashCode() : 0);
        result = 31 * result + attendanceBeginStatus;
        return result;
    }

    @Basic
    @Column(name = "attendance_code")
    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    @Basic
    @Column(name = "attendance_count")
    public Integer getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(Integer attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    @Basic
    @Column(name = "absence_count")
    public Integer getAbsenceCount() {
        return absenceCount;
    }

    public void setAbsenceCount(Integer absenceCount) {
        this.absenceCount = absenceCount;
    }
}
