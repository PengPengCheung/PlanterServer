package dao.logic;

import dao.BaseDAO;
import dao.ICourseInfo;
import entity.CourseInfoEntity;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by peng on 2017/4/18.
 */
public class CourseDAO extends BaseDAO{



    public CourseDAO(){super();}

    public CourseInfoEntity getCourseByCourseId(String courseId){
        SqlSession session = getSession();

        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        CourseInfoEntity entity = courseInfo.selectCourseById(courseId);

        return entity;
    }

    public CourseInfoEntity getCourseByCourseCode(String courseCode){
        SqlSession session = getSession();
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        CourseInfoEntity entity = courseInfo.selectCourseByCourseCode(courseCode);
        return entity;
    }

    public void insertCourseInfo(CourseInfoEntity entity){
        SqlSession session = getSession();
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        courseInfo.insertCourseInfo(entity);
        session.commit();
    }

    public List<CourseInfoEntity> getCourseInfoList(){
        SqlSession session = getSession();
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        List<CourseInfoEntity> courseInfoEntityList = courseInfo.selectAllCourseInfo();
        return courseInfoEntityList;
    }

    public void updateCourseInfoTime(CourseInfoEntity entity){
        SqlSession session = getSession();
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
//        courseInfo.updateCourseInfo(entity.getCourseTime(), entity.getCourseCode());
        courseInfo.updateCourseInfo(entity);
        session.commit();
    }
}
