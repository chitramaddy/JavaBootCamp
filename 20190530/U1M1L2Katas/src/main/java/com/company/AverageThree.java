package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        int num1 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Second Number: ");
        int num2 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Third Number: ");
        int num3 = Integer.parseInt(myScan.nextLine());

        //Add the three user inputs and find the average value. To allow decimals, result is stored as a float.
        float result = (num1 + num2 + num3)/3f;
        System.out.printf("The average value is %f.\n\n", result);
    }
}
