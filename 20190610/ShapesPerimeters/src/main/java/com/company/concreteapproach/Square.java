package com.company.concreteapproach;

public class Square extends Shape {


    private double side;

    public Square(double side){
        super("Chitra", "red", 10, 10 );
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
