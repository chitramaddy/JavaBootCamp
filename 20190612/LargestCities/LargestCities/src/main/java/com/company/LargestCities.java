package com.company;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LargestCities {
    public static void main(String[] args) {

        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City( "Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> cities = new HashMap<>();

        cities.put("New York", newYork);
        cities.put("California", losAngeles);
        cities.put("Illinois", chicago);
        cities.put("Colorado", denver);
        cities.put("Iowa", desMoines);
        cities.put("Georgia", atlanta);

        Scanner scan = new Scanner(System.in);

        Set<Map.Entry<String, City>> entries = cities.entrySet();

        for(Map.Entry<String, City> entry : entries){
            System.out.println("State "+ entry.getKey()+", City: "+ entry.getValue().getName()+ ", Population: "+entry.getValue().getPopulation());
        }

        System.out.print("Please enter a population (number): ");
        int popLimit = Integer.parseInt(scan.nextLine());

        System.out.println("Cities with a population larger than " + popLimit);

        Set<String> keys = cities.keySet();

        for(String key : keys) {
            if(cities.get(key).getPopulation() > popLimit) {
                System.out.println(key + " : " + cities.get(key).getName());
            }
        }
    }
}
