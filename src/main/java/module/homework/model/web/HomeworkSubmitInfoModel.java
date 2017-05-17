package module.homework.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/9.
 */
public class HomeworkSubmitInfoModel {


    @JsonProperty(Resource.KEY.KEY_STUDENT_ID)
    private String studentId;

    @JsonProperty(Resource.KEY.KEY_COURSE_ID)
    private String courseId;

//    @JsonProperty(Resource.KEY.KEY_HOMEWORK_ID)
//    private String homeworkId;

    @JsonProperty(Resource.KEY.KEY_STU_NAME)
    private String studentName;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_ID)
    private String homeworkSubmitId; // 区别于教师发布的作业id，这里指的是学生提交的作业id

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_ID)
    private String homeworkTeacherPublishedId;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_NAME)
    private String homeworkSubmitName;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_DOWNLOAD_URL)
    private String homeworkDownloadURL;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SCORE)
    private int homeworkScore;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_SUBMIT_TEACHER_SCORE_STATUS)
    private int homeworkScoreStatus;

    @JsonProperty(Resource.KEY.KEY_HOMEWORK_STUDENT_SUBMIT_TIME)
    private String homeworkSubmitTime;

//    public String getHomeworkId() {
//        return homeworkId;
//    }
//
//    public void setHomeworkId(String homeworkId) {
//        this.homeworkId = homeworkId;
//    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getHomeworkTeacherPublishedId() {
        return homeworkTeacherPublishedId;
    }

    public void setHomeworkTeacherPublishedId(String homeworkTeacherPublishedId) {
        this.homeworkTeacherPublishedId = homeworkTeacherPublishedId;
    }

    public int getHomeworkScoreStatus() {
        return homeworkScoreStatus;
    }

    public void setHomeworkScoreStatus(int homeworkScoreStatus) {
        this.homeworkScoreStatus = homeworkScoreStatus;
    }

    public String getHomeworkSubmitTime() {
        return homeworkSubmitTime;
    }

    public void setHomeworkSubmitTime(String homeworkSubmitTime) {
        this.homeworkSubmitTime = homeworkSubmitTime;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getHomeworkSubmitId() {
        return homeworkSubmitId;
    }

    public void setHomeworkSubmitId(String homeworkSubmitId) {
        this.homeworkSubmitId = homeworkSubmitId;
    }

    public String getHomeworkSubmitName() {
        return homeworkSubmitName;
    }

    public void setHomeworkSubmitName(String homeworkSubmitName) {
        this.homeworkSubmitName = homeworkSubmitName;
    }

    public String getHomeworkDownloadURL() {
        return homeworkDownloadURL;
    }

    public void setHomeworkDownloadURL(String homeworkDownloadURL) {
        this.homeworkDownloadURL = homeworkDownloadURL;
    }

    public int getHomeworkScore() {
        return homeworkScore;
    }

    public void setHomeworkScore(int homeworkScore) {
        this.homeworkScore = homeworkScore;
    }
}
