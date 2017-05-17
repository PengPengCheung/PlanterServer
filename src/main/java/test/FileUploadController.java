package test;

import common.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.DataUtils;
import utils.Files_Utils_DG;
import utils.JsonUtil;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/21.
 */

@Controller
@RequestMapping(value = "/FileUpload2/*")
public class FileUploadController {


      @RequestMapping("fileUpload_stream")
      @ResponseBody
      public String upFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("file_upload") MultipartFile multipartFile){
        String filePath= Files_Utils_DG.FilesUpload_stream(request,multipartFile,"/files/Upload");

          try {
              response.sendRedirect("");
          } catch (IOException e) {
              e.printStackTrace();
          }
          return "{'TFMark':'true','Msg':'upload success !','filePath':'" + filePath + "'}";
    }


    /*
     * 方式五
     * 采用 fileUpload_ajax ， file.transferTo 来保存上传的文件 异步
     * @RequestParam(value = "file_AjaxFile",required = false)
     * @RequestParam("postFile")
     */
    @RequestMapping(value = "fileUpload_ajax", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String fileUpload_ajax(@RequestParam("file_AjaxFile") MultipartFile multipartFile, HttpServletRequest request) {
        System.out.println("enterFileUploadAjax");
//        DataUtils.printRequestBodyStr("FileUploadController: ", request);

        System.out.println("Content-Type: " + request.getContentType());

        String id = request.getParameter(Resource.KEY.KEY_TEACHER_ID);
        String name = request.getParameter(Resource.KEY.KEY_COURSE_ID);
        System.out.println("id: " + id + ", name: " + name);

        HttpSession session = request.getSession();
        String path = session.getServletContext().getRealPath("/");
        System.out.println("contextPath: " + session.getServletContext().getContextPath() + ", realPath: " +  path);

        //调用保存文件的帮助类进行保存文件，并返回文件的相对路径
        String filePath = Files_Utils_DG.FilesUpload_transferTo_spring(request, multipartFile, "/files/Upload", id);
        System.out.println("{'TFMark':'true','Msg':'upload success !','filePath':'" + filePath + "'}");
        return "{'TFMark':'true','Msg':'upload success !','filePath':'" + filePath + "'}";
    }


    /**
     * 文件下载
     *
     * @param response
     */
    @RequestMapping(value = "fileDownload_servlet")
    public void fileDownload_servlet(HttpServletRequest request, HttpServletResponse response) {
        Files_Utils_DG.FilesDownload_stream(request,response,"/files/download/韩晓娜_面向大学英语课堂的智能教学系统_毕业设计开题报告.docx");
    }

}
