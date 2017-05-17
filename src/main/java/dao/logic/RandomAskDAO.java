package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IBonusOP;
import dao.IRandomAskOP;
import entity.RandomAskInfoEntity;
import entity.TeacherClassAskEntity;
import entity.TeacherClassRandomAskTableEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.test.context.jdbc.Sql;
import utils.DBUtil;

/**
 * Created by peng on 2017/4/20.
 */
public class RandomAskDAO extends BaseDAO{

    public RandomAskDAO(){
        super();
    }

    public void insertBonusInfo(String openClassId, String studentId){
        SqlSession session = getSession();
        IBonusOP bonusOP = session.getMapper(IBonusOP.class);
        TeacherClassAskEntity entity = constructTeacherClassAskEntity(openClassId, studentId);
        bonusOP.insertBonusInfo(entity);
        session.commit();
    }

    private TeacherClassAskEntity constructTeacherClassAskEntity(String openClassId, String studentId){
        TeacherClassAskEntity entity = new TeacherClassAskEntity();
        entity.setOpenClassId(openClassId);
        entity.setsId(studentId);
        entity.setTeacherClassAskId(DBUtil.generateUUID());
        entity.setAskBonus(Resource.BONUS_NUM.SURPRISE_BONUS_NUM);
        entity.setBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        return entity;
    }

    public RandomAskInfoEntity insertRandomAskInfo(String randomAskTime){
        SqlSession session = getSession();
        IRandomAskOP randomAskOP = session.getMapper(IRandomAskOP.class);
        RandomAskInfoEntity entity = new RandomAskInfoEntity();
        entity.setRandomAskTime(randomAskTime);
        entity.setRandomAskId(DBUtil.generateUUID());
        entity.setRandomAskStatus(Resource.RANDOM_ASK.RANDOM_ASK_BEGIN);
        randomAskOP.insertRandomAskInfo(entity);
        session.commit();
        return entity;
    }

    public void insertTeacherRandomAskInfo(String openClassId, String randomAskId){
        SqlSession session = getSession();
        IRandomAskOP randomAskOP = session.getMapper(IRandomAskOP.class);
        TeacherClassRandomAskTableEntity entity = new TeacherClassRandomAskTableEntity();
        entity.setOpenClassId(openClassId);
        entity.setRandomAskId(randomAskId);
        entity.setTeacherClassRandomAskId(DBUtil.generateUUID());
        randomAskOP.insertTeacherRandomAskInfo(entity);
        session.commit();
    }


}
