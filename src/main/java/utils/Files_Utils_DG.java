package utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class Files_Utils_DG {
      /**
       * private constructor method that make class can not be instantiation
       */
      private Files_Utils_DG() {
          throw new Error("The class Cannot be instance !");
      }



    /**
     * spring mvc files Upload method (transferTo method)
     * MultipartFile use TransferTo method upload
     *
     * @param request       HttpServletRequest
     * @param multipartFile MultipartFile(spring)
     * @param filePath      filePath example "/files/Upload"
     * @return
     */
    public static String FilesUpload_transferTo_spring(HttpServletRequest request, MultipartFile multipartFile, String filePath, String id) {
        if (multipartFile != null) {
            //get files suffix
            String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));

            String newFileName = multipartFile.getOriginalFilename();
            //filePath+fileName the complex file Name
            String absolutePath = getAbsolutePath(request, filePath, id, newFileName);
            //return relative Path
            String relativePath = getRelativePath(filePath, id, newFileName);
            System.out.println("suffix: " + suffix + ", absolutePath: " + absolutePath + ", relativePath: " + relativePath);
            System.out.println("filePath: " + filePath);
            try {
                //save file
                multipartFile.transferTo(new File(absolutePath));
                //return relative Path
                return relativePath;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return null;
    }


//
//      /**
//       * spring mvc files Upload method (transferTo method)
//       * MultipartFile use TransferTo method upload
//       *
//      * @param request       HttpServletRequest
//       * @param multipartFile MultipartFile(spring)
//       * @param filePath      filePath example "/files/Upload"
//       * @return
//       */
//      public static String FilesUpload_transferTo_spring(HttpServletRequest request, MultipartFile multipartFile, String filePath) {
//          if (multipartFile != null) {
//              //get files suffix
//              String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
//
////              String newFileName = UUID.randomUUID().toString();
//              String newFileName = multipartFile.getOriginalFilename();
//             //filePath+fileName the complex file Name
//              String absolutePath = getAbsolutePath(request, filePath, newFileName);
//              //return relative Path
//              String relativePath = getRelativePath(filePath, newFileName);
//              System.out.println("suffix: " + suffix + ", absolutePath: " + absolutePath + ", relativePath: " + relativePath);
//              System.out.println("filePath: " + filePath);
//              try {
//                  //save file
//                  multipartFile.transferTo(new File(absolutePath));
//                  //return relative Path
//                  return relativePath;
//              } catch (IOException e) {
//                  e.printStackTrace();
//                  return null;
//              }
//          } else
//              return null;
//      }

      /**
       * user stream type save files
       * @param request       HttpServletRequest
       * @param multipartFile MultipartFile  support CommonsMultipartFile file
       * @param filePath      filePath example "/files/Upload"
       * @return
       */
      public static String FilesUpload_stream(HttpServletRequest request,MultipartFile multipartFile,String filePath) {
          if (multipartFile != null) {
              //get files suffix
              String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
              //filePath+fileName the complex file Name
              String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
              //return relative Path
              String relativePath = getRelativePath(filePath, suffix, "");
              try{
                  InputStream inputStream = multipartFile.getInputStream();
                  FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                  byte buffer[] = new byte[4096]; //create a buffer
                  long fileSize = multipartFile.getSize();
                  if(fileSize<=buffer.length){//if fileSize < buffer
                      buffer = new byte[(int)fileSize];
                  }
                  int line =0;
                  while((line = inputStream.read(buffer)) >0 )
                  {
                      fileOutputStream.write(buffer,0,line);
                  }
                  fileOutputStream.close();
                  inputStream.close();
                  return relativePath;
              }catch (Exception e){
                  e.printStackTrace();
              }
          } else
              return null;
          return null;
      }


      public static void deleteFile(HttpServletRequest request, String filePath){
          String realPath = getServerPath(request, filePath);
          File file = new File(realPath);
          if(!file.exists()){
              return;
          }

          file.delete();
      }


      /**
       * @param request  HttpServletRequest
       * @param response HttpServletResponse
       * @param filePath example "/filesOut/Download/mst.txt"
       * @return
       */
      public static void FilesDownload_stream(HttpServletRequest request, HttpServletResponse response, String filePath) {
         //get server path (real path)
//         String realPath = request.getSession().getServletContext().getRealPath(filePath);
         String realPath = getServerPath(request, filePath);
         File file = new File(realPath);
         String filenames = file.getName();
         InputStream inputStream;
         try {
             inputStream = new BufferedInputStream(new FileInputStream(file));
             byte[] buffer = new byte[inputStream.available()];
             inputStream.read(buffer);
             inputStream.close();
             response.reset();
             // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
             response.addHeader("Content-Disposition", "attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
             response.addHeader("Content-Length", "" + file.length());
             OutputStream os = new BufferedOutputStream(response.getOutputStream());
             response.setContentType("application/octet-stream");
             os.write(buffer);// 输出文件
             os.flush();
             os.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }


     //-------------------------------------------------------------------------------
     //return server absolute path（real path）
     public static String getServerPath(HttpServletRequest request, String filePath) {
         return request.getSession().getServletContext().getRealPath(filePath);
//         return "/Users/peng/Software/Tomcat/apache-tomcat-7.0.75/webapps" + filePath;
     }

     //return a dir that named date of today ; example:20160912
     public static String getDataPath() {
         return new SimpleDateFormat("yyyyMMdd").format(new Date());
     }

     //check if the path has exist if not create it
     public static void checkDir(String savePath) {
         File dir = new File(savePath);
         if (!dir.exists() || !dir.isDirectory()) {
             dir.mkdirs();
         }
     }

          //return an UUID Name parameter (suffix cover '.') example： ".jpg"、".txt"
     public static String getUUIDName(String suffix) {
         return UUID.randomUUID().toString() + suffix;// make new file name
     }

     //return server absolute path（real path） the style is  “server absolute path/DataPath/UUIDName”filePath example "/files/Upload"
     public static String getAndSetAbsolutePath(HttpServletRequest request, String filePath, String suffix) {
         String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;//example:F:/qixiao/files/Upload/20160912/
         System.out.println(savePath);
         checkDir(savePath);//check if the path has exist if not create it
         String path = savePath + getUUIDName(suffix);
//         checkFile(path);
         return path;
     }

    //return server absolute path（real path） the style is  “server absolute path/DataPath/UUIDName”filePath example "/files/Upload"
    public static String getAndSetAbsolutePath(HttpServletRequest request, String filePath, String fileName, String suffix) {
        String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;//example:F:/qixiao/files/Upload/20160912/
        System.out.println(savePath);
        checkDir(savePath);//check if the path has exist if not create it
        String path = savePath + fileName + suffix;
//         checkFile(path);
        return path;
    }

    // /Users/peng/Software/Tomcat/apache-tomcat-7.0.75/webapps/ROOT/file/Upload/20170424/d5fd860f-d088-41ba-8a12-781015d59af7.docx
    //return server absolute path（real path） the style is  “server absolute path/DataPath/UUIDName”filePath example "/files/Upload"
    public static String getAbsolutePath(HttpServletRequest request, String filePath, String id, String originalFileName) {
        String savePath = getServerPath(request, filePath) + File.separator + id + File.separator + getDataPath() + File.separator;//example:F:/qixiao/files/Upload/20160912/
        System.out.println(savePath);
        checkDir(savePath);//check if the path has exist if not create it
        String path = savePath + originalFileName;
//         checkFile(path);
        return path;
    }

     private static void checkFile(String path){
          File file = new File(path);
          System.out.println(path);
          if(!file.exists()){
              try {
//                  file.mkdirs();
                  file.createNewFile();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
     }

//     //get the relative path of files style is “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
//     public static String getRelativePath(String filePath, String suffix) {
//         return filePath + File.separator + getDataPath() + File.separator + getUUIDName(suffix);//example:/files/Upload/20160912/
//     }

    //get the relative path of files style is “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
//    public static String getRelativePath(String filePath, String newFileName, String suffix) {
//        return filePath + File.separator + getDataPath() + File.separator + newFileName + suffix;//example:/files/Upload/20160912/
//    }

    //get the relative path of files style is “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
    public static String getRelativePath(String filePath, String id, String originalFileName) {
        return filePath + File.separator + id + File.separator + getDataPath() + File.separator + originalFileName;//example:/files/Upload/20160912/
    }
 }