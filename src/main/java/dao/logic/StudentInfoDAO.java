package dao.logic;

import dao.BaseDAO;
import dao.IStudentInfo;
import entity.StudentInfoEntity;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by peng on 2017/4/20.
 */
public class StudentInfoDAO extends BaseDAO{

    public StudentInfoDAO(){
        super();
    }


    public String getStudentIdByStudentName(String studentName){
        SqlSession session = getSession();
        IStudentInfo studentInfo = session.getMapper(IStudentInfo.class);
        String studentId = null;
        List<StudentInfoEntity> entities = studentInfo.selectStudentByStudentName(studentName);
        if(entities != null){
            for(StudentInfoEntity entity : entities){
                studentId = entity.getsId();
                return studentId;
            }
        }

        return studentId;

    }


    public StudentInfoEntity getStudentInfoByStudentId(String studentId){
        SqlSession session = getSession();
        IStudentInfo studentInfo = session.getMapper(IStudentInfo.class);
        return studentInfo.selectStudentByStudentId(studentId);
    }

    public String getStudentNameByStudentId(String studentId){
        SqlSession session = getSession();
        IStudentInfo studentInfo = session.getMapper(IStudentInfo.class);
        return studentInfo.selectStudentNameByStudentId(studentId);
    }

}
