package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "homework_info", schema = "PlanterDatabase", catalog = "")
public class HomeworkInfoEntity {
    private String homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private int homeworkStatus;
    private String homeworkCommitDdl;
    private String homeworkPublishTime;

    @Basic
    @Column(name = "homework_commit_ddl")
    public String getHomeworkCommitDdl() {
        return homeworkCommitDdl;
    }

    public void setHomeworkCommitDdl(String homeworkCommitDdl) {
        this.homeworkCommitDdl = homeworkCommitDdl;
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
    @Column(name = "homework_title")
    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    @Basic
    @Column(name = "homework_content")
    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    @Basic
    @Column(name = "homework_status")
    public int getHomeworkStatus() {
        return homeworkStatus;
    }

    public void setHomeworkStatus(int homeworkStatus) {
        this.homeworkStatus = homeworkStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeworkInfoEntity entity = (HomeworkInfoEntity) o;

        if (homeworkStatus != entity.homeworkStatus) return false;
        if (homeworkId != null ? !homeworkId.equals(entity.homeworkId) : entity.homeworkId != null) return false;
        if (homeworkTitle != null ? !homeworkTitle.equals(entity.homeworkTitle) : entity.homeworkTitle != null)
            return false;
        if (homeworkContent != null ? !homeworkContent.equals(entity.homeworkContent) : entity.homeworkContent != null)
            return false;
        if (homeworkCommitDdl != null ? !homeworkCommitDdl.equals(entity.homeworkCommitDdl) : entity.homeworkCommitDdl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = homeworkId != null ? homeworkId.hashCode() : 0;
        result = 31 * result + (homeworkTitle != null ? homeworkTitle.hashCode() : 0);
        result = 31 * result + (homeworkContent != null ? homeworkContent.hashCode() : 0);
        result = 31 * result + homeworkStatus;
        result = 31 * result + (homeworkCommitDdl != null ? homeworkCommitDdl.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "homework_publish_time")
    public String getHomeworkPublishTime() {
        return homeworkPublishTime;
    }

    public void setHomeworkPublishTime(String homeworkPublishTime) {
        this.homeworkPublishTime = homeworkPublishTime;
    }
}
