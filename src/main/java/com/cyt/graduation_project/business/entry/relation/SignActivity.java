package com.cyt.graduation_project.business.entry.relation;

public class SignActivity {
    private int id;
    private int userId;
    private String userAccount;
    private int activityId;
    private String activityTopic;
    private int demandNum;
    private String provinceName;
    private String applyTime;
    private String passTime;  //审核时间
    private String auditor;   //审核人
    private int reviewStatus; // 1表示报名 2 表示审核成功 3表示上岗中 4 表示活动结束

    public SignActivity() {
    }

    public SignActivity(int id, int userId, String userAccount, int activityId, String activityTopic, int demandNum, String provinceName, String applyTime, String passTime, String auditor, int reviewStatus) {

        this.id = id;
        this.userId = userId;
        this.userAccount = userAccount;
        this.activityId = activityId;
        this.activityTopic = activityTopic;
        this.demandNum = demandNum;
        this.provinceName = provinceName;
        this.applyTime = applyTime;
        this.passTime = passTime;
        this.auditor = auditor;
        this.reviewStatus = reviewStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityTopic() {
        return activityTopic;
    }

    public void setActivityTopic(String activityTopic) {
        this.activityTopic = activityTopic;
    }

    public int getDemandNum() {
        return demandNum;
    }

    public void setDemandNum(int demandNum) {
        this.demandNum = demandNum;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getPassTime() {
        return passTime;
    }

    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public int getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(int reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
}
