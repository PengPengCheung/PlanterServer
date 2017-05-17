package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "group_info", schema = "PlanterDatabase", catalog = "")
public class GroupInfoEntity {
    private String groupId;
    private String groupDate;
    private String groupName;
    private String groupLeaderName;
    private String groupMembers;

    @Id
    @Column(name = "group_id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_date")
    public String getGroupDate() {
        return groupDate;
    }

    public void setGroupDate(String groupDate) {
        this.groupDate = groupDate;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_leader_name")
    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }

    @Basic
    @Column(name = "group_members")
    public String getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(String groupMembers) {
        this.groupMembers = groupMembers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupInfoEntity that = (GroupInfoEntity) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupDate != null ? !groupDate.equals(that.groupDate) : that.groupDate != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupLeaderName != null ? !groupLeaderName.equals(that.groupLeaderName) : that.groupLeaderName != null)
            return false;
        if (groupMembers != null ? !groupMembers.equals(that.groupMembers) : that.groupMembers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupDate != null ? groupDate.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupMembers != null ? groupMembers.hashCode() : 0);
        result = 31 * result + (groupLeaderName != null ? groupLeaderName.hashCode() : 0);
        return result;
    }
}
