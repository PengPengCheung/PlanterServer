package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "teacher_class_ask", schema = "PlanterDatabase", catalog = "")
public class TeacherClassAskEntity {
    private String teacherClassAskId;
    private String openClassId;
    private Integer askBonus;
    private String sId;
    private Integer bonusType;

    @Id
    @Column(name = "teacher_class_ask_id")
    public String getTeacherClassAskId() {
        return teacherClassAskId;
    }

    public void setTeacherClassAskId(String teacherClassAskId) {
        this.teacherClassAskId = teacherClassAskId;
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
    @Column(name = "ask_bonus")
    public Integer getAskBonus() {
        return askBonus;
    }

    public void setAskBonus(Integer askBonus) {
        this.askBonus = askBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherClassAskEntity that = (TeacherClassAskEntity) o;

        if (teacherClassAskId != null ? !teacherClassAskId.equals(that.teacherClassAskId) : that.teacherClassAskId != null)
            return false;
        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;
        if (askBonus != null ? !askBonus.equals(that.askBonus) : that.askBonus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherClassAskId != null ? teacherClassAskId.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (askBonus != null ? askBonus.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
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
