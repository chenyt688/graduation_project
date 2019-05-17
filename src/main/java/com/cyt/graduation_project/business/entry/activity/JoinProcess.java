package com.cyt.graduation_project.business.entry.activity;

public class JoinProcess {
    private int state;
    private String activityTopic;

    public JoinProcess() {
    }

    public JoinProcess(int state, String activityTopic) {
        this.state = state;
        this.activityTopic = activityTopic;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getActivityTopic() {
        return activityTopic;
    }

    public void setActivityTopic(String activityTopic) {
        this.activityTopic = activityTopic;
    }
}
