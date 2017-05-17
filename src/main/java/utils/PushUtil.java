package utils;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Resource;

/**
 * Created by peng on 2017/3/16.
 */
public class PushUtil {

    private static String MSG_CONTENT = "PushUtil Test";

    public static final int PUSH_TYPE_NOTIFICATION = 0;
    public static final int PUSH_TYPE_MESSAGE = 1;
    public static final int PUSH_TYPE_NOTIFICATION_AND_MESSAGE = 2;



    public static void pushToMobDevices(Object model, String notification){
        String pushJsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            pushJsonStr = mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

//        PushUtil.push(Resource.Notification.ATTENDANCE_CHECK_NOTIFICATION, PushUtil.PUSH_TYPE_NOTIFICATION);

        PushUtil.pushMessageAndNotification(pushJsonStr, notification);
    }

    public static void push(String notificationOrMessage, int type){
        if(type != PUSH_TYPE_NOTIFICATION && type != PUSH_TYPE_MESSAGE) {
            return;
        }

        JPushClient jpushClient = new JPushClient(Resource.JPUSH_MASTER_SECRET, Resource.JPUSH_APP_KEY, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject(notificationOrMessage, type);

        send(jpushClient, payload);


    }

    private static void send(JPushClient jpushClient, PushPayload payload){
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("result = "+result);
        } catch (APIConnectionException e) {
            System.out.println("APIConnectionException: " + e.toString());
            // Connection error, should retry later
//            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            System.out.println("APIRequestException: " + e.toString());
        }
    }

    public static void pushMessageAndNotification(String message, String notification){
        JPushClient jpushClient = new JPushClient(Resource.JPUSH_MASTER_SECRET, Resource.JPUSH_APP_KEY, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject(notification, message);

        send(jpushClient, payload);
    }

    private static PushPayload buildPushObject(String msg, int type) {
        PushPayload pushPayload = null;

        switch (type) {
            case PUSH_TYPE_NOTIFICATION:{
                pushPayload = PushPayload.newBuilder()
                        .setPlatform(Platform.android())
                        .setAudience(Audience.alias(Resource.JPUSH_ALIAS))
                        .setNotification(Notification.android(msg, "", null))
                        .build();
            }
            break;
            case PUSH_TYPE_MESSAGE:{
                pushPayload = PushPayload.newBuilder()
                        .setPlatform(Platform.android_ios())
                        .setAudience(Audience.newBuilder()
//                        .addAudienceTarget(AudienceTarget.tag(Resource.JPUSH_ALIAS))
                                .addAudienceTarget(AudienceTarget.alias(Resource.JPUSH_ALIAS))
                                .build())
                        .setMessage(Message.newBuilder()
                                .setMsgContent(msg)
                                .build())
                        .build();
            }
            break;
        }


        return pushPayload;
    }

    private static PushPayload buildPushObject(String notificationStr, String msg) {
//        return PushPayload.alertAll(notifyMessage);
//        return PushPayload.messageAll(MSG_CONTENT);
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
//                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
                        .addAudienceTarget(AudienceTarget.alias(Resource.JPUSH_ALIAS))
                        .build())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setAlert(notificationStr)
//                                .addExtra("from", "JPush")
                                .build())
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(msg)
//                        .addExtra("peng", "Server")
                        .build())
                .build();
    }



    public static void main(String[] args) throws PushClientException,PushServerException {
//        push();
//        pushToSingleDevice();
//            JPushTest();
//        goEasyPushTest();
//        push("hello", "new Notification");
//        push("push Notification", PUSH_TYPE_NOTIFICATION);
    }


}
