package com.company;

public class Processor {


    private String make;
    private String model;
    private String speed;

    public Processor(String make, String model, String speed) {
        this.make = make;
        this.model = model;
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

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }



}
