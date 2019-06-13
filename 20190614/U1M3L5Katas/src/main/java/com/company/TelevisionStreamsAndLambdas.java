package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionStreamsAndLambdas {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisionList;

            televisionList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            int screenSize = 60;

            System.out.println("Televisions with a screen size greater than 60 inches: ");
            televisionList
                    .stream()
                    .filter(tv -> tv.getScreenSize() > screenSize)
                    .forEach(tv -> {
                        System.out.println("===============");
                        System.out.println("Make: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("Screen Size: "+ tv.getScreenSize());
                    });

            System.out.println("\n-----------------------------------");
            System.out.println("Television grouped by brands: ");
            System.out.println("-----------------------------------");
            Map<String, List<Television>> groupedTelevisions =
                    televisionList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = groupedTelevisions.keySet();
            for(String key : keys) {
                System.out.println(key);
            }

            System.out.println("\n-----------------------------------");
            // Print the average horsepower of the motorcycles in inventory
            double avgScreensize =
                    televisionList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.format("Average Screen Size is %f\n", avgScreensize);

            System.out.println("-----------------------------------");

            int maxScreenSize =
                    televisionList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("\nLargest Screen Size " + maxScreenSize);

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }




}