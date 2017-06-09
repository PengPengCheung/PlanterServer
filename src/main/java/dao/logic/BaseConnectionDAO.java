package dao.logic;

import dao.BaseDAO;
import dao.IBaseConnection;
import dao.ICourseInfo;
import entity.BaseConnectionEntity;
import entity.CourseInfoEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.test.context.jdbc.Sql;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/17.
 */
public class BaseConnectionDAO extends BaseDAO {

    public BaseConnectionDAO(){
        super();
    }

    public List<BaseConnectionEntity> selectBaseConnectionEntitiesByStudentId(String studentId){
        SqlSession session = getSession();
        IBaseConnection connection = session.getMapper(IBaseConnection.class);
        List<BaseConnectionEntity> entityList = connection.selectBaseConnectionListByStudentId(studentId);
        return entityList;
    }

    public List<BaseConnectionEntity> selectAllBaseConnection(){
        SqlSession session = getSession();
        IBaseConnection baseConnection = session.getMapper(IBaseConnection.class);
        List<BaseConnectionEntity> baseConnectionEntityList = baseConnection.selectAllConnection();

        if(baseConnectionEntityList != null && baseConnectionEntityList.size() > 0){
            return baseConnectionEntityList;
        }

        return new LinkedList<BaseConnectionEntity>();
    }

    public BaseConnectionEntity selectBaseConnectionByCourseIdAndStudentId(String courseId, String studentId){
        SqlSession session = getSession();
        IBaseConnection baseConnection = session.getMapper(IBaseConnection.class);
        BaseConnectionEntity entity = baseConnection.selectBaseConnectionByCourseIdAndStudentId(courseId, studentId);
        return entity;
    }

    public List<BaseConnectionEntity> selectBaseConnectionByTeacherId(String teacherId){
        SqlSession session = getSession();
        IBaseConnection connection = session.getMapper(IBaseConnection.class);
        List<BaseConnectionEntity> connectionEntityList = connection.selectBaseConnectionListByTeacherId(teacherId);
        return connectionEntityList;
    }

    public List<BaseConnectionEntity> getBaseConnectionListByCourseId(String courseId){
        SqlSession session = getSession();
        IBaseConnection connections = session.getMapper(IBaseConnection.class);
        List<BaseConnectionEntity> connectionEntityList = connections.selectBaseConnectionListByCourseId(courseId);

        return connectionEntityList;
    }

    public boolean insertBaseConnection(BaseConnectionEntity entity){
        boolean isSuccess = false;
        SqlSession session = getSession();
        IBaseConnection connection = session.getMapper(IBaseConnection.class);
        List<BaseConnectionEntity> connectionEntityList = connection.selectAllConnection();
        for(BaseConnectionEntity baseConnectionEntity: connectionEntityList){
            String courseId = baseConnectionEntity.getcId();
            String teacherId = baseConnectionEntity.gettId();
            String studentId = baseConnectionEntity.getsId();
            System.out.println("courseId: " + courseId + ", teacherId: " + teacherId + ", studentId: " + studentId);
            if(courseId != null && courseId.equals(entity.getcId())){ // 已创建的课程才添加，不添加未创建的课程

                if(teacherId == null){
                    isSuccess = false;
                    return isSuccess;
                }

                if(teacherId.equals(entity.gettId())){
                    if(studentId != null && studentId.equals(entity.getsId())){ // 如果存在该学生id，则说明此联系已经建立
                        return isSuccess;
                    }
                }
            }
        }
        connection.insertBaseConnectionEntity(entity);
        session.commit();
        isSuccess = true;
        return isSuccess;
    }
}
