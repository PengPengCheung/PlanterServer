package dao.logic;

import common.Resource;
import dao.*;
import entity.*;
import model.DataResponse;
import module.launch.model.SignUpMobViewModel;
import module.planter.model.PlanterViewModel;
import module.signup.model.SignUpWebRequestViewModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import utils.DBUtil;

import java.util.List;
import java.util.UUID;

/**
 * Created by peng on 2017/3/23.
 */
public class SignUpDAO extends BaseDAO{

    private static final Logger logger = Logger.getLogger(SignUpDAO.class);

    public SignUpDAO(){
        super();
    }

    public StudentInfoEntity insertStudentInfo(SignUpMobViewModel viewModel){
        SqlSession session = getSession();
        IStudentInfo studentInfo = session.getMapper(IStudentInfo.class);
        StudentInfoEntity studentInfoEntity = constructStudentInfoEntity(viewModel);
        studentInfo.addStudent(studentInfoEntity);
        session.commit();
        return studentInfoEntity;
    }

    private StudentInfoEntity constructStudentInfoEntity(SignUpMobViewModel viewModel) {
        StudentInfoEntity entity = new StudentInfoEntity();
        entity.setsId(DBUtil.generateUUID());
        entity.setsNo(viewModel.getmNum());
        entity.setsPassword(viewModel.getmPassword());
        entity.setsName(viewModel.getmName());
        return entity;
    }


    public void studentSignUp(SignUpWebRequestViewModel requestViewModel){
        SqlSession session = getSession();

        IStudentInfo studentInfoOP = session.getMapper(IStudentInfo.class);
        TeacherInfoEntity entity = constructTeacherInfoEntity(requestViewModel);
//        teacherInfoOP.insertTeacherInfoRecord(entity);
        session.commit();

    }

    public void teacherSignUp(SignUpWebRequestViewModel requestViewModel){
        SqlSession session = getSession();

        ITeacherInfoOP teacherInfoOP = session.getMapper(ITeacherInfoOP.class);
        TeacherInfoEntity entity = constructTeacherInfoEntity(requestViewModel);
        teacherInfoOP.insertTeacherInfoRecord(entity);
        session.commit();
    }

    private TeacherInfoEntity constructTeacherInfoEntity(SignUpWebRequestViewModel requestViewModel) {
        if(requestViewModel == null){
            return new TeacherInfoEntity();
        }

        TeacherInfoEntity entity = new TeacherInfoEntity();
        entity.settName(requestViewModel.getUserName());
        entity.settPassword(requestViewModel.getUserPassword());
        entity.settId(DBUtil.generateUUID());

        return entity;
    }


    private boolean validateCourseCode(String inputCourseCode, SqlSession session){
        if(inputCourseCode == null){
            return false;
        }
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        List<CourseInfoEntity> courseInfoEntities = courseInfo.selectAllCourseInfo();
        for (CourseInfoEntity entity: courseInfoEntities) {
            String code = entity.getCourseCode();
            if(inputCourseCode.equals(code)){
                return true;
            }
        }

        return false;
    }

    private void insertNewTree(SqlSession session){
        TreeInfoEntity treeInfoEntity = initTreeInfo();
        ITreeInfo treeOp = session.getMapper(ITreeInfo.class);
        treeOp.insertTreeInfo(treeInfoEntity);
        session.commit();
    }


