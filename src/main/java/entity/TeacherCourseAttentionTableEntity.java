package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/4/20.
 */
@Entity
@Table(name = "teacher_course_attention_table", schema = "PlanterDatabase", catalog = "")
public class TeacherCourseAttentionTableEntity {
    private String teacherCourseAttentionId;
    private String openClassId;
    private String attentionBeginTime;
    private String attentionEndTime;
    private int attentionType;
    private String attentionDuration;

    @Id
    @Column(name = "teacher_course_attention_id")
    public String getTeacherCourseAttentionId() {
        return teacherCourseAttentionId;
    }

    public void setTeacherCourseAttentionId(String teacherCourseAttentionId) {
        this.teacherCourseAttentionId = teacherCourseAttentionId;
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
    @Column(name = "attention_begin_time")
    public String getAttentionBeginTime() {
        return attentionBeginTime;
    }

    public void setAttentionBeginTime(String attentionBeginTime) {
        this.attentionBeginTime = attentionBeginTime;
    }

    @Basic
    @Column(name = "attention_end_time")
    public String getAttentionEndTime() {
        return attentionEndTime;
    }

    public void setAttentionEndTime(String attentionEndTime) {
        this.attentionEndTime = attentionEndTime;
    }

    @Basic
    @Column(name = "attention_type")
    public int getAttentionType() {
        return attentionType;
    }

    public void setAttentionType(int attentionType) {
        this.attentionType = attentionType;
    }

    @Basic
    @Column(name = "attention_duration")
    public String getAttentionDuration() {
        return attentionDuration;
    }

    public void setAttentionDuration(String attentionDuration) {
        this.attentionDuration = attentionDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherCourseAttentionTableEntity that = (TeacherCourseAttentionTableEntity) o;

        if (attentionType != that.attentionType) return false;
        if (teacherCourseAttentionId != null ? !teacherCourseAttentionId.equals(that.teacherCourseAttentionId) : that.teacherCourseAttentionId != null)
            return false;
        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;
        if (attentionBeginTime != null ? !attentionBeginTime.equals(that.attentionBeginTime) : that.attentionBeginTime != null)
            return false;
        if (attentionEndTime != null ? !attentionEndTime.equals(that.attentionEndTime) : that.attentionEndTime != null)
            return false;
        if (attentionDuration != null ? !attentionDuration.equals(that.attentionDuration) : that.attentionDuration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherCourseAttentionId != null ? teacherCourseAttentionId.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (attentionBeginTime != null ? attentionBeginTime.hashCode() : 0);
        result = 31 * result + (attentionEndTime != null ? attentionEndTime.hashCode() : 0);
        result = 31 * result + attentionType;
        result = 31 * result + (attentionDuration != null ? attentionDuration.hashCode() : 0);
        return result;
    }
}
