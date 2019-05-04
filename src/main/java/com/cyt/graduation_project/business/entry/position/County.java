package com.cyt.graduation_project.business.entry.position;

public class County {
    private int id ;
    private long cityId;
    private long countyId;
    private String countyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getCountyId() {
        return countyId;
    }

    public void setCountyId(long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public County(int id, long cityId, long countyId, String countyName) {

        this.id = id;
        this.cityId = cityId;
        this.countyId = countyId;
        this.countyName = countyName;
    }

    public County() {

    }
}
