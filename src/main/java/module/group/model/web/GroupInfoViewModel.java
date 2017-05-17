package module.group.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

import java.util.List;

/**
 * Created by peng on 2017/4/8.
 */
public class GroupInfoViewModel extends BaseViewModel {


    @JsonProperty(Resource.KEY.KEY_GROUP_ID)
    private String groupId;

    @JsonProperty(Resource.KEY.KEY_GROUP_NAME)
    private String groupName;

    @JsonProperty(Resource.KEY.KEY_GROUP_MEMBERS)
    private List<String> groupMemberList;

    @JsonProperty(Resource.KEY.KEY_GROUP_LEADER_NAME)
    private String groupLeaderName;

    @JsonProperty(Resource.KEY.KEY_GROUP_TASK_CONTENT)
    private String taskContent;

    @JsonProperty(Resource.KEY.KEY_GROUP_STUDENT_SCORE)
    private int studentScore;

    @JsonProperty(Resource.KEY.KEY_GROUP_TEACHER_SCORE)
    private int teacherScore;

    public List<String> getGroupMemberList() {
        return groupMemberList;
    }

    public void setGroupMemberList(List<String> groupMemberList) {
        this.groupMemberList = groupMemberList;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }

    public int getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(int teacherScore) {
        this.teacherScore = teacherScore;
    }
}
