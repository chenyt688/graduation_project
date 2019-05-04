package com.cyt.graduation_project.business.entry.userinfo;

public class UserResume {
    private int userId;
    private String userCareer;
    private String educationLevel;
    private String targetSubjectName;
    private String secondSubjectName;
    private String education;        //教育经历
    private String honor;
    private String hobby;
    private String experience;
    private String selfIntroduction;
    private int adjustment;          //是否接受调剂
    private int delFlag;

    public UserResume(int userId, String userCareer, String educationLevel, String targetSubjectName, String secondSubjectName, String education, String honor, String hobby, String experience, String selfIntroduction, int adjustment, int delFlag) {
        this.userId = userId;
        this.userCareer = userCareer;
        this.educationLevel = educationLevel;
        this.targetSubjectName = targetSubjectName;
        this.secondSubjectName = secondSubjectName;
        this.education = education;
        this.honor = honor;
        this.hobby = hobby;
        this.experience = experience;
        this.selfIntroduction = selfIntroduction;
        this.adjustment = adjustment;
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "UserResume{" +
                "userId=" + userId +
                ", userCareer='" + userCareer + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", targetSubjectName='" + targetSubjectName + '\'' +
                ", secondSubjectName='" + secondSubjectName + '\'' +
                ", education='" + education + '\'' +
                ", honor='" + honor + '\'' +
                ", hobby='" + hobby + '\'' +
                ", experience='" + experience + '\'' +
                ", selfIntroduction='" + selfIntroduction + '\'' +
                ", adjustment=" + adjustment +
                ", delFlag=" + delFlag +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCareer() {
        return userCareer;
    }

    public void setUserCareer(String userCareer) {
        this.userCareer = userCareer;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getTargetSubjectName() {
        return targetSubjectName;
    }

    public void setTargetSubjectName(String targetSubjectName) {
        this.targetSubjectName = targetSubjectName;
    }

    public String getSecondSubjectName() {
        return secondSubjectName;
    }

    public void setSecondSubjectName(String secondSubjectName) {
        this.secondSubjectName = secondSubjectName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public int getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(int adjustment) {
        this.adjustment = adjustment;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public UserResume() {

    }
}
