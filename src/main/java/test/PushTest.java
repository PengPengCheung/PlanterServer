package test;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.BaseViewModel;
import common.Resource;
import io.goeasy.GoEasy;
import module.attendance.model.AttendanceCheckWebResponseViewModel;
import module.attendance.model.AttendanceViewModel;
import module.attention.model.AttentionGoingModel;
import module.attention.model.AttentionViewModel;
import module.homework.model.HomeworkViewModel;
import module.summary.model.mob.SummaryViewModel;
import net.sf.json.JSONObject;
import utils.DBUtil;
import utils.JsonUtil;
import utils.PushUtil;
import utils.TimeUtil;

import java.util.Date;


/**
 * Created by peng on 2017/3/10.
 */
public class PushTest {

    // 百度云推送
    static String apiKey = "BvxQh7toN3zczrXGPUyMj0Tl";
    static String secretKey = "QBlUhMvVtCDGfdtQ1ls0ilfkR7e9UROs";
    static String channelId = "4506051034133639245";

    // 极光推送
//    static String MASTER_SECRET = "48d81d4ed28ac042d020dbbb";
//    static String APP_KEY = "82815b3656aaca29b5b32f17";

    // GoEasy
    static String appKey = "BC-be5f25350dac454d943677328902cccc";//"a3046b42-bae4-4785-bdac-26da75afe10b";

    public static void main(String[] args) throws PushClientException,PushServerException{
//        pushToSingleDevice();
//            JPushTest();
        goEasyPushTest();
//        pushToWebDemo();
//        interactionPushTest();
//        pushToWebAttentionDemo();
//        pushToWebGroupAttentionDemo();
    }

    private static AttendanceViewModel constructAttendanceViewModel(String courseId){
        Date date = new Date();
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
        attendanceViewModel.setmDataFrom(Resource.DATA_FROM.DATA_FROM_PUSH);
        attendanceViewModel.setmCourseId(courseId);
        attendanceViewModel.setmAttendanceBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        attendanceViewModel.setmAttendanceCode("313132");
        attendanceViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
        attendanceViewModel.setmAttendanceId(DBUtil.generateUUID());
        attendanceViewModel.setmAttendanceTime(TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM));
        attendanceViewModel.setmAttendanceValidDuration("05:00");
        attendanceViewModel.setmAttendanceCount(10);
        attendanceViewModel.setmAbsenceCount(11);
        attendanceViewModel.setmAttendanceBonusNum(5);
        attendanceViewModel.setmAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT);

        return attendanceViewModel;
    }

    private static AttentionViewModel constructAttentionViewModel(String courseId){
        Date date = new Date();
        AttentionViewModel attentionViewModel = new AttentionViewModel();
        attentionViewModel.setmDataFrom(Resource.DATA_FROM.DATA_FROM_PUSH);
        attentionViewModel.setmCourseId(courseId);
        attentionViewModel.setmAttentionId(DBUtil.generateUUID());
        attentionViewModel.setmAttentionBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        attentionViewModel.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
        attentionViewModel.setmAttentionId(DBUtil.generateUUID());
        attentionViewModel.setmAttentionTime(TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM));
        attentionViewModel.setmAttentionDuration("05:00");
        attentionViewModel.setmAttentionFocusCount(10);
        attentionViewModel.setmAttentionLostFocusCount(11);
        attentionViewModel.setmAttentionBonusNum(5);
        attentionViewModel.setmAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_DEFAULT);

        return attentionViewModel;
    }

    private static SummaryViewModel constructSummaryViewModel(String courseId){
        String summaryId = DBUtil.generateUUID();
        SummaryViewModel summaryViewModel = new SummaryViewModel();
        summaryViewModel.setmCourseId(courseId);
        summaryViewModel.setmModuleId(Resource.Module.MODULE_COURSE_SUMMARY);
        summaryViewModel.setmSummaryBonusType(Resource.BONUS_TYPE.BONUS_TYPE_WATER);
        summaryViewModel.setmSummaryBonusNum(10);
        summaryViewModel.setmSummaryId(summaryId);
        summaryViewModel.setmSummaryRequestTime(TimeUtil.timeToStr(new Date(), TimeUtil.CHN_PATTERN_YMD_HM));
        summaryViewModel.setmSummaryStatus(Resource.SUMMARY.SUMMARY_WAIT_FOR_SENDING);

        return summaryViewModel;
    }

    private static HomeworkViewModel constructHomeworkViewModel(String courseId){
        String homeworkId = DBUtil.generateUUID();

        Date date = new Date();
        HomeworkViewModel homeworkViewModel = new HomeworkViewModel();
        homeworkViewModel.setmCourseId(courseId);
        homeworkViewModel.setmModuleId(Resource.Module.MODULE_COURSE_HOMEWORK);
        homeworkViewModel.setmHomeworkBonusNum(5);
        homeworkViewModel.setmHomeworkSubmitDDL(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HM));
        homeworkViewModel.setmHomeworkContent(Resource.TEST_LONG_TEXT);
        homeworkViewModel.setmHomeworkItemCurrentTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD));
        homeworkViewModel.setmHomeworkRank(2);
        homeworkViewModel.setmHomeworkPublishTime(TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HM));
        homeworkViewModel.setmHomeworkTitle("综英第一次作业");
        homeworkViewModel.setmHomeworkScore(90);
        homeworkViewModel.setmHomeworkId(homeworkId);
        homeworkViewModel.setmHomeworkStatus(Resource.HOMEWORK.HOMEWORK_SUBMIT_SUCCESS);

        return homeworkViewModel;

    }




    private  static void interactionPushTest(){
        // 5243a79c-6383-434e-9068-1307a8718589
        String courseId = "27b6a51d-3c96-41b1-b5c1-5cae3790ba90";

//        AttendanceViewModel model =  constructAttendanceViewModel(courseId);
        AttentionViewModel model = constructAttentionViewModel(courseId);
//        SummaryViewModel model = constructSummaryViewModel(courseId);
//        HomeworkViewModel model = constructHomeworkViewModel(courseId);

        String pushJsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            pushJsonStr = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }




