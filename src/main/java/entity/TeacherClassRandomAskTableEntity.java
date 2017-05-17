package entity;

import javax.persistence.*;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "teacher_class_random_ask_table", schema = "PlanterDatabase", catalog = "")
public class TeacherClassRandomAskTableEntity {
    private String teacherClassRandomAskId;
    private String openClassId;
    private String randomAskId;

    @Id
    @Column(name = "teacher_class_random_ask_id")
    public String getTeacherClassRandomAskId() {
        return teacherClassRandomAskId;
    }

    public void setTeacherClassRandomAskId(String teacherClassRandomAskId) {
        this.teacherClassRandomAskId = teacherClassRandomAskId;
    }

    @Basic
    @Column(name = "open_class_id")
    public String getOpenClassId() {
        return openClassId;
    }

    public void setOpenClassId(String openClassId) {
        this.openClassId = openClassId;
    }

    @Basic
    @Column(name = "random_ask_id")
    public String getRandomAskId() {
        return randomAskId;
    }

    public void setRandomAskId(String randomAskId) {
        this.randomAskId = randomAskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherClassRandomAskTableEntity that = (TeacherClassRandomAskTableEntity) o;

        if (teacherClassRandomAskId != null ? !teacherClassRandomAskId.equals(that.teacherClassRandomAskId) : that.teacherClassRandomAskId != null)
            return false;
        if (openClassId != null ? !openClassId.equals(that.openClassId) : that.openClassId != null) return false;
        if (randomAskId != null ? !randomAskId.equals(that.randomAskId) : that.randomAskId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherClassRandomAskId != null ? teacherClassRandomAskId.hashCode() : 0;
        result = 31 * result + (openClassId != null ? openClassId.hashCode() : 0);
        result = 31 * result + (randomAskId != null ? randomAskId.hashCode() : 0);
        return result;
    }
}
