package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/23.
 */
@Entity
@Table(name = "attendance_info", schema = "PlanterDatabase", catalog = "")
public class AttendanceInfoEntity {
    private String attendanceDatetime;
    private int attendanceStatus;
    private String attendanceCode;
    private String attendanceValidTime;
    private Integer attendanceBonus;
    private String attendanceInfoId;

    @Basic
    @Column(name = "attendance_datetime")
    public String getAttendanceDatetime() {
        return attendanceDatetime;
    }

    public void setAttendanceDatetime(String attendanceDatetime) {
        this.attendanceDatetime = attendanceDatetime;
    }

    @Basic
    @Column(name = "attendance_status")
    public int getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(int attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
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
    @Column(name = "attendance_valid_time")
    public String getAttendanceValidTime() {
        return attendanceValidTime;
    }

    public void setAttendanceValidTime(String attendanceValidTime) {
        this.attendanceValidTime = attendanceValidTime;
    }

    @Basic
    @Column(name = "attendance_bonus")
    public Integer getAttendanceBonus() {
        return attendanceBonus;
    }

    public void setAttendanceBonus(Integer attendanceBonus) {
        this.attendanceBonus = attendanceBonus;
    }

    @Id
    @Column(name = "attendance_info_id")
    public String getAttendanceInfoId() {
        return attendanceInfoId;
    }

    public void setAttendanceInfoId(String attendanceInfoId) {
        this.attendanceInfoId = attendanceInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceInfoEntity entity = (AttendanceInfoEntity) o;

        if (attendanceStatus != entity.attendanceStatus) return false;
        if (attendanceDatetime != null ? !attendanceDatetime.equals(entity.attendanceDatetime) : entity.attendanceDatetime != null)
            return false;
        if (attendanceCode != null ? !attendanceCode.equals(entity.attendanceCode) : entity.attendanceCode != null)
            return false;
        if (attendanceValidTime != null ? !attendanceValidTime.equals(entity.attendanceValidTime) : entity.attendanceValidTime != null)
            return false;
        if (attendanceBonus != null ? !attendanceBonus.equals(entity.attendanceBonus) : entity.attendanceBonus != null)
            return false;
        if (attendanceInfoId != null ? !attendanceInfoId.equals(entity.attendanceInfoId) : entity.attendanceInfoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attendanceDatetime != null ? attendanceDatetime.hashCode() : 0;
        result = 31 * result + attendanceStatus;
        result = 31 * result + (attendanceCode != null ? attendanceCode.hashCode() : 0);
        result = 31 * result + (attendanceValidTime != null ? attendanceValidTime.hashCode() : 0);
        result = 31 * result + (attendanceBonus != null ? attendanceBonus.hashCode() : 0);
        result = 31 * result + (attendanceInfoId != null ? attendanceInfoId.hashCode() : 0);
        return result;
    }
}
