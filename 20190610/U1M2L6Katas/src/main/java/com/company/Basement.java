package com.company;

public class Basement extends Home{

    private String flooring;
    private String color;
    private double area;

    public Basement(){
        super(12, 15);
        this.flooring = flooring;
        this.color = color;
    }

    public double calcArea(){
       area  = super.calcSqft(12,15);
        return area;
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
