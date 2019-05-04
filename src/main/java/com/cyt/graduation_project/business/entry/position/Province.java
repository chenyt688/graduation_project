package com.cyt.graduation_project.business.entry.position;

public class Province {
    private int id;
    private long provinceId;
    private String provinceName;

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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Province() {

    }

    public Province(int id, long provinceId, String provinceName) {

        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }
}
