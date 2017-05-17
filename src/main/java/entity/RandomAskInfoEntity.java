package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "random_ask_info", schema = "PlanterDatabase", catalog = "")
public class RandomAskInfoEntity {
    private String randomAskId;
    private String randomAskTime;
    private int randomAskStatus;

    @Basic
    @Column(name = "random_ask_time")
    public String getRandomAskTime() {
        return randomAskTime;
    }

    public void setRandomAskTime(String randomAskTime) {
        this.randomAskTime = randomAskTime;
    }

    @Id
    @Column(name = "random_ask_id")
    public String getRandomAskId() {
        return randomAskId;
    }

    public void setRandomAskId(String randomAskId) {
        this.randomAskId = randomAskId;
    }

    @Basic
    @Column(name = "random_ask_status")
    public int getRandomAskStatus() {
        return randomAskStatus;
    }

    public void setRandomAskStatus(int randomAskStatus) {
        this.randomAskStatus = randomAskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomAskInfoEntity that = (RandomAskInfoEntity) o;

        if (randomAskStatus != that.randomAskStatus) return false;
        if (randomAskId != null ? !randomAskId.equals(that.randomAskId) : that.randomAskId != null) return false;
        if (randomAskTime != null ? !randomAskTime.equals(that.randomAskTime) : that.randomAskTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = randomAskId != null ? randomAskId.hashCode() : 0;
        result = 31 * result + (randomAskTime != null ? randomAskTime.hashCode() : 0);
        result = 31 * result + randomAskStatus;
        return result;
    }
}
