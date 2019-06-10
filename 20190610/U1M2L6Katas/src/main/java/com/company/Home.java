package com.company;

public class Home {

    private double length;
    private double width;
    private double area;

    public Home(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double calcSqft(double length, double width){
       area = length * width;
       return area;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


}
