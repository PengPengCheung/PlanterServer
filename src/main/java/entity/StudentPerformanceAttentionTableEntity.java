package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/27.
 */
@Entity
@Table(name = "student_performance_attention_table", schema = "PlanterDatabase", catalog = "")
public class StudentPerformanceAttentionTableEntity {
    private String openClassId;
    private String attentionId;
    private String studentPerformanceAttentionId;
    private String sId;

    @Basic
    @Column(name = "open_class_id")
    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    @Basic
    @Column(name = "attention_id")
    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

    @Id
    @Column(name = "student_performance_attention_id")
    public String getStudentPerformanceAttentionId() {
        return studentPerformanceAttentionId;
    }

    public void setStudentPerformanceAttentionId(String studentPerformanceAttentionId) {
        this.studentPerformanceAttentionId = studentPerformanceAttentionId;
    }

    @Basic
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentPerformanceAttentionTableEntity that = (StudentPerformanceAttentionTableEntity) o;

        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;
        if (attentionId != null ? !attentionId.equals(that.attentionId) : that.attentionId != null) return false;
        if (studentPerformanceAttentionId != null ? !studentPerformanceAttentionId.equals(that.studentPerformanceAttentionId) : that.studentPerformanceAttentionId != null)
            return false;
        if (sId != null ? !sId.equals(that.sId) : that.sId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentPerformanceAttentionId != null ? studentPerformanceAttentionId.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (attentionId != null ? attentionId.hashCode() : 0);
        result = 31 * result + (sId != null ? sId.hashCode() : 0);
        return result;
    }
}
