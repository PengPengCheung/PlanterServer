package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "handup_info", schema = "PlanterDatabase", catalog = "")
public class HandupInfoEntity {
    private String handupId;
    private Integer handupStatus;
    private Timestamp handupTime;

    @Id
    @Column(name = "handup_id")
    public String getHandupId() {
        return handupId;
    }

    public void setHandupId(String handupId) {
        this.handupId = handupId;
    }

    @Basic
    @Column(name = "handup_status")
    public Integer getHandupStatus() {
        return handupStatus;
    }

    public void setHandupStatus(Integer handupStatus) {
        this.handupStatus = handupStatus;
    }

    @Basic
    @Column(name = "handup_time")
    public Timestamp getHandupTime() {
        return handupTime;
    }

    public void setHandupTime(Timestamp handupTime) {
        this.handupTime = handupTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HandupInfoEntity that = (HandupInfoEntity) o;

        if (handupId != null ? !handupId.equals(that.handupId) : that.handupId != null) return false;
        if (handupStatus != null ? !handupStatus.equals(that.handupStatus) : that.handupStatus != null) return false;
        if (handupTime != null ? !handupTime.equals(that.handupTime) : that.handupTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = handupId != null ? handupId.hashCode() : 0;
        result = 31 * result + (handupStatus != null ? handupStatus.hashCode() : 0);
        result = 31 * result + (handupTime != null ? handupTime.hashCode() : 0);
        return result;
    }
}
