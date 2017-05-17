package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/25.
 */
@Entity
@Table(name = "student_summary", schema = "PlanterDatabase", catalog = "")
@IdClass(StudentSummaryEntityPK.class)
public class StudentSummaryEntity {
    private String sId;
    private String summaryTime;
    private String summaryContent;
    private String summaryEvaluation;
    private Integer summaryBonus;
    private Integer summaryStatus;
    private String openClassId;
    private String studentSummaryId;

    @Basic
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "summary_time")
    public String getSummaryTime() {
        return summaryTime;
    }

    public void setSummaryTime(String summaryTime) {
        this.summaryTime = summaryTime;
    }

    @Basic
    @Column(name = "summary_content")
    public String getSummaryContent() {
        return summaryContent;
    }

    public void setSummaryContent(String summaryContent) {
        this.summaryContent = summaryContent;
    }

    @Basic
    @Column(name = "summary_evaluation")
    public String getSummaryEvaluation() {
        return summaryEvaluation;
    }

    public void setSummaryEvaluation(String summaryEvaluation) {
        this.summaryEvaluation = summaryEvaluation;
    }

    @Basic
    @Column(name = "summary_bonus")
    public Integer getSummaryBonus() {
        return summaryBonus;
    }

    public void setSummaryBonus(Integer summaryBonus) {
        this.summaryBonus = summaryBonus;
    }

    @Basic
    @Column(name = "summary_status")
    public Integer getSummaryStatus() {
        return summaryStatus;
    }

    public void setSummaryStatus(Integer summaryStatus) {
        this.summaryStatus = summaryStatus;
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
    @Column(name = "student_summary_id")
    public String getStudentSummaryId() {
        return studentSummaryId;
    }

    public void setStudentSummaryId(String studentSummaryId) {
        this.studentSummaryId = studentSummaryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentSummaryEntity entity = (StudentSummaryEntity) o;

        if (sId != null ? !sId.equals(entity.sId) : entity.sId != null) return false;
        if (summaryTime != null ? !summaryTime.equals(entity.summaryTime) : entity.summaryTime != null) return false;
        if (summaryContent != null ? !summaryContent.equals(entity.summaryContent) : entity.summaryContent != null)
            return false;
        if (summaryEvaluation != null ? !summaryEvaluation.equals(entity.summaryEvaluation) : entity.summaryEvaluation != null)
            return false;
        if (summaryBonus != null ? !summaryBonus.equals(entity.summaryBonus) : entity.summaryBonus != null)
            return false;
        if (summaryStatus != null ? !summaryStatus.equals(entity.summaryStatus) : entity.summaryStatus != null)
            return false;
        if (openClassId != null ? !openClassId.equals(entity.openClassId) : entity.openClassId != null) return false;
        if (studentSummaryId != null ? !studentSummaryId.equals(entity.studentSummaryId) : entity.studentSummaryId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId != null ? sId.hashCode() : 0;
        result = 31 * result + (summaryTime != null ? summaryTime.hashCode() : 0);
        result = 31 * result + (summaryContent != null ? summaryContent.hashCode() : 0);
        result = 31 * result + (summaryEvaluation != null ? summaryEvaluation.hashCode() : 0);
        result = 31 * result + (summaryBonus != null ? summaryBonus.hashCode() : 0);
        result = 31 * result + (summaryStatus != null ? summaryStatus.hashCode() : 0);
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (studentSummaryId != null ? studentSummaryId.hashCode() : 0);
        return result;
    }
}
