package dao.logic;

import common.Resource;
import dao.BaseDAO;
import dao.IAttendanceInfo;
import dao.IAttentionOP;
import dao.IBaseConnection;
import entity.AttendanceInfoEntity;
import entity.BaseConnectionEntity;
import entity.StudentPerformanceAttendanceTableEntity;
import entity.TeacherCourseAttendanceTableEntity;
import module.attendance.model.AttendanceInfo;
import module.attendance.model.AttendanceViewModel;
import module.attendance.model.web.AttendanceWebRequestViewModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.test.context.jdbc.Sql;
import utils.CommonUtil;
import utils.DBUtil;
import utils.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by peng on 2017/3/23.
 */
public class AttendanceDAO extends BaseDAO {


    public AttendanceDAO(){
        super();
    }

    public void attendanceCodeRecieved(){
        SqlSession session = getSession();

    }

    public int getAttendanceCountByOpenClassId(String openClassId){
        SqlSession session = getSession();
        IAttendanceInfo attendanceInfo = session.getMapper(IAttendanceInfo.class);
        List<TeacherCourseAttendanceTableEntity> attendanceTableEntities = attendanceInfo.getTeacherAttendanceInfoByOpenClassId(openClassId);
        int maxCount = 0;
        for(TeacherCourseAttendanceTableEntity entity: attendanceTableEntities){
            if(entity.getAttendanceCount() != null){
                int count =  entity.getAttendanceCount();
                if(count > maxCount){
                    maxCount = count;
                }
            }
        }

        return maxCount;
    }

//    public String getAttdanceSuccessStudentNameByStudentId(String studentId, ){}

    // 学生进行考勤后，增加学生-考勤联系表记录
    public void insertStudentAttendanceConnectionRecord(String openClassId, AttendanceInfoEntity attendanceInfoEntity){
        StudentPerformanceAttendanceTableEntity entity = new StudentPerformanceAttendanceTableEntity();
        entity.setAttendanceId(attendanceInfoEntity.getAttendanceInfoId());
        entity.setOpenClassId(openClassId);
        entity.setStudentPerformanceAttendanceId(DBUtil.generateUUID());

        SqlSession session = getSession();
        IAttendanceInfo info = session.getMapper(IAttendanceInfo.class);
        info.insertStudentAttendanceConnection(entity);
        session.commit();
    }

    public void updateTeacherCourseAttendanceEntity(TeacherCourseAttendanceTableEntity entity){
        SqlSession session = getSession();
        IAttendanceInfo attendanceInfo = session.getMapper(IAttendanceInfo.class);
        attendanceInfo.updateTeacherAttendanceInfo(entity);
        session.commit();
    }

    public AttendanceInfoEntity insertAttendanceInfo(String attendanceCode, int status, String attendanceTime){
        SqlSession session = getSession();
        IAttendanceInfo attendanceInfo = session.getMapper(IAttendanceInfo.class);
        AttendanceInfoEntity entity = constructAttendanceInfo(status, attendanceCode, attendanceTime);
        attendanceInfo.addAttendanceInfo(entity);
        session.commit();
        return entity;
    }

    public TeacherCourseAttendanceTableEntity getTeacherCourseAttendanceInfoByAttendanceId(String attendanceId){
        SqlSession session = getSession();
        IAttendanceInfo info = session.getMapper(IAttendanceInfo.class);
        TeacherCourseAttendanceTableEntity entity = info.getTeacherAttendanceInfoByAttendanceId(attendanceId);
        return entity;
    }

