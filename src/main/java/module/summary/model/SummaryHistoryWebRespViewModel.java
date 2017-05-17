package module.summary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/1.
 */
public class SummaryHistoryWebRespViewModel extends BaseViewModel{


    @JsonProperty(Resource.KEY.KEY_STU_NAME)
    private String studentName;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_CONTENT)
    private String summaryContent;

    @JsonProperty(Resource.KEY.KEY_SUMMARY_RESPONSE_RESULT)
    private int summaryResult;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSummaryContent() {
        return summaryContent;
    }

    public void setSummaryContent(String summaryContent) {
        this.summaryContent = summaryContent;
    }

    public int getSummaryResult() {
        return summaryResult;
    }

    public void setSummaryResult(int summaryResult) {
        this.summaryResult = summaryResult;
    }
}
