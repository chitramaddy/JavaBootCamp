package com.company;

public class Mints {

    private int mintQuantity;
    private String name;

    public Mints(int mintQuantity, String name) {
        this.mintQuantity = mintQuantity;
        this.name = name;
    }

    public int getMintQuantity() {
        return mintQuantity;
    }

    public void setMintQuantity(int mintQuantity) {
        this.mintQuantity = mintQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
