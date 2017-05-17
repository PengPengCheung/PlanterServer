package dao;

import entity.AttentionInfoEntity;
import entity.StudentPerformanceAttentionTableEntity;
import entity.TeacherCourseAttentionTableEntity;

import java.util.List;

/**
 * Created by peng on 2017/3/27.
 */
public interface IAttentionOP {

    void insertAttentionRecord(AttentionInfoEntity entity);

    void insertTeacherAttentionPublishInfo(TeacherCourseAttentionTableEntity entity);

    void insertStudentCourseAttentionConnection(StudentPerformanceAttentionTableEntity entity);

    List<TeacherCourseAttentionTableEntity> selectTeacherAttentionListByOpenClassId(String openClassId);

    void updateTeacherAttentionEntity(TeacherCourseAttentionTableEntity entity);

}
