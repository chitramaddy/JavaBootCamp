package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numspeaker;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturer, String model, int numspeaker, String station, int volume, boolean powered){
        this.manufacturer = manufacturer;
        this.model = model;
        this.numspeaker = numspeaker;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
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

    public void setNumSpeakers(int numspeaker){
        this.numspeaker = numspeaker;
    }

    public int getNumSpeakers(){
        return this.numspeaker;
    }

    public void setStation(String station){
        this.station = station;
    }

    public String getStation(){
        return this.station;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }

    public void isPowered(boolean powered){
        this.powered = powered;
    }

    public boolean isPowered(){
        return this.powered;
    }

}
