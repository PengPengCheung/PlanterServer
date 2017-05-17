package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "teacher_course_resource_table", schema = "PlanterDatabase", catalog = "")
@IdClass(TeacherCourseResourceTableEntityPK.class)
public class TeacherCourseResourceTableEntity {
    private String tId;
    private String cId;
    private String resourceId;

    @Id
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Id
    @Column(name = "c_id")
    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Id
    @Column(name = "resource_id")
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

        TeacherCourseResourceTableEntity entity = (TeacherCourseResourceTableEntity) o;

        if (tId != null ? !tId.equals(entity.tId) : entity.tId != null) return false;
        if (cId != null ? !cId.equals(entity.cId) : entity.cId != null) return false;
        if (resourceId != null ? !resourceId.equals(entity.resourceId) : entity.resourceId != null) return false;

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
