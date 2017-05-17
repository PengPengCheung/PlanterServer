package module.group.model.mob;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/26.
 */

public class GroupPushViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_TEACHER_OPEN_GROUP_ID)
    private String mTeacherGroupOpenId;

    @JsonProperty(Resource.KEY.KEY_GROUP_PUSH_TYPE)
    private int mPushType;

    @JsonProperty(Resource.KEY.KEY_GROUP_OPEN_TIME)
    private String mGroupOpenTime;

    @JsonProperty(Resource.KEY.KEY_GROUP_LIMIT)
    private String mGroupLimit;

    public String getmTeacherGroupOpenId() {
        return mTeacherGroupOpenId;
    }

    public void setmTeacherGroupOpenId(String mTeacherGroupOpenId) {
        this.mTeacherGroupOpenId = mTeacherGroupOpenId;
    }

    public int getmPushType() {
        return mPushType;
    }

    public void setmPushType(int mPushType) {
        this.mPushType = mPushType;
    }

    public String getmGroupOpenTime() {
        return mGroupOpenTime;
    }

    public void setmGroupOpenTime(String mGroupOpenTime) {
        this.mGroupOpenTime = mGroupOpenTime;
    }

    public String getmGroupLimit() {
        return mGroupLimit;
    }

    public void setmGroupLimit(String mGroupLimit) {
        this.mGroupLimit = mGroupLimit;
    }
}
