package module.homework.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/9.
 */
public class HomeworkPublishRequestModel extends BaseViewModel{

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_TITLE)
    private String homeworkTitle;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_CONTENT)
    private String homeworkContent;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_PUBLISH_TIME)
    private String homeworkPublishTime;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL)
    private String homeworkDDL;

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public String getHomeworkPublishTime() {
        return homeworkPublishTime;
    }

    public void setHomeworkPublishTime(String homeworkPublishTime) {
        this.homeworkPublishTime = homeworkPublishTime;
    }

    public String getHomeworkDDL() {
        return homeworkDDL;
    }

    public void setHomeworkDDL(String homeworkDDL) {
        this.homeworkDDL = homeworkDDL;
    }
}
