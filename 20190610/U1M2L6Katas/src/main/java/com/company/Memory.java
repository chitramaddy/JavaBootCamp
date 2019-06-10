package com.company;

import java.sql.SQLOutput;

public class Memory {
    private String make;
    private String type;
    private String speed;

    public Memory(String make, String type, String speed) {
        this.make = make;
        this.type = type;
        this.speed = speed;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void upgradeMemory(String speed){
        System.out.println("Memory upgraded");
        this.speed += speed;
    }






}
