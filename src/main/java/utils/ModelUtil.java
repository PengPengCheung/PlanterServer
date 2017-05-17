package utils;

import entity.BaseConnectionEntity;

/**
 * Created by peng on 2017/4/19.
 */
public class ModelUtil {

    public static BaseConnectionEntity constructConnectionEntity(String teacherId, String courseId, String studentId){
        BaseConnectionEntity entity = new BaseConnectionEntity();
        entity.setsId(studentId);
        entity.setcId(courseId);
        entity.settId(teacherId);
        entity.setBaseConnectionId(DBUtil.generateUUID());
        return entity;
    }
}
