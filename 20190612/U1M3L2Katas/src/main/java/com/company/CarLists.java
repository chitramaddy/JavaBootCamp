package com.company;

import java.util.*;

public class CarLists {

    public static void main(String[] args) {

        Car camry = new Car("Toyota", "Camry");
        Car corolla = new Car("Toyota", "Corolla");
        Car highlander = new Car("Toyota", "Highlander");

        Car mustang = new Car("Ford", "Mustang");
        Car fusion = new Car("Ford", "Fusion");
        Car taurus = new Car("Ford", "Taurus");

        Car accord = new Car("Honda", "Accord");
        Car civic = new Car("Honda", "Civic");
        Car fit = new Car("Honda", "Fit");

        List<String> toyotaList = new ArrayList<>();
        List<String> fordList = new ArrayList<>();
        List<String> hondaList = new ArrayList<>();

        fordList.add("Mustang");
        fordList.add( "Fusion");
        fordList.add("Taurus");

        toyotaList.add( "Camry");
        toyotaList.add( "Corolla");
        toyotaList.add( "Highlander");

        hondaList.add("Accord");
        hondaList.add( "Civic");
        hondaList.add( "Fit");

        Map<String, List > make = new HashMap<>();

        make.put("Toyota", toyotaList);
        make.put("Ford", fordList);
        make.put("Honda", hondaList);

        Set<Map.Entry<String, List>> entries = make.entrySet();

        for (Map.Entry<String, List> entry : entries){
            System.out.println("Make: "+ entry.getKey() + "\t Model: "+
                    entry.getValue().get(0) +", "+entry.getValue().get(1)+", "+entry.getValue().get(2));
        }


        }

    }


