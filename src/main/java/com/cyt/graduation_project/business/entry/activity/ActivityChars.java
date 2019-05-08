package com.cyt.graduation_project.business.entry.activity;

public class ActivityChars {
    private String provinceName;
    private int num;

    public ActivityChars() {
    }

    public ActivityChars(String provinceName, int num) {
        this.provinceName = provinceName;
        this.num = num;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
