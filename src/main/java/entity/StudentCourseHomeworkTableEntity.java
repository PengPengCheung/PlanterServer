package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_course_homework_table", schema = "PlanterDatabase", catalog = "")
@IdClass(StudentCourseHomeworkTableEntityPK.class)
public class StudentCourseHomeworkTableEntity {
//    private String sId;
    private String s_id;
    private String cId;
    private String homeworkId;
    private String homeworkSubmitDate;
    private Integer homeworkScoreStatus;
    private Integer homeworkScore;
    private String studentSubmitHomeworkId;
    private String homeworkDownloadUrl;
    private String homeworkSubmitName;
    private String homeworkSavePath;

    @Basic
    @Column(name = "s_id")
    public String getsId() {
//        return sId;
        return s_id;
    }

    public void setsId(String sId) {
//        this.sId = sId;
        this.s_id=sId;
    }

    @Basic
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "homework_id")
    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Basic
    @Column(name = "homework_submit_date")
    public String getHomeworkSubmitDate() {
        return homeworkSubmitDate;
    }

    public void setHomeworkSubmitDate(String homeworkSubmitDate) {
        this.homeworkSubmitDate = homeworkSubmitDate;
    }

    @Basic
    @Column(name = "homework_score_status")
    public Integer getHomeworkScoreStatus() {
        return homeworkScoreStatus;
    }

    public void setHomeworkScoreStatus(Integer homeworkScoreStatus) {
        this.homeworkScoreStatus = homeworkScoreStatus;
    }

    @Basic
    @Column(name = "homework_score")
    public Integer getHomeworkScore() {
        return homeworkScore;
    }

    public void setHomeworkScore(Integer homeworkScore) {
        this.homeworkScore = homeworkScore;
    }

    @Id
    @Column(name = "student_submit_homework_id")
    public String getStudentSubmitHomeworkId() {
        return studentSubmitHomeworkId;
    }

    public void setStudentSubmitHomeworkId(String studentSubmitHomeworkId) {
        this.studentSubmitHomeworkId = studentSubmitHomeworkId;
    }

    @Basic
    @Column(name = "homework_download_url")
    public String getHomeworkDownloadUrl() {
        return homeworkDownloadUrl;
    }

    public void setHomeworkDownloadUrl(String homeworkDownloadUrl) {
        this.homeworkDownloadUrl = homeworkDownloadUrl;
    }

    @Basic
    @Column(name = "homework_submit_name")
    public String getHomeworkSubmitName() {
        return homeworkSubmitName;
    }

    public void setHomeworkSubmitName(String homeworkSubmitName) {
        this.homeworkSubmitName = homeworkSubmitName;
    }

    @Basic
    @Column(name = "homework_save_path")
    public String getHomeworkSavePath() {
        return homeworkSavePath;
    }

    public void setHomeworkSavePath(String homeworkSavePath) {
        this.homeworkSavePath = homeworkSavePath;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseHomeworkTableEntity entity = (StudentCourseHomeworkTableEntity) o;

//        if (sId != null ? !sId.equals(entity.sId) : entity.sId != null) return false;
        if (s_id != null ? !s_id.equals(entity.s_id) : entity.s_id != null) return false;
        if (cId != null ? !cId.equals(entity.cId) : entity.cId != null) return false;
        if (homeworkId != null ? !homeworkId.equals(entity.homeworkId) : entity.homeworkId != null) return false;
        if (homeworkSubmitDate != null ? !homeworkSubmitDate.equals(entity.homeworkSubmitDate) : entity.homeworkSubmitDate != null)
            return false;
        if (homeworkScoreStatus != null ? !homeworkScoreStatus.equals(entity.homeworkScoreStatus) : entity.homeworkScoreStatus != null)
            return false;
        if (homeworkScore != null ? !homeworkScore.equals(entity.homeworkScore) : entity.homeworkScore != null)
            return false;
        if (studentSubmitHomeworkId != null ? !studentSubmitHomeworkId.equals(entity.studentSubmitHomeworkId) : entity.studentSubmitHomeworkId != null)
            return false;
        if (homeworkDownloadUrl != null ? !homeworkDownloadUrl.equals(entity.homeworkDownloadUrl) : entity.homeworkDownloadUrl != null)
            return false;
        if (homeworkSubmitName != null ? !homeworkSubmitName.equals(entity.homeworkSubmitName) : entity.homeworkSubmitName != null)
            return false;
        if (homeworkSavePath != null ? !homeworkSavePath.equals(entity.homeworkSavePath) : entity.homeworkSavePath != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
//        int result = sId != null ? sId.hashCode() : 0;
        int result = s_id != null ? s_id.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (homeworkId != null ? homeworkId.hashCode() : 0);
        result = 31 * result + (homeworkSubmitDate != null ? homeworkSubmitDate.hashCode() : 0);
        result = 31 * result + (homeworkScoreStatus != null ? homeworkScoreStatus.hashCode() : 0);
        result = 31 * result + (homeworkScore != null ? homeworkScore.hashCode() : 0);
        result = 31 * result + (studentSubmitHomeworkId != null ? studentSubmitHomeworkId.hashCode() : 0);
        result = 31 * result + (homeworkDownloadUrl != null ? homeworkDownloadUrl.hashCode() : 0);
        result = 31 * result + (homeworkSubmitName != null ? homeworkSubmitName.hashCode() : 0);
        result = 31 * result + (homeworkSavePath != null ? homeworkSavePath.hashCode() : 0);
        return result;
    }
}
