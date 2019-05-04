package com.cyt.graduation_project.business.entry.role;

import com.cyt.graduation_project.business.entry.menu.Supmenu;

import java.util.List;

public class Role {
    private int roleId;
    private String roleName;
    private List<Supmenu> supmenuList;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", supmenuList=" + supmenuList +
                '}';
    }

    public Role(int roleId, String roleName, List<Supmenu> supmenuList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.supmenuList = supmenuList;
    }

    public List<Supmenu> getSupmenuList() {
        return supmenuList;
    }

    public void setSupmenuList(List<Supmenu> supmenuList) {
        this.supmenuList = supmenuList;
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