//        PushUtil.push(Resource.Notification.ATTENDANCE_CHECK_NOTIFICATION, PushUtil.PUSH_TYPE_NOTIFICATION);

        PushUtil.pushMessageAndNotification(pushJsonStr, Resource.Notification.HOMEWORK_CHECK_NOTIFICATION);
    }

    private static void pushToWebGroupAttentionDemo(){
        int total = 3;
        for(int i=0;i<total;i++){
            AttentionGoingModel model = new AttentionGoingModel();
            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
            model.setmStudentId(Resource.TEST.TEST_STU_ID);
            model.setAttentionType(Resource.ATTENTION.ATTENTION_TYPE_GROUP);
            model.setStudentName("韩晓娜");
            model.setAttentionInsistTime("3:00");
            model.setAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_FAIL);
            goEasyPushToWeb(model);
            System.out.println("name: " + model.getStudentName() + " 专注失败");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<total;i++){
            AttentionGoingModel model = new AttentionGoingModel();
            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
            model.setmStudentId(Resource.TEST.TEST_STU_ID);
            model.setAttentionType(Resource.ATTENTION.ATTENTION_TYPE_GROUP);
            model.setStudentName("朋朋");
//            model.setAttentionInsistTime("3:00");
            model.setAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_SUCCESS);
            model.setScore(90);
            goEasyPushToWeb(model);
            System.out.println("name: " + model.getStudentName() + " 专注成功");
        }
    }

    private static void pushToWebAttentionDemo(){
        int total = 5;
        for(int i=0;i<total;i++){
            AttentionGoingModel model = new AttentionGoingModel();
            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
            model.setmStudentId(Resource.TEST.TEST_STU_ID);
            model.setAttentionType(Resource.ATTENTION.ATTENTION_TYPE_NORMAL);
            model.setStudentName("韩晓娜");
            model.setAttentionInsistTime("3:00");
            model.setAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_FAIL);

            goEasyPushToWeb(model);
            System.out.println("name: " + model.getStudentName() + " 专注失败");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<total;i++){
            AttentionGoingModel model = new AttentionGoingModel();
            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENTION);
            model.setmStudentId(Resource.TEST.TEST_STU_ID);
            model.setAttentionType(Resource.ATTENTION.ATTENTION_TYPE_NORMAL);
            model.setStudentName("朋朋");
//            model.setAttentionInsistTime("3:00");
            model.setAttentionStatus(Resource.ATTENTION.ATTENTION_STATUS_SUCCESS);
            goEasyPushToWeb(model);
            System.out.println("name: " + model.getStudentName() + " 专注成功");
        }
    }



    // 推送给网页的考勤情况
    private static void pushToWebDemo(){
        int total = 10;
        for(int i=0;i<10;i++){
            AttendanceCheckWebResponseViewModel model = new AttendanceCheckWebResponseViewModel();
            model.setmModuleId(Resource.Module.MODULE_COURSE_ATTENDANCE);
            model.setmCourseId(Resource.TEST.TEST_COURSE_ID);
            model.setmTeacherId(Resource.TEST.TEST_TEACHER_ID);
            model.setStudentName("韩晓娜 " + i);
            model.setStudentAttendanceCount(i+3);
            model.setStudentAbsentCount(i);
            model.setEnd(false);

            if(i == 9){
                model.setTotalAttendanceCount(i + 1);
                model.setTotalAbsentCount(total - i);
                model.setEnd(true);
            }
            goEasyPushToWeb(model);
            System.out.println("name: " + model.getStudentName() + " 已签到");
        }
    }

    private static void goEasyPushToWeb(BaseViewModel model){
        String jsonStr = JsonUtil.objToJSON(model);
        GoEasy goEasy = new GoEasy(Resource.GOEASY_APP_KEY);
        goEasy.publish(Resource.GOEASY_CHANNEL, jsonStr);
    }

    public static void goEasyPushTest(){
        GoEasy goEasy = new GoEasy(appKey);
        goEasy.publish(Resource.GOEASY_CHANNEL, "GoEasy Test");
    }

