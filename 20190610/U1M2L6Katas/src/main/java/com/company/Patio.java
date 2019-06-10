package com.company;

public class Patio extends Home {

    private double patioArea;
    public Patio(){
        super(8, 7.5);

    }

    public double calcArea(){
        patioArea = super.calcSqft(8, 7.5);
        return patioArea;
    }
}
