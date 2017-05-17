package module.attendance;

/**
 * Created by peng on 2017/3/16.
 */
public class AttendanceCodeGenerator {

//    public AttendanceCodeGenerator(){
//
//    }

    public static String generateAttendanceCode(){
        double originCode = Math.random() * 9 + 1;
        int code = (int)(originCode*100000);
        return String.valueOf(code);
    }

}
