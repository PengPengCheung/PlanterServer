package module.attention.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/7.
 */
// 正在进行专注的时候使用
public class AttentionGoingModel extends BaseViewModel{

//    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
//    private String studentId;

    @JsonProperty(Resource.KEY.KEY_STU_NAME)
    private String studentName;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_INSIST_TIME)
    private String attentionInsistTime;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_STATUS)
    private int attentionStatus;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TYPE)
    private int attentionType;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_SCORE)
    private int score = -1; // 小组专注时才有值

    @JsonProperty(Resource.KEY.KEY_BONUS_TYPE)
    private int mAttentionBonusType;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_BONUS_NUM)
    private int mAttentionBonusNum;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_DURATION)
    private String mAttentionDuration;

    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_ID)
    private String mOpenClassId;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_TIME)
    private String mStartTime;

    @JsonProperty(Resource.KEY.KEY_ATTENTION_END_TIME)
    private String mEndTime;
//
//    public String getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }

    public String getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(String mStartTime) {
        this.mStartTime = mStartTime;
    }

    public String getmEndTime() {
        return mEndTime;
    }

    public void setmEndTime(String mEndTime) {
        this.mEndTime = mEndTime;
    }

    public String getmOpenClassId() {
        return mOpenClassId;
    }

    public void setmOpenClassId(String mOpenClassId) {
        this.mOpenClassId = mOpenClassId;
    }

    public int getmAttentionBonusType() {
        return mAttentionBonusType;
    }

    public void setmAttentionBonusType(int mAttentionBonusType) {
        this.mAttentionBonusType = mAttentionBonusType;
    }

    public int getmAttentionBonusNum() {
        return mAttentionBonusNum;
    }

    public void setmAttentionBonusNum(int mAttentionBonusNum) {
        this.mAttentionBonusNum = mAttentionBonusNum;
    }

    public String getmAttentionDuration() {
        return mAttentionDuration;
    }

    public void setmAttentionDuration(String mAttentionDuration) {
        this.mAttentionDuration = mAttentionDuration;
    }

    public int getAttentionType() {
        return attentionType;
    }

    public void setAttentionType(int attentionType) {
        this.attentionType = attentionType;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAttentionInsistTime() {
        return attentionInsistTime;
    }

    public void setAttentionInsistTime(String attentionInsistTime) {
        this.attentionInsistTime = attentionInsistTime;
    }

    public int getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(int attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
