package com.dgd.huellas.domain.models;

public class Dog extends Animal{
    private String race;
    private Boolean friendly;

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Boolean getFriendly() {
        return friendly;
    }

    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }
}
