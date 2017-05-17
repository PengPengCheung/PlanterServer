package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_course_tree_bonus", schema = "PlanterDatabase", catalog = "")
@IdClass(StudentCourseTreeBonusEntityPK.class)
public class StudentCourseTreeBonusEntity {
    private String sId;
    private String cId;
    private Integer bonusReason;
    private Integer bonusNum;
    private Integer bonusType;

    @Id
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Id
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "bonus_reason")
    public Integer getBonusReason() {
        return bonusReason;
    }

    public void setBonusReason(Integer bonusReason) {
        this.bonusReason = bonusReason;
    }

    @Basic
    @Column(name = "bonus_num")
    public Integer getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(Integer bonusNum) {
        this.bonusNum = bonusNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseTreeBonusEntity that = (StudentCourseTreeBonusEntity) o;

        if (sId != null ? !sId.equals(that.sId) : that.sId != null) return false;
        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (bonusReason != null ? !bonusReason.equals(that.bonusReason) : that.bonusReason != null) return false;
        if (bonusNum != null ? !bonusNum.equals(that.bonusNum) : that.bonusNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId != null ? sId.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (bonusReason != null ? bonusReason.hashCode() : 0);
        result = 31 * result + (bonusNum != null ? bonusNum.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "bonus_type")
    public Integer getBonusType() {
        return bonusType;
    }

    public void setBonusType(Integer bonusType) {
        this.bonusType = bonusType;
    }
}
