package com.cyt.graduation_project.business.entry.finance;

public class Finance {
    private int financeId;
    private String financeType; //收入  支出
    private String financeTime;
    private String financeAbout;  //财务用途
    private String financeChannel; //财务渠道
    private double financeAmount; //金额额度
    private String userName;

    public Finance() {
    }

    public Finance(int financeId, String financeType, String financeTime, String financeAbout, String financeChannel, double financeAmount, String userName) {

        this.financeId = financeId;
        this.financeType = financeType;
        this.financeTime = financeTime;
        this.financeAbout = financeAbout;
        this.financeChannel = financeChannel;
        this.financeAmount = financeAmount;
        this.userName = userName;
    }

    public int getFinanceId() {
        return financeId;
    }

    public void setFinanceId(int financeId) {
        this.financeId = financeId;
    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public String getFinanceTime() {
        return financeTime;
    }

    public void setFinanceTime(String financeTime) {
        this.financeTime = financeTime;
    }

    public String getFinanceAbout() {
        return financeAbout;
    }

    public void setFinanceAbout(String financeAbout) {
        this.financeAbout = financeAbout;
    }

    public String getFinanceChannel() {
        return financeChannel;
    }

    public void setFinanceChannel(String financeChannel) {
        this.financeChannel = financeChannel;
    }

    public double getFinanceAmount() {
        return financeAmount;
    }

    public void setFinanceAmount(double financeAmount) {
        this.financeAmount = financeAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
