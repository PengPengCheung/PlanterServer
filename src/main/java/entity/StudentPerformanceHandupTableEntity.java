package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_performance_handup_table", schema = "PlanterDatabase", catalog = "")
public class StudentPerformanceHandupTableEntity {
    private String openClassId;
    private String handupInfoId;
    private String studentPerfomanceHandupId;

    @Basic
    @Column(name = "open_class_id")
    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    @Basic
    @Column(name = "handup_info_id")
    public String getHandupInfoId() {
        return handupInfoId;
    }

    public void setHandupInfoId(String handupInfoId) {
        this.handupInfoId = handupInfoId;
    }

    @Id
    @Column(name = "student_perfomance_handup_id")
    public String getStudentPerfomanceHandupId() {
        return studentPerfomanceHandupId;
    }

    public void setStudentPerfomanceHandupId(String studentPerfomanceHandupId) {
        this.studentPerfomanceHandupId = studentPerfomanceHandupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentPerformanceHandupTableEntity that = (StudentPerformanceHandupTableEntity) o;

        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;
        if (handupInfoId != null ? !handupInfoId.equals(that.handupInfoId) : that.handupInfoId != null) return false;
        if (studentPerfomanceHandupId != null ? !studentPerfomanceHandupId.equals(that.studentPerfomanceHandupId) : that.studentPerfomanceHandupId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openClassId != null ? openClassId.hashCode() : 0;
        result = 31 * result + (handupInfoId != null ? handupInfoId.hashCode() : 0);
        result = 31 * result + (studentPerfomanceHandupId != null ? studentPerfomanceHandupId.hashCode() : 0);
        return result;
    }
}
