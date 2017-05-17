package module.homework.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

import javax.persistence.JoinColumn;

/**
 * Created by peng on 2017/4/14.
 */
public class HomeworkStudentInfoModel {

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_ID)
    private String homeworkId;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_TITLE)
    private String homeworkTitle;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_DDL)
    private String homeworkDDL;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_CONTENT)
    private String homeworkContent;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_NUM)
    private int homeworkSubmitNum;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_STATUS)
    private int homeworkSubmitStatus;

    public int getHomeworkSubmitStatus() {
        return homeworkSubmitStatus;
    }

    public void setHomeworkSubmitStatus(int homeworkSubmitStatus) {
        this.homeworkSubmitStatus = homeworkSubmitStatus;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public String getHomeworkDDL() {
        return homeworkDDL;
    }

    public void setHomeworkDDL(String homeworkDDL) {
        this.homeworkDDL = homeworkDDL;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public int getHomeworkSubmitNum() {
        return homeworkSubmitNum;
    }

    public void setHomeworkSubmitNum(int homeworkSubmitNum) {
        this.homeworkSubmitNum = homeworkSubmitNum;
    }
}
