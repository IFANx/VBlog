package com.example.vblogservice.entity.domian;

public class UserWithBLOBs extends User {
    private String description;

    private byte[] portrait;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public byte[] getPortrait() {
        return portrait;
    }

    public void setPortrait(byte[] portrait) {
        this.portrait = portrait;
    }
}