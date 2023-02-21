package com.dgd.huellas.domain.models;

public class Dog extends Animal{
    private String raza;
    private Boolean amigable;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Boolean getAmigable() {
        return amigable;
    }

    public void setAmigable(Boolean amigable) {
        this.amigable = amigable;
    }
}
