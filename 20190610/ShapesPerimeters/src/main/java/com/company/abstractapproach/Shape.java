package com.company.abstractapproach;

public abstract class Shape {

    public String name;
    private String color;
    private float x_coordinate;
    private float y_coordinate;
    private double area;
    private double perimeter;

    public Shape(String name, String color){
        this.name = name;
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(float x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public float getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(float y_coordinate) {
        this.y_coordinate = y_coordinate;
    }


}
