package com.cyt.graduation_project.business.entry.relation;

public class UserRole {
    private int userId;
    private int roleId;

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }

    public UserRole() {
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public UserRole(int userId, int roleId) {

        this.userId = userId;
        this.roleId = roleId;
    }
}