    public DataResponse<PlanterViewModel> addStudentSignUpRecord(SignUpMobViewModel model){
        SqlSession session = getSession();
        int status = -1;
//        ISignUp signUp = session.getMapper(ISignUp.class);
        IStudentInfo studentInfo = session.getMapper(IStudentInfo.class);
        IBaseConnection conn = session.getMapper(IBaseConnection.class);
        ICourseInfo courseInfo = session.getMapper(ICourseInfo.class);
        StudentInfoEntity student = constructDBModel(model);
        studentInfo.addStudent(student);
//        String teacherId = getTeacherId();
//        String courseId = getCourseId();
//        String connectionId = getConnectionId();
        String courseCode = model.getmCourseCode();
        boolean isValidate = validateCourseCode(courseCode, session);
        if(isValidate){
            String studentId = student.getsId();
            Logger.getLogger(SignUpDAO.class).error("courseCode: " + courseCode + ", studentId: " + studentId);
            CourseInfoEntity courseInfoEntity = courseInfo.selectCourseByCourseCode(courseCode);
            if(courseInfoEntity != null){
                conn.updateBaseConnection(studentId, courseInfoEntity.getcId());
            }

//        conn.addBaseConnection(teacherId, student.getsId(), courseId, connectionId, courseCode);
            session.commit();


            String courseId = null;
            if(courseInfoEntity != null){
                courseId = courseInfoEntity.getcId();
            }
//            BaseConnectionEntity connectionEntity = conn.selectBaseConnectionByCourseId(courseId);
//            String stuId = studentId;
//            String courseId = connectionEntity.getcId();

            // 初始化并插入成长树
            TreeInfoEntity treeInfoEntity = initTreeInfo();
            ITreeInfo treeOp = session.getMapper(ITreeInfo.class);
            treeOp.insertTreeInfo(treeInfoEntity);
            session.commit();

            // 插入关联表的课程、学生id
            IStudentCourseTree sctOP = session.getMapper(IStudentCourseTree.class);
            StudentCourseTreeEntity sct = new StudentCourseTreeEntity();
            sct.setcId(courseId);
            sct.setsId(studentId);
            sct.setTreeId(treeInfoEntity.getTreeId());
            sctOP.insertStudentCourseTree(sct);
            session.commit();

            // 根据课程id找到对应课程信息
            ICourseInfo courseOp = session.getMapper(ICourseInfo.class);
            CourseInfoEntity course = courseOp.selectCourseById(courseId);

            logger.error("courseId: " + courseId + ", studentId: " + studentId);

            // 组装返回的视图
            PlanterViewModel responseModel = constructResponseModel(treeInfoEntity, course);
            responseModel.setmStudentId(studentId);
            status = Resource.STATUS_TEST.STATUS_COURSE_CODE_VALIDATE_SUCCESS;
            DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(status, "课程码验证通过");
            response.setData(responseModel);
            return response;

        } else {
            status = Resource.STATUS_TEST.STATUS_COURSE_CODE_UNAVAILABLE;
            DataResponse<PlanterViewModel> response = new DataResponse<PlanterViewModel>(status, "课程码不正确");
            return response;
        }
    }

    private TreeInfoEntity initTreeInfo() {
        TreeInfoEntity tree = new TreeInfoEntity();
        String treeId = DBUtil.generateUUID();
        tree.setTreeId(treeId);
        tree.setTreeStatus(Resource.TREE_STATUS.TREE_SEED);
        tree.setTreeSun(0);
        tree.setTreeSoil(0);
        tree.setTreeWater(0);
        tree.setTreeSoilUsedNum(0);
        tree.setTreeWaterUsedNum(0);
        tree.setTreeSunUsedNum(0);
        return tree;
    }

    private PlanterViewModel constructResponseModel(TreeInfoEntity tree, CourseInfoEntity course) {
        PlanterViewModel model = new PlanterViewModel();
        model.setmCourseId(course.getcId());
        model.setmCourseName(course.getCourseName());
        model.setmCourseTime(course.getCourseTime());
        model.setmPlanterStatus(tree.getTreeStatus());
        model.setmPlanterWater(tree.getTreeWater());
        model.setmPlanterSunshine(tree.getTreeSun());
        model.setmPlanterSoil(tree.getTreeSoil());
        model.setmPlanterPercent(0);

        return model;
    }

    private String getConnectionId(){
        return DBUtil.generateUUID();
    }

    private String getTeacherId(){
        return DBUtil.generateUUID();
    }

    private String getCourseId(){
        return DBUtil.generateUUID();
    }

    private StudentInfoEntity constructDBModel(SignUpMobViewModel model) {
        StudentInfoEntity entity = new StudentInfoEntity();
        String id = UUID.randomUUID().toString();
        entity.setsId(id);
        entity.setsName(model.getmName());
        entity.setsNo(model.getmNum());
        entity.setsPassword(model.getmPassword());

        return entity;
    }

}
