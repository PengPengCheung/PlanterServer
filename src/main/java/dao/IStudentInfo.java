package dao;

import entity.StudentInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/3/22.
 */
public interface IStudentInfo {

    void addStudent(StudentInfoEntity student);
    StudentInfoEntity selectStudent(String sName);

    StudentInfoEntity selectStudentByStudentId(@Param("sId") String sId);

    String selectStudentNameByStudentId(@Param("sId") String sId);

    List<StudentInfoEntity> selectStudentByStudentName(@Param("sName") String sName);
}
