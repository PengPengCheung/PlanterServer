package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by peng on 2017/3/22.
 */
public class StudentCourseTreeBonusEntityPK implements Serializable {
    private String sId;
    private String cId;

    @Column(name = "s_id")
    @Id
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Column(name = "c_id")
    @Id
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseTreeBonusEntityPK that = (StudentCourseTreeBonusEntityPK) o;

        if (sId != null ? !sId.equals(that.sId) : that.sId != null) return false;
        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId != null ? sId.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        return result;
    }
}
