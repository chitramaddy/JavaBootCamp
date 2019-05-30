package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        int num1 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Second Number: ");
        int num2 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Third Number: ");
        int num3 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Fourth Number: ");
        int num4 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Fifth Number: ");
        int num5 = Integer.parseInt(myScan.nextLine());

        //to find the total of all five numbers and print the result
        int result = num1 + num2 + num3 + num4 + num5;
        System.out.println("The total is " + result + "." );
    }
}
