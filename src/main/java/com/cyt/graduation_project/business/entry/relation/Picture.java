package com.cyt.graduation_project.business.entry.relation;

public class Picture {
    private int id;
    private String img;
    private String imgName;
    private int userId;
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Picture() {

    }

    public Picture(int id, String img, String imgName, int userId, int flag) {

        this.id = id;
        this.img = img;
        this.imgName = imgName;
        this.userId = userId;
        this.flag = flag;
    }
}
