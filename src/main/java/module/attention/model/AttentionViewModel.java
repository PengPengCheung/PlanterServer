package module.attention.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/3/20.
 */
public class AttentionViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_ATTENTION_ID)
    private String mAttentionId;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TIME)
    private String mAttentionTime;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_DURATION)
    private String mAttentionDuration;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_FOCUS_COUNT)
    private int mAttentionFocusCount;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_LOST_FOCUS_COUNT)
    private int mAttentionLostFocusCount;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_BONUS_NUM)
    private int mAttentionBonusNum;

    @JsonProperty(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttentionBonusType;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_STATUS)
    private int mAttentionStatus;

    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TYPE)
    private int mAttentionType;

    public int getmAttentionType() {
        return mAttentionType;
    }

    public void setmAttentionType(int mAttentionType) {
        this.mAttentionType = mAttentionType;
    }

    public String getmOpenClassId() {
        return mOpenClassId;
    }

    public void setmOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public String getmAttentionId() {
        return mAttentionId;
    }

    public void setmAttentionId(String mAttentionId) {
        this.mAttentionId = mAttentionId;
    }

    public int getmAttentionBonusType() {
        return mAttentionBonusType;
    }

    public void setmAttentionBonusType(int mAttentionBonusType) {
        this.mAttentionBonusType = mAttentionBonusType;
    }

    public int getmAttentionStatus() {
        return mAttentionStatus;
    }

    public void setmAttentionStatus(int mAttentionStatus) {
        this.mAttentionStatus = mAttentionStatus;
    }

    public String getmAttentionTime() {
        return mAttentionTime;
    }

    public void setmAttentionTime(String mAttentionTime) {
        this.mAttentionTime = mAttentionTime;
    }

    public String getmAttentionDuration() {
        return mAttentionDuration;
    }

    public void setmAttentionDuration(String mAttentionDuration) {
        this.mAttentionDuration = mAttentionDuration;
    }

    public int getmAttentionFocusCount() {
        return mAttentionFocusCount;
    }

    public void setmAttentionFocusCount(int mAttentionFocusCount) {
        this.mAttentionFocusCount = mAttentionFocusCount;
    }

    public int getmAttentionLostFocusCount() {
        return mAttentionLostFocusCount;
    }

    public void setmAttentionLostFocusCount(int mAttentionLostFocusCount) {
        this.mAttentionLostFocusCount = mAttentionLostFocusCount;
    }

    public int getmAttentionBonusNum() {
        return mAttentionBonusNum;
    }

    public void setmAttentionBonusNum(int mAttentionBonusNum) {
        this.mAttentionBonusNum = mAttentionBonusNum;
    }
}