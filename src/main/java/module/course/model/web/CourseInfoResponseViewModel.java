package module.course.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

import java.util.List;

/**
 * Created by peng on 2017/3/29.
 */

// 用于前端显示课程列表
public class CourseInfoResponseViewModel {


    @JsonProperty(Resource.KEY.KEY_COURSE_ID)
    private String courseId;

    @JsonProperty(Resource.KEY.KEY_COURSE_CODE)
    private String courseCode; // 对应该门课程的课程码

    @JsonProperty(Resource.KEY.KEY_COURSE_NAME)
    private String courseName;

    @JsonProperty(Resource.KEY.KEY_COURSE_OPEN_COUNT)
    private int classOpenCount;

    @JsonProperty(Resource.KEY.KEY_COURSE_OPEN_TIME)
    private List<String> courseTimeList;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getClassOpenCount() {
        return classOpenCount;
    }

    public void setClassOpenCount(int classOpenCount) {
        this.classOpenCount = classOpenCount;
    }

    public List<String> getCourseTimeList() {
        return courseTimeList;
    }

    public void setCourseTimeList(List<String> courseTimeList) {
        this.courseTimeList = courseTimeList;
    }
}