//    public static void JPushTest(){
//        JPushClient jpushClient = new JPushClient(Resource.JPUSH_MASTER_SECRET, Resource.JPUSH_APP_KEY, null, ClientConfig.getInstance());
//
//        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_all_all_alert();
//
//        try {
//            PushResult result = jpushClient.sendPush(payload);
////            LOG.info("Got result - " + result);
//            System.out.println("result = "+result);
//        } catch (APIConnectionException e) {
//            System.out.println("APIConnectionException: " + e.toString());
//            // Connection error, should retry later
////            LOG.error("Connection error, should retry later", e);
//
//        } catch (APIRequestException e) {
//            System.out.println("APIRequestException: " + e.toString());
//            // Should review the error, and fix the request
////            LOG.error("Should review the error, and fix the request", e);
////            LOG.info("HTTP Status: " + e.getStatus());
////            LOG.info("Error Code: " + e.getErrorCode());
////            LOG.info("Error Message: " + e.getErrorMessage());
//        }
//    }

    private static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("Server Notification Test");
    }


    public static void pushToAllDevice() throws PushClientException,PushServerException {

        PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

        // 2. build a BaidupushClient object to access released interfaces
        BaiduPushClient pushClient = new BaiduPushClient(pair,
                BaiduPushConstants.CHANNEL_REST_URL);

        // 3. register a YunLogHandler to get detail interacting information
        // in this request.
        pushClient.setChannelLogHandler(new YunLogHandler() {

            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });

        String params = "{\"title\":\"TEST\",\"description\":\"HelloBaidupush!\",\"timestamp\":\"2313123123\"}";

        try {
            // 4. specify request arguments
            PushMsgToAllRequest request = new PushMsgToAllRequest()
                    .addMsgExpires(new Integer(3600)).addMessageType(0)
                    .addMessage(params) //添加透传消息
//                    .addSendTime(System.currentTimeMillis() / 1000 + 120) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
                    .addDeviceType(3);
            // 5. http request
            PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
            // Http请求结果解析打印
            System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
                    + response.getSendTime() + ",timerId: "
                    + response.getTimerId());
        } catch (PushClientException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                System.out.println(String.format(
                        "requestId: %d, errorCode: %d, errorMessage: %s",
                        e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }

    }

    public static void pushToSingleDevice() throws PushClientException,PushServerException {
        // 1. get apiKey and secretKey from developer console
        PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

        // 2. build a BaidupushClient object to access released interfaces
        BaiduPushClient pushClient = new BaiduPushClient(pair,
                BaiduPushConstants.CHANNEL_REST_URL);

        // 3. register a YunLogHandler to get detail interacting information
        // in this request.
        pushClient.setChannelLogHandler(new YunLogHandler() {

            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });

        try {
            // 4. specify request arguments
            //创建 Android的通知
            JSONObject notification = new JSONObject();
            notification.put("title", "TEST");
            notification.put("description","Hello Baidu Push");
            notification.put("notification_builder_id", 0);
            notification.put("notification_basic_style", 4);
            notification.put("open_type", 1);
            notification.put("url", "http://push.baidu.com");
            JSONObject jsonCustormCont = new JSONObject();
            jsonCustormCont.put("key", "value"); //自定义内容，key-value
            notification.put("custom_content", jsonCustormCont);

            PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
                    .addChannelId(channelId)
                    .addMsgExpires(new Integer(3600)). // message有效时间
                    addMessageType(1).// 1：通知,0:透传消息. 默认为0 注：IOS只有通知.
                    addMessage(notification.toString()).
                            addDeviceType(3);// deviceType => 3:android, 4:ios
            // 5. http request
            PushMsgToSingleDeviceResponse response = pushClient
                    .pushMsgToSingleDevice(request);
            // Http请求结果解析打印
            System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
                    + response.getSendTime());
        } catch (PushClientException e) {
			/*
			 * ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,'true' 表示抛出, 'false' 表示捕获。
			 */
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                System.out.println(String.format(
                        "requestId: %d, errorCode: %d, errorMessage: %s",
                        e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }
    }
}
