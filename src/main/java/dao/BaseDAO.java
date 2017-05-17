package dao;

import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

/**
 * Created by peng on 2017/3/22.
 */
public class BaseDAO {

    SqlSession session;

    public BaseDAO(){
        session = DBUtil.init();
    }

    public SqlSession getSession(){
        return session;
    }

//    public void method(){
//        handleDataWithDB(session);
//        DBUtil.closeSession(session);
//    }

    public void closeSession(){
        session.close();
    }
}
