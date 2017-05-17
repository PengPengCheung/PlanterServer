package dao;

import entity.TreeInfoEntity;

/**
 * Created by peng on 2017/3/24.
 */
public interface ITreeInfo {

    TreeInfoEntity selectTreeInfoById(String treeId);

    void insertTreeInfo(TreeInfoEntity tree);
}
