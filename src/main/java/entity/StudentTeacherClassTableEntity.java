package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_teacher_class_table", schema = "PlanterDatabase", catalog = "")
public class StudentTeacherClassTableEntity {

    private String openClassId;
    private Integer classStatus;
    private String cId;
    private String tId;
    private String classBeginTime;
    private String classEndTime;

    @Id
    @Column(name = "open_class_id")
    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentTeacherClassTableEntity that = (StudentTeacherClassTableEntity) o;

        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;

        return true;
    }


    @Basic
    @Column(name = "class_status")
    public Integer getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Integer classStatus) {
        this.classStatus = classStatus;
    }

    @Basic
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "class_begin_time")
    public String getClassBeginTime() {
        return classBeginTime;
    }

    public void setClassBeginTime(String classBeginTime) {
        this.classBeginTime = classBeginTime;
    }

    @Basic
    @Column(name = "class_end_time")
    public String getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime;
    }

    @Override
    public int hashCode() {
        int result = openClassId != null ? openClassId.hashCode() : 0;
        result = 31 * result + (classStatus != null ? classStatus.hashCode() : 0);
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (tId != null ? tId.hashCode() : 0);
        result = 31 * result + (classBeginTime != null ? classBeginTime.hashCode() : 0);
        result = 31 * result + (classEndTime != null ? classEndTime.hashCode() : 0);
        return result;
    }
}
