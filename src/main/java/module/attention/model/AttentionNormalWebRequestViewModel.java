package module.attention.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/7.
 */
public class AttentionNormalWebRequestViewModel extends BaseViewModel{


    @JsonProperty(Resource.KEY.KEY_ATTENTION_DURATION)
    private String attentionDuration; // 专注时长

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TYPE)
    private int attentionType;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TIME)
    private String attentionTime;

    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String openClassId;

    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    public String getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(String attentionTime) {
        this.attentionTime = attentionTime;
    }

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
}
