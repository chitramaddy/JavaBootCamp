package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BasicArrayLists6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        int random1;

        for (int i = 0; i < 10; i++) {
            random1 = random.nextInt(50) + 1;
            numbers.add(random1);
        }
        System.out.println(numbers);
        System.out.println("Enter a number between 1 and 50: ");
        int input = Integer.parseInt(scan.nextLine());
        boolean isFound = false;
        for(int i=0; i < numbers.size(); i++){
            if(numbers.get(i) == input){
                isFound = true;
                System.out.println(numbers.get(i) + " is in the ArrayList.");
            }
        }

        if(!isFound){
            System.out.println(input + " is not found in the ArrayList.");
        }


    }
}
