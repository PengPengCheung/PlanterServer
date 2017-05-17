package module.randomask.controller;

import common.Resource;
import model.DataResponse;
import module.randomask.model.web.StudentInfoModel;
import module.randomask.service.AskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DBUtil;
import utils.DataUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by peng on 2017/4/9.
 */
@Controller
public class RandomAskController {

    private static final String TAG = RandomAskController.class.getSimpleName();

    private static int total = 10;

    List<String> studentIdList;

    public RandomAskController(){
        initIdList();
    }


    // {"c_id":"course789","t_id":"1234", "open_class_id":""}
    // 进入随机提问模块时调用, 返回学生id和学生姓名
    @RequestMapping(value = "/web/randomAsk/enterAskModule", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<StudentInfoModel>> getStudentInfoListWhenEnterAskModule(@RequestBody Map<String, String> params){

        AskService service = new AskService();
        return service.getStudentInfoList(params);


//        DataResponse<List<StudentInfoModel>> response = new DataResponse<List<StudentInfoModel>>(200, "no reason");
//        List<StudentInfoModel> studentInfoModelList = new LinkedList<StudentInfoModel>();
//
////        int total = 10;
//
//        for(int i=0;i<total;i++){
//            StudentInfoModel model = new StudentInfoModel();
//            model.setStudentId(studentIdList.get(i));
//            model.setStudentName("小娜 " + i);
//            studentInfoModelList.add(model);
//        }
//
//        response.setData(studentInfoModelList);
//
//        return response;
    }

    // {"c_id":"course789","t_id":"1234", "open_class_id":""}
    // 进入随机提问模块时调用
    @RequestMapping(value = "/web/randomAsk/enterAskModule2", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<List<StudentInfoModel>> getStudentInfoListWhenEnterAskModule(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + ", getStudentInfoList", request);

        DataResponse<List<StudentInfoModel>> response = new DataResponse<List<StudentInfoModel>>(200, "no reason");
        List<StudentInfoModel> studentInfoModelList = new LinkedList<StudentInfoModel>();

//        int total = 10;

        for(int i=0;i<total;i++){
            StudentInfoModel model = new StudentInfoModel();
            model.setStudentId(studentIdList.get(i));
            model.setStudentName("小娜 " + i);
            studentInfoModelList.add(model);
        }

        response.setData(studentInfoModelList);

        return response;
    }

    private void initIdList(){
        if(studentIdList == null){
            studentIdList = new LinkedList<String>();
        }

        if(studentIdList.size() == total){
            return;
        }

        for(int i=0;i<total;i++){
            studentIdList.add(DBUtil.generateUUID());
        }

    }



    //网页端教师发放惊喜
    // {"c_id":"course789","t_id":"1234","s_id":"b77a96a7-1fa8-4211-81b0-2a2471724e33"}
    @RequestMapping(value = "/web/randomAsk/giveBonus", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> giveBonus(@RequestBody Map<String, String> params){

        AskService service = new AskService();
        return service.giveBonus(params);

//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"no reason");
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(Resource.KEY.KEY_RANDOM_ASK_GIVE_BONUS_STATUS, Resource.RANDOM_ASK.RANDOM_ASK_GIVE_BONUS_SUCCESS);
//        response.setData(params);
//
//        return response;
    }


    //网页端教师发放惊喜
    // {"c_id":"course789","t_id":"1234","s_id":"b77a96a7-1fa8-4211-81b0-2a2471724e33"}
    @RequestMapping(value = "/web/randomAsk/giveBonus2", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> giveBonus(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + ", giveBonus", request);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"no reason");
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put(Resource.KEY.KEY_RANDOM_ASK_GIVE_BONUS_STATUS, Resource.RANDOM_ASK.RANDOM_ASK_GIVE_BONUS_SUCCESS);
        response.setData(params);

        return response;
    }


    // {"c_id":"course789","t_id":"1234","random_ask_time":"2017-04-09 15:11:07"}
    // 教师进行随机提问
    @RequestMapping(value = "/web/randomAsk/randomAskBegin", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<StudentInfoModel> randomAsk(@RequestBody Map<String, String> params){
        AskService service = new AskService();
        return service.getRandomAskStudentInfoModel(params);

//        DataResponse<StudentInfoModel> response = new DataResponse<StudentInfoModel>(200, "no reason");
//        StudentInfoModel model = new StudentInfoModel();
//        int randomNum = (int)(Math.random() * total);
//        model.setStudentId(studentIdList.get(randomNum));
//        model.setStudentName("小娜 " + randomNum);
//
//        response.setData(model);
//
//        return response;
    }

    // {"c_id":"course789","t_id":"1234","random_ask_time":"2017-04-09 15:11:07"}
    // 教师进行随机提问
    @RequestMapping(value = "/web/randomAsk/randomAskBegin2", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<StudentInfoModel> randomAsk(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + ", randomAsk", request);

        DataResponse<StudentInfoModel> response = new DataResponse<StudentInfoModel>(200, "no reason");
        StudentInfoModel model = new StudentInfoModel();
        int randomNum = (int)(Math.random() * total);
        model.setStudentId(studentIdList.get(randomNum));
        model.setStudentName("小娜 " + randomNum);

        response.setData(model);

        return response;
    }

}
