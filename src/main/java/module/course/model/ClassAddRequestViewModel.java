package module.course.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/29.
 */
public class ClassAddRequestViewModel {


    @JsonProperty(Resource.KEY.KEY_COURSE_CODE)
    private String courseCode; // 判断数据库中是否存在该课程码，若存在则找到对应的数据项进行修改，若不存在则新建一个数据项

    @JsonProperty(Resource.KEY.KEY_TEACHER_ID)
    private String teacherId;

    @JsonProperty(Resource.KEY.KEY_COURSE_NAME)
    private String courseName;

    @JsonProperty(Resource.KEY.KEY_COURSE_DATE)
    private String courseDate; // 记录星期几

    @JsonProperty(Resource.KEY.KEY_COURSE_TIME)
    private String courseTime; // 记录开课的时间点，格式为 12:20

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
}
