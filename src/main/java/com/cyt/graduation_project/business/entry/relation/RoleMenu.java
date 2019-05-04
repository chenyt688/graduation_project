package com.cyt.graduation_project.business.entry.relation;

public class RoleMenu {
    private int roleId;
    private String supmenuId;

    public RoleMenu(int roleId, String supmenuId) {
        this.roleId = roleId;
        this.supmenuId = supmenuId;
    }

    public RoleMenu() {

    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "roleId=" + roleId +
                ", supmenuId='" + supmenuId + '\'' +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getSupmenuId() {
        return supmenuId;
    }

    public void setSupmenuId(String supmenuId) {
        this.supmenuId = supmenuId;
    }
}
