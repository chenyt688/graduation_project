package com.cyt.graduation_project.business.entry.userinfo;

public class IdentityType {
    private int identityId;
    private String identityName;

    public IdentityType(int identityId, String identityName) {
        this.identityId = identityId;
        this.identityName = identityName;
    }

    public IdentityType() {

    }

    public int getIdentityId() {
        return identityId;
    }

    public void setIdentityId(int identityId) {
        this.identityId = identityId;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }
}
