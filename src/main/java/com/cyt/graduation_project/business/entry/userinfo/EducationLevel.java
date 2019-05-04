package com.cyt.graduation_project.business.entry.userinfo;

public class EducationLevel {
    private int levelId;
    private String levelName;

    @Override
    public String toString() {
        return "EducationLevel{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                '}';
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public EducationLevel() {

    }

    public EducationLevel(int levelId, String levelName) {

        this.levelId = levelId;
        this.levelName = levelName;
    }
}
