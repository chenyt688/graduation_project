package com.cyt.graduation_project.business.entry.relation;

public class UserDiary {
    private int userId;
    private int diaryId;

    public UserDiary(int userId, int diaryId) {
        this.userId = userId;
        this.diaryId = diaryId;
    }

    @Override
    public String toString() {
        return "UserDiary{" +
                "userId=" + userId +
                ", diaryId=" + diaryId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }

    public UserDiary() {

    }
}
