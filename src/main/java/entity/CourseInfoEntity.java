package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/24.
 */
@Entity
@Table(name = "course_info", schema = "PlanterDatabase", catalog = "")
public class CourseInfoEntity {
    private String cId;
    private String courseTime;
    private String courseName;
    private String courseAddr;
    private String courseDuration;
    private String courseCode;

    @Id
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "course_time")
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_addr")
    public String getCourseAddr() {
        return courseAddr;
    }

    public void setCourseAddr(String courseAddr) {
        this.courseAddr = courseAddr;
    }

    @Basic
    @Column(name = "course_duration")
    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfoEntity that = (CourseInfoEntity) o;

        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (courseTime != null ? !courseTime.equals(that.courseTime) : that.courseTime != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseAddr != null ? !courseAddr.equals(that.courseAddr) : that.courseAddr != null) return false;
        if (courseDuration != null ? !courseDuration.equals(that.courseDuration) : that.courseDuration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (courseTime != null ? courseTime.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseAddr != null ? courseAddr.hashCode() : 0);
        result = 31 * result + (courseDuration != null ? courseDuration.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "course_code")
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
