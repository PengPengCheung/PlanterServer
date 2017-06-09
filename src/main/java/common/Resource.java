package common;

/**
 * Created by peng on 2017/3/16.
 */
public class Resource {

    public static final String JPUSH_MASTER_SECRET = "5fc72fb21fe6e4c48c9e21ed";
    public static final String JPUSH_APP_KEY = "b7470409635a75e96fe27578";//82815b3656aaca29b5b32f17

    public static final String JPUSH_ALIAS = "Planter";

    public static final String GOEASY_CHANNEL = "Planter";
    // GoEasy
    public static final String GOEASY_APP_KEY = "BC-be5f25350dac454d943677328902cccc";//"a3046b42-bae4-4785-bdac-26da75afe10b";


//    private static final String HOST_URL = "http://10.173.8.165:8080"; // http://10.173.40.45:8080
    private static final String HOST_URL = "http://118.89.48.183:8080";
    public static final String RESOURCE_SAVE_ABSOLUTE_PATH = "/files/Upload";
    public static final String RESOURCE_DOWNLOAD_URL = HOST_URL + "/Planter/FileUpload/fileDownload_servlet";
    public static final String STUDENT_HOMEWORK_DOWNLOAD_URL = HOST_URL + "/FileDownload/StudentHomeworkDownload";


    public static class TEST{
        public static final String TEST_TEACHER_ID = "1234";
        public static final String TEST_STU_ID = "student456";
        public static final String TEST_COURSE_ID = "course789";

        public static final String TEST_STU_NAME = "朋朋";
    }

    public static class KEY{

        // 启动页注册登录等
        public static final String KEY_STU_NAME = "student_name";
        public static final String KEY_STU_ID = "student_id";
        public static final String KEY_STU_PASSWORD = "student_password";
        public static final String KEY_STU_COURSE_CODE = "student_course_code";


        public static final String KEY_COURSE_OPEN_COUNT = "course_open_count";

        public static final String KEY_COURSE_OPEN_TIME = "course_open_time_list";

        public static final String KEY_SIMPLE_STATUS = "response_status";

        public static final String KEY_NAME = "userName";
        public static final String KEY_PASSWORD = "userPassword";
        public static final String KEY_ROLE = "Rank";

        public static final String KEY_LOGIN_REASON = "login_reason";


        public static final String KEY_RESULT = "result";

        public static final String KEY_DATA_GET_METHOD = "data_get_from";
        public static final String KEY_BONUS_TYPE = "bonus_type";


        public static final String KEY_MODULE_ID = "module_id";
        public static final String KEY_ACTION_ID = "action_id";

        public static final String KEY_TEACHER_ID = "t_id";
        public static final String KEY_STUDENT_ID = "s_id";
        public static final String KEY_COURSE_ID  = "c_id";
        public static final String KEY_CONNECTION_ID = "base_connection_id";

        //Course 相关信息
        public static final String KEY_COURSE_NAME = "course_name";
        public static final String KEY_COURSE_TIME = "course_time";
        public static final String KEY_COURSE_CODE = "course_code"; // 用于传输给老师的课程码
        public static final String KEY_COURSE_DATE = "course_date"; // 记录星期几

        // 开课信息
        public static final String KEY_CLASS_OPEN_TIME = "class_begin_time";
        public static final String KEY_CLASS_CLOSE_TIME = "class_end_time";
        public static final String KEY_CLASS_BEGIN_STATUS = "class_begin_status";
        public static final String KEY_CLASS_OPEN_ID = "open_class_id"; // 开课信息id

        //Attendance，考勤模块
        public static final String KEY_ATTENDANCE_ID = "attendance_id";
        public static final String KEY_ATTENDANCE_CODE = "attendance_code";
        public static final String KEY_ATTENDANCE_STATUS = "attendance_status";
        public static final String KEY_ATTENDANCE_BONUS_NUM = "attendance_bonus_num";
        public static final String KEY_ATTENDANCE_TIME = "attendance_time";
        public static final String KEY_ATTENDANCE_ATT_COUNT = "attendance_count";
        public static final String KEY_ATTENDANCE_ABS_COUNT = "absence_count";
        public static final String KEY_ATTENDANCE_VALID_DURATION = "attendance_valid_time";
        public static final String KEY_ATTENDANCE_CODE_SEND_STATUS = "attendance_code_send_status";
        public static final String KEY_ATTENDANCE_TOTAL_COUNT = "attendance_total_count";
        public static final String KEY_ABSENCE_TOTAL_COUNT = "absence_total_count";
        public static final String KEY_ATTENDANCE_END = "attendance_check_end";



