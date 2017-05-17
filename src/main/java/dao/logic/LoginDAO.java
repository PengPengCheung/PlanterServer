package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.ILoginOP;
import entity.StudentInfoEntity;
import entity.TeacherInfoEntity;
import module.login.model.LoginWebRequestViewModel;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by peng on 2017/3/28.
 */
public class LoginDAO extends BaseDAO{

    public LoginDAO(){
        super();
    }

    public String login(LoginWebRequestViewModel model){
        SqlSession session = getSession();

        int status = model.getStatus();


        String id =  storeByRole(status, model, session);

        return id;
    }

    private String storeByRole(int status, LoginWebRequestViewModel model, SqlSession session){
        ILoginOP loginOP = session.getMapper(ILoginOP.class);
        String validId = null;
        switch (status){
            case Resource.ROLE.ROLE_TEACHER:{
                List<TeacherInfoEntity> teacherInfoEntityList = loginOP.getTeacherList();
                validId = validTeacherInfo(teacherInfoEntityList, model);

            }
            break;
            case Resource.ROLE.ROLE_STUDENT:{
                List<StudentInfoEntity> studentInfoEntityList = loginOP.getStudentList();
                validId = validStudentInfo(studentInfoEntityList, model);
            }
            break;
        }

//        if((validId != null)){
//
//        }

        return validId;

    }

    private String validStudentInfo(List<StudentInfoEntity> list, LoginWebRequestViewModel model){
        boolean result = false;

        String id = null;

        System.out.println("validStudentInfo name: " + model.getName());

        System.out.println("list size: " + list.size());

        for(StudentInfoEntity entity:list){
            System.out.println("sNo: " + entity.getsNo());
            if(entity.getsNo() != null && entity.getsNo().equals(model.getName())){
                System.out.println("Student No: " + entity.getsNo());
                if(entity.getsPassword().equals(model.getPassword())){
                    result = true;
                    id = entity.getsId();
                }
            }
        }

        return id;
    }

    private String validTeacherInfo(List<TeacherInfoEntity> list, LoginWebRequestViewModel model){
        boolean result = false;
        String id = null;

        for(TeacherInfoEntity entity:list){
            if(entity.gettName().equals(model.getName())){
                if(entity.gettPassword().equals(model.getPassword())){
                    result = true;
                    id = entity.gettId();
                }
            }
        }

        return id;
    }



}
