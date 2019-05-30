package com.company;


import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        int num1 = Integer.parseInt(myScan.nextLine());

        System.out.println("Enter Second Number: ");
        int num2 = Integer.parseInt(myScan.nextLine());

        //subtract the second number from the first number.
        int result = num1 - num2;
        System.out.println("The difference is " + result + ".");
    }

}
