package dao;

import entity.StudentInfoEntity;
import entity.TeacherInfoEntity;

import java.util.List;

/**
 * Created by peng on 2017/3/28.
 */
public interface ILoginOP {

    List<TeacherInfoEntity> getTeacherList();

    List<StudentInfoEntity> getStudentList();

}
