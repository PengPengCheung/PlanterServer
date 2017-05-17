package module.resource.service;

import common.Resource;
import dao.logic.HomeworkDAO;
import dao.logic.ResourceDAO;
import entity.ResourceInfoEntity;
import model.DataResponse;
import module.homework.model.web.HomeworkSubmitInfoModel;
import module.resource.model.web.TeachResource;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by peng on 2017/4/23.
 */
public class TeachResourceService {


    // {"resource_id":"18ecc9c7-11e7-4819-aa26-f8a30c53170b","c_id":"course789","t_id":"1234"}
    public DataResponse<Map<String, Integer>> deleteResourceByTeacher(Map<String, String> params, HttpServletRequest request){
        String resourceId = null;
        String courseId = null;
        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_RESOURCE_ID)){
            resourceId = params.get(Resource.KEY.KEY_RESOURCE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        ResourceDAO resourceDAO = new ResourceDAO();
        ResourceInfoEntity resourceInfoEntity = resourceDAO.getResourceInfoEntityByResourceId(resourceId);
        String filePath = resourceInfoEntity.getResourceSavePath();
        Files_Utils_DG.deleteFile(request, filePath);
        resourceDAO.deleteResourceByTeacher(courseId, teacherId, resourceId);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_RESOURCE_DELETE_STATUS, Resource.RES_STATUS.RESOURCE_DELETE_FILE_SUCCESS);

        response.setData(map);

        return response;

    }



    // 获取学生的课程资源列表
    // {"c_id":"c9c59c54-d5d5-4da1-859c-ac8f540ce5b3","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
    public DataResponse<List<TeachResource>> getCourseResourceListForStudent(Map<String, String> params){
        String courseId = null;
        String studentId = null;
        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);

        }

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        }

        CommonUtil.printLog("TeachResourceService getCourseResourceListForStudent courseId: " + courseId);

        ResourceDAO resourceDAO = new ResourceDAO();
        List<ResourceInfoEntity> resourceInfoEntityList = resourceDAO.getResourceInfoListByCourseId(courseId);
        List<TeachResource> teachResourceList = new LinkedList<TeachResource>();
        for(ResourceInfoEntity resource : resourceInfoEntityList){
            CommonUtil.printLog("TeachResourceService getCourseResourceListForStudent resource name: " + resource.getResourceName());
            TeachResource teachResource = constructTeachResource(resource);
            teachResourceList.add(teachResource);
        }

        DataResponse<List<TeachResource>> response = new DataResponse<List<TeachResource>>(200, "success");
        response.setData(teachResourceList);
        return response;
    }

    private TeachResource constructTeachResource(ResourceInfoEntity entity){
        TeachResource resource = new TeachResource();
        resource.setmModuleId(Resource.Module.MODULE_FRAME_RESOURCE);
        resource.setResourceName(entity.getResourceName());
        if(entity.getResourceDownloadCount() == null){
            resource.setDownloadCount(0);
        } else {
            resource.setDownloadCount(entity.getResourceDownloadCount());
        }

        if(entity.getResourceLikeCount() == null){
            resource.setLikeCount(0);
        } else {
            resource.setLikeCount(entity.getResourceLikeCount());
        }


        resource.setUploadDate(entity.getResourceUploadTime());
        resource.setDownloadUrl(entity.getResourceUrl());
        resource.setResourceId(entity.getResourceId());

        return resource;
    }



    public DataResponse<Map<String, Integer>> postStudentHomework(MultipartFile multipartFile, HttpServletRequest request){

        HomeworkSubmitInfoModel model = constructHomeworkSubmitInfoModel(request);

        HomeworkDAO homeworkDAO = new HomeworkDAO();
        String relativePath = Files_Utils_DG.FilesUpload_transferTo_spring(request, multipartFile, Resource.RESOURCE_SAVE_ABSOLUTE_PATH, model.getStudentId());
        homeworkDAO.saveStudentSubmitHomeworkInfo(relativePath, multipartFile.getOriginalFilename(), model);
        homeworkDAO.updateHomeworkInfoEntity(model.getHomeworkTeacherPublishedId());

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"success");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_HOMEWORK_SUBMIT_STATUS, Resource.HOMEWORK.HOMEWORK_SUBMIT_STATUS_SUCCESS);
        response.setData(map);

        return response;
    }