        //Attention, 专注模块
        public static final String KEY_ATTENTION_ID = "attention_id";
        public static final String KEY_ATTENTION_TIME = "attention_time";
        public static final String KEY_ATTENTION_END_TIME = "attention_end_time";
        public static final String KEY_ATTENTION_DURATION = "attention_duration";
        public static final String KEY_ATTENTION_FOCUS_COUNT = "attention_focus_count";
        public static final String KEY_ATTENTION_LOST_FOCUS_COUNT = "attention_lost_focus_count";
        public static final String KEY_ATTENTION_BONUS_NUM = "attention_bonus_num";
        public static final String KEY_ATTENTION_STATUS = "attention_status"; // 专注状态，成功、失败、正在专注
        public static final String KEY_ATTENTION_TYPE = "attention_type";
        public static final String KEY_ATTENTION_BEGIN_SIGNAL = "attention_begin"; // 专注开始的标志
        public static final String KEY_ATTENTION_INSIST_TIME = "attention_insist_time"; // 专注时长
        public static final String KEY_ATTENTION_SCORE = "attention_score"; // 小组专注时才有打分, 此处的键对应的值是学生个体打出的具体分数
        public static final String KEY_ATTENTION_STUDENT_NEED_SCORE = "attention_student_need_score";


        //RandomAsk, 随机提问
        public static final String KEY_RANDOM_ASK_GIVE_BONUS_STATUS = "random_ask_bonus_status";
        public static final String KEY_RANDOM_ASK_CURRENT_TIME = "random_ask_time";


        //Summary, 总结反馈模块
        public static final String KEY_SUMMARY_ID = "summary_id";
        public static final String KEY_SUMMARY_REQUEST_TIME = "summary_request_time"; // 老师发送反馈请求的时间
        public static final String KEY_SUMMARY_SEND_TIME = "summary_send_time";
        public static final String KEY_SUMMARY_BONUS_NUM = "summary_bonus_num";
        public static final String KEY_SUMMARY_CONTENT = "summary_content";
        public static final String KEY_SUMMARY_STATUS = "summary_status";
        public static final String KEY_SUMMARY_RESPONSE_RESULT = "summary_result";

        public static final String KEY_SUMMARY_WEB_DEATILS = "summary_details"; // 详情
        public static final String KEY_SUMMARY_WEB_NEW_FILES = "summary_new_files"; // 新增的课堂反馈数
        public static final String KEY_SUMMARY_WEB_HANDLE_STATUS = "summary_handle_status"; // 教师对全班反馈的处理状态
        public static final String KEY_SUMMARY_WEB_HANDLE_RESULT = "summary_handle_result";

        //Attendance web, 查看反馈详情
        public static final String KEY_COURSE_TIMES = "course_times"; // 查看往期反馈时显示的课时
        public static final String KEY_COURSE_OPEN_TIME_IN_YMD = "class_open_time"; // 显示开课的年月日


        //Homework, 作业模块
        public static final String KEY_HOMEWORK_ID = "homework_id";
        public static final String KEY_HOMEWORK_PUBLISH_TIME = "homework_publish_time";
        public static final String KEY_HOMEWORK_PUBLISH_STATUS = "homework_publish_status";
        public static final String KEY_HOMEWORK_SUBMIT_DDL = "homework_submit_ddl";
        public static final String KEY_HOMEWORK_CURRENT_TIME = "homework_current_time";
        public static final String KEY_HOMEWORK_STATUS = "homework_status"; // 这个作业的状态是指作业的提交/发布等状态
        public static final String KEY_HOMEWORK_SCORE = "homework_score"; // 教师打分,对应的值是打分分数
        public static final String KEY_HOMEWORK_RANK = "homework_rank";
        public static final String KEY_HOMEWORK_BONUS_NUM = "homework_bonus_num";
        public static final String KEY_HOMEWORK_TITLE = "homework_title";
        public static final String KEY_HOMEWORK_CONTENT = "homework_content";

