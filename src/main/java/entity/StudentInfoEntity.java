package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "student_info", schema = "PlanterDatabase", catalog = "")
public class StudentInfoEntity {
    private String sId;
    private String sName;
    private String sHeadUrl;
    private String sSchool;
    private String sNo;
    private String sPassword;

    @Id
    @Column(name = "s_id")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_name")
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "s_head_url")
    public String getsHeadUrl() {
        return sHeadUrl;
    }

    public void setsHeadUrl(String sHeadUrl) {
        this.sHeadUrl = sHeadUrl;
    }

    @Basic
    @Column(name = "s_school")
    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentInfoEntity that = (StudentInfoEntity) o;

        if (sId != null ? !sId.equals(that.sId) : that.sId != null) return false;
        if (sName != null ? !sName.equals(that.sName) : that.sName != null) return false;
        if (sHeadUrl != null ? !sHeadUrl.equals(that.sHeadUrl) : that.sHeadUrl != null) return false;
        if (sSchool != null ? !sSchool.equals(that.sSchool) : that.sSchool != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId != null ? sId.hashCode() : 0;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (sHeadUrl != null ? sHeadUrl.hashCode() : 0);
        result = 31 * result + (sSchool != null ? sSchool.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "s_no")
    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    @Basic
    @Column(name = "s_password")
    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
}
