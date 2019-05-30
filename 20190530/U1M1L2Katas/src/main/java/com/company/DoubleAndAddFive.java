package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.format("%n");

        System.out.println("Input a number: ");
        int number = Integer.parseInt(myScanner.nextLine());

        // Multiply the user input by 2 and Add 5 to the result. Print the result as a float with 2 decimal places.
        int result = (2*number)+5;
        System.out.println("The result is " + result);
    }

}
