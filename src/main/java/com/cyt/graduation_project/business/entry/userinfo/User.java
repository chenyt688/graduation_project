package com.cyt.graduation_project.business.entry.userinfo;

public class User {
    private int userId;
    private String userAccount;
    private String userPassword;
    private String userName;
    private int roleId;
    private int userGender;
    private String userIdentityType;
    private String userIdentityData;
    private String userImgUrl;
    private String userPhone;
    private String userBirth;
    private String userAddress;
    private String userEmail;
    private String userRegistrationTime;
    private int delFlag;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", roleId=" + roleId +
                ", userGender=" + userGender +
                ", userIdentityType='" + userIdentityType + '\'' +
                ", userIdentityData='" + userIdentityData + '\'' +
                ", userImgUrl='" + userImgUrl + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRegistrationTime='" + userRegistrationTime + '\'' +
                ", delFlag=" + delFlag +
                '}';
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getUserIdentityType() {
        return userIdentityType;
    }

    public void setUserIdentityType(String userIdentityType) {
        this.userIdentityType = userIdentityType;
    }

    public String getUserIdentityData() {
        return userIdentityData;
    }

    public void setUserIdentityData(String userIdentityData) {
        this.userIdentityData = userIdentityData;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRegistrationTime() {
        return userRegistrationTime;
    }

    public void setUserRegistrationTime(String userRegistrationTime) {
        this.userRegistrationTime = userRegistrationTime;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public User(int userId, String userAccount, String userPassword, String userName, int roleId, int userGender, String userIdentityType, String userIdentityData, String userImgUrl, String userPhone, String userBirth, String userAddress, String userEmail, String userRegistrationTime, int delFlag) {

        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.roleId = roleId;
        this.userGender = userGender;
        this.userIdentityType = userIdentityType;
        this.userIdentityData = userIdentityData;
        this.userImgUrl = userImgUrl;
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userRegistrationTime = userRegistrationTime;
        this.delFlag = delFlag;
    }

    public User() {

    }
}
