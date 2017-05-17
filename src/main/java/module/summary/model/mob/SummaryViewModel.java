package module.summary.model.mob;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/3/20.
 */
public class SummaryViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_SUMMARY_REQUEST_TIME)
    private String mSummaryRequestTime;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_BONUS_NUM)
    private int mSummaryBonusNum;

    @JsonProperty(Resource.KEY.KEY_BONUS_TYPE)
    private int mSummaryBonusType;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_CONTENT)
    private String mSummaryContent;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_ID)
    private String mSummaryId;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_STATUS)
    private int mSummaryStatus;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_SEND_TIME)
    private String mSummarySendTime;

    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    public String getmOpenClassId() {
        return mOpenClassId;
    }

    public void setmOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public int getmSummaryBonusType() {
        return mSummaryBonusType;
    }

    public void setmSummaryBonusType(int mSummaryBonusType) {
        this.mSummaryBonusType = mSummaryBonusType;
    }

    public String getmSummaryId() {
        return mSummaryId;
    }

    public void setmSummaryId(String mSummaryId) {
        this.mSummaryId = mSummaryId;
    }

    public String getmSummarySendTime() {
        return mSummarySendTime;
    }

    public void setmSummarySendTime(String mSummarySendTime) {
        this.mSummarySendTime = mSummarySendTime;
    }

    public String getmSummaryRequestTime() {
        return mSummaryRequestTime;
    }

    public void setmSummaryRequestTime(String mSummaryRequestTime) {
        this.mSummaryRequestTime = mSummaryRequestTime;
    }

    public int getmSummaryBonusNum() {
        return mSummaryBonusNum;
    }

    public void setmSummaryBonusNum(int mSummaryBonusNum) {
        this.mSummaryBonusNum = mSummaryBonusNum;
    }

    public String getmSummaryContent() {
        return mSummaryContent;
    }

    public void setmSummaryContent(String mSummaryContent) {
        this.mSummaryContent = mSummaryContent;
    }

    public int getmSummaryStatus() {
        return mSummaryStatus;
    }

    public void setmSummaryStatus(int mSummaryStatus) {
        this.mSummaryStatus = mSummaryStatus;
    }
}
