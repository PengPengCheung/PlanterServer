package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IGroupOP;
import entity.GroupInfoEntity;
import entity.GroupTaskConnectionEntity;
import entity.GroupTaskEntity;
import entity.TeacherCourseGroupTableEntity;
import module.group.model.mob.GroupMobOpenRequestModel;
import module.group.model.web.GroupOpenRequestViewModel;
import module.group.model.web.GroupTaskInfoRequestViewModel;
import org.apache.ibatis.session.SqlSession;
import utils.CommonUtil;
import utils.DBUtil;

import java.util.List;

/**
 * Created by peng on 2017/4/21.
 */
public class GroupDAO extends BaseDAO{


    public GroupDAO(){
        super();
    }


    public GroupTaskEntity getGroupTaskEntityByGroupTaskId(String taskId){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        GroupTaskEntity entity = groupOP.selectGroupTaskEntityByGroupTaskId(taskId);
        return entity;
    }

    public void publishGroupTask(GroupTaskInfoRequestViewModel viewModel){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        GroupTaskEntity entity = constructGroupTaskEntity(viewModel);
        groupOP.insertGroupTaskInfoEntity(entity);

        GroupTaskConnectionEntity groupTaskConnectionEntity = groupOP.getGroupTaskConnectionEntityByGroupId(viewModel.getGroupId());
        groupTaskConnectionEntity.setGroupTaskId(entity.getGroupTaskId());
        groupOP.updateGroupTaskConnection(groupTaskConnectionEntity);

        session.commit();
    }

    private GroupTaskEntity constructGroupTaskEntity(GroupTaskInfoRequestViewModel viewModel) {
        GroupTaskEntity entity = new GroupTaskEntity();
        entity.setGroupTaskId(DBUtil.generateUUID());
        entity.setGroupTaskContent(viewModel.getGroupTaskContent());
        entity.setGroupTaskDdl(viewModel.getGroupTaskDDL());
        entity.setGroupTaskPublishDate(viewModel.getGroupTaskPublishDate());
        return entity;
    }


    public GroupInfoEntity getGroupInfoEntityByGroupId(String groupId){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        GroupInfoEntity entity = groupOP.selectGroupInfoEntityByGroupId(groupId);
        return entity;
    }

    public List<GroupTaskConnectionEntity> getGroupTaskInfoList(String teacherCourseGroupId){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        List<GroupTaskConnectionEntity> entities = groupOP.selectGroupTaskConnectionEntityListByTeacherCourseGroupId(teacherCourseGroupId);
        return entities;
    }


    public List<TeacherCourseGroupTableEntity> getTeacherCourseGroupList(String courseId){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        List<TeacherCourseGroupTableEntity> entityList = groupOP.selectTeacherCourseGroupByCourseId(courseId);
        return entityList;
    }


    public void openGroupByStudent(GroupMobOpenRequestModel model){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        CommonUtil.printLog("GroupDAO openGroupByStudent " + model.getTeacherOpenGroupId());
        GroupInfoEntity groupInfoEntity = constructStudentGroupInfoEntity(model);
        groupOP.insertStudentGroupInfoEntity(groupInfoEntity);

        GroupTaskConnectionEntity groupTaskConnectionEntity = new GroupTaskConnectionEntity();
        groupTaskConnectionEntity.setGroupId(groupInfoEntity.getGroupId());
        groupTaskConnectionEntity.setGroupTeacherOpenId(model.getTeacherOpenGroupId());
        groupOP.insertGroupTaskConnection(groupTaskConnectionEntity);

        session.commit();
    }

    private GroupInfoEntity constructStudentGroupInfoEntity(GroupMobOpenRequestModel model) {
        GroupInfoEntity entity = new GroupInfoEntity();
        entity.setGroupDate(model.getGroupOpenTime());
        entity.setGroupId(DBUtil.generateUUID());
        entity.setGroupName(model.getGroupName());
        CommonUtil.printLog("memberList: " + model.groupMembersToString());
        entity.setGroupMembers(model.groupMembersToString());
        entity.setGroupLeaderName(model.getLeaderName());
        return entity;

    }


    public TeacherCourseGroupTableEntity openGroupByTeacher(GroupOpenRequestViewModel requestViewModel){
        SqlSession session = getSession();
        IGroupOP groupOP = session.getMapper(IGroupOP.class);
        TeacherCourseGroupTableEntity entity = constructTeacherCourseGroupEntity(requestViewModel);
        groupOP.insertTeacherCourseGroupEntity(entity);
        session.commit();

        return entity;

    }

    private TeacherCourseGroupTableEntity constructTeacherCourseGroupEntity(GroupOpenRequestViewModel viewModel){
        TeacherCourseGroupTableEntity entity = new TeacherCourseGroupTableEntity();
        entity.setcId(viewModel.getmCourseId());
        entity.settId(viewModel.getmTeacherId());
        entity.setTeacherCourseGroupId(DBUtil.generateUUID());
        entity.setGroupOpening(Resource.GROUP.GROUP_STATUS_OPEN);
        String limitStr = viewModel.getMin() + "," + viewModel.getMax();
        entity.setGroupMemberLimit(limitStr);
        entity.setGroupOpenTime(viewModel.getGroupOpenTime());
        return entity;
    }
}
