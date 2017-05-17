package module.summary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/7.
 */
public class SummaryAttendanceMixWebViewModel extends BaseViewModel{

    @JsonProperty(Resource.KEY.KEY_COURSE_TIMES)
    private String courseSequence;

    @JsonProperty(Resource.KEY.KEY_COURSE_OPEN_TIME_IN_YMD)
    private String courseOpenDate;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ATT_COUNT)
    private int attendanceCount;

    @JsonProperty(Resource.KEY.KEY_ATTENDANCE_ABS_COUNT)
    private int absenceCount;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_WEB_HANDLE_STATUS)
    private int summaryStatus;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_WEB_NEW_FILES)
    private int summaryNewFiles;


    public String getCourseSequence() {
        return courseSequence;
    }

    public void setCourseSequence(String courseSequence) {
        this.courseSequence = courseSequence;
    }

    public String getCourseOpenDate() {
        return courseOpenDate;
    }

    public void setCourseOpenDate(String courseOpenDate) {
        this.courseOpenDate = courseOpenDate;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public int getAbsenceCount() {
        return absenceCount;
    }

    public void setAbsenceCount(int absenceCount) {
        this.absenceCount = absenceCount;
    }

    public int getSummaryStatus() {
        return summaryStatus;
    }

    public void setSummaryStatus(int summaryStatus) {
        this.summaryStatus = summaryStatus;
    }

    public int getSummaryNewFiles() {
        return summaryNewFiles;
    }

    public void setSummaryNewFiles(int summaryNewFiles) {
        this.summaryNewFiles = summaryNewFiles;
    }
}
