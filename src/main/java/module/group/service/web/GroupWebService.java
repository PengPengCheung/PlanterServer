package module.group.service.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import common.Resource;
import dao.logic.GroupDAO;
import dao.logic.StudentInfoDAO;
import entity.*;
import model.DataResponse;
import module.attendance.model.AttendanceViewModel;
import module.attendance.model.web.AttendanceWebRequestViewModel;
import module.group.model.mob.GroupMobOpenRequestModel;
import module.group.model.mob.GroupPushViewModel;
import module.group.model.web.GroupInfoViewModel;
import module.group.model.web.GroupOpenRequestViewModel;
import module.group.model.web.GroupResponseModel;
import module.group.model.web.GroupTaskInfoRequestViewModel;
import org.w3c.dom.ls.LSException;
import utils.CommonUtil;
import utils.DBUtil;
import utils.PushUtil;
import utils.TimeUtil;

import java.util.*;

/**
 * Created by peng on 2017/4/21.
 */
public class GroupWebService {





    // {"t_id":"1234","c_id":"course789","group_id":"74078b52-504f-4bb4-8c9d-2ea906a95661","group_task_content":"吞吞吐吐拖拖拖拖拖","group_publish_date":"2017-04-08 17:13:09","group_task_ddl":"2017-04-18 17:12:53"}
    // 教师发布任务时调用，调用完毕后，会回调请求所有任务的接口，重新获取一次小组任务详情
    public DataResponse<Map<String, Integer>> publishTask(GroupTaskInfoRequestViewModel model){
        GroupDAO groupDAO = new GroupDAO();
        groupDAO.publishGroupTask(model);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200,"success");
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put(Resource.KEY.KEY_GROUP_TASK_ADD_STATUS, Resource.GROUP.GROUP_TASK_ADD_SUCCESS);
        response.setData(params);

        return response;
    }




    // {"t_id":"null","c_id":"course789"}  web端进入分组模块时发出的请求
    // 每次请求时都把小组任务全部取出
    public DataResponse<GroupResponseModel> getWebResponseGroupList(Map<String, String> params){
        String courseId = null;
        String teacherId = null;

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            courseId = params.get(Resource.KEY.KEY_COURSE_ID);
        }

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            teacherId = params.get(Resource.KEY.KEY_TEACHER_ID);
        }

        GroupResponseModel responseModel = new GroupResponseModel();
