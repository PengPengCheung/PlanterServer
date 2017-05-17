package dao;

import entity.HomeworkInfoEntity;
import entity.StudentCourseHomeworkTableEntity;
import entity.TeacherCourseHomeworkTableEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/4/21.
 */
public interface IHomeworkOP {

    void insertHomeworkInfoEntity(HomeworkInfoEntity entity);

    void insertTeacherHomeworkRecord(TeacherCourseHomeworkTableEntity entity);

    void insertStudentHomeworkRecord(StudentCourseHomeworkTableEntity entity);

    List<String> selectHomeworkIdListByTeacherIdAndCourseId(@Param("tId") String tId, @Param("cId") String cId);

    HomeworkInfoEntity selectHomeworkInfoEntityByHomeworkId(String homeworkId);

    List<StudentCourseHomeworkTableEntity> selectStudentCourseHomeworkInfoByHomeworkIdAndCourseId(@Param("homeworkId") String homeworkId, @Param("cId") String cId);

    List<StudentCourseHomeworkTableEntity> selectStudentSubmitHomeworkInfoList(String homeworkId);

    List<TeacherCourseHomeworkTableEntity> selectTeacherCourseHomeworkInfoListByCourseId(@Param("cId") String courseId);

    String selectHomeworkSavePathByHomeworkSubmitId(@Param("studentSubmitHomeworkId") String homeworkSubmitId);

    StudentCourseHomeworkTableEntity selectStudentHomeworkInfoEntityBySubmitId(@Param("studentSubmitHomeworkId") String studentSubmitHomeworkId);

    void updateStudentCourseHomeworkInfoEntity(StudentCourseHomeworkTableEntity entity);

    void updateHomeworkStatus(HomeworkInfoEntity entity);

}