        public static final String KEY_HOMEWORK_SUBMIT_NUM = "homework_submit_num"; // 作业提交人数
        public static final String KEY_HOMEWORK_SUBMIT_NAME = "homework_submit_name"; // 学生提交的作业名称
        public static final String KEY_HOMEWORK_SUBMIT_ID = "homework_submit_id"; // 学生提交的作业id,根据这个id下载对应的作业
        public static final String KEY_HOMEWORK_SUBMIT_DOWNLOAD_URL = "homework_download_url"; // 学生作业下载链接
        public static final String KEY_HOMEWORK_SUBMIT_TEACHER_SCORE_STATUS = "homework_teacher_score_status"; // 教师对学生作业的打分状态
        public static final String KEY_HOMEWORK_STUDENT_SUBMIT_TIME = "homework_student_submit_time"; // 学生提交作业的时间
        public static final String KEY_HOMEWORK_SUBMIT_STATUS = "homework_submit_status";

        // Planter，首页
        public static final String KEY_PLANTER_STATUS = "planter_status";
        public static final String KEY_PLANTER_USED_SUNSHINE = "planter_used_sunshine";
        public static final String KEY_PLANTER_USED_WATER = "planter_used_water";
        public static final String KEY_PLANTER_USED_SOIL = "planter_used_soil";
        public static final String KEY_PLANTER_PERCENTAGE = "planter_percentage";


        //Group, 分组模块， web
        public static final String KEY_GROUP_OPEN = "group_open";
        public static final String KEY_GROUP_ID = "group_id"; // 学生分组的id
        public static final String KEY_TEACHER_OPEN_GROUP_ID = "group_teacher_open_id"; // 教师发布分组信息的id
        public static final String KEY_GROUP_NAME = "group_name";
        public static final String KEY_GROUP_LEADER_NAME = "group_leader_name";
        public static final String KEY_GROUP_OPEN_TIME = "group_open_time";
        public static final String KEY_GROUP_LIMIT = "group_limit";
        public static final String KEY_GROUP_PUSH_TYPE = "group_push_type";

        public static final String KEY_GROUP_STUDENT_SCORE = "group_student_score";
        public static final String KEY_GROUP_TEACHER_SCORE = "group_teacher_score";
        public static final String KEY_GROUP_MEMBERS = "group_members";
        public static final String KEY_GROUP_INFO_LIST = "group_info_list";
        public static final String KEY_GROUP_TASK_ADD_STATUS = "group_task_publish";

        public static final String KEY_GROUP_TASK_CONTENT = "group_task_content";
        public static final String KEY_GROUP_TASK_PUBLISH_DATE = "group_publish_date";
        public static final String KEY_GROUP_TASK_DDL = "group_task_ddl";

        public static final String KEY_GROUP_MIN = "group_member_min";
        public static final String KEY_GROUP_MAX = "group_member_max";

        public static final String KEY_GROUP_TEACHER_SCORE_STATUS = "group_teacher_score_status";


        //Resource, 资源模块
        public static final String KEY_RESOURCE_ID = "resource_id";
        public static final String KEY_RESOURCE_NAME = "resource_name"; // 资源名称
        public static final String KEY_RESOURCE_UPLOAD_DATE = "resource_upload_date"; // 上传日期
        public static final String KEY_RESOURCE_DOWNLOAD_COUNT = "resource_download_count"; // 下载次数
        public static final String KEY_RESOURCE_LIKE_COUNT = "resource_like_count"; // 点赞数
        public static final String KEY_RESOURCE_DOWNLOAD_URL = "resource_download_url"; // 下载url

        public static final String KEY_RESOURCE_DELETE_STATUS = "resource_file_delete_status"; // 删除状态


    }

    public static class CLASS{
        public static final int CLASS_STATUS_OPEN = 1; // 表示已开课
        public static final int CLASS_STATUS_CLOSE = 0; // 表示已结课
    }

    public static class DATA_FROM {
        public static final int DATA_FROM_PUSH = 1;
        public static final int DATA_FROM_REQUEST = 2;
    }

    public static class ATTENDANCE{
        public static final int ATTENDANCE_STATUS_SUCCESS = 1;
        public static final int ATTENDANCE_STATUS_FAIL = -2;
        public static final int ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS = 0;
        public static final int ATTENDANCE_STATUS_NOT_IN_TIME = -1;
        public static final int ATTENDANCE_STATUS_CODE_ERROR = -3;
        public static final int ATTENDANCE_STATUS_DEFAULT = -100;

