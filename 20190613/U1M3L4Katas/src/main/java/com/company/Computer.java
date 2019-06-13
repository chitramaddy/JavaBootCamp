package com.company;

import com.opencsv.bean.CsvBindByName;

public class Computer {


    @CsvBindByName(column = "RAM")
    private int RAM;
    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "CPU")
    private String CPU;
    @CsvBindByName(column = "StorageSize")
    private String storageSize;

    public Computer(int RAM, String brand, String model, String CPU, String storageSize) {
        this.RAM = RAM;
        this.brand = brand;
        this.model = model;
        this.CPU = CPU;
        this.storageSize = storageSize;
    }

    public Computer() {

    }
    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }

}
