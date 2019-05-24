package com.cyt.graduation_project.business.entry.activity;

public class AnalysisData {
    private String provinceName;
    private double num;

    public AnalysisData() {
    }

    public AnalysisData(String provinceName, double num) {

        this.provinceName = provinceName;
        this.num = num;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
