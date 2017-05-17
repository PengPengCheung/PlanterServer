package dao;

import entity.GroupInfoEntity;
import entity.GroupTaskConnectionEntity;
import entity.GroupTaskEntity;
import entity.TeacherCourseGroupTableEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/4/21.
 */
public interface IGroupOP {

    void insertTeacherCourseGroupEntity(TeacherCourseGroupTableEntity entity);

    void insertStudentGroupInfoEntity(GroupInfoEntity entity);

    void insertGroupTaskConnection(GroupTaskConnectionEntity entity);

    void insertGroupTaskInfoEntity(GroupTaskEntity entity);

    List<TeacherCourseGroupTableEntity> selectTeacherCourseGroupByCourseId(@Param("cId") String courseId);


    List<GroupTaskConnectionEntity> selectGroupTaskConnectionEntityListByTeacherCourseGroupId(@Param("groupTeacherOpenId") String teacherCourseGroupId);

    GroupInfoEntity selectGroupInfoEntityByGroupId(@Param("groupId") String groupId);

    GroupTaskConnectionEntity getGroupTaskConnectionEntityByGroupId(@Param("groupId") String groupId);

    void updateGroupTaskConnection(GroupTaskConnectionEntity entity);

    GroupTaskEntity selectGroupTaskEntityByGroupTaskId(@Param("groupTaskId") String groupTaskId);
}
