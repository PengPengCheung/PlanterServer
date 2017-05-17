package service;

import dao.BaseDAO;
import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

/**
 * Created by peng on 2017/3/22.
 */
public abstract class BaseService {



    public BaseService(){

    }

    public void handleDB(BaseDAO dao){

    }

    public abstract void handleDataWithDB(SqlSession session, BaseDAO dao);



}
