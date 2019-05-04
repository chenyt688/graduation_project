package com.cyt.graduation_project.business.entry.userinfo;

public class UserStatus {
    private int userId;
    private int userStatus;   //0表示离线 ，1表示已登录在线，2表示用户注销

    @Override
    public String toString() {
        return "UserStatus{" +
                "userId=" + userId +
                ", userStatus=" + userStatus +
                '}';
    }

    public UserStatus() {
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public UserStatus(int userId, int userStatus) {

        this.userId = userId;
        this.userStatus = userStatus;
    }
}
