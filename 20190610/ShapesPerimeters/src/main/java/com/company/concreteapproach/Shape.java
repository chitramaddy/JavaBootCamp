package com.company.concreteapproach;

public class Shape {

    private String name;
    private String color;
    private float x_coordinate;
    private float y_coordinate;
    private double area;
    private double perimeter;

    public Shape(String name, String color, float x_coordinate, float y_coordinate){
        this.name = name;
        this.color = color;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public double area(){ return area; }

    public double perimeter(){ return perimeter; }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public float getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }



}
