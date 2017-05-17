package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_course_tree", schema = "PlanterDatabase", catalog = "")
@IdClass(StudentCourseTreeEntityPK.class)
public class StudentCourseTreeEntity {
    private String sId;
    private String cId;
    private String treeId;

    @Id
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
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
    @Column(name = "tree_id")
    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseTreeEntity that = (StudentCourseTreeEntity) o;

        if (sId != null ? !sId.equals(that.sId) : that.sId != null) return false;
        if (cId != null ? !cId.equals(that.cId) : that.cId != null) return false;
        if (treeId != null ? !treeId.equals(that.treeId) : that.treeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId != null ? sId.hashCode() : 0;
        result = 31 * result + (cId != null ? cId.hashCode() : 0);
        result = 31 * result + (treeId != null ? treeId.hashCode() : 0);
        return result;
    }
}
