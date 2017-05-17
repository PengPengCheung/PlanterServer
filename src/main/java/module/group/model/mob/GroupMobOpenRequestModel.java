package module.group.model.mob;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

import java.util.List;

/**
 * Created by peng on 2017/4/25.
 */
public class GroupMobOpenRequestModel {

    @JsonProperty(Resource.KEY.KEY_TEACHER_OPEN_GROUP_ID)
    private String teacherOpenGroupId;

    @JsonProperty(Resource.KEY.KEY_GROUP_LEADER_NAME)
    private String leaderName;

    @JsonProperty(Resource.KEY.KEY_GROUP_MEMBERS)
    private List<String> memberList;

    @JsonProperty(Resource.KEY.KEY_GROUP_NAME)
    private String groupName;

    @JsonProperty(Resource.KEY.KEY_GROUP_OPEN_TIME)
    private String groupOpenTime;

    public String getGroupOpenTime() {
        return groupOpenTime;
    }

    public void setGroupOpenTime(String groupOpenTime) {
        this.groupOpenTime = groupOpenTime;
    }

    public String getTeacherOpenGroupId() {
        return teacherOpenGroupId;
    }

    public void setTeacherOpenGroupId(String teacherOpenGroupId) {
        this.teacherOpenGroupId = teacherOpenGroupId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String groupMembersToString(){
        if(memberList != null){
            StringBuilder stringBuilder = new StringBuilder();
            for(String member : memberList){
                stringBuilder.append(member);
                stringBuilder.append(",");
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }

        return "";
    }
}
