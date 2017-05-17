package dao;

import entity.AttendanceInfoEntity;
import entity.StudentPerformanceAttendanceTableEntity;
import entity.TeacherCourseAttendanceTableEntity;
import module.attendance.model.AttendanceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/3/23.
 */
public interface IAttendanceInfo {

    List<AttendanceInfoEntity> getAttendanceInfo(String studentId);
    void addAttendanceInfo(AttendanceInfoEntity attendanceInfo);

    void insertTeacherSendAttendanceRecord(TeacherCourseAttendanceTableEntity entity);

    void insertStudentAttendanceConnection(StudentPerformanceAttendanceTableEntity entity);

    List<TeacherCourseAttendanceTableEntity> selectTeacherAttendanceListByOpenClassId(String openClassId);

    TeacherCourseAttendanceTableEntity getTeacherAttendanceInfoByAttendanceId(@Param("teacherAttendanceId") String attendanceId);

    List<TeacherCourseAttendanceTableEntity> getTeacherAttendanceInfoByOpenClassId(@Param("openClassId") String openClassId);

    void updateTeacherAttendanceInfo(TeacherCourseAttendanceTableEntity entity);
}
