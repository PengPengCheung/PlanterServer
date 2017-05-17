package module.frame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;
import module.attendance.model.AttendanceViewModel;
import module.attention.model.AttentionViewModel;
import module.homework.model.HomeworkViewModel;
import module.summary.model.mob.SummaryViewModel;

import java.util.List;

public class FrameCourseAllMsgViewModel extends BaseViewModel {

    @JsonProperty(Resource.Module.MODULE_COURSE_ATTENDANCE_NAME)
    private List<AttendanceViewModel> mAttendanceList;

    @JsonProperty(Resource.Module.MODULE_COURSE_ATTENTION_NAME)
    private List<AttentionViewModel> mAttentionList;

    @JsonProperty(Resource.Module.MODULE_COURSE_SUMMARY_NAME)
    private List<SummaryViewModel> mSummaryList;

    @JsonProperty(Resource.Module.MODULE_COURSE_HOMEWORK_NAME)
    private List<HomeworkViewModel> mHomeworkList;

    public List<AttendanceViewModel> getmAttendanceList() {
        return mAttendanceList;
    }

    public void setmAttendanceList(List<AttendanceViewModel> mAttendanceList) {
        this.mAttendanceList = mAttendanceList;
    }

    public List<AttentionViewModel> getmAttentionList() {
        return mAttentionList;
    }

    public void setmAttentionList(List<AttentionViewModel> mAttentionList) {
        this.mAttentionList = mAttentionList;
    }

    public List<SummaryViewModel> getmSummaryList() {
        return mSummaryList;
    }

    public void setmSummaryList(List<SummaryViewModel> mSummaryList) {
        this.mSummaryList = mSummaryList;
    }

    public List<HomeworkViewModel> getmHomeworkList() {
        return mHomeworkList;
    }

    public void setmHomeworkList(List<HomeworkViewModel> mHomeworkList) {
        this.mHomeworkList = mHomeworkList;
    }
}