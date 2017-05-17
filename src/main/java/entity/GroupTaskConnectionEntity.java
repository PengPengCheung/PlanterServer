package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "group_task_connection", schema = "PlanterDatabase", catalog = "")
public class GroupTaskConnectionEntity {
    private String groupId;
    private String groupTaskId;
    private Integer teacherScore;
    private String classScore;
    private Integer groupBonusNum;
    private String groupTeacherOpenId;
    private Integer groupBonusType;

    @Id
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_task_id")
    public String getGroupTaskId() {
        return groupTaskId;
    }

    public void setGroupTaskId(String groupTaskId) {
        this.groupTaskId = groupTaskId;
    }

    @Basic
    @Column(name = "teacher_score")
    public Integer getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(Integer teacherScore) {
        this.teacherScore = teacherScore;
    }

    @Basic
    @Column(name = "class_score")
    public String getClassScore() {
        return classScore;
    }

    public void setClassScore(String classScore) {
        this.classScore = classScore;
    }

    @Basic
    @Column(name = "group_bonus_num")
    public Integer getGroupBonusNum() {
        return groupBonusNum;
    }

    public void setGroupBonusNum(Integer groupBonusNum) {
        this.groupBonusNum = groupBonusNum;
    }

    @Basic
    @Column(name = "group_teacher_open_id")
    public String getGroupTeacherOpenId() {
        return groupTeacherOpenId;
    }

    public void setGroupTeacherOpenId(String groupTeacherOpenId) {
        this.groupTeacherOpenId = groupTeacherOpenId;
    }

    @Basic
    @Column(name = "group_bonus_type")
    public Integer getGroupBonusType() {
        return groupBonusType;
    }

    public void setGroupBonusType(Integer groupBonusType) {
        this.groupBonusType = groupBonusType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTaskConnectionEntity that = (GroupTaskConnectionEntity) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupTaskId != null ? !groupTaskId.equals(that.groupTaskId) : that.groupTaskId != null) return false;
        if (teacherScore != null ? !teacherScore.equals(that.teacherScore) : that.teacherScore != null) return false;
        if (classScore != null ? !classScore.equals(that.classScore) : that.classScore != null) return false;
        if (groupBonusNum != null ? !groupBonusNum.equals(that.groupBonusNum) : that.groupBonusNum != null)
            return false;
        if (groupTeacherOpenId != null ? !groupTeacherOpenId.equals(that.groupTeacherOpenId) : that.groupTeacherOpenId != null)
            return false;
        if (groupBonusType != null ? !groupBonusType.equals(that.groupBonusType) : that.groupBonusType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupTaskId != null ? groupTaskId.hashCode() : 0);
        result = 31 * result + (teacherScore != null ? teacherScore.hashCode() : 0);
        result = 31 * result + (classScore != null ? classScore.hashCode() : 0);
        result = 31 * result + (groupBonusNum != null ? groupBonusNum.hashCode() : 0);
        result = 31 * result + (groupTeacherOpenId != null ? groupTeacherOpenId.hashCode() : 0);
        result = 31 * result + (groupBonusType != null ? groupBonusType.hashCode() : 0);
        return result;
    }
}
