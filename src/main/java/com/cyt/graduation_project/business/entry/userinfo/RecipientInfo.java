package com.cyt.graduation_project.business.entry.userinfo;

public class RecipientInfo {
    private int recipientId;
    private int userId;
    private String userName;
    private String userIdCard;
    private String userPhone;
    private String userImgUrl;
    private String applicationTime;
    private String passTime;
    private String startTime;
    private String endTime;
    private String familyStatus;        //家庭状况
    private String proveImgUrl;          //个人申请书
    private String selfAccBookImgUrl;   //个人户口页
    private String villageLetterImgUrl; //村级证明信
    private String townProveImgUrl;     //乡级证明
    private String studentListImgUrl;   //学籍表
    private String qrcodeUrl;           //二维码
    private String reviewStatus;        //1表示报名 2表示审核成功  3表示审核失败
    private int delFlag;

    public RecipientInfo(int recipientId, int userId, String userName, String userIdCard, String userPhone, String userImgUrl, String applicationTime, String passTime, String startTime, String endTime, String familyStatus, String proveImgUrl, String selfAccBookImgUrl, String villageLetterImgUrl, String townProveImgUrl, String studentListImgUrl, String qrcodeUrl, String reviewStatus, int delFlag) {
        this.recipientId = recipientId;
        this.userId = userId;
        this.userName = userName;
        this.userIdCard = userIdCard;
        this.userPhone = userPhone;
        this.userImgUrl = userImgUrl;
        this.applicationTime = applicationTime;
        this.passTime = passTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.familyStatus = familyStatus;
        this.proveImgUrl = proveImgUrl;
        this.selfAccBookImgUrl = selfAccBookImgUrl;
        this.villageLetterImgUrl = villageLetterImgUrl;
        this.townProveImgUrl = townProveImgUrl;
        this.studentListImgUrl = studentListImgUrl;
        this.qrcodeUrl = qrcodeUrl;
        this.reviewStatus = reviewStatus;
        this.delFlag = delFlag;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getProveImgUrl() {
        return proveImgUrl;
    }

    public void setProveImgUrl(String provImgUrl) {
        this.proveImgUrl = provImgUrl;
    }

    public String getSelfAccBookImgUrl() {
        return selfAccBookImgUrl;
    }

    public void setSelfAccBookImgUrl(String selfAccBookImgUrl) {
        this.selfAccBookImgUrl = selfAccBookImgUrl;
    }

    public String getVillageLetterImgUrl() {
        return villageLetterImgUrl;
    }

    public void setVillageLetterImgUrl(String villageLetterImgUrl) {
        this.villageLetterImgUrl = villageLetterImgUrl;
    }

    public String getTownProveImgUrl() {
        return townProveImgUrl;
    }

    public void setTownProveImgUrl(String townProveImgUrl) {
        this.townProveImgUrl = townProveImgUrl;
    }

    public String getStudentListImgUrl() {
        return studentListImgUrl;
    }

    public void setStudentListImgUrl(String studentListImgUrl) {
        this.studentListImgUrl = studentListImgUrl;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public RecipientInfo() {

    }
}
