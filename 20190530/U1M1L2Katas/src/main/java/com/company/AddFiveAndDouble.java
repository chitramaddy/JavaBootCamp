package com.company;

//import scanner

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        //initialize scanner
        Scanner myScanner = new Scanner(System.in);
        System.out.format("%n");

        System.out.println("Input a number: ");
        int number = Integer.parseInt(myScanner.nextLine());

        //Add 5 to the user input and multiply the sum by 2. Print the result as a float with 2 decimal places.
        float result = (number + 5) * 2;
        System.out.printf("Your result is %.2f", result);


    }
}
