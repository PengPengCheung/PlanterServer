package dao;

import entity.ResourceInfoEntity;
import entity.TeacherCourseResourceTableEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/4/23.
 */
public interface IResourceOP {

    void insertResourceInfoEntity(ResourceInfoEntity entity);

    void insertTeacherResourceConnection(TeacherCourseResourceTableEntity entity);

    String selectResourceSavedPathByResourceId(String resourceId);

    List<TeacherCourseResourceTableEntity> getTeacherResourceIdList(@Param("tId") String tId, @Param("cId") String cId);

    ResourceInfoEntity selectResourceInfoEntityByResourceId(@Param("resourceId") String resourceId);

    List<TeacherCourseResourceTableEntity> getResourceInfoIdListByCourseId(@Param("cId") String courseId);

    void updateResourceInfoEntity(ResourceInfoEntity entity);

    void deleteResourceByResourceId(String resourceId);

    void deleteTeacherResourceConnection(String resourceId);

}
