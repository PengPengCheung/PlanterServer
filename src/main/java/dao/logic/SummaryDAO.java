package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IClassOP;
import dao.IStudentSummaryOP;
import dao.ITeacherSummaryOP;
import entity.StudentSummaryEntity;
import entity.StudentTeacherClassTableEntity;
import entity.TeacherSummaryEntity;
import module.summary.model.mob.SummaryViewModel;
import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

import java.util.List;

/**
 * Created by peng on 2017/3/25.
 */
public class SummaryDAO extends BaseDAO {

    public SummaryDAO(){
        super();
    }


    public List<StudentSummaryEntity> getStudentSummaryListByOpenClassId(String openClassId){
        SqlSession session = getSession();
        IStudentSummaryOP summaryOP = session.getMapper(IStudentSummaryOP.class);
        List<StudentSummaryEntity> summaryEntityList = summaryOP.getStudentSummaryListByOpenClassId(openClassId);
        return summaryEntityList;
    }

    public List<StudentTeacherClassTableEntity> getCourseOpenListByOpenClassId(String courseId, String teacherId){
        SqlSession session = getSession();
        IClassOP classOP = session.getMapper(IClassOP.class);
        List<StudentTeacherClassTableEntity> entities = classOP.getClassOpenRecordByTeacherIdAndCourseId(teacherId, courseId);
        return entities;
    }


    public TeacherSummaryEntity storeTeacherSummaryInfo(SummaryViewModel model){
        SqlSession session = getSession();
        ITeacherSummaryOP teacherSummaryOP = session.getMapper(ITeacherSummaryOP.class);
        TeacherSummaryEntity entity = constructTeacherSummary(model);
        teacherSummaryOP.insertTeacherSummary(entity);
        session.commit();
        return entity;

    }

    private TeacherSummaryEntity constructTeacherSummary(SummaryViewModel model) {
        TeacherSummaryEntity entity = new TeacherSummaryEntity();
        entity.setOpenClassId(model.getmOpenClassId());
        entity.setSummaryRequestTime(model.getmSummaryRequestTime());
        entity.setTeacherSummaryId(DBUtil.generateUUID());
        return entity;
    }


    public boolean storeStudentSummary(SummaryViewModel model){
        SqlSession session = getSession();

        try{
            IStudentSummaryOP studentSummaryOP = session.getMapper(IStudentSummaryOP.class);
            StudentSummaryEntity entity = constructStudentSummaryDBModel(model);
            studentSummaryOP.insertStudentSummary(entity);
            session.commit();
            return true;

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private StudentSummaryEntity constructStudentSummaryDBModel(SummaryViewModel model) {
        StudentSummaryEntity entity = new StudentSummaryEntity();
        entity.setsId(model.getmStudentId());
        entity.setSummaryTime(model.getmSummarySendTime());
        entity.setSummaryContent(model.getmSummaryContent());
        entity.setSummaryStatus(Resource.SUMMARY.SUMMARY_SEND_NOT_REPLY);
        entity.setSummaryBonus(Resource.BONUS_NUM.SUMMARY_BONUS_NUM);
        entity.setOpenClassId(model.getmOpenClassId());
        entity.setStudentSummaryId(DBUtil.generateUUID());


        return entity;
    }

}
