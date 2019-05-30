package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        int num1 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Second Number: ");
        int num2 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Third Number: ");
        int num3 = Integer.parseInt(myScan.nextLine());

        //Multiply the three user input values and print it to the screen.
        int result = num1 * num2 * num3;
        System.out.println("The product is " + result +".");

    }
}