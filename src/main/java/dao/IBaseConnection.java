package dao;

import common.Resource;
import entity.BaseConnectionEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by peng on 2017/3/23.
 */
public interface IBaseConnection {

    BaseConnectionEntity getStudentIdFromBaseConnection(@Param("teacherId") String teacherId, @Param("courseId") String courseId);

//    void addBaseConnection(@Param(Resource.KEY.KEY_TEACHER_ID) String teacherId, @Param(Resource.KEY.KEY_STUDENT_ID) String stuId, @Param(Resource.KEY.KEY_COURSE_ID) String courseId, @Param(Resource.KEY.KEY_CONNECTION_ID) String connectionId, @Param("course_code") String courseCode);

    void insertBaseConnectionEntity(BaseConnectionEntity entity);

    BaseConnectionEntity selectBaseConnectionByCourseId(@Param("cId") String cId);

    void updateBaseConnection(@Param("sId") String sId, @Param("cId") String cId);

    List<BaseConnectionEntity> selectAllConnection();

    List<BaseConnectionEntity> selectBaseConnectionListByTeacherId(String teacherId);

    List<BaseConnectionEntity> selectBaseConnectionListByCourseId(String courseId);

    List<BaseConnectionEntity> selectBaseConnectionListByStudentId(@Param("sId") String studentId);

    BaseConnectionEntity selectBaseConnectionByCourseIdAndStudentId(@Param("cId") String cId, @Param("sId") String sId);
}
