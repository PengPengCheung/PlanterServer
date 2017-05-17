package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/25.
 */
@Entity
@Table(name = "teacher_summary", schema = "PlanterDatabase", catalog = "")
@IdClass(TeacherSummaryEntityPK.class)
public class TeacherSummaryEntity {
    private String summaryRequestTime;
    private String openClassId;
    private String teacherSummaryId;

    @Basic
    @Column(name = "summary_request_time")
    public String getSummaryRequestTime() {
        return summaryRequestTime;
    }

    public void setSummaryRequestTime(String summaryRequestTime) {
        this.summaryRequestTime = summaryRequestTime;
    }

    @Basic
    @Column(name = "open_class_id")
    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    @Id
    @Column(name = "teacher_summary_id")
    public String getTeacherSummaryId() {
        return teacherSummaryId;
    }

    public void setTeacherSummaryId(String teacherSummaryId) {
        this.teacherSummaryId = teacherSummaryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherSummaryEntity entity = (TeacherSummaryEntity) o;

        if (summaryRequestTime != null ? !summaryRequestTime.equals(entity.summaryRequestTime) : entity.summaryRequestTime != null)
            return false;
        if (openClassId != null ? !openClassId.equals(entity.openClassId) : entity.openClassId != null) return false;
        if (teacherSummaryId != null ? !teacherSummaryId.equals(entity.teacherSummaryId) : entity.teacherSummaryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = summaryRequestTime != null ? summaryRequestTime.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (teacherSummaryId != null ? teacherSummaryId.hashCode() : 0);
        return result;
    }
}
