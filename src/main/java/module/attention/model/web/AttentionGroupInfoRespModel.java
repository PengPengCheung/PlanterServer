package module.attention.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/8.
 */
public class AttentionGroupInfoRespModel {

    @JsonProperty(Resource.KEY.KEY_GROUP_ID)
    private String groupId;

    @JsonProperty(Resource.KEY.KEY_GROUP_NAME)
    private String groupName;

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
}
