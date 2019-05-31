package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;
        do {
            System.out.println("Enter a number between 15 and 32(not inclusive): ");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);
            System.out.format("You entered %d", userInt);
        } while (userInt <= 15 || userInt >= 32);
    }
}
