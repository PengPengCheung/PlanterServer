package test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import module.attendance.model.AttendanceInfo;
import module.attendance.model.AttendanceViewModel;
import utils.CommonUtil;
import utils.DataUtils;
import utils.TimeUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by peng on 2017/3/19.
 */
public class Test {

    public static void main(String[] args) {
//        testTimeToStr();

        testTimeTask("5:30");
//        testMin(2, 12,5);
//        testLongTime();
//        testStrToTime();

//        testObjToJson();

//        test("test", "value");

//        String str = TimeUtil.timeToStr(new Date(), "yyyy年MM月dd日 HH时mm分");
//        System.out.println("time to str: " + str);
//
//        Date date = TimeUtil.strToTime(str, "yyyy年MM月dd日 HH时mm分");
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
//        String time = sdf.format(date);
//        System.out.println("str to time: " + time);
    }

    private static void testTimeTask(String timeStr){

        TimeUtil.durationStrToMilliSeconds(timeStr);

//        Date date = TimeUtil.strToTime(timeStr, TimeUtil.ENG_PATTERN_YMD_HMS);
//        System.out.println(date.getTime());
//        TimeUtil.startTimeTask(3131);
    }



    private static void testMin(int x, int y, int z){
        int min = CommonUtil.getMinimumNum(x, y, z);
        System.out.println("min: " + min);
    }

    private static void testLongTime(){
        String timeStr = TimeUtil.getTimeText(7200 * 1000);
//        String timeStr = TimeUtil.getTimeFromMillisecond(3600 * 1000);
        System.out.println(timeStr);
    }

    private static void test(String key, String value){
        DataUtils.printData(key, value);
    }

    private static void testObjToJson(){
        ObjectMapper mapper = new ObjectMapper();
        AttendanceViewModel attendanceViewModel = new AttendanceViewModel();
//        attendanceViewModel.setmAbsenceCount(5);
        try {
            String pushJsonStr = mapper.writeValueAsString(attendanceViewModel);
            System.out.println(pushJsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void testStrToTime(){
        // 2017-04-01T06:40:38.459Z
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        java.util.Date time=null;
        try {
            time= sdf.parse(sdf.format(new Date()));
            String str = sdf.format(time);
            System.out.println("str to time: " + str);

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    public static void testTimeToStr(){
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String timeStr = formatter.format(d);
        System.out.println("time: " + timeStr);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        System.out.println("calendar time: " + year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);
    }

}
