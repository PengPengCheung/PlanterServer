package dao.logic;

import dao.BaseDAO;
import dao.IAttentionOP;
import entity.AttentionInfoEntity;
import entity.StudentPerformanceAttentionTableEntity;
import entity.TeacherCourseAttentionTableEntity;
import module.attention.model.AttentionGoingModel;
import module.attention.model.AttentionNormalWebRequestViewModel;
import module.attention.model.AttentionWebViewModel;
import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

import java.util.List;

/**
 * Created by peng on 2017/3/27.
 */
public class AttentionDAO extends BaseDAO {

    public AttentionDAO(){
        super();
    }


    public void insertStudentCourseAttentionConnection(AttentionInfoEntity entity, String openClassId, String studentId){
        SqlSession session = getSession();
        IAttentionOP attentionOP = session.getMapper(IAttentionOP.class);
        if(entity != null){
            StudentPerformanceAttentionTableEntity studentPerformanceAttentionTableEntity = constructStudentAttentionEntity(entity.getAttentionId(), openClassId, studentId);
            attentionOP.insertStudentCourseAttentionConnection(studentPerformanceAttentionTableEntity);
            session.commit();
        }
    }

    private StudentPerformanceAttentionTableEntity constructStudentAttentionEntity(String attentionId, String openClassId, String studentId){
        StudentPerformanceAttentionTableEntity entity = new StudentPerformanceAttentionTableEntity();
        entity.setAttentionId(attentionId);
        entity.setOpenClassId(openClassId);
        entity.setStudentPerformanceAttentionId(DBUtil.generateUUID());
        entity.setsId(studentId);

        return entity;
    }

    public AttentionInfoEntity insertStudentAttentionEntity(AttentionGoingModel attentionGoingModel){
        SqlSession session = getSession();
        AttentionInfoEntity entity = constructAttentionEntity(attentionGoingModel);
        IAttentionOP attentionOP = session.getMapper(IAttentionOP.class);
        attentionOP.insertAttentionRecord(entity);
        session.commit();

        return entity;
    }

    private AttentionInfoEntity constructAttentionEntity(AttentionGoingModel attentionGoingModel) {
        AttentionInfoEntity entity = new AttentionInfoEntity();
        entity.setAttentionId(DBUtil.generateUUID());
        entity.setAttentionType(attentionGoingModel.getAttentionType());
        entity.setAttentionBonusNum(attentionGoingModel.getmAttentionBonusNum());
        entity.setAttentionBonusType(attentionGoingModel.getmAttentionBonusType());
        entity.setAttentionDuration(attentionGoingModel.getmAttentionDuration());
        entity.setAttentionTime(attentionGoingModel.getmStartTime());
        entity.setAttentionEndTime(attentionGoingModel.getmEndTime());
        entity.setAttentionStatus(attentionGoingModel.getAttentionStatus());
        entity.setAttentionInsistTime(attentionGoingModel.getAttentionInsistTime());
        entity.setAttentionScore(attentionGoingModel.getScore());
        return entity;
    }


    public void insertAttentionDAO(AttentionWebViewModel webViewModel){
        SqlSession session = getSession();
        IAttentionOP attentionOP = session.getMapper(IAttentionOP.class);
        AttentionInfoEntity entity = constructAttentionOP(webViewModel);
        attentionOP.insertAttentionRecord(entity);
        session.commit();
    }

    private AttentionInfoEntity constructAttentionOP(AttentionWebViewModel webViewModel) {
        AttentionInfoEntity entity = new AttentionInfoEntity();
        entity.setAttentionType(webViewModel.getAttentionType());
        entity.setAttentionDuration(webViewModel.getAttentionDuration());
        String attentionId = DBUtil.generateUUID();
        entity.setAttentionId(attentionId);

        return entity;


    }

    public TeacherCourseAttentionTableEntity insertTeacherNormalAttentionInfo(AttentionNormalWebRequestViewModel normalWebRequestViewModel){
        SqlSession session = getSession();
        IAttentionOP attentionOP = session.getMapper(IAttentionOP.class);
        TeacherCourseAttentionTableEntity entity = constructTeacherCourseAttentionEntity(normalWebRequestViewModel);
        attentionOP.insertTeacherAttentionPublishInfo(entity);
        session.commit();
        return entity;

    }

    private TeacherCourseAttentionTableEntity constructTeacherCourseAttentionEntity(AttentionNormalWebRequestViewModel model){
        TeacherCourseAttentionTableEntity entity = new TeacherCourseAttentionTableEntity();
        entity.setTeacherCourseAttentionId(DBUtil.generateUUID());
        entity.setAttentionType(model.getAttentionType());
        entity.setAttentionBeginTime(model.getAttentionTime());
        entity.setAttentionDuration(model.getAttentionDuration());
        entity.setOpenClassId(model.getOpenClassId());

        return entity;
    }

    public List<TeacherCourseAttentionTableEntity> selectTeacherAttentionListByOpenClassId(String openClassId){
        SqlSession session = getSession();
        IAttentionOP attentionOP = session.getMapper(IAttentionOP.class);
        List<TeacherCourseAttentionTableEntity> teacherCourseAttentionTableEntityList = attentionOP.selectTeacherAttentionListByOpenClassId(openClassId);
        return teacherCourseAttentionTableEntityList;
    }

    public void updateTeacherCourseAttentionEntity(TeacherCourseAttentionTableEntity entity){
        SqlSession session = getSession();
        IAttentionOP attentionOP = session.getMapper(IAttentionOP.class);
        attentionOP.updateTeacherAttentionEntity(entity);
        session.commit();

    }

//    public boolean checkTeacherCourseAttentionStatus(TeacherCourseAttentionTableEntity entity){
//
//    }
}
