package module.resource;

import common.Resource;
import dao.logic.ResourceDAO;
import model.DataResponse;
import module.resource.model.web.TeachResource;
import module.resource.service.TeachResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by peng on 2017/4/14.
 */
@Controller
public class TeachResourceController {

    private static final String TAG = TeachResourceController.class.getSimpleName();

//    private String testUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492176245979&di=a3ce83f551ac4d92c81f3975cc339076&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F38%2F47%2F19300001391844134804474917734_950.png";

    private String testUrl = "http://192.168.235.50:8080/FileUpload/fileDownload_servlet";
    // {"c_id":"course789","t_id":"1234"}
    // 获取资源列表
    @RequestMapping(value = "/web/resource/getResourceList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<TeachResource>> getTeachResources(@RequestBody Map<String, String> params) {
        CommonUtil.printLog(TAG + " getTeachResources");

        TeachResourceService service = new TeachResourceService();
        return service.getTeacherUploadResourceList(params);

//        DataResponse<List<TeachResource>> response = new DataResponse<List<TeachResource>>(200, "no reason");
//
//        List<TeachResource> list = new LinkedList<TeachResource>();
//
//        for(int i=0;i<10;i++){
//            TeachResource resource = new TeachResource();
//            resource.setmModuleId(Resource.Module.MODULE_FRAME_RESOURCE);
//            resource.setResourceName("FileNameFileNameFileNameFileNameFileName");
//            resource.setDownloadCount(10);
//            resource.setLikeCount(20);
//            resource.setUploadDate(TimeUtil.timeToStr(new Date(), TimeUtil.ENG_PATTERN_YMD));
//            resource.setDownloadUrl(testUrl);
//            resource.setResourceId(DBUtil.generateUUID());
//            list.add(resource);
//        }
//
//        response.setData(list);
//
//        return response;

    }




    // 用于学生上传作业
    @RequestMapping(value = "/FileUpload/studentFileUpload", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public DataResponse<Map<String, Integer>> studentFileUpload(@RequestParam("file_AjaxFile") MultipartFile multipartFile, HttpServletRequest request){

        TeachResourceService teachResourceService = new TeachResourceService();

        return teachResourceService.postStudentHomework(multipartFile, request);

    }



    @RequestMapping(value = "/FileUpload/fileUpload_ajax", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String fileUpload_ajax(@RequestParam("file_AjaxFile") MultipartFile multipartFile, HttpServletRequest request) {
        System.out.println("enterFileUploadAjax");
//        DataUtils.printRequestBodyStr("FileUploadController: ", request);
        TeachResourceService service = new TeachResourceService();
        return service.postResource(multipartFile, request);

//        System.out.println("Content-Type: " + request.getContentType());
//
//        String teacherId = request.getParameter(Resource.KEY.KEY_TEACHER_ID);
//        String courseId = request.getParameter(Resource.KEY.KEY_COURSE_ID);
//        System.out.println("teacherId: " + teacherId + ", courseId: " + courseId);
//
//        HttpSession session = request.getSession();
//        String path = session.getServletContext().getRealPath("/");
//        System.out.println("contextPath: " + session.getServletContext().getContextPath() + ", realPath: " +  path);
//
//        //调用保存文件的帮助类进行保存文件，并返回文件的相对路径
//        String filePath = Files_Utils_DG.FilesUpload_transferTo_spring(request, multipartFile, "/files/Upload");
//        System.out.println("{'TFMark':'true','Msg':'upload success !','filePath':'" + filePath + "'}");
//        return "{'TFMark':'true','Msg':'upload success !','filePath':'" + filePath + "'}";
    }

    /**
     * 文件下载
     *
     * //  "/files/download/韩晓娜_面向大学英语课堂的智能教学系统_毕业设计开题报告.docx"
     * @param response
     */
    @RequestMapping(value = "/FileUpload/fileDownload_servlet/{resourceId}")
    public void fileDownload_servlet(HttpServletRequest request, HttpServletResponse response, @PathVariable String resourceId) {


        ResourceDAO resourceDAO = new ResourceDAO();
        String path = resourceDAO.getResourceSavedPathByResourceId(resourceId);
        resourceDAO.addDownloadCount(resourceId);
        CommonUtil.printLog("TeachResourceController savedPath: " + path);
        Files_Utils_DG.FilesDownload_stream(request,response,path);
    }



    // 获取学生的课程资源列表
    // {"c_id":"c9c59c54-d5d5-4da1-859c-ac8f540ce5b3","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
    @RequestMapping(value = "/web/resource/getStudentResourceList", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<TeachResource>> getStudentTeachResources(@RequestBody Map<String, String> params){
        TeachResourceService service = new TeachResourceService();
        return service.getCourseResourceListForStudent(params);

    }



//    // 获取学生的课程资源列表
//    // {"c_id":"c9c59c54-d5d5-4da1-859c-ac8f540ce5b3","s_id":"b78ca7d6-e690-46f8-b30a-5f1287e1b81d"}
//    @RequestMapping(value = "/web/resource/getStudentResourceList", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<List<TeachResource>> getStudentTeachResources(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + ", getStudentTeachResources", request);
//
//        DataResponse<List<TeachResource>> response = new DataResponse<List<TeachResource>>(200, "no reason");
//
//        List<TeachResource> list = new LinkedList<TeachResource>();
//
//        for(int i=0;i<10;i++){
//            TeachResource resource = new TeachResource();
//            resource.setmModuleId(Resource.Module.MODULE_FRAME_RESOURCE);
//            resource.setResourceName("震惊！百分之九十九的人都不知道！点击速看！男人看了沉默，女人看了会流泪！不转不是好学生！");
//            resource.setDownloadCount(10);
//            resource.setLikeCount(20);
//            resource.setUploadDate(TimeUtil.timeToStr(new Date(), TimeUtil.ENG_PATTERN_YMD));
//            resource.setDownloadUrl(testUrl);
//            resource.setResourceId(DBUtil.generateUUID());
//            list.add(resource);
//        }
//
//        response.setData(list);
//
//        return response;
//
//    }

    // {"resource_id":"18ecc9c7-11e7-4819-aa26-f8a30c53170b","c_id":"course789","t_id":"1234"}
    // 删除某个资源
    @RequestMapping(value = "/web/resource/delete", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> deleteResource(@RequestBody Map<String, String> params, HttpServletRequest request){

        TeachResourceService service = new TeachResourceService();
        return service.deleteResourceByTeacher(params, request);

//        DataUtils.printRequestBodyStr(TAG + ", deleteResource", request);
//
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put(Resource.KEY.KEY_RESOURCE_DELETE_STATUS, Resource.RES_STATUS.RESOURCE_DELETE_FILE_SUCCESS);
//
//        response.setData(map);
//        return response;

    }

}
