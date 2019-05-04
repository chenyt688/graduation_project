package com.cyt.graduation_project.business.entry.menu;

public class Basemenu {
    private int basisMenuId;
    private String basisMenuName;

    @Override
    public String toString() {
        return "Basemenu{" +
                "basisMenuId=" + basisMenuId +
                ", basisMenuName='" + basisMenuName + '\'' +
                '}';
    }

    public int getBasisMenuId() {
        return basisMenuId;
    }

    public void setBasisMenuId(int basisMenuId) {
        this.basisMenuId = basisMenuId;
    }

    public String getBasisMenuName() {
        return basisMenuName;
    }

    public void setBasisMenuName(String basisMenuName) {
        this.basisMenuName = basisMenuName;
    }

    public Basemenu(int basisMenuId, String basisMenuName) {

        this.basisMenuId = basisMenuId;
        this.basisMenuName = basisMenuName;
    }

    public Basemenu() {

    }
}
