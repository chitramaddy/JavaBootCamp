package com.company;

public class Rooms extends Home {
    private double roomArea;

    public Rooms(){
        super(12, 10);
    }

    public double calcSqft(String length, String Width){
       roomArea  = super.calcSqft(12, 10);
       return roomArea;
    }
}
