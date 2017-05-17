package test;

import common.Resource;
import dao.IAttendanceInfo;
import dao.IBaseConnection;
import dao.ICourseInfo;
import dao.IStudentInfo;
import dao.logic.StudentInfoDAO;
import entity.AttendanceInfoEntity;
import entity.BaseConnectionEntity;
import entity.CourseInfoEntity;
import entity.StudentInfoEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by peng on 2017/3/9.
 */
public class JDBCTest {

    public static Logger logger = Logger.getLogger(JDBCTest.class);


    public static void main(String[] args){


        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = JDBCTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        Configuration configuration = new Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        sqlSessionFactoryBean.setConfiguration(configuration);
//        testAttendance(session);
//        testSql(session);


        boolean validate = validateCourseCode("1234567890", session);
        System.out.println("isValidate = " + validate);

//        testJDBC();
//        testMyBatis();
//        testSerialize();

        testStudentInfoDAO();
    }

    static void testSelect(SqlSession session){
        IStudentInfo info = session.getMapper(IStudentInfo.class);
        StudentInfoEntity entity = info.selectStudent("小明");

    }


    static void testStudentInfoDAO(){
//        // 02230447-e12d-434f-a3ff-b9a48966397e
        StudentInfoDAO dao = new StudentInfoDAO();
        String entity = dao.getStudentNameByStudentId("02230447-e12d-434f-a3ff-b9a48966397e");
        if(entity != null){
            System.out.println("not null name: " + entity);
        } else {
            System.out.println("null no name");
        }
    }


    static void testSql(SqlSession session){
        String courseCode = "777777";// 777777
        IBaseConnection conn = session.getMapper(IBaseConnection.class);
        BaseConnectionEntity connectionEntity = conn.selectBaseConnectionByCourseId(courseCode);
        session.commit();
        String cid = connectionEntity.getcId();
        String s_id = connectionEntity.getsId();
        System.out.println(cid + " " + s_id);
    }

    static void testAttendance(SqlSession session){
        IAttendanceInfo info = session.getMapper(IAttendanceInfo.class);
        AttendanceInfoEntity ainfo = new AttendanceInfoEntity();
        ainfo.setAttendanceInfoId("1444");
        ainfo.setAttendanceDatetime("2017/3/23");
        ainfo.setAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT);
        info.addAttendanceInfo(ainfo);
        session.commit();
    }

    private static boolean validateCourseCode(String inputCourseCode, SqlSession session){
        if(inputCourseCode == null){
            return false;
        }
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        List<CourseInfoEntity> courseInfoEntities = courseInfo.selectAllCourseInfo();
        for (CourseInfoEntity entity: courseInfoEntities) {
            String code = entity.getCourseCode();
            if(inputCourseCode.equals(code)){
                return true;
            }
        }

        return false;
    }

    private static void testSerialize(){
        List<String> list = new ArrayList<String>();
        list.add("testString");
        Info info = new Info();
        info.setData(list);
        System.out.println(info.getData().get(0));
    }

    public static void testMyBatis(){
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = JDBCTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
//        String statement = "test.userMapper.getUser";//映射sql的标识字符串

        insertStudent(session);
//
//        User user = new User();
//        user.setId(6667);
//        user.setName("peng2");
//        user.setAge(3334);
//
//        IUser userOp = session.getMapper(IUser.class);
//
////        updateUser(userOp, session);
//
//        deleteUser(userOp, session);
//        getUsers(userOp, session);

//        userOp.addUser(user);
//        session.commit();
//        User user = userOp.selectUserById(245);
//        List<User> userList = userOp.selectUsers("hello");
//        //执行查询返回一个唯一user对象的sql
////        User user = session.selectOne(statement, 1);
//        System.out.println(userList);
//        session.clearCache();
        session.close();
    }

    private static void insertStudent(SqlSession session) {
        StudentInfoEntity student = new StudentInfoEntity();
        String name = new String("小明");
        student.setsName(name);
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        student.setsId(uuid);
        student.setsHeadUrl("http://www.baidu.com");
        student.setsSchool("广东外语外贸大学");
        IStudentInfo stuOp = session.getMapper(IStudentInfo.class);
        stuOp.addStudent(student);
        session.commit();
    }

    public static void updateUser(IUser userOp, SqlSession session){
        User selectUser = userOp.selectUserById(6667);
        selectUser.setName("ppp2");
        userOp.updateUser(selectUser);
        session.commit();
    }

    public static void getUser(IUser userOp, SqlSession session){
        User user = userOp.selectUserById(245);
        System.out.println(user);
    }

    public static void getUsers(IUser userOp, SqlSession session){
        List<User> userList = userOp.selectUsers("hello");
        System.out.println(userList);
    }

    public static void deleteUser(IUser userOp, SqlSession session){
        userOp.deleteUser(6667); // 如果数据库不存在这个id的数据，那就什么都不做，不会抛出异常
        session.commit();
    }

    public static void addUser(IUser userOp, SqlSession session){
        User user = new User();
        user.setId(6667);
        user.setName("peng2");
        user.setAge(3334);
        userOp.addUser(user);
        session.commit();
    }

    public static void testJDBC(){
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/peng_test";
        // MySQL配置时的用户名
        String user = "root";
        // Java连接MySQL配置时的密码
        String password = "zph123";

        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from test1";
            //结果集
            ResultSet rs = statement.executeQuery(sql);
            String name = null;
            while(rs.next()) {
                //选择sname这列数据
                name = rs.getString("test_id");
                // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
                // 然后使用GB2312字符集解码指定的字节数组
                name = new String(name.getBytes("UTF8"),"GB2312");
                // 输出结果
//                System.out.println(rs.getString("sno") + "\t" + name);
                System.out.println(rs.getString("test_id") + "\t" + name);
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
