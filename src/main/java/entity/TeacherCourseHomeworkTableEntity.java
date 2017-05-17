package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "teacher_course_homework_table", schema = "PlanterDatabase", catalog = "")
@IdClass(TeacherCourseHomeworkTableEntityPK.class)
public class TeacherCourseHomeworkTableEntity {
    private String tId;
    private String cId;
    private String homeworkId;
    private Integer homeworkPublishStatus;

    @Id
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Id
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Id
    @Column(name = "homework_id")
    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Basic
    @Column(name = "homework_publish_status")
    public Integer getHomeworkPublishStatus() {
        return homeworkPublishStatus;
    }

    public void setHomeworkPublishStatus(Integer homeworkPublishStatus) {
        this.homeworkPublishStatus = homeworkPublishStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherCourseHomeworkTableEntity that = (TeacherCourseHomeworkTableEntity) o;

        if (tId != null ? !tId.equals(that.tId) : that.tId != null) return false;
        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (homeworkId != null ? !homeworkId.equals(that.homeworkId) : that.homeworkId != null) return false;
        if (homeworkPublishStatus != null ? !homeworkPublishStatus.equals(that.homeworkPublishStatus) : that.homeworkPublishStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId != null ? tId.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (homeworkId != null ? homeworkId.hashCode() : 0);
        result = 31 * result + (homeworkPublishStatus != null ? homeworkPublishStatus.hashCode() : 0);
        return result;
    }
}
