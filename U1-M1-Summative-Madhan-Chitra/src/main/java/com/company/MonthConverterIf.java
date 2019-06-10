package com.company;

import java.util.Scanner;

public class MonthConverterIf {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int monthNumber = 0;
        System.out.println("Enter a number between 1 and 12. I will tell you the name of the month.");
        monthNumber = Integer.parseInt(scan.nextLine());

        if (monthNumber >= 1 && monthNumber <= 12) {
            if (monthNumber == 1) {
                System.out.println("The month is January.");
            } else if (monthNumber == 2) {
                System.out.println("The month is February.");
            } else if (monthNumber == 3) {
                System.out.println("The month is March.");
            } else if (monthNumber == 4) {
                System.out.println("The month is April.");
            } else if (monthNumber == 5) {
                System.out.println("The month is May.");
            } else if (monthNumber == 6) {
                System.out.println("The month is June.");
            } else if (monthNumber == 7) {
                System.out.println("The month is July.");
            } else if (monthNumber == 8) {
                System.out.println("The month is August.");
            } else if (monthNumber == 9) {
                System.out.println("The month is Septemeber.");
            } else if (monthNumber == 10) {
                System.out.println("The month is October.");
            } else if (monthNumber == 11) {
                System.out.println("The month is November.");
            } else if (monthNumber == 12) {
                System.out.println("The month is December.");
            } }else {
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
            }
        }
    }
