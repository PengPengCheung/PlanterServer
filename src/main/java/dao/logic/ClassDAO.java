package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IClassOP;
import entity.StudentTeacherClassTableEntity;
import module.course.ClassViewModel;
import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

/**
 * Created by peng on 2017/3/27.
 */
public class ClassDAO extends BaseDAO{

    public ClassDAO(){
        super();
    }


    public StudentTeacherClassTableEntity getOpenClassEntityByOpenClassId(String openClassId){
        SqlSession session = getSession();
        IClassOP classOP = session.getMapper(IClassOP.class);
        StudentTeacherClassTableEntity entity = classOP.selectOpenClassRecordByOpenClassId(openClassId);
        return entity;
    }

    public StudentTeacherClassTableEntity openClass(ClassViewModel viewModel){
        SqlSession session = getSession();

        return createClassOpenRecord(session, viewModel);

    }

    private StudentTeacherClassTableEntity createClassOpenRecord(SqlSession session, ClassViewModel viewModel){
        IClassOP classOP = session.getMapper(IClassOP.class);
//        String baseConnectionId = classOP.selectBaseConnectionIdByTeacherAndCourse(viewModel.getmTeacherId(), viewModel.getmCourseId());


        StudentTeacherClassTableEntity entity = constructEntity(viewModel);

        classOP.insertClassOpenRecord(entity);
        session.commit();
        return entity;
    }

    private StudentTeacherClassTableEntity constructEntity(ClassViewModel viewModel){
        StudentTeacherClassTableEntity entity = new StudentTeacherClassTableEntity();
//        entity.setClassDatetime(viewModel.getClassBeginTime());
//        entity.setBaseConnectionId(baseConnectionId);
        entity.settId(viewModel.getmTeacherId());
        System.out.println("constructEntity cId: " + viewModel.getmCourseId());
        entity.setcId(viewModel.getmCourseId());
        String openClassId = DBUtil.generateUUID();
        entity.setOpenClassId(openClassId);
        entity.setClassStatus(Resource.CLASS.CLASS_STATUS_OPEN);
        entity.setClassBeginTime(viewModel.getClassBeginTime());
        return entity;
    }

}