//        responseModel.setIsOpen(Resource.GROUP.GROUP_STATUS_OPEN);
        List<GroupInfoViewModel> modelList = new LinkedList<GroupInfoViewModel>();

        GroupDAO groupDAO = new GroupDAO();
        List<TeacherCourseGroupTableEntity> entityList = groupDAO.getTeacherCourseGroupList(courseId);
        CommonUtil.printLog("GroupWebService getWebResponseGroupList size: " + entityList.size());
        for(TeacherCourseGroupTableEntity entity : entityList){
            CommonUtil.printLog("GroupWebService getWebResponseGroupList opening: " + entity.getGroupOpening());
            responseModel.setIsOpen(entity.getGroupOpening());
            String teacherCourseId = entity.getTeacherCourseGroupId();
            CommonUtil.printLog("GroupWebService 1 teacherCourseId : " + teacherCourseId);
            List<GroupTaskConnectionEntity> entities = groupDAO.getGroupTaskInfoList(teacherCourseId);
            CommonUtil.printLog("GroupWebService 2 size : " + entities.size());
            for(GroupTaskConnectionEntity groupTaskConnection: entities){
                String groupId = groupTaskConnection.getGroupId();
                CommonUtil.printLog("GroupWebService 3 groupId : " + groupId);
                GroupInfoEntity groupInfoEntity = groupDAO.getGroupInfoEntityByGroupId(groupId);
                CommonUtil.printLog("GroupWebService 4 groupMembers : " + groupInfoEntity.getGroupMembers());
                GroupInfoViewModel groupInfoViewModel = constructGroupInfoViewModel(groupInfoEntity, groupTaskConnection, groupDAO);
                CommonUtil.printLog("GroupWebService 5 : ");
                modelList.add(groupInfoViewModel);
            }
        }

        CommonUtil.printLog("GroupWebService 6 list size : " + modelList.size());
        responseModel.setGroupInfoList(modelList);

        DataResponse<GroupResponseModel> response = new DataResponse<GroupResponseModel>(200,"success");
        response.setData(responseModel);

        return response;

    }

    private List<String> getMemberList(String groupMembers){
        String[] members = groupMembers.split(",");
        List<String> memberList = new LinkedList<String>();
        for(int i=0;i<members.length;i++){
            memberList.add(members[i]);
        }

        return memberList;
    }

    private GroupInfoViewModel constructGroupInfoViewModel(GroupInfoEntity entity, GroupTaskConnectionEntity groupTaskConnectionEntity, GroupDAO groupDAO){
        GroupInfoViewModel viewModel = new GroupInfoViewModel();
        viewModel.setmModuleId(Resource.Module.MODULE_COURSE_GROUP);
        viewModel.setGroupId(entity.getGroupId());
        viewModel.setGroupName(entity.getGroupName());
        viewModel.setGroupLeaderName(entity.getGroupLeaderName());
        List<String> memberList = getMemberList(entity.getGroupMembers());
        viewModel.setGroupMemberList(memberList);
        if(groupTaskConnectionEntity != null && groupTaskConnectionEntity.getGroupTaskId() != null){
            String groupTaskId = groupTaskConnectionEntity.getGroupTaskId();
            GroupTaskEntity taskEntity = groupDAO.getGroupTaskEntityByGroupTaskId(groupTaskId);
            viewModel.setTaskContent(taskEntity.getGroupTaskContent());
        } else {
            viewModel.setTaskContent("暂无任务"); // 如果老师还没发布任务的话就传入"暂无任务"
        }

        viewModel.setStudentScore(-1);
        viewModel.setTeacherScore(-1);

        return viewModel;
    }

