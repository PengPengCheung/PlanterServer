package module.attention.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/8.
 */
public class AttentionGroupRequestViewModel extends BaseViewModel{

    @JsonProperty(Resource.KEY.KEY_ATTENTION_DURATION)
    private String attentionDuration; // 专注时长

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TYPE)
    private int attentionType;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TIME)
    private String attentionTime; // 专注的开始时刻

    @JsonProperty(Resource.KEY.KEY_GROUP_ID)
    private String groupId;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_STUDENT_NEED_SCORE)
    private boolean isStudentNeedScore;

    public String getAttentionDuration() {
        return attentionDuration;
    }

    public void setAttentionDuration(String attentionDuration) {
        this.attentionDuration = attentionDuration;
    }

    public int getAttentionType() {
        return attentionType;
    }

    public void setAttentionType(int attentionType) {
        this.attentionType = attentionType;
    }

    public String getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(String attentionTime) {
        this.attentionTime = attentionTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public boolean isStudentNeedScore() {
        return isStudentNeedScore;
    }

    public void setStudentNeedScore(boolean studentNeedScore) {
        isStudentNeedScore = studentNeedScore;
    }
}
