package com.company.concreteapproach;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        super("t1", "blue", 19, 20);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double area() {
        double p = perimeter() / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p-sideC));
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }


}
