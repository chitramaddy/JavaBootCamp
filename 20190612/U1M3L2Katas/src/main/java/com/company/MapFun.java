package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFun {
    public static void main(String[] args) {
        Map<String, Integer> newCars = new HashMap<>();

        newCars.put("Toyota Camry", 2012);
        newCars.put("Chevy Camaro", 1969);
        newCars.put("Hyundai Genesis", 2015);
        newCars.put("Jeep Wrangler", 2003);
        newCars.put("Honda Civic", 2018);
        newCars.put("Toyota Supra", 1995);
        newCars.put("Pontiac GTO", 1964);

        System.out.println("Name \t\t" + " Year \t\t ");
        printMethod(newCars);
        System.out.println("--------------------");
        newCars.put("Ford Explorer", 2012);
        newCars.put("Smart Fortwo", 2013);

        printMethod(newCars);

        newCars.remove("Jeep Wrangler");

        System.out.println("--------------------");
        printMethod(newCars);

    }

    public static void printMethod(Map<String, Integer> c){
        Set<Map.Entry<String, Integer>> cars = c.entrySet();

        for (Map.Entry<String, Integer> car : cars) {
            System.out.println(car.getKey() + ",\t" + car.getValue());
        }
    }

}
