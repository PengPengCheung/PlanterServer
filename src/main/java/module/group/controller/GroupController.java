package module.group.controller;

import common.Resource;
import model.DataResponse;
import module.group.model.mob.GroupMobOpenRequestModel;
import module.group.model.web.GroupInfoViewModel;
import module.group.model.web.GroupResponseModel;
import module.group.model.web.GroupTaskInfoRequestViewModel;
import module.group.service.web.GroupWebService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.CommonUtil;
import utils.DBUtil;
import utils.DataUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/4/8.
 */
@Controller
public class GroupController {

    private static final String TAG = GroupController.class.getSimpleName();

    private int status = Resource.GROUP.GROUP_STATUS_OPEN;


    @RequestMapping(value = "/mob/group/studentOpenGroup", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, String>> receiveStudentOpenGroupRequest(@RequestBody GroupMobOpenRequestModel model){

        CommonUtil.printLog("GroupController receiveStudentOpenGroupRequest: 1 ");
        CommonUtil.printLog("GroupController receiveStudentOpenGroupRequest: " + model.getGroupName());

        GroupWebService service = new GroupWebService();
        return service.studentOpenGroup(model);


//        return "{\"group\":\"test\"}";
    }


    // {"t_id":"null","c_id":"course789"}  web端进入分组模块时发出的请求
    // 每次请求时都把小组任务全部取出
    @RequestMapping(value = "/web/group/enterGroupModule", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<GroupResponseModel> enterGroupModules(@RequestBody Map<String, String> params){

        GroupWebService service = new GroupWebService();
        return service.getWebResponseGroupList(params);

//        DataResponse<GroupResponseModel> response = new DataResponse<GroupResponseModel>(200, "no reason");
//        GroupResponseModel model = new GroupResponseModel();
//        model.setIsOpen(status);
//
//        List<String> memberList = getMemberList();
//
//        List<GroupInfoViewModel> modelList = new LinkedList<GroupInfoViewModel>();
//        for(int i=0;i<10;i++){
//            GroupInfoViewModel viewModel = new GroupInfoViewModel();
//            viewModel.setmModuleId(Resource.Module.MODULE_COURSE_GROUP);
//            viewModel.setGroupId(DBUtil.generateUUID());
//            viewModel.setGroupName("晓娜对不队 " + (i+1));
//            viewModel.setGroupLeaderName("韩晓娜 " + (i+1));
//            viewModel.setGroupMemberList(memberList);
//            viewModel.setTaskContent("暂无任务"); // 如果老师还没发布任务的话就传入"暂无任务"
//            viewModel.setStudentScore(-1);
//            viewModel.setTeacherScore(80);
//
//            modelList.add(viewModel);
//        }
//
//        model.setGroupInfoList(modelList);
//        response.setData(model);
//
//        return response;
    }



//    // {"t_id":"null","c_id":"course789"}  web端进入分组模块时发出的请求
//    // 每次请求时都把小组任务全部取出
//    @RequestMapping(value = "/web/group/enterGroupModule2", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<GroupResponseModel> enterGroupModules(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + " enterGroupModules", request);
//
//        DataResponse<GroupResponseModel> response = new DataResponse<GroupResponseModel>(200, "no reason");
//        GroupResponseModel model = new GroupResponseModel();
//        model.setIsOpen(status);
//
//        List<String> memberList = getMemberList();
//
//        List<GroupInfoViewModel> modelList = new LinkedList<GroupInfoViewModel>();
//        for(int i=0;i<10;i++){
//            GroupInfoViewModel viewModel = new GroupInfoViewModel();
//            viewModel.setmModuleId(Resource.Module.MODULE_COURSE_GROUP);
//            viewModel.setGroupId(DBUtil.generateUUID());
//            viewModel.setGroupName("晓娜对不队 " + (i+1));
//            viewModel.setGroupLeaderName("韩晓娜 " + (i+1));
//            viewModel.setGroupMemberList(memberList);
//            viewModel.setTaskContent("暂无任务"); // 如果老师还没发布任务的话就传入"暂无任务"
//            viewModel.setStudentScore(-1);
//            viewModel.setTeacherScore(80);
//
//            modelList.add(viewModel);
//        }
//
//        model.setGroupInfoList(modelList);
//        response.setData(model);
//
//        return response;
//    }


    // {"t_id":"1234","c_id":"course789","group_id":"74078b52-504f-4bb4-8c9d-2ea906a95661","group_task_content":"吞吞吐吐拖拖拖拖拖","group_publish_date":"2017-04-08 17:13:09","group_task_ddl":"2017-04-18 17:12:53"}
    // 教师发布任务时调用，调用完毕后，会回调请求所有任务的接口，重新获取一次小组任务详情
    @RequestMapping(value = "/web/group/publishTask", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> publishGroupTask(@RequestBody GroupTaskInfoRequestViewModel model){
        CommonUtil.printLog("GroupController publishGroupTask : " + model.getGroupId());
        GroupWebService service = new GroupWebService();
        return service.publishTask(model);

    }


//    // {"t_id":"1234","c_id":"course789","group_id":"74078b52-504f-4bb4-8c9d-2ea906a95661","group_task_content":"吞吞吐吐拖拖拖拖拖","group_publish_date":"2017-04-08 17:13:09","group_task_ddl":"2017-04-18 17:12:53"}
//    // 教师发布任务时调用，调用完毕后，会回调请求所有任务的接口，重新获取一次小组任务详情
//    @RequestMapping(value = "/web/group/publishTask", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<Map<String, Integer>> publishGroupTask(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + " publishGroupTask", request);
//
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"no reason");
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(Resource.KEY.KEY_GROUP_TASK_ADD_STATUS, Resource.GROUP.GROUP_TASK_ADD_SUCCESS);
//        response.setData(params);
//
//        return response;
//
//    }

    // 用于教师开通分组
    // {"t_id":"1234","c_id":"course789","group_member_min":5,"group_member_max":10}
    @RequestMapping(value = "/web/group/openGroup", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> openGroup(@RequestBody Map<String, String> params){
        GroupWebService service = new GroupWebService();
        return service.openGroup(params);

//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(Resource.KEY.KEY_GROUP_OPEN, Resource.GROUP.GROUP_STATUS_OPEN);
//
//        response.setData(params);
//        status = Resource.GROUP.GROUP_STATUS_OPEN;
//        return response;

    }

//    // 用于教师开通分组
//    // {"t_id":"1234","c_id":"course789","group_member_min":5,"group_member_max":10}
//    @RequestMapping(value = "/web/group/openGroup", method = RequestMethod.POST)
//    @ResponseBody
//    public DataResponse<Map<String, Integer>> openGroup(HttpServletRequest request){
//        DataUtils.printRequestBodyStr(TAG + " openGroup", request);
//
//        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
//        Map<String, Integer> params = new HashMap<String, Integer>();
//        params.put(Resource.KEY.KEY_GROUP_OPEN, Resource.GROUP.GROUP_STATUS_OPEN);
//
//        response.setData(params);
//        status = Resource.GROUP.GROUP_STATUS_OPEN;
//        return response;
//
//    }

    //{"t_id":"1234","c_id":"course789","group_id":"ba24edf9-8847-4ee8-a951-7b30ce3959d3","group_teacher_score":90}
    // 教师对某组打分
    @RequestMapping(value = "/web/group/teacherScore", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse<Map<String, Integer>> teacherScore(HttpServletRequest request){
        DataUtils.printRequestBodyStr(TAG + " teacherScore", request);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "no reason");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_GROUP_TEACHER_SCORE_STATUS, Resource.GROUP.GROUP_SCORE_TEACHER_STATUS_SUCCESS);
        response.setData(map);

        return response;
    }



    private List<String> getMemberList() {
        List<String> memberList = new LinkedList<String>();

        for(int i=0;i<10;i++){
            memberList.add("朋朋" + i);
        }

        return memberList;
    }

}
