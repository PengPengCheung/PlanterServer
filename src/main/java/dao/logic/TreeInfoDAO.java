package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IStudentCourseTree;
import dao.ITreeInfo;
import entity.StudentCourseTreeBonusEntity;
import entity.StudentCourseTreeEntity;
import entity.TreeInfoEntity;
import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

/**
 * Created by peng on 2017/4/21.
 */
public class TreeInfoDAO extends BaseDAO{

    public TreeInfoDAO(){super();}

    public void updateTreeInfoEntity(TreeInfoEntity entity){
        SqlSession session = getSession();
        IStudentCourseTree studentCourseTree = session.getMapper(IStudentCourseTree.class);
        studentCourseTree.updateStudentTreeInfo(entity);
        session.commit();
    }

    public TreeInfoEntity selectCourseTreeByStudentIdAndCourseId(String studentId, String courseId){
        SqlSession session = getSession();
        IStudentCourseTree studentCourseTree = session.getMapper(IStudentCourseTree.class);
        StudentCourseTreeEntity studentCourseTreeEntity = studentCourseTree.selectStudentTreeById(courseId, studentId);


        TreeInfoEntity treeInfoEntity = studentCourseTree.selectTreeInfoEntityByTreeId(studentCourseTreeEntity.getTreeId());
        return treeInfoEntity;
    }

    public void awardToCourseTree(String studentId, String courseId, int bonusModuleId, int bonusType, int bonusNum){
        SqlSession session = getSession();
        IStudentCourseTree studentCourseTree = session.getMapper(IStudentCourseTree.class);
        StudentCourseTreeBonusEntity entity = constructStudentTreeCourseBonusEntity(studentId, courseId, bonusModuleId, bonusType, bonusNum);
        studentCourseTree.insertTreeBonusRecord(entity);
        session.commit();
    }

    private StudentCourseTreeBonusEntity constructStudentTreeCourseBonusEntity(String studentId, String courseId, int bonusModuleId, int bonusType, int bonusNum){
        StudentCourseTreeBonusEntity entity = new StudentCourseTreeBonusEntity();
        entity.setcId(courseId);
        entity.setsId(studentId);
        entity.setBonusReason(bonusModuleId);
        entity.setBonusNum(bonusNum);
        entity.setBonusType(bonusType);
        return entity;
    }

    public void insertStudentTreeConnection(String studentId, String courseId, String treeId){
        SqlSession session = getSession();
        IStudentCourseTree studentCourseTreeOP = session.getMapper(IStudentCourseTree.class);
        StudentCourseTreeEntity entity = constructStudentCourseTreeEntity(studentId, courseId, treeId);
        studentCourseTreeOP.insertStudentCourseTree(entity);
        session.commit();
    }

    private StudentCourseTreeEntity constructStudentCourseTreeEntity(String studentId, String courseId, String treeId){
        StudentCourseTreeEntity entity = new StudentCourseTreeEntity();
        entity.setsId(studentId);
        entity.setcId(courseId);
        entity.setTreeId(treeId);
        return entity;
    }

    public TreeInfoEntity insertNewTreeInfo(){
        SqlSession session = getSession();
        ITreeInfo treeInfoOP = session.getMapper(ITreeInfo.class);
        TreeInfoEntity treeInfoEntity = initTreeInfoEntity();
        treeInfoOP.insertTreeInfo(treeInfoEntity);
        session.commit();
        return treeInfoEntity;
    }

    private TreeInfoEntity initTreeInfoEntity(){
        TreeInfoEntity entity = new TreeInfoEntity();
        entity.setTreeId(DBUtil.generateUUID());
        entity.setTreeStatus(Resource.TREE_STATUS.TREE_SEED);
        entity.setTreeWater(0);
        entity.setTreeSoil(0);
        entity.setTreeSun(0);
        entity.setTreeSoilUsedNum(0);
        entity.setTreeSunUsedNum(0);
        entity.setTreeWaterUsedNum(0);
        return entity;
    }
}
