package utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.JDBCTest;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by peng on 2017/3/22.
 */
public class DBUtil {

    private static final String configureFile = "conf.xml"; // 需要放在resource目录下

    public static SqlSession init(){
        //mybatis的配置文件
        String resource = configureFile;
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        return session;
    }

    public static void closeSession(SqlSession session){
        if(session != null){
            session.close();
        }
    }

    public static String generateUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
