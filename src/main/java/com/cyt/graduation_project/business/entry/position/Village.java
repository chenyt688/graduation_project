package com.cyt.graduation_project.business.entry.position;

public class Village {
    private int id;
    private long townId;
    private long villageId;
    private String villageName;

    public Village(int id, long townId, long villageId, String villageName) {
        this.id = id;
        this.townId = townId;
        this.villageId = villageId;
        this.villageName = villageName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTownId() {
        return townId;
    }

    public void setTownId(long townId) {
        this.townId = townId;
    }

    public long getVillageId() {
        return villageId;
    }

    public void setVillageId(long villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public Village() {

    }
}
