package com.company;

public class Microwave {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave(String manufacturer, String model, int secondsLeft, String time, boolean running){
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

    public void setSecondsLeft(int secondsLeft){
        this.secondsLeft = secondsLeft;
    }

    public int getSecondsLeft(){
        return this.secondsLeft;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return this.time;
    }


    public void isRunning(boolean running){
        this.running = running;
    }

    public boolean isRunning(){
        return this.running;
    }

    public void start(int secondsLeft){
        System.out.println(secondsLeft--);
    }

    public void stop(){
        System.out.println("Ready");
    }

    public void clear(){
        System.out.println( secondsLeft=0 );
    }


}
