package com.cyt.graduation_project.business.entry.activity;

public class ActivityInfo {
    private int activityId;
    private int userId;                 //发起人
    private String activityAddress;
    private String applicationTime;
    private String passTime;
    private String activityStartTime;
    private String activityEndTime;
    private String topic;
    private String imgUrl;
    private int demandNum;
    private String organizationProfiles;//组织简介
    private String workContent;         //工作内容
    private String treatmentGain;       //收获待遇
    private String conditions;          //报名条件
    private String contactInfo;
    private int reviewStatus;           //审核状态  0表示待审核  1表示已审核 2表示发布 3表示审核不通过 4表示结束
    private int delFlag;
    private String provinceName;

    public ActivityInfo() {
    }

    public ActivityInfo(int activityId, int userId, String activityAddress, String applicationTime, String passTime, String activityStartTime, String activityEndTime, String topic, String imgUrl, int demandNum, String organizationProfiles, String workContent, String treatmentGain, String conditions, String contactInfo, int reviewStatus, int delFlag, String provinceName) {
        this.activityId = activityId;
        this.userId = userId;
        this.activityAddress = activityAddress;
        this.applicationTime = applicationTime;
        this.passTime = passTime;
        this.activityStartTime = activityStartTime;
        this.activityEndTime = activityEndTime;
        this.topic = topic;
        this.imgUrl = imgUrl;
        this.demandNum = demandNum;
        this.organizationProfiles = organizationProfiles;
        this.workContent = workContent;
        this.treatmentGain = treatmentGain;
        this.conditions = conditions;
        this.contactInfo = contactInfo;
        this.reviewStatus = reviewStatus;
        this.delFlag = delFlag;
        this.provinceName = provinceName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getActivityId() {

        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getPassTime() {
        return passTime;
    }

    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getDemandNum() {
        return demandNum;
    }

    public void setDemandNum(int demandNum) {
        this.demandNum = demandNum;
    }

    public String getOrganizationProfiles() {
        return organizationProfiles;
    }

    public void setOrganizationProfiles(String organizationProfiles) {
        this.organizationProfiles = organizationProfiles;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getTreatmentGain() {
        return treatmentGain;
    }

    public void setTreatmentGain(String treatmentGain) {
        this.treatmentGain = treatmentGain;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(int reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
