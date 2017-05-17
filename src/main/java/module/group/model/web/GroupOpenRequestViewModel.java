package module.group.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/8.
 */
public class GroupOpenRequestViewModel extends BaseViewModel{

    @JsonProperty(Resource.KEY.KEY_GROUP_MIN)
    private int min;

    @JsonProperty(Resource.KEY.KEY_GROUP_MAX)
    private int max;

    @JsonProperty(Resource.KEY.KEY_GROUP_OPEN_TIME)
    private String groupOpenTime;

    public String getGroupOpenTime() {
        return groupOpenTime;
    }

    public void setGroupOpenTime(String groupOpenTime) {
        this.groupOpenTime = groupOpenTime;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
