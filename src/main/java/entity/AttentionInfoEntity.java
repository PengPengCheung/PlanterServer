package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/27.
 */
@Entity
@Table(name = "attention_info", schema = "PlanterDatabase", catalog = "")
public class AttentionInfoEntity {
    private String attentionId;
    private String attentionDuration;
    private int attentionType;
    private String attentionTime;
    private String attentionEndTime;
    private int attentionStatus;
    private Integer attentionScore;
    private Integer attentionBonusType;
    private Integer attentionBonusNum;
    private String attentionInsistTime;

    public void setAttentionStatus(Integer attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    @Basic
    @Column(name = "attention_status")
    public int getAttentionStatus(){
        return attentionStatus;
    }

    public void setAttentionStatus(int attentionStatus) {
        this.attentionStatus = attentionStatus;
    }

    @Id
    @Column(name = "attention_id")
    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId;
    }

    @Basic
    @Column(name = "attention_duration")
    public String getAttentionDuration() {
        return attentionDuration;
    }

    public void setAttentionDuration(String attentionDuration) {
        this.attentionDuration = attentionDuration;
    }

    @Basic
    @Column(name = "attention_type")
    public int getAttentionType() {
        return attentionType;
    }

    public void setAttentionType(int attentionType) {
        this.attentionType = attentionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttentionInfoEntity entity = (AttentionInfoEntity) o;

        if (attentionType != entity.attentionType) return false;
        if (attentionId != null ? !attentionId.equals(entity.attentionId) : entity.attentionId != null) return false;
        if (attentionDuration != null ? !attentionDuration.equals(entity.attentionDuration) : entity.attentionDuration != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attentionId != null ? attentionId.hashCode() : 0;
        result = 31 * result + (attentionDuration != null ? attentionDuration.hashCode() : 0);
        result = 31 * result + attentionType;
        return result;
    }

    @Basic
    @Column(name = "attention_time")
    public String getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(String attentionTime) {
        this.attentionTime = attentionTime;
    }

    @Basic
    @Column(name = "attention_end_time")
    public String getAttentionEndTime() {
        return attentionEndTime;
    }

    public void setAttentionEndTime(String attentionEndTime) {
        this.attentionEndTime = attentionEndTime;
    }


    @Basic
    @Column(name = "attention_score")
    public Integer getAttentionScore() {
        return attentionScore;
    }

    public void setAttentionScore(Integer attentionScore) {
        this.attentionScore = attentionScore;
    }

    @Basic
    @Column(name = "attention_bonus_type")
    public Integer getAttentionBonusType() {
        return attentionBonusType;
    }

    public void setAttentionBonusType(Integer attentionBonusType) {
        this.attentionBonusType = attentionBonusType;
    }

    @Basic
    @Column(name = "attention_bonus_num")
    public Integer getAttentionBonusNum() {
        return attentionBonusNum;
    }

    public void setAttentionBonusNum(Integer attentionBonusNum) {
        this.attentionBonusNum = attentionBonusNum;
    }

    @Basic
    @Column(name = "attention_insist_time")
    public String getAttentionInsistTime() {
        return attentionInsistTime;
    }

    public void setAttentionInsistTime(String attentionInsistTime) {
        this.attentionInsistTime = attentionInsistTime;
    }
}
