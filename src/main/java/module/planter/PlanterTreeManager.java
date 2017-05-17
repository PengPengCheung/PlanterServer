package module.planter;

import common.Resource;
import dao.logic.TreeInfoDAO;
import entity.TreeInfoEntity;
import utils.CommonUtil;

/**
 * Created by peng on 2017/4/21.
 */
public class PlanterTreeManager {

    public static void newCourseTree(String studentId, String courseId){
        TreeInfoDAO treeInfoDAO = new TreeInfoDAO();
        TreeInfoEntity treeInfoEntity = treeInfoDAO.insertNewTreeInfo();
        treeInfoDAO.insertStudentTreeConnection(studentId, courseId, treeInfoEntity.getTreeId());

    }

    // 投入种植
    public static void plantTree(String studentId, String courseId, int elementNum){
        TreeInfoDAO treeInfoDAO = new TreeInfoDAO();
        TreeInfoEntity entity = treeInfoDAO.selectCourseTreeByStudentIdAndCourseId(studentId, courseId);
        addElementIntoTree(treeInfoDAO, entity, elementNum);
    }

//    // 投入种植
//    public static void plantTree(String studentId, String courseId, int elementType, int elementNum){
//        TreeInfoDAO treeInfoDAO = new TreeInfoDAO();
//        TreeInfoEntity entity = treeInfoDAO.selectCourseTreeByStudentIdAndCourseId(studentId, courseId);
//        addElementIntoTree(treeInfoDAO, entity, elementNum, elementType);
//    }

    private static void addElementIntoTree(TreeInfoDAO dao, TreeInfoEntity entity, int elementNum) {
//        switch (elementType){
//            case Resource.BONUS_TYPE.BONUS_TYPE_SUNSHINE:{
//                int hadSunshineNum = entity.getTreeSun() - elementNum;
//                int usedSunshineNum = entity.getTreeSunUsedNum();
//                int usedTotal = usedSunshineNum + elementNum;
//                entity.setTreeSunUsedNum(usedTotal);
//                entity.setTreeSun(hadSunshineNum);
//            }
//            break;
//            case Resource.BONUS_TYPE.BONUS_TYPE_WATER:{
//                int hadWaterNum = entity.getTreeWater() - elementNum;
//                int usedWaterNum = entity.getTreeWaterUsedNum();
//                int usedTotal = usedWaterNum + elementNum;
//                entity.setTreeWaterUsedNum(usedTotal);
//                entity.setTreeWater(hadWaterNum);
//            }
//            break;
//            case Resource.BONUS_TYPE.BONUS_TYPE_SOIL:{
//                int hadSoilNum = entity.getTreeSoil() - elementNum;
//                int usedSoilNum = entity.getTreeSoilUsedNum();
//                int usedTotal = usedSoilNum + elementNum;
//                entity.setTreeSoilUsedNum(usedTotal);
//                entity.setTreeSoil(hadSoilNum);
//            }
//            break;
//        }

        int hadSunshineNum = entity.getTreeSun() - elementNum;
        int usedSunshineNum = entity.getTreeSunUsedNum();
        int usedSunshineTotal = usedSunshineNum + elementNum;
        entity.setTreeSunUsedNum(usedSunshineTotal);
        entity.setTreeSun(hadSunshineNum);

        int hadWaterNum = entity.getTreeWater() - elementNum;
        int usedWaterNum = entity.getTreeWaterUsedNum();
        int usedWaterTotal = usedWaterNum + elementNum;
        entity.setTreeWaterUsedNum(usedWaterTotal);
        entity.setTreeWater(hadWaterNum);

        int hadSoilNum = entity.getTreeSoil() - elementNum;
        int usedSoilNum = entity.getTreeSoilUsedNum();
        int usedSoilTotal = usedSoilNum + elementNum;
        entity.setTreeSoilUsedNum(usedSoilTotal);
        entity.setTreeSoil(hadSoilNum);

        int soilUsedNum = entity.getTreeSoilUsedNum();
        int waterUsedNum = entity.getTreeWaterUsedNum();
        int sunshineUsedNum = entity.getTreeSunUsedNum();

        int totalUsed = soilUsedNum + waterUsedNum + sunshineUsedNum;

        int status = getTreeStatusByUsedElements(totalUsed);

        entity.setTreeStatus(status);

        dao.updateTreeInfoEntity(entity);
    }


    private static int getTreeStatusByUsedElements(int totalUsedNum) {

        int currentStatus = Resource.TREE_STATUS.TREE_SEED;

        CommonUtil.printLog("PlanterTreeManager before compute currentStatus: " + currentStatus + ", totalUsedNum: " + totalUsedNum);

        if(totalUsedNum >= Resource.TREE.SEED.SEED_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.SEEDLING.SEEDLING_TOTAL_ELEM_NUM){

            currentStatus = Resource.TREE_STATUS.TREE_SEED;

        } else if(totalUsedNum >= Resource.TREE.SEEDLING.SEEDLING_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_ELEM_NUM){

            currentStatus = Resource.TREE_STATUS.TREE_SEEDLING;

        } else if(totalUsedNum >= Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_ELEM_NUM){

            currentStatus = Resource.TREE_STATUS.TREE_SEEDLING_MATURE;

        } else if(totalUsedNum >= Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_ELEM_NUM){

            currentStatus = Resource.TREE_STATUS.TREE_DEVELOPMENT;

        } else if(totalUsedNum >= Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_ELEM_NUM){

            currentStatus = Resource.TREE_STATUS.TREE_MATURE;

        } else if(totalUsedNum >= Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_ELEM_NUM){

            currentStatus = Resource.TREE_STATUS.TREE_FINAL;

        }

        CommonUtil.printLog("PlanterTreeManager after compute  currentStatus: " + currentStatus);

        return currentStatus;
    }

    public static void rewardToCourseTree(String studentId, String courseId, int bonusModuleId, int bonusType, int bonusNum){
        TreeInfoDAO treeInfoDAO = new TreeInfoDAO();
        treeInfoDAO.awardToCourseTree(studentId, courseId, bonusModuleId, bonusType, bonusNum);
        TreeInfoEntity treeEntity = treeInfoDAO.selectCourseTreeByStudentIdAndCourseId(studentId, courseId);
        addBonus(bonusType, bonusNum, treeEntity, treeInfoDAO);

    }

    private static void addBonus(int bonusType, int bonusNum, TreeInfoEntity treeEntity, TreeInfoDAO dao){
        switch (bonusType){
            case Resource.BONUS_TYPE.BONUS_TYPE_SUNSHINE:{
                int total = treeEntity.getTreeSun() + bonusNum;
                treeEntity.setTreeSun(total);
            }
            break;
            case Resource.BONUS_TYPE.BONUS_TYPE_WATER:{
                int total = treeEntity.getTreeWater() + bonusNum;
                treeEntity.setTreeWater(total);
            }
            break;
            case Resource.BONUS_TYPE.BONUS_TYPE_SOIL:{
                int total = treeEntity.getTreeSoil() + bonusNum;
                treeEntity.setTreeSoil(total);
            }
            break;
        }

        dao.updateTreeInfoEntity(treeEntity);
    }




}
