package module.group.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/8.
 */
public class GroupScoreRequestViewModel {

    @JsonProperty(Resource.KEY.KEY_GROUP_TEACHER_SCORE)
    private int teacherScore;

    @JsonProperty(Resource.KEY.KEY_GROUP_ID)
    private String groupId;


    public int getTeacherScore() {
        return teacherScore;
    }

    public void setTeacherScore(int teacherScore) {
        this.teacherScore = teacherScore;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
