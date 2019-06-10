package com.company;

public class Chips {

    private String brand;

    private int quantity;

    public Chips(String brand, int quantity) {
        this.brand = brand;
        this.quantity = quantity;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
