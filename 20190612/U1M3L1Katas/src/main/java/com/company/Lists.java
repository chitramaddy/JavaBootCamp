package com.company;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {


        List<Classmate> classmateList = new ArrayList<>();

        Classmate cm1 = new Classmate("Joe Smith, ", "Brown");
        Classmate cm2 = new Classmate("Michelle, ", "Black");
        Classmate cm3 = new Classmate("Vijaya, ", "Black");
        Classmate cm4 = new Classmate("Ofe, ", "Black");
        Classmate cm5 = new Classmate("Thusmeen, ", "Black");

        classmateList.add(cm1);
        classmateList.add(cm2);
        classmateList.add(cm3);
        classmateList.add(cm4);
        classmateList.add(cm5);

        for(Classmate cm : classmateList){
            System.out.println("Name : "+cm.getName() + " Hair Color: "+ cm.getHairColor());
        }
    }
}