//    public DataResponse<List<HomeworkSubmitInfoModel>> getStudentHoemworkInfoList(){}

    private HomeworkSubmitInfoModel constructHomeworkSubmitInfoModel(HttpServletRequest request){
        String studentId = request.getParameter(Resource.KEY.KEY_STUDENT_ID);
        String courseId = request.getParameter(Resource.KEY.KEY_COURSE_ID);
        String teacherPublishedHomeworkId = request.getParameter(Resource.KEY.KEY_HOMEWORK_ID);
        String homeworkSubmitTime = request.getParameter(Resource.KEY.KEY_HOMEWORK_STUDENT_SUBMIT_TIME);

        HomeworkSubmitInfoModel model = new HomeworkSubmitInfoModel();
        model.setStudentId(studentId);
        model.setCourseId(courseId);
        model.setHomeworkTeacherPublishedId(teacherPublishedHomeworkId);
        model.setHomeworkSubmitTime(homeworkSubmitTime);

        return model;
    }

    public String postResource(MultipartFile multipartFile, HttpServletRequest request){
        String teacherId = request.getParameter(Resource.KEY.KEY_TEACHER_ID);
        String courseId = request.getParameter(Resource.KEY.KEY_COURSE_ID);
        CommonUtil.printLog("teacherId: " + teacherId + ", courseId: " + courseId);

        String relativeFilePath = Files_Utils_DG.FilesUpload_transferTo_spring(request, multipartFile, Resource.RESOURCE_SAVE_ABSOLUTE_PATH, teacherId);
        CommonUtil.printLog("TeachResourceService postResource path: " + relativeFilePath);
        Logger.getLogger(TeachResourceService.class).error(relativeFilePath);
        ResourceDAO resourceDAO = new ResourceDAO();
        ResourceInfoEntity resourceInfoEntity = resourceDAO.insertResourceInfo(relativeFilePath, multipartFile.getOriginalFilename());
        resourceDAO.insertTeacherResourceConnection(teacherId, courseId, resourceInfoEntity.getResourceId());
        CommonUtil.printLog("TeachResourceService postResource: " + resourceInfoEntity.getResourceUrl());
//        PushUtil.pushToMobDevices();
        return "{'TFMark':'true','Msg':'upload success !','filePath':'" + relativeFilePath + "'}";
    }



    // {"c_id":"course789","t_id":"1234"}
    public DataResponse<List<TeachResource>> getTeacherUploadResourceList(Map<String, String> params){
        String courseId = null;
        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        CommonUtil.printLog("TeacherResourceService getTeacherUploadResourceList teacherId: " + teacherId + ", courseId: " + courseId);

        ResourceDAO resourceDAO = new ResourceDAO();
        List<TeachResource> resourceList = new LinkedList<TeachResource>();
        List<ResourceInfoEntity> entityList = resourceDAO.getResourceInfoEntityListByTeacherIdAndCourseId(teacherId, courseId);

        for(ResourceInfoEntity entity : entityList){
            TeachResource resource = constructTeacheResource(entity);
            resourceList.add(resource);
        }
        DataResponse<List<TeachResource>> response = new DataResponse<List<TeachResource>>(200, "success");
        response.setData(resourceList);
        return response;
    }

    private TeachResource constructTeacheResource(ResourceInfoEntity entity){
        TeachResource resource = new TeachResource();
        resource.setmModuleId(Resource.Module.MODULE_FRAME_RESOURCE);
        resource.setResourceName(entity.getResourceName());
        resource.setDownloadCount(entity.getResourceDownloadCount());
        resource.setLikeCount(entity.getResourceLikeCount());
        resource.setUploadDate(entity.getResourceUploadTime());
        CommonUtil.printLog("entity url: " + entity.getResourceUrl());
        resource.setDownloadUrl(entity.getResourceUrl());
        resource.setResourceId(entity.getResourceId());

        return resource;
    }

}
