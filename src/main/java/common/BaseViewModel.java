package common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BaseViewModel implements Serializable {


    @JsonProperty(Resource.KEY.KEY_DATA_GET_METHOD)
    public int mDataFrom;

    @JsonProperty(Resource.KEY.KEY_COURSE_ID)
    private String mCourseId;

    @JsonProperty(Resource.KEY.KEY_MODULE_ID)
    private int mModuleId;

    @JsonProperty(Resource.KEY.KEY_ACTION_ID)
    private int mActionId;

    @JsonProperty(Resource.KEY.KEY_TEACHER_ID)
    private String mTeacherId;

    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
    private String mStudentId;

    public int getmDataFrom() {
        return mDataFrom;
    }

    public void setmDataFrom(int mDataFrom) {
        this.mDataFrom = mDataFrom;
    }

    public String getmTeacherId() {
        return mTeacherId;
    }

    public void setmTeacherId(String mTeacherId) {
        this.mTeacherId = mTeacherId;
    }

    public String getmStudentId() {
        return mStudentId;
    }

    public void setmStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    public String getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public int getmModuleId() {
        return mModuleId;
    }

    public void setmModuleId(int mModuleId) {
        this.mModuleId = mModuleId;
    }

    public int getmActionId() {
        return mActionId;
    }

    public void setmActionId(int mActionId) {
        this.mActionId = mActionId;
    }
}