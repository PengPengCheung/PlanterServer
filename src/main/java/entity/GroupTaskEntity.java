package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "group_task", schema = "PlanterDatabase", catalog = "")
public class GroupTaskEntity {
    private String groupTaskId;
    private String groupTaskPublishDate;
    private String groupTaskContent;
    private String groupTaskDdl;

    @Id
    @Column(name = "group_task_id")
    public String getGroupTaskId() {
        return groupTaskId;
    }

    public void setGroupTaskId(String groupTaskId) {
        this.groupTaskId = groupTaskId;
    }

    @Basic
    @Column(name = "group_task_publish_date")
    public String getGroupTaskPublishDate() {
        return groupTaskPublishDate;
    }

    public void setGroupTaskPublishDate(String groupTaskPublishDate) {
        this.groupTaskPublishDate = groupTaskPublishDate;
    }

    @Basic
    @Column(name = "group_task_content")
    public String getGroupTaskContent() {
        return groupTaskContent;
    }

    public void setGroupTaskContent(String groupTaskContent) {
        this.groupTaskContent = groupTaskContent;
    }

    @Basic
    @Column(name = "group_task_ddl")
    public String getGroupTaskDdl() {
        return groupTaskDdl;
    }

    public void setGroupTaskDdl(String groupTaskDdl) {
        this.groupTaskDdl = groupTaskDdl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTaskEntity entity = (GroupTaskEntity) o;

        if (groupTaskId != null ? !groupTaskId.equals(entity.groupTaskId) : entity.groupTaskId != null) return false;
        if (groupTaskPublishDate != null ? !groupTaskPublishDate.equals(entity.groupTaskPublishDate) : entity.groupTaskPublishDate != null)
            return false;
        if (groupTaskContent != null ? !groupTaskContent.equals(entity.groupTaskContent) : entity.groupTaskContent != null)
            return false;
        if (groupTaskDdl != null ? !groupTaskDdl.equals(entity.groupTaskDdl) : entity.groupTaskDdl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupTaskId != null ? groupTaskId.hashCode() : 0;
        result = 31 * result + (groupTaskPublishDate != null ? groupTaskPublishDate.hashCode() : 0);
        result = 31 * result + (groupTaskContent != null ? groupTaskContent.hashCode() : 0);
        result = 31 * result + (groupTaskDdl != null ? groupTaskDdl.hashCode() : 0);
        return result;
    }
}
