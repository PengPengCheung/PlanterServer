package dao;

import entity.RandomAskInfoEntity;
import entity.TeacherClassRandomAskTableEntity;

/**
 * Created by peng on 2017/4/20.
 */
public interface IRandomAskOP {

    void insertRandomAskInfo(RandomAskInfoEntity entity);

    void insertTeacherRandomAskInfo(TeacherClassRandomAskTableEntity entity);
}
