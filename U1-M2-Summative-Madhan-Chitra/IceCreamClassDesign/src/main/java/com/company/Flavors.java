package com.company;

public class Flavors {

    private String flavorName;
    private double flavorPrice;

    public Flavors(String flavorName, double flavorPrice) {
        this.flavorName = flavorName;
        this.flavorPrice = flavorPrice;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public double getFlavorPrice() {
        return flavorPrice;
    }

    public void setFlavorPrice(double flavorPrice) {
        this.flavorPrice = flavorPrice;
    }


}
