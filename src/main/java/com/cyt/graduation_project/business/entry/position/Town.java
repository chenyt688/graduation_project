package com.cyt.graduation_project.business.entry.position;

public class Town {
    private int id;
    private long countyId;
    private long townId;
    private String townName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCountyId() {
        return countyId;
    }

    public void setCountyId(long countyId) {
        this.countyId = countyId;
    }

    public long getTownId() {
        return townId;
    }

    public void setTownId(long townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Town(int id, long countyId, long townId, String townName) {

        this.id = id;
        this.countyId = countyId;
        this.townId = townId;
        this.townName = townName;
    }

    public Town() {

    }
}
