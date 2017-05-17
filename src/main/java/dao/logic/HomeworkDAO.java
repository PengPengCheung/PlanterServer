package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IHomeworkOP;
import entity.HomeworkInfoEntity;
import entity.StudentCourseHomeworkTableEntity;
import entity.TeacherCourseHomeworkTableEntity;
import module.homework.model.web.HomeworkPublishRequestModel;
import module.homework.model.web.HomeworkSubmitInfoModel;
import org.apache.ibatis.session.SqlSession;
import utils.CommonUtil;
import utils.DBUtil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/21.
 */
public class HomeworkDAO extends BaseDAO{

    public HomeworkDAO(){super();}


    public void scoreToStudentHomework(String homeworkSubmitId, int score){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        CommonUtil.printLog("HomeworkDAO scoreToStudentHomework homeworkSubmitId: " + homeworkSubmitId + ", score: " + score);
        StudentCourseHomeworkTableEntity homeworkTableEntity = homeworkOP.selectStudentHomeworkInfoEntityBySubmitId(homeworkSubmitId);

        if(homeworkTableEntity == null){
            CommonUtil.printLog("homeworkTableEntity == null");
            return;
        }
        CommonUtil.printLog("HomeworkDAO scoreToHomework homeworkId: " + homeworkTableEntity.getHomeworkId());
        homeworkTableEntity.setHomeworkScore(score);
        homeworkTableEntity.setHomeworkScoreStatus(Resource.HOMEWORK.HOMEWORK_SCORED);
        homeworkOP.updateStudentCourseHomeworkInfoEntity(homeworkTableEntity);
        session.commit();
    }

    public String getHomeworkSavePathByHomeworkSubmitId(String homeworkSubmitId){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        String savedPath = homeworkOP.selectHomeworkSavePathByHomeworkSubmitId(homeworkSubmitId);
        return savedPath;
    }


    public void updateHomeworkInfoEntity(String homeworkId){
        CommonUtil.printLog("HomeworkDAO updateHomeworkInfoEntity homeworkId: " + homeworkId);
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        HomeworkInfoEntity homeworkInfoEntity = homeworkOP.selectHomeworkInfoEntityByHomeworkId(homeworkId);
        homeworkInfoEntity.setHomeworkStatus(Resource.HOMEWORK.HOMEWORK_SUBMIT_STATUS_SUCCESS);
        homeworkOP.updateHomeworkStatus(homeworkInfoEntity);
        session.commit();
    }

    public void saveStudentSubmitHomeworkInfo(String relativeFilePath, String fileName, HomeworkSubmitInfoModel model){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        StudentCourseHomeworkTableEntity entity = constructStudentCourseHomeworkInfoEntity(relativeFilePath, fileName, model);
        homeworkOP.insertStudentHomeworkRecord(entity);






        session.commit();
    }

    private StudentCourseHomeworkTableEntity constructStudentCourseHomeworkInfoEntity(String relativeFilePath, String fileName, HomeworkSubmitInfoModel model) {
        StudentCourseHomeworkTableEntity entity = new StudentCourseHomeworkTableEntity();
        String uuid = DBUtil.generateUUID();
        entity.setStudentSubmitHomeworkId(uuid);
        entity.setcId(model.getCourseId());
        entity.setsId(model.getStudentId());
        entity.setHomeworkId(model.getHomeworkTeacherPublishedId());
        entity.setHomeworkSavePath(relativeFilePath);
        entity.setHomeworkSubmitDate(model.getHomeworkSubmitTime());
        entity.setHomeworkScoreStatus(Resource.HOMEWORK.HOMEWORK_SUBMIT_SUCCESS);
        entity.setHomeworkScore(-1);
        entity.setHomeworkSubmitName(fileName);
        entity.setHomeworkDownloadUrl(getDownloadUrl(uuid));

        return entity;
    }

    private String getDownloadUrl(String id){
        return Resource.STUDENT_HOMEWORK_DOWNLOAD_URL + File.separator + id;
    }


