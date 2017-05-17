package module.attention.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/3/27.
 */
public class AttentionWebViewModel extends BaseViewModel{


    @JsonProperty(Resource.KEY.KEY_ATTENTION_DURATION)
    private String attentionDuration;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TYPE)
    private int attentionType;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TIME)
    private String attentionTime;

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
