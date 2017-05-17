package module.group.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by peng on 2017/4/8.
 */
public class GroupTaskInfoRequestViewModel extends BaseViewModel{

    @JsonProperty(Resource.KEY.KEY_GROUP_ID)
    private String groupId;

    @JsonProperty(Resource.KEY.KEY_GROUP_TASK_CONTENT)
    private String groupTaskContent;

    @JsonProperty(Resource.KEY.KEY_GROUP_TASK_PUBLISH_DATE)
    private String groupTaskPublishDate;

    @JsonProperty(Resource.KEY.KEY_GROUP_TASK_DDL)
    private String groupTaskDDL;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupTaskContent() {
        return groupTaskContent;
    }

    public void setGroupTaskContent(String groupTaskContent) {
        this.groupTaskContent = groupTaskContent;
    }

    public String getGroupTaskPublishDate() {
        return groupTaskPublishDate;
    }

    public void setGroupTaskPublishDate(String groupTaskPublishDate) {
        this.groupTaskPublishDate = groupTaskPublishDate;
    }

    public String getGroupTaskDDL() {
        return groupTaskDDL;
    }

    public void setGroupTaskDDL(String groupTaskDDL) {
        this.groupTaskDDL = groupTaskDDL;
    }
}
