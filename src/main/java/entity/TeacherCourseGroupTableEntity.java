package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "teacher_course_group_table", schema = "PlanterDatabase", catalog = "")
@IdClass(TeacherCourseGroupTableEntityPK.class)
public class TeacherCourseGroupTableEntity {
    private String tId;
    private String cId;
    private String groupMemberLimit;
    private Integer groupOpening;
    private String teacherCourseGroupId;
    private String groupOpenTime;

    @Basic
    @Id
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Basic
    @Id
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "group_member_limit")
    public String getGroupMemberLimit() {
        return groupMemberLimit;
    }

    public void setGroupMemberLimit(String groupMemberLimit) {
        this.groupMemberLimit = groupMemberLimit;
    }

    @Basic
    @Column(name = "group_opening")
    public Integer getGroupOpening() {
        return groupOpening;
    }

    public void setGroupOpening(Integer groupOpening) {
        this.groupOpening = groupOpening;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherCourseGroupTableEntity entity = (TeacherCourseGroupTableEntity) o;

        if (tId != null ? !tId.equals(entity.tId) : entity.tId != null) return false;
        if (cId != null ? !cId.equals(entity.cId) : entity.cId != null) return false;
        if (groupMemberLimit != null ? !groupMemberLimit.equals(entity.groupMemberLimit) : entity.groupMemberLimit != null)
            return false;
        if (groupOpening != null ? !groupOpening.equals(entity.groupOpening) : entity.groupOpening != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId != null ? tId.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (groupMemberLimit != null ? groupMemberLimit.hashCode() : 0);
        result = 31 * result + (groupOpening != null ? groupOpening.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "teacher_course_group_id")
    public String getTeacherCourseGroupId() {
        return teacherCourseGroupId;
    }

    public void setTeacherCourseGroupId(String teacherCourseGroupId) {
        this.teacherCourseGroupId = teacherCourseGroupId;
    }

    @Basic
    @Column(name = "group_open_time")
    public String getGroupOpenTime() {
        return groupOpenTime;
    }

    public void setGroupOpenTime(String groupOpenTime) {
        this.groupOpenTime = groupOpenTime;
    }
}
