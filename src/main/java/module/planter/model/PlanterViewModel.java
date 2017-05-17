package module.planter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

public class PlanterViewModel extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_PLANTER_STATUS)
    private int mPlanterStatus;

    @JsonProperty(Resource.KEY.KEY_COURSE_NAME)
    private String mCourseName;

    @JsonProperty(Resource.KEY.KEY_COURSE_TIME)
    private String mCourseTime;

    @JsonProperty(Resource.KEY.KEY_PLANTER_USED_SUNSHINE)
    private int mPlanterSunshine;

    @JsonProperty(Resource.KEY.KEY_PLANTER_USED_WATER)
    private int mPlanterWater;

    @JsonProperty(Resource.KEY.KEY_PLANTER_USED_SOIL)
    private int mPlanterSoil;

    @JsonProperty(Resource.KEY.KEY_PLANTER_PERCENTAGE)
    private int mPlanterPercent;

    public int getmPlanterStatus() {
        return mPlanterStatus;
    }

    public void setmPlanterStatus(int mPlanterStatus) {
        this.mPlanterStatus = mPlanterStatus;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmCourseTime() {
        return mCourseTime;
    }

    public void setmCourseTime(String mCourseTime) {
        this.mCourseTime = mCourseTime;
    }

    public int getmPlanterSunshine() {
        return mPlanterSunshine;
    }

    public void setmPlanterSunshine(int mPlanterSunshine) {
        this.mPlanterSunshine = mPlanterSunshine;
    }

    public int getmPlanterWater() {
        return mPlanterWater;
    }

    public void setmPlanterWater(int mPlanterWater) {
        this.mPlanterWater = mPlanterWater;
    }

    public int getmPlanterSoil() {
        return mPlanterSoil;
    }

    public void setmPlanterSoil(int mPlanterSoil) {
        this.mPlanterSoil = mPlanterSoil;
    }

    public int getmPlanterPercent() {
        return mPlanterPercent;
    }

    public void setmPlanterPercent(int mPlanterPercent) {
        this.mPlanterPercent = mPlanterPercent;
    }
}