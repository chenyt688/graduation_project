package com.cyt.graduation_project.business.entry.menu;

public class Supmenu {
    private int basisMenuId;
    private int supmenuId;
    private String supmenuName;
    private String supmenuUrl;

    @Override
    public String toString() {
        return "Supmenu{" +
                "basisMenuId=" + basisMenuId +
                ", supmenuId=" + supmenuId +
                ", supmenuName='" + supmenuName + '\'' +
                ", supmenuUrl='" + supmenuUrl + '\'' +
                '}';
    }

    public int getBasisMenuId() {
        return basisMenuId;
    }

    public void setBasisMenuId(int basisMenuId) {
        this.basisMenuId = basisMenuId;
    }

    public int getSupmenuId() {
        return supmenuId;
    }

    public void setSupmenuId(int supmenuId) {
        this.supmenuId = supmenuId;
    }

    public String getSupmenuName() {
        return supmenuName;
    }

    public void setSupmenuName(String supmenuName) {
        this.supmenuName = supmenuName;
    }

    public String getSupmenuUrl() {
        return supmenuUrl;
    }

    public void setSupmenuUrl(String supmenuUrl) {
        this.supmenuUrl = supmenuUrl;
    }

    public Supmenu(int basisMenuId, int supmenuId, String supmenuName, String supmenuUrl) {

        this.basisMenuId = basisMenuId;
        this.supmenuId = supmenuId;
        this.supmenuName = supmenuName;
        this.supmenuUrl = supmenuUrl;
    }

    public Supmenu() {

    }
}