//    private void test(){
//        GroupResponseModel model = new GroupResponseModel();
//        model.setIsOpen(Resource.GROUP.GROUP_STATUS_OPEN);
//
//        List<String> memberList = getMemberList();
//
//        List<GroupInfoViewModel> modelList = new LinkedList<GroupInfoViewModel>();
//        for(int i=0;i<10;i++){
//
//
//            modelList.add(viewModel);
//        }
//
//        model.setGroupInfoList(modelList);
//    }

    public DataResponse<Map<String, String>> studentOpenGroup(GroupMobOpenRequestModel model){
        int num = 0;
        String leaderName = model.getLeaderName();
        List<String> memberList = model.getMemberList();
        StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
        GroupDAO groupDAO = new GroupDAO();
        String studentId = studentInfoDAO.getStudentIdByStudentName(leaderName);
        if(studentId != null){
            if(memberList != null && memberList.size() > 0){
                for (String memberName : memberList){
                    String memberId = studentInfoDAO.getStudentIdByStudentName(memberName);
                    if(memberId != null){
                        pushToStudent(memberId); // 推送给其他组员，表示已经分好组
                        num++;
                    } else {
                        return constructNotExistResponse();
                    }
                }

                CommonUtil.printLog("GroupWebService num: " + num + ", memberList.size = " + memberList.size());

                if(num == memberList.size()){
                    CommonUtil.printLog("GroupWebService num == memberList.size");
                    groupDAO.openGroupByStudent(model);
                    pushToStudent(studentId);
                }
            }
        } else {
            return constructNotExistResponse();
        }

        return constructSuccessResponse();
    }

    private DataResponse<Map<String, String>> constructSuccessResponse() {
        DataResponse<Map<String, String>> response = new DataResponse<Map<String, String>>(200,"success");
        Map<String, String> params = new HashMap<String, String>();
        params.put("open_group_status", "group_open_success");
        response.setData(params);
        return response;
    }

    private DataResponse<Map<String, String>> constructNotExistResponse() {
        DataResponse<Map<String, String>> response = new DataResponse<Map<String, String>>(200,"success");
        Map<String, String> params = new HashMap<String, String>();
        params.put("open_group_status", "someone not exist.");
        response.setData(params);
        return response;
    }

    private void pushToStudent(String studentId){
        CommonUtil.printLog("studentId: " + studentId);
    }



    // {"t_id":"1234","c_id":"course789","group_member_min":5,"group_member_max":10}
    public DataResponse<Map<String, Integer>> openGroup(Map<String, String> params){
        GroupOpenRequestViewModel model = constructGroupOpenRequestModel(params);
        GroupDAO groupDAO = new GroupDAO();
        TeacherCourseGroupTableEntity entity = groupDAO.openGroupByTeacher(model);

        GroupPushViewModel pushViewModel = constructGroupPushViewModel(entity);
        pushOpenGroupNotificationToStudents(pushViewModel);

        DataResponse<Map<String, Integer>> response = new DataResponse<Map<String, Integer>>(200, "success");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Resource.KEY.KEY_GROUP_OPEN, entity.getGroupOpening());

        response.setData(map);
        return response;

    }

    private void pushOpenGroupNotificationToStudents(GroupPushViewModel pushViewModel) {
        pushToStudentUsers(pushViewModel);
    }

    private void pushToStudentUsers(GroupPushViewModel pushViewModel){

        String pushJsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            pushJsonStr = mapper.writeValueAsString(pushViewModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        CommonUtil.printLog("pushJsonStr: " + pushJsonStr);
        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.GROUP_CHECK_NOTIFICATION);
    }

    private GroupPushViewModel constructGroupPushViewModel(TeacherCourseGroupTableEntity entity) {
        GroupPushViewModel pushViewModel = new GroupPushViewModel();
        pushViewModel.setmModuleId(Resource.Module.MODULE_COURSE_GROUP);
        pushViewModel.setmPushType(Resource.GROUP.GROUP_TYPE_OPEN_GROUP_NOTIFICATION);
        pushViewModel.setmCourseId(entity.getcId());
        String dateStr = entity.getGroupOpenTime();
        if(dateStr == null){
            Date date = new Date();
            dateStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS);
        }
        pushViewModel.setmGroupOpenTime(dateStr);
        pushViewModel.setmGroupLimit(entity.getGroupMemberLimit());
        pushViewModel.setmTeacherGroupOpenId(entity.getTeacherCourseGroupId());
        return pushViewModel;
    }

    private GroupOpenRequestViewModel constructGroupOpenRequestModel(Map<String, String> params) {
        GroupOpenRequestViewModel requestViewModel = new GroupOpenRequestViewModel();

        if(params.containsKey(Resource.KEY.KEY_TEACHER_ID)){
            requestViewModel.setmTeacherId(params.get(Resource.KEY.KEY_TEACHER_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_COURSE_ID)){
            requestViewModel.setmCourseId(params.get(Resource.KEY.KEY_COURSE_ID));
        }

        if(params.containsKey(Resource.KEY.KEY_GROUP_MIN)){
            String minStr = params.get(Resource.KEY.KEY_GROUP_MIN);
            int min = Integer.parseInt(minStr);
            requestViewModel.setMin(min);
        }

        if(params.containsKey(Resource.KEY.KEY_GROUP_MAX)){
            String maxStr = params.get(Resource.KEY.KEY_GROUP_MAX);
            int max = Integer.parseInt(maxStr);
            requestViewModel.setMax(max);
        }

        if(params.containsKey(Resource.KEY.KEY_GROUP_OPEN_TIME)){
           String openTime =  params.get(Resource.KEY.KEY_GROUP_OPEN_TIME);
           requestViewModel.setGroupOpenTime(openTime);
        }

        return requestViewModel;

    }


}
