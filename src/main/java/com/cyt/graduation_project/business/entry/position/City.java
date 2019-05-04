package com.cyt.graduation_project.business.entry.position;

public class City {
    private int id;
    private long provinceId;
    private long cityId;
    private String cityName;

    public City() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City(int id, long provinceId, long cityId, String cityName) {

        this.id = id;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.cityName = cityName;
    }
}
