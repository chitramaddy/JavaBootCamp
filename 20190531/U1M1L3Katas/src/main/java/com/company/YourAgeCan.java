package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int age;

        System.out.println("Enter your age: ");
        userInput = myScanner.nextLine();
        age = Integer.parseInt(userInput);

        if (age >= 100) {
            System.out.println("Is more than a century old.");
            System.out.println("Can retire.");
            System.out.println("is eligible for AARP.");
            System.out.println("Be president.");
            System.out.println("Drink Alcohol.");
            System.out.println("Vote.");
        } else if (age >= 80 && age <= 89) {
            System.out.println("User is an octogenerian.");
            System.out.println("Can retire.");
            System.out.println("is eligible for AARP.");
            System.out.println("Be president.");
            System.out.println("Drink Alcohol.");
            System.out.println("Vote.");
        } else if (age > 65) {
            System.out.println("User can retire.");
            System.out.println("is eligible for AARP.");
            System.out.println("Be president.");
            System.out.println("Drink Alcohol.");
            System.out.println("Vote.");
        } else if (age > 55) {
            System.out.println("User is eligible for AARP.");
            System.out.println("Be president.");
            System.out.println("Drink Alcohol.");
            System.out.println("Vote.");
        } else if (age > 35) {
            System.out.println("Be president.");
            System.out.println("Drink Alcohol.");
            System.out.println("Vote.");
        } else if (age > 21) {
            System.out.println("Drink Alcohol.");
            System.out.println("Vote.");
        }else if(age > 18){
            System.out.println("Vote.");
        }

    }
}
