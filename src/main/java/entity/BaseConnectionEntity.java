package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/24.
 */
@Entity
@Table(name = "base_connection", schema = "PlanterDatabase", catalog = "")
public class BaseConnectionEntity {
    private String cId;
    private String sId;
    private String tId;
    private String baseConnectionId;

    @Basic
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Id
    @Column(name = "base_connection_id")
    public String getBaseConnectionId() {
        return baseConnectionId;
    }

    public void setBaseConnectionId(String baseConnectionId) {
        this.baseConnectionId = baseConnectionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseConnectionEntity that = (BaseConnectionEntity) o;

        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (sId != null ? !sId.equals(that.sId) : that.sId != null) return false;
        if (tId != null ? !tId.equals(that.tId) : that.tId != null) return false;
        if (baseConnectionId != null ? !baseConnectionId.equals(that.baseConnectionId) : that.baseConnectionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (sId != null ? sId.hashCode() : 0);
        result = 31 * result + (tId != null ? tId.hashCode() : 0);
        result = 31 * result + (baseConnectionId != null ? baseConnectionId.hashCode() : 0);
        return result;
    }
}
