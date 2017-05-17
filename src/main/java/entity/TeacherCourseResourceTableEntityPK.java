package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by peng on 2017/3/22.
 */
public class TeacherCourseResourceTableEntityPK implements Serializable {
    private String tId;
    private String cId;
    private String resourceId;

    @Column(name = "t_id")
    @Id
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }


    @Column(name = "c_id")
    @Id
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Column(name = "resource_id")
    @Id
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherCourseResourceTableEntityPK that = (TeacherCourseResourceTableEntityPK) o;

        if (tId != null ? !tId.equals(that.tId) : that.tId != null) return false;
        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (resourceId != null ? !resourceId.equals(that.resourceId) : that.resourceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId != null ? tId.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        return result;
    }
}
