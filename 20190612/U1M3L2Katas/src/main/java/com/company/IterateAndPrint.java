package com.company;

import java.util.*;

public class IterateAndPrint {

    public static void main(String[] args) {

        Map<String, String> baseballTeam = new HashMap<>();

        baseballTeam.put("Pitcher", "Mike Foltynewicz");
        baseballTeam.put("Catcher", "Brian McCann");
        baseballTeam.put("First Baseman", "Freddie Freeman");
        baseballTeam.put("Second Baseman", "Ozzie Albies");
        baseballTeam.put("Third Baseman", "Josh Donaldson");
        baseballTeam.put("Shortstop", "Dansby Swanson");
        baseballTeam.put("Left Fielder", "Ronald Acuna, Jr.");
        baseballTeam.put("Center Fielder", "Ender Inciarte");
        baseballTeam.put("Right Fielder", "Nick Markakis");


        Set<String> myKeys = baseballTeam.keySet();

        //Print all the keys
        System.out.println("Keys");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        for(String key: myKeys){
            System.out.println(key);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Values");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");

        //Print all the values

        Collection<String> myValues = baseballTeam.values();
        for(String value: myValues){
            System.out.println(value);
        }

        //Print the key, value pair
        Set<Map.Entry <String, String>> myEntries = baseballTeam.entrySet();

        //Map through each entry in myEntries
        for(Map.Entry<String, String> entry : myEntries){
            System.out.println("Key: "+ entry.getKey()+ "\t Value: "+ entry.getValue());
        }






    }

}