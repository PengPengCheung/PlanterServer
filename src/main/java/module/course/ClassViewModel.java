package module.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/3/27.
 */
public class ClassViewModel extends BaseViewModel{


    @JsonProperty(Resource.KEY.KEY_CLASS_OPEN_TIME)
    private String classBeginTime;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_CODE)
    private String attendanceCode;

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public String getClassBeginTime() {
        return classBeginTime;
    }

    public void setClassBeginTime(String classBeginTime) {
        this.classBeginTime = classBeginTime;
    }
}

