package dao;

import entity.CourseInfoEntity;

import java.util.List;

/**
 * Created by peng on 2017/3/24.
 */
public interface ICourseInfo {

    CourseInfoEntity selectCourseById(String cId);

    List<CourseInfoEntity> selectAllCourseInfo();

//    void updateCourseInfo(String courseTime, String courseCode);
    void updateCourseInfo(CourseInfoEntity entity);

    void insertCourseInfo(CourseInfoEntity entity);

    CourseInfoEntity selectCourseByCourseCode(String courseCode);
}
