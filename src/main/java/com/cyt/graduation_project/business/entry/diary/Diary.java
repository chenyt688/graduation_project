package com.cyt.graduation_project.business.entry.diary;

public class Diary {
    private int diaryId;
    private int userId;
    private String userAccount;
    private String userName;
    private String diaryTime;
    private String weekday;
    private String diaryAddress;
    private String weather;
    private String diaryTopic;
    private String diaryContent;
    private int diaryShow;
    private int delFlag;


    public Diary(int diaryId, int userId, String userAccount, String userName, String diaryTime, String weekday, String diaryAddress, String weather, String diaryTopic, String diaryContent, int diaryShow, int delFlag) {
        this.diaryId = diaryId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userName = userName;
        this.diaryTime = diaryTime;
        this.weekday = weekday;
        this.diaryAddress = diaryAddress;
        this.weather = weather;
        this.diaryTopic = diaryTopic;
        this.diaryContent = diaryContent;
        this.diaryShow = diaryShow;
        this.delFlag = delFlag;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }

    public String getDiaryTime() {
        return diaryTime;
    }

    public void setDiaryTime(String diaryTime) {
        this.diaryTime = diaryTime;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getDiaryAddress() {
        return diaryAddress;
    }

    public void setDiaryAddress(String diaryAddress) {
        this.diaryAddress = diaryAddress;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDiaryTopic() {
        return diaryTopic;
    }

    public void setDiaryTopic(String diaryTopic) {
        this.diaryTopic = diaryTopic;
    }

    public String getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(String diaryContent) {
        this.diaryContent = diaryContent;
    }

    public int getDiaryShow() {
        return diaryShow;
    }

    public void setDiaryShow(int diaryShow) {
        this.diaryShow = diaryShow;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public Diary() {

    }
}
