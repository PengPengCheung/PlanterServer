package dao;

import entity.StudentCourseTreeBonusEntity;
import entity.StudentCourseTreeEntity;
import entity.TreeInfoEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by peng on 2017/3/24.
 */
public interface IStudentCourseTree {

    StudentCourseTreeEntity selectStudentTreeById(@Param("cId") String cId, @Param("sId") String sId);

    TreeInfoEntity selectTreeInfoEntityByTreeId(String treeId);

    void insertStudentCourseTree(StudentCourseTreeEntity entity);

    void insertTreeBonusRecord(StudentCourseTreeBonusEntity entity);

    void updateStudentTreeInfo(TreeInfoEntity entity);
}