    public List<HomeworkInfoEntity> getHomeworkInfoListByCourseId(String courseId){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        List<HomeworkInfoEntity> homeworkInfoEntityList = new LinkedList<HomeworkInfoEntity>();
        List<TeacherCourseHomeworkTableEntity> entityList = homeworkOP.selectTeacherCourseHomeworkInfoListByCourseId(courseId);

        for(TeacherCourseHomeworkTableEntity entity : entityList){
            String homeworkId = entity.getHomeworkId();
            HomeworkInfoEntity homeworkInfoEntity = homeworkOP.selectHomeworkInfoEntityByHomeworkId(homeworkId);
            homeworkInfoEntityList.add(homeworkInfoEntity);
        }

        return homeworkInfoEntityList;
    }


    public List<StudentCourseHomeworkTableEntity> getStudentSubmitHomeworkList(String homeworkId){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        List<StudentCourseHomeworkTableEntity> homeworkSubmitList = homeworkOP.selectStudentSubmitHomeworkInfoList(homeworkId);
        return homeworkSubmitList;
    }

    public int getSubmitNumByHomeworkIdAndCourseId(String homeworkId, String courseId){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        List<StudentCourseHomeworkTableEntity> entityList = homeworkOP.selectStudentCourseHomeworkInfoByHomeworkIdAndCourseId(homeworkId, courseId);
        if(entityList != null){
            return entityList.size();
        }

        return 0;
    }

    public List<HomeworkInfoEntity> getHomeworkInfoList(String teacherId, String courseId){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        List<String> homeworkIdList = homeworkOP.selectHomeworkIdListByTeacherIdAndCourseId(teacherId, courseId);
        List<HomeworkInfoEntity> entityList = new LinkedList<HomeworkInfoEntity>();
        for(String homeworkId : homeworkIdList){
            HomeworkInfoEntity entity = homeworkOP.selectHomeworkInfoEntityByHomeworkId(homeworkId);
            entityList.add(entity);
        }
        return entityList;
    }

    public void insertTeacherCourseHomeworkRecord(String teacherId, String courseId, String homeworkId){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        TeacherCourseHomeworkTableEntity entity = constructTeacherHomeworkEntity(teacherId, courseId, homeworkId);
        homeworkOP.insertTeacherHomeworkRecord(entity);
        session.commit();
    }

    private TeacherCourseHomeworkTableEntity constructTeacherHomeworkEntity(String teacherId, String courseId, String homeworkId) {
        TeacherCourseHomeworkTableEntity entity = new TeacherCourseHomeworkTableEntity();
        entity.setHomeworkId(homeworkId);
        entity.settId(teacherId);
        entity.setcId(courseId);
        entity.setHomeworkPublishStatus(Resource.HOMEWORK.HOMEWORK_PUBLISHED);
        return entity;
    }

    public HomeworkInfoEntity publishHomework(HomeworkPublishRequestModel publishRequestModel){
        SqlSession session = getSession();
        IHomeworkOP homeworkOP = session.getMapper(IHomeworkOP.class);
        HomeworkInfoEntity entity = constructHomeworkInfoEntity(publishRequestModel);
        homeworkOP.insertHomeworkInfoEntity(entity);
        session.commit();
        return entity;
    }

    private HomeworkInfoEntity constructHomeworkInfoEntity(HomeworkPublishRequestModel model){
        HomeworkInfoEntity entity = new HomeworkInfoEntity();
        entity.setHomeworkId(DBUtil.generateUUID());
        entity.setHomeworkTitle(model.getHomeworkTitle());
        entity.setHomeworkContent(model.getHomeworkContent());
        entity.setHomeworkCommitDdl(model.getHomeworkDDL());
        entity.setHomeworkStatus(Resource.HOMEWORK.HOMEWORK_PUBLISHED);
        entity.setHomeworkPublishTime(model.getHomeworkPublishTime());

        return entity;
    }


}