        // 教师考勤状态：考勤结束、开始考勤
        public static final int ATTENDANCE_STATUS_BEGIN = 1;
        public static final int ATTENDANCE_STATUS_END = 0;

        // 考勤通知是否发送成功
        public static final int ATTENDANCE_NOTIFICATION_SEND_SUCCESS = 1;
        public static final int ATTENDANCE_NOTIFICATION_SEND_FAIL = 0;

        public static final int ATTENDANCE_BONUS_TYPE = BONUS_TYPE.BONUS_TYPE_WATER; // 水滴
        public static final int ATTENDANCE_BONUS_NUM = 5;

        public static final String ATTENDANCE_DURATION = "05:00";
    }

    public static class BONUS_TYPE{
        public static final int BONUS_TYPE_SUNSHINE = 1;
        public static final int BONUS_TYPE_WATER = 2;
        public static final int BONUS_TYPE_SOIL = 3;
    }

    public static class BONUS_NUM{
        public static final int SUMMARY_BONUS_NUM = 5;
        public static final int ATTENDANCE_BONUS_NUM = 5;
        public static final int ATTENTION_BONUS_NUM = 5;
        public static final int HOMEWORK_BONUS_NUM = 5;
        public static final int GROUP_BONUS_NUM = 5;
        public static final int SURPRISE_BONUS_NUM = 3;
    }

    public static class ATTENTION {
        // 专注类型
        public static final int ATTENTION_TYPE_NORMAL = 1;
        public static final int ATTENTION_TYPE_GROUP = 2;

        // 专注开始、结束状态标志
        public static final int ATTENTION_BEGIN = 1;
        public static final int ATTENTION_END = 0;

        // 学生专注状态
        public static final int ATTENTION_STATUS_SUCCESS = 1;
        public static final int ATTENTION_STATUS_DEFAULT = 0; // 默认状态不专注
        public static final int ATTENTION_STATUS_FAIL = -3;
        public static final int ATTENTION_STATUS_ATTENTIONING = 2; // 正在专注
        public static final int ATTENTION_STATUS_NOT_PAY_ATTENTION = -1; // 未参与本次专注
        public static final int ATTENTION_STATUS_NOT_IN_TIME = -2; // 不在专注时间
    }

    public static class LOGIN{
        public static final int STATUS_SUCCESS = 200;
        public static final int STATUS_FAIL = -1;

        public static final String LOGIN_SUCCESS = "登录成功";
        public static final String LOGIN_FAIL = "用户名或密码不正确";
    }

    public static class RESULT{
        public static final int RESULT_OPERATION_SUCCESS = 1;
        public static final int RESULT_OPERATION_FAIL = -1;
    }

    public static class GROUP{
        // 开通分组的状态
        public static final int GROUP_STATUS_OPEN = 1;
        public static final int GROUP_STATUS_NOT_OPEN = 0;


        // 移动端，推送到移动端的组别信息类型
        public static final int GROUP_TYPE_OPEN_GROUP_NOTIFICATION = 1; // 教师开通分组推送类型
        public static final int GROUP_TYPE_STUDENT_OPEN_GROUP_ALREADY = 2; // 学生自行分组消息类型

        // 发布小组任务是否成功
        public static final int GROUP_TASK_ADD_SUCCESS = 1;
        public static final int GROUP_TASK_ADD_FAIL = -1;

        // 教师打分是否成功
        public static final int GROUP_SCORE_TEACHER_STATUS_SUCCESS = 1; // 成功
        public static final int GROUP_SCORE_TEACHER_STATUS_FAIL = 0;
    }

    public static class RANDOM_ASK{
        public static final int RANDOM_ASK_GIVE_BONUS_SUCCESS = 1; // 发放奖励成功
        public static final int RANDOM_ASK_GIVE_BONUS_FAIL = -1;

        // 随机提问状态：开始/结束
        public static final int RANDOM_ASK_BEGIN = 1;
        public static final int RANDOM_ASK_END = 0;
    }

    public static class COUNT_DOWN_TIME_LIMIT {
        public static final int ATTENDANCE_COUNT_DOWN_TIME = 10000;
        public static final int ATTENTION_COUNT_DOWN_TIME = 1;
    }


    public static class ROLE {
        public static final int ROLE_TEACHER = 0;
        public static final int ROLE_STUDENT = 1;
    }

