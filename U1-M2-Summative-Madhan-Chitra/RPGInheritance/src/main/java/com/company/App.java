package com.company;

public class App {
    public static void main(String[] args) {
        Farmer sam = new Farmer("Sam", 75,100,75,10,1);

        Constable cop = new Constable("cop", 60,100,60,20,5, "NJ");

        Warrior michelle = new Warrior("Michelle", 75,100,100,50,10, 100);

        sam.harvest();

        michelle.run(20);

        System.out.println("Constable has jurisdiction over "+ cop.getJurisdiction()+ ".");
    }




}
