package module.randomask.service;

import com.sun.org.apache.regexp.internal.RE;
import common.Resource;
import dao.logic.BaseConnectionDAO;
import dao.logic.RandomAskDAO;
import dao.logic.StudentInfoDAO;
import entity.BaseConnectionEntity;
import entity.RandomAskInfoEntity;
import entity.StudentInfoEntity;
import model.DataResponse;
import module.randomask.model.web.StudentInfoModel;
import utils.CommonUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/4/20.
 */
public class AskService {

    // {"c_id":"course789","t_id":"1234","s_id":"b77a96a7-1fa8-4211-81b0-2a2471724e33", "open_class_id":""}
    public DataResponse<Map<String, Integer>> giveBonus(Map<String, String> params){
        String openClassId = null;
        String studentId = null;

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            openClassId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_STUDENT_ID)){
            studentId = params.get(Resource.KEY.KEY_STUDENT_ID);
        }

        RandomAskDAO randomAskDAO = new RandomAskDAO();
        randomAskDAO.insertBonusInfo(openClassId, studentId);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"success");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_RANDOM_ASK_GIVE_BONUS_STATUS, Resource.RANDOM_ASK.RANDOM_ASK_GIVE_BONUS_SUCCESS);
        response.setData(map);

        return response;

    }



    // {"c_id":"course789","t_id":"1234", "open_class_id":""}
    public DataResponse<List<StudentInfoModel>> getStudentInfoList(Map<String, String> params){
        String courseId = null;
        String teacherId = null;
        String openClassId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            openClassId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);
        }

        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        BaseConnectionDAO dao = new BaseConnectionDAO();
        List<BaseConnectionEntity> entityList = dao.getBaseConnectionListByCourseId(courseId);
        List<StudentInfoModel> modelList = new LinkedList<StudentInfoModel>();
        for(BaseConnectionEntity entity: entityList){
            String studentId = entity.getsId();
            if(studentId != null){
                StudentInfoEntity studentInfoEntity = studentInfoDAO.getStudentInfoByStudentId(studentId);
                StudentInfoModel model = constructStudentInfoModelByStudentInfoEntity(studentInfoEntity);
                modelList.add(model);
            }

        }

        return constructSuccessResponse(modelList);

    }

    private DataResponse<StudentInfoModel> constructSuccessResponse(StudentInfoModel model){
        DataResponse<StudentInfoModel> response = new DataResponse<StudentInfoModel>(200, "success");
        response.setData(model);
        return response;
    }

    private DataResponse<StudentInfoModel> constructFailResponse(StudentInfoModel model){
        DataResponse<StudentInfoModel> response = new DataResponse<StudentInfoModel>(200, "fail");
        response.setData(model);
        return response;
    }

    private DataResponse<List<StudentInfoModel>> constructSuccessResponse(List<StudentInfoModel> list){
        DataResponse<List<StudentInfoModel>> response = new DataResponse<List<StudentInfoModel>>(200, "success");
        response.setData(list);
        return response;
    }

    private StudentInfoModel constructStudentInfoModelByStudentInfoEntity(StudentInfoEntity studentInfoEntity) {
        if(studentInfoEntity == null){
            return new StudentInfoModel();
        }
        StudentInfoModel model = new StudentInfoModel();
        model.setStudentId(studentInfoEntity.getsId());
        model.setStudentName(studentInfoEntity.getsName());
        return model;
    }

    // {"c_id":"course789","t_id":"1234","random_ask_time":"2017-04-09 15:11:07", "open_class_id":""}
    public DataResponse<StudentInfoModel> getRandomAskStudentInfoModel(Map<String, String> params){
        String randomAskTime = null;
        String openClassId = null;
        String courseId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_RANDOM_ASK_CURRENT_TIME)){
            randomAskTime = params.get(Resource.KEY.KEY_RANDOM_ASK_CURRENT_TIME);
        }

        if(params.containsKey(Resource.KEY.KEY_CLASS_OPEN_ID)){
            openClassId = params.get(Resource.KEY.KEY_CLASS_OPEN_ID);
        }

        // 记录随机提问的相关信息
        RandomAskDAO dao = new RandomAskDAO();
        RandomAskInfoEntity entity = dao.insertRandomAskInfo(randomAskTime);
        dao.insertTeacherRandomAskInfo(openClassId, entity.getRandomAskId());

        //
        BaseConnectionDAO baseConnectionDAO = new BaseConnectionDAO();
        List<BaseConnectionEntity> connectionEntityList = baseConnectionDAO.getBaseConnectionListByCourseId(courseId);
        int size = connectionEntityList.size();
        CommonUtil.printLog("AskService getRandomAskStudentInfoModel list size = " + size);
        int choosePos = CommonUtil.getRandomInt(size);
        CommonUtil.printLog("choosePos: " + choosePos);
        if(choosePos < size){
            StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
            StudentInfoEntity studentInfoEntity = studentInfoDAO.getStudentInfoByStudentId(connectionEntityList.get(choosePos).getsId());
            StudentInfoModel model = constructStudentInfoModelByStudentInfoEntity(studentInfoEntity);
            return constructSuccessResponse(model);
        }


        return constructFailResponse(new StudentInfoModel());
    }
}
