package com.bilgeadam.memory;

public class Calisan extends Object{

    public String name;
    public String surname;
    public Integer userID;

    //Constructor shortcut --> alt+insert

    public Calisan(){

    }
    public Calisan(Integer userID, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.userID = userID;
    }
}
