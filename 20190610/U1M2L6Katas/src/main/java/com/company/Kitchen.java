package com.company;

public class Kitchen extends Home {

    private String flooring;
    private String color;
    private double costOfFlooring;
    private double costOfPainting;

    public Kitchen(String flooring, String color){
        super(10, 12);
        this.flooring = flooring;
        this.color = color;
    }

    public double flooringCost(double price){
        return costOfFlooring;
    }

    public double paintingCost(double price){
        return costOfPainting;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }




}
