package dao;

import com.sun.xml.internal.bind.annotation.XmlIsSet;
import entity.StudentTeacherClassTableEntity;
import entity.TeacherCourseAttendanceTableEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/3/27.
 */
public interface IClassOP {

    String selectBaseConnectionIdByTeacherAndCourse(String teacherId, String courseId);

    void insertClassOpenRecord(StudentTeacherClassTableEntity entity);

    List<StudentTeacherClassTableEntity> getClassOpenRecordByTeacherIdAndCourseId(@Param("tId") String tId, @Param("cId") String cId);

    StudentTeacherClassTableEntity selectOpenClassRecordByOpenClassId(@Param("openClassId") String openClassId);

//    List<TeacherCourseAttendanceTableEntity> getTeacherCourseAttendanceEntities(String openClassId);

}
