package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "teacher_info", schema = "PlanterDatabase", catalog = "")
public class TeacherInfoEntity {
    private String tId;
    private String tName;
    private String tSchool;
    private String tPassword;

    @Id
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "t_name")
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Basic
    @Column(name = "t_school")
    public String gettSchool() {
        return tSchool;
    }

    public void settSchool(String tSchool) {
        this.tSchool = tSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherInfoEntity that = (TeacherInfoEntity) o;

        if (tId != null ? !tId.equals(that.tId) : that.tId != null) return false;
        if (tName != null ? !tName.equals(that.tName) : that.tName != null) return false;
        if (tSchool != null ? !tSchool.equals(that.tSchool) : that.tSchool != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId != null ? tId.hashCode() : 0;
        result = 31 * result + (tName != null ? tName.hashCode() : 0);
        result = 31 * result + (tSchool != null ? tSchool.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "t_password")
    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }
}
