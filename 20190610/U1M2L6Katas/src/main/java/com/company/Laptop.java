package com.company;

public class Laptop {

    private String make;
    private String model;
    private String OS;

    private Processor processor;
    private Memory memory;
    private OpticalDrive od;

    public Laptop(String make, String model, String OS) {
        this.make = make;
        this.model = model;
        this.OS = OS;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public OpticalDrive getOd() {
        return od;
    }

    public void setOd(OpticalDrive od) {
        this.od = od;
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

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void installSoftware(String software){
        System.out.println("Installed new software");
    }


}
