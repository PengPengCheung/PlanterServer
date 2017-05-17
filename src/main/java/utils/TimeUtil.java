package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by peng on 2017/3/19.
 */
public class TimeUtil {

    public static final String ATTENDANCE_TIME_LIMIT_STR = "5:00";



    public static final String CHN_PATTERN_YMD_HMS = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String CHN_PATTERN_YMD_HM = "yyyy年MM月dd日 HH时mm分";
    public static final String ENG_PATTERN_MS = "mm:ss";
    public static final String ENG_PATTERN_YMD = "yyyy-MM-dd";
    public static final String ENG_PATTERN_YMD_HM = "yyy/MM/dd HH:mm";
    public static final String ENG_PATTERN_YMD_HMS = "yyy/MM/dd HH:mm:ss";
    public static final int COUNT_DOWN_TIME_IN_MILLISECONDS = 10000;

    //"yyyy年MM月dd日 HH时mm分ss秒"
    public static String timeToStr(Date date, String pattern){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String timeStr = formatter.format(date);
        System.out.println("time: " + timeStr);
        return timeStr;
    }

    //"yyyy年MM月dd日 HH时mm分"
    public static Date strToTime(String timeStr, String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        java.util.Date time=null;
        try {
            time= sdf.parse(timeStr);
            return time;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    public static int durationStrToMilliSeconds(String duration){
        String[] durations = duration.split(":");
        int total = 0;
        if(durations.length > 1){
            int min = Integer.parseInt(durations[0]);
            int second = Integer.parseInt(durations[1]);
            int minToMilli = minutesToMilliSeconds(min);
            int secToMilli = secondsToMilliSeconds(second);
            System.out.println("minutes: " + minToMilli + ", seconds: " + secToMilli);
            total = minToMilli + secToMilli;
        }

        System.out.println("total: " + total);
        return total;

    }

    private static int minutesToMilliSeconds(int minutes){
        if(minutes > 0){
            return minutes * secondsToMilliSeconds(60);
        }

        return 0;
    }

    private static int secondsToMilliSeconds(int seconds){
        if(seconds >= 0){
            return seconds * 1000;
        }

        return 0;
    }


    public static void startTimeTask(final int countDownTimeInMilliSeconds, final CountDownListener listener){
        final Timer timer = new Timer();

        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                CommonUtil.printLog("time: " + countDownTimeInMilliSeconds);
                timer.cancel();
                if(listener != null){
                    listener.onCountDownEnd();
                }

            }
        };

        timer.schedule(timerTask, countDownTimeInMilliSeconds);
    }

    /**
     * 从时间(毫秒)中提取出时间(时:分)
     * 时间格式:  时:分
     *
     * @param millisecond
     * @return
     */
    public static String getTimeFromMillisecond(long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        Date date = new Date(millisecond);
        String timeStr = simpleDateFormat.format(date);
        return timeStr;
    }


    /**
     *
     * @param 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author fy.zhang
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " days " + hours + " hours " + minutes + " minutes "
                + seconds + " seconds ";
    }


    /**
     * 传入的time参数单位为milliseconds，即毫秒.这个方法可以将毫秒单位的时间转换为0：00形式的时间
     *
     * @param time 传入的时间长度，单位为milliseconds，即毫秒
     * @return 返回00：00形式的时间字符串
     */
    public static String getTimeText(int time) {
        if (time < 0) {
            return "time wrong";
        }

        int totalSeconds = time / 1000;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        String showTime;
        if (seconds > 9 && seconds < 60) {
            showTime = minutes + ":" + seconds;
        } else {
            showTime = minutes + ":0" + seconds;
        }
        return showTime;
    }

}