    public static class SUMMARY{
        // 移动端，学生收到的教师请求状态
        public static final int SUMMARY_WAIT_FOR_SENDING = 0;
        public static final int SUMMARY_SEND_SUCCESS = 1;
        public static final int SUMMARY_CHECKING = 2;

        // 网页端，教师发送反馈通知的状态
        public static final int SUMMARY_REQUEST_SUCCESS = 1;
        public static final int SUMMARY_REQUEST_FAIL = 0;

        // 教师对学生反馈处理结果，成功或失败
        public static final int SUMMARY_HANDLE_SUCCESS = 1;
        public static final int SUMMARY_HANDLE_FAIL = 0;

        // 学生发送反馈的状态
        public static final int SUMMARY_SEND_NOT_REPLY = 3;
        public static final int SUMMARY_SEND_REPLY = 4;
        public static final int SUMMARY_NOT_SEND = 5;


        // 网页端，教师回复反馈的结果(针对某个学生而言)
        public static final int SUMMARY_REASONABLE = 1;
        public static final int SUMMARY_THANKS = -1;
        public static final int SUMMARY_DEFAULT = 0; // 默认状态下不评价

        // 网页端 显示教师处理的三种情况
        public static final int SUMMARY_NO_SUMMARY = 1; // 暂无反馈
        public static final int SUMMARY_ALL_DONE = 2; // 所有反馈均处理
        public static final int SUMMARY_NOT_FINISHED = 3; // 有反馈未处理
    }

    public static class RES_STATUS {

        public static final int RESOURCE_DELETE_FILE_SUCCESS = 1;
        public static final int RESOURCE_DELETE_FILE_FAIL = -1;
        public static final int RESOURCE_ADD_FILE_SUCCESS = 2;
        public static final int RESOURCE_ADD_FILE_FAIL = -2;
    }

    public static class HOMEWORK{
        public static final int HOMEWORK_PUBLISHED = 0; // 教师已发布但学生未提交
        public static final int HOMEWORK_SUBMIT_SUCCESS = 1; // 学生已提交但教师未打分
        public static final int HOMEWORK_SCORED = 2; // 教师已打分

        public static final int HOMEWORK_SUBMIT_STATUS_SUCCESS = 1;
        public static final int HOMEWORK_SUBMIT_STATUS_FAIL = -1;


        // 发布作业是否成功的状态， 用于响应返回
        public static final int HOMEWORK_PUBLISHED_SUCCESS = 1;
        public static final int HOMEWORK_PUBLISHED_FAIL = -1;

        // 教师对作业打分是否成功的状态
        public static final int HOMEWORK_TEACHER_SCORE_SUCCESS = 1;
        public static final int HOMEWORK_TEACHER_SCORE_FAIL = -1;
    }



    public static class TREE{

        public static class SEED{
            public static final int SEED_TOTAL_SUNSHINE = 0;
            public static final int SEED_TOTAL_WATER = 0;
            public static final int SEED_TOTAL_SOIL = 0;
            public static final int SEED_TOTAL_ELEM_NUM = SEED_TOTAL_SOIL + SEED_TOTAL_SUNSHINE + SEED_TOTAL_WATER;
        }

        public static class SEEDLING{
            public static final int SEEDLING_TOTAL_SUNSHINE = 25;
            public static final int SEEDLING_TOTAL_WATER = 25;
            public static final int SEEDLING_TOTAL_SOIL = 25;
            public static final int SEEDLING_TOTAL_ELEM_NUM = SEEDLING_TOTAL_SUNSHINE + SEEDLING_TOTAL_WATER + SEEDLING_TOTAL_SOIL;
        }

        public static class SEEDLING_MATURE{
            public static final int SEEDLING_MATURE_TOTAL_SUNSHINE = 50;
            public static final int SEEDLING_MATURE_TOTAL_WATER = 50;
            public static final int SEEDLING_MATURE_TOTAL_SOIL = 50;
            public static final int SEEDLING_MATURE_TOTAL_ELEM_NUM = SEEDLING_MATURE_TOTAL_SUNSHINE + SEEDLING_MATURE_TOTAL_WATER + SEEDLING_MATURE_TOTAL_SOIL;
        }

