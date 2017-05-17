package module.group.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

import java.util.List;

/**
 * Created by peng on 2017/4/8.
 */
public class GroupResponseModel {

    @JsonProperty(Resource.KEY.KEY_GROUP_OPEN)
    private int isOpen;

    @JsonProperty(Resource.KEY.KEY_GROUP_INFO_LIST)
    private List<GroupInfoViewModel> groupInfoList;

    public List<GroupInfoViewModel> getGroupInfoList() {
        return groupInfoList;
    }

    public void setGroupInfoList(List<GroupInfoViewModel> groupInfoList) {
        this.groupInfoList = groupInfoList;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }
}
