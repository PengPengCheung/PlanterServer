package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by peng on 2017/3/22.
 */
public class GroupTaskConnectionEntityPK implements Serializable {
    private String groupId;
    private String groupTaskId;

    @Column(name = "group_id")
    @Id
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(name = "group_task_id")
    @Id
    public String getGroupTaskId() {
        return groupTaskId;
    }

    public void setGroupTaskId(String groupTaskId) {
        this.groupTaskId = groupTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupTaskConnectionEntityPK that = (GroupTaskConnectionEntityPK) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupTaskId != null ? !groupTaskId.equals(that.groupTaskId) : that.groupTaskId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupTaskId != null ? groupTaskId.hashCode() : 0);
        return result;
    }
}