        public static class TREE_DEVELOPMENT{
            public static final int TREE_DEVELOPMENT_TOTAL_SUNSHINE = 100;
            public static final int TREE_DEVELOPMENT_TOTAL_WATER = 100;
            public static final int TREE_DEVELOPMENT_TOTAL_SOIL = 100;
            public static final int TREE_DEVELOPMENT_TOTAL_ELEM_NUM = TREE_DEVELOPMENT_TOTAL_SUNSHINE + TREE_DEVELOPMENT_TOTAL_WATER + TREE_DEVELOPMENT_TOTAL_SOIL;
        }

        public static class TREE_MATURE{
            public static final int TREE_MATURE_TOTAL_SUNSHINE = 150;
            public static final int TREE_MATURE_TOTAL_WATER = 150;
            public static final int TREE_MATURE_TOTAL_SOIL = 150;
            public static final int TREE_MATURE_TOTAL_ELEM_NUM = TREE_MATURE_TOTAL_SUNSHINE + TREE_MATURE_TOTAL_WATER + TREE_MATURE_TOTAL_SOIL;
        }

        public static class TREE_FINAL{
            public static final int TREE_FINAL_TOTAL_SUNSHINE = 200;
            public static final int TREE_FINAL_TOTAL_WATER = 200;
            public static final int TREE_FINAL_TOTAL_SOIL = 200;
            public static final int TREE_FINAL_TOTAL_ELEM_NUM = TREE_FINAL_TOTAL_SUNSHINE + TREE_FINAL_TOTAL_WATER + TREE_FINAL_TOTAL_SOIL;
        }

    }

    public static class TREE_STATUS{
        public static final int TREE_SEED = 0;
        public static final int TREE_SEEDLING = 1;
        public static final int TREE_SEEDLING_MATURE = 2;
        public static final int TREE_DEVELOPMENT = 3;
        public static final int TREE_MATURE = 4;

        public static final int TREE_FINAL = 5;
    }

    public static class STATUS_TEST{
        // 登录注册课程码状态
        public static int STATUS_COURSE_CODE_UNAVAILABLE = -100;
        public static int STATUS_COURSE_CODE_VALIDATE_SUCCESS = 1;

        // 总结反馈返回状态
        public static int STATUS_SUMMARY_SEND_SUCCESS = 200;
        public static int STATUS_SUMMARY_SEND_FAIL = 201;

        // 开课操作返回码
        public static int STATUS_CLASS_OPEN_SUCCESS = 200;

        // 专注返回码
        public static final int STATUS_ATTENTION_RECEIVED_SUCCESS = 200;

    }

    public static class Module {

        public String TYPE = "type";
        public static final int MODULE_FRAME_PLANTER = 10;
        public static final int MODULE_FRAME_NOTIFICATION = 1;
        public static final int MODULE_FRAME_RESOURCE = 2;

        public static final int MODULE_COURSE_ATTENDANCE = 3;
        public static final int MODULE_COURSE_ATTENTION = 4;
        public static final int MODULE_COURSE_SUMMARY = 5;
        public static final int MODULE_COURSE_HOMEWORK = 6;
        public static final int MODULE_COURSE_GROUP = 7;
        public static final int MODULE_COURSE_OTHERS = 8;


        public static final String MODULE_COURSE_ATTENDANCE_NAME = "Attendance";
        public static final String MODULE_COURSE_ATTENTION_NAME = "Attention";
        public static final String MODULE_COURSE_SUMMARY_NAME = "Summary";
        public static final String MODULE_COURSE_HOMEWORK_NAME = "Homework";
        public static final String MODULE_COURSE_GROUP_NAME = "Group";
        public static final String MODULE_COURSE_OTHERS_NAME = "Others";
    }

    public static class Notification{

        public static final String ATTENDANCE_CHECK_NOTIFICATION = "您有一个考勤通知，请查看";
        public static final String ATTENTION_CHECK_NOTIFICATION = "您有一个专注通知，请查看";
        public static final String SUMMARY_CHECK_NOTIFICATION = "老师邀请您对本节课做反馈，请查看";
        public static final String HOMEWORK_CHECK_NOTIFICATION = "老师发布了新的作业，点此查看";
        public static final String GROUP_CHECK_NOTIFICATION = "请尽快进行分组";
    }



    public static final String TEST_LONG_TEXT = "This is a dialog without title. This is a dialog without title. This is a dialog without title. " +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            " ";
}
