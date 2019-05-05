package com.cyt.graduation_project.business.entry.userinfo;

public class ParticipantsInfo {
    private int id;
    private int userId;
    private int activityId;
    private String applyTime;
    private String passTime;  //审核时间
    private String auditor;   //审核人
    private int reviewStatus; // 1表示报名 2 表示审核成功 3表示上岗中 4 表示活动结束

    @Override
    public String toString() {
        return "ParticipantsInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", activityId=" + activityId +
                ", applyTime='" + applyTime + '\'' +
                ", passTime='" + passTime + '\'' +
                ", auditor='" + auditor + '\'' +
                ", reviewStatus=" + reviewStatus +
                '}';
    }

    public ParticipantsInfo() {
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

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
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

    public ParticipantsInfo(int id, int userId, int activityId, String applyTime, String passTime, String auditor, int reviewStatus) {

        this.id = id;
        this.userId = userId;
        this.activityId = activityId;
        this.applyTime = applyTime;
        this.passTime = passTime;
        this.auditor = auditor;
        this.reviewStatus = reviewStatus;
    }
}