    private AttendanceInfoEntity constructAttendanceInfo(int status, String attendanceCode, String attendanceTime){
        AttendanceInfoEntity info = new AttendanceInfoEntity();
        info.setAttendanceInfoId(DBUtil.generateUUID());
        info.setAttendanceStatus(status);
        if(status == Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS){
            info.setAttendanceCode(attendanceCode);
            info.setAttendanceDatetime(attendanceTime);
            info.setAttendanceBonus(Resource.ATTENDANCE.ATTENDANCE_BONUS_NUM);
            info.setAttendanceValidTime(Resource.ATTENDANCE.ATTENDANCE_DURATION);
        } else {
            info.setAttendanceDatetime(attendanceTime);
            info.setAttendanceBonus((-Resource.ATTENDANCE.ATTENDANCE_BONUS_NUM));
            info.setAttendanceValidTime(Resource.ATTENDANCE.ATTENDANCE_DURATION);
        }

        return info;

    }

    public String getAttendanceCodeByOpenClassId(String openClassId){
        SqlSession session = getSession();
        IAttendanceInfo attentionOP = session.getMapper(IAttendanceInfo.class);
        List<TeacherCourseAttendanceTableEntity> entityList = attentionOP.selectTeacherAttendanceListByOpenClassId(openClassId);
        for(TeacherCourseAttendanceTableEntity entity : entityList){
            // 因为一节课内一个时间点只能开启一次考勤，所以考勤状态为开始的时候就返回考勤码
            if(entity.getAttendanceBeginStatus() == Resource.ATTENDANCE.ATTENDANCE_STATUS_BEGIN){
                String code = entity.getAttendanceCode();
                return code;
            }
        }

        CommonUtil.printLog("AttendanceCode Not Found. ");

        return "";

    }

    public TeacherCourseAttendanceTableEntity insertTeacherSendAttendanceCodeRecord(AttendanceWebRequestViewModel viewModel){
        SqlSession session = getSession();
        IAttendanceInfo attendanceInfo = session.getMapper(IAttendanceInfo.class);
        TeacherCourseAttendanceTableEntity entity = constructTeacherCourseAttendanceEntity(viewModel);
        attendanceInfo.insertTeacherSendAttendanceRecord(entity);
        session.commit();
        return entity;
    }

    private TeacherCourseAttendanceTableEntity constructTeacherCourseAttendanceEntity(AttendanceWebRequestViewModel viewModel){
        TeacherCourseAttendanceTableEntity entity = new TeacherCourseAttendanceTableEntity();
        entity.setTeacherAttendanceId(DBUtil.generateUUID());
        String classOpenId = viewModel.getClassOpenId();
        CommonUtil.printLog("AttendanceDAO constructTeacherCourseAttendanceEntity classOpenId: " + classOpenId);
        entity.setOpenClassId(classOpenId);
        Date date = new Date();
        entity.setAttendanceBeginTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS));
        entity.setAttendanceBeginStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_BEGIN);
        entity.setAttendanceCode(viewModel.getAttendanceCode());
        entity.setAttendanceCount(0);
        entity.setAbsenceCount(0);
        return entity;
    }

    public AttendanceViewModel getAttendanceViewModelAfterCounting(AttendanceViewModel model){
        String teacherId = model.getmTeacherId();
        String courseId = model.getmCourseId();
        int attendanceCount = 0;
        int absenceCount = 0;

        SqlSession session = getSession();
        IBaseConnection baseConnection = session.getMapper(IBaseConnection.class);
        IAttendanceInfo attendanceInfo = session.getMapper(IAttendanceInfo.class);
        BaseConnectionEntity connectionEntity = baseConnection.getStudentIdFromBaseConnection(teacherId, courseId);
        if(connectionEntity != null){
            List<AttendanceInfoEntity> attendanceList = attendanceInfo.getAttendanceInfo(connectionEntity.getsId());
            for(int i=0;i<attendanceList.size();i++){
                AttendanceInfoEntity entity = attendanceList.get(i);
                int attendanceStatus = entity.getAttendanceStatus();
                if(attendanceStatus == Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS){
                    attendanceCount++;
                }
                if(attendanceStatus == Resource.ATTENDANCE.ATTENDANCE_STATUS_FAIL){
                    absenceCount++;
                }
            }

            model.setmAttendanceCount(attendanceCount);
            model.setmAbsenceCount(absenceCount);
        }
        return model;
    }


}
