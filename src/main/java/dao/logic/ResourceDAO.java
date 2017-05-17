package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IResourceOP;
import entity.ResourceInfoEntity;
import entity.TeacherCourseResourceTableEntity;
import org.apache.ibatis.session.SqlSession;
import utils.CommonUtil;
import utils.DBUtil;
import utils.TimeUtil;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/23.
 */
public class ResourceDAO extends BaseDAO{

    public ResourceDAO(){
        super();
    }

    public ResourceInfoEntity getResourceInfoEntityByResourceId(String resourceId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        ResourceInfoEntity entity = resourceOP.selectResourceInfoEntityByResourceId(resourceId);
        return entity;
    }

    public void deleteResourceByTeacher(String courseId, String teacherId, String resourceId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        resourceOP.deleteResourceByResourceId(resourceId);
        resourceOP.deleteTeacherResourceConnection(resourceId);
        session.commit();
    }

    public List<ResourceInfoEntity> getResourceInfoListByCourseId(String courseId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        List<TeacherCourseResourceTableEntity> resourceInfoIdList = resourceOP.getResourceInfoIdListByCourseId(courseId);
        List<ResourceInfoEntity> resourceInfoEntityList = new LinkedList<ResourceInfoEntity>();
        for(TeacherCourseResourceTableEntity entity : resourceInfoIdList){
            String resourceId = entity.getResourceId();
            ResourceInfoEntity resourceInfoEntity = resourceOP.selectResourceInfoEntityByResourceId(resourceId);
            resourceInfoEntityList.add(resourceInfoEntity);
        }
        return resourceInfoEntityList;
    }


    public List<ResourceInfoEntity> getResourceInfoEntityListByTeacherIdAndCourseId(String teacherId, String courseId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        List<ResourceInfoEntity> resourceInfoEntities = new LinkedList<ResourceInfoEntity>();
        List<TeacherCourseResourceTableEntity> resourceList = resourceOP.getTeacherResourceIdList(teacherId, courseId);
        CommonUtil.printLog("ResourceDAO resourceList: " + (resourceList== null));
        if(resourceList != null){
            CommonUtil.printLog("ResourceDAO resourceList size: " + resourceList.size());
        }
        for(TeacherCourseResourceTableEntity resourceInfo : resourceList){
            ResourceInfoEntity entity = resourceOP.selectResourceInfoEntityByResourceId(resourceInfo.getResourceId());
            resourceInfoEntities.add(entity);
        }

        return resourceInfoEntities;
    }

    public void addDownloadCount(String resourceId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        CommonUtil.printLog("ResourceDAO addDownloadCount resourceId: " + resourceId);
        ResourceInfoEntity entity = resourceOP.selectResourceInfoEntityByResourceId(resourceId);
        if(entity.getResourceDownloadCount() == null){
            entity.setResourceDownloadCount(1);
        } else {
            int downloadCount = entity.getResourceDownloadCount();
            downloadCount++;
            entity.setResourceDownloadCount(downloadCount);
        }

        resourceOP.updateResourceInfoEntity(entity);
        session.commit();
    }

    public String getResourceSavedPathByResourceId(String resourceId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        String resourceSavedPath = resourceOP.selectResourceSavedPathByResourceId(resourceId);
        return resourceSavedPath;
    }


    public ResourceInfoEntity insertResourceInfo(String filePath, String fileName){
        CommonUtil.printLog("ResourceDAO insertResourceInfo filePath: " + filePath + ", fileName: " + fileName);
        ResourceInfoEntity entity = constructResourceInfoEntity(filePath, fileName, 0, 0);
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        resourceOP.insertResourceInfoEntity(entity);
        session.commit();
        return entity;
    }


    private String getDownloadUrl(String id){
        return Resource.RESOURCE_DOWNLOAD_URL + File.separator + id;
    }

    private ResourceInfoEntity constructResourceInfoEntity(String filePath, String fileName, int downloadCount, int likeCount) {
        ResourceInfoEntity entity = new ResourceInfoEntity();
        String resourceId = DBUtil.generateUUID();
        entity.setResourceId(resourceId);
        entity.setResourceDownloadCount(downloadCount);
        entity.setResourceLikeCount(likeCount);
        entity.setResourceName(fileName);
        String downloadUrl = getDownloadUrl(resourceId);
        CommonUtil.printLog("ResourceDAO constructResourceInfoEntity downloadUrl: " + downloadUrl);
        entity.setResourceUrl(downloadUrl);
        entity.setResourceSavePath(filePath);
        Date date = new Date();
        String dateStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS);
        entity.setResourceUploadTime(dateStr);


        return entity;
    }


    public void insertTeacherResourceConnection(String teacherId, String courseId, String resourceId){
        SqlSession session = getSession();
        IResourceOP resourceOP = session.getMapper(IResourceOP.class);
        TeacherCourseResourceTableEntity entity = constructTeacherResourceEntity(teacherId, courseId, resourceId);
        resourceOP.insertTeacherResourceConnection(entity);
        session.commit();

    }

    private TeacherCourseResourceTableEntity constructTeacherResourceEntity(String teacherId, String courseId, String resourceId){
        TeacherCourseResourceTableEntity entity = new TeacherCourseResourceTableEntity();
        entity.setResourceId(resourceId);
        entity.settId(teacherId);
        entity.setcId(courseId);

        return entity;
    }

}
