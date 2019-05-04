package com.cyt.graduation_project.business.entry.position;

public class SpecificAddress {
    private int id;
    private long villageId;
    private long spAddId;
    private String spAddName;

    public SpecificAddress() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVillageId() {
        return villageId;
    }

    public void setVillageId(long villageId) {
        this.villageId = villageId;
    }

    public long getSpAddId() {
        return spAddId;
    }

    public void setSpAddId(long spAddId) {
        this.spAddId = spAddId;
    }

    public String getSpAddName() {
        return spAddName;
    }

    public void setSpAddName(String spAddName) {
        this.spAddName = spAddName;
    }

    public SpecificAddress(int id, long villageId, long spAddId, String spAddName) {

        this.id = id;
        this.villageId = villageId;
        this.spAddId = spAddId;
        this.spAddName = spAddName;
    }
}
