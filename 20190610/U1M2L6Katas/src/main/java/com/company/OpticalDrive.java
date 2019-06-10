package com.company;

public class OpticalDrive {

    private String speed;
    private String make;

    public OpticalDrive(String speed, String make, String model) {
        this.speed = speed;
        this.make = make;
        this.model = model;
    }

    private String model;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



}
