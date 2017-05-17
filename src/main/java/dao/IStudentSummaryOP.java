package dao;

import entity.StudentSummaryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by peng on 2017/3/25.
 */
public interface IStudentSummaryOP {

    void insertStudentSummary(StudentSummaryEntity entity);

    List<StudentSummaryEntity> getStudentSummaryListByOpenClassId(@Param("openClassId") String openClassId);
}
