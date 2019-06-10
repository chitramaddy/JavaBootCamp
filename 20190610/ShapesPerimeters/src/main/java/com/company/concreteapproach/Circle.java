package com.company.concreteapproach;

public class Circle extends Shape {


    private double radius;

    public Circle(double radius) {
        super("life", "red", 10, 10);

        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
