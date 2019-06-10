package com.company;

import java.util.Scanner;

public class MonthConverterSwitch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int monthNumber = 0;
        System.out.println("Enter a number between 1 and 12. I will tell you the name of the month.");
        monthNumber = Integer.parseInt(scan.nextLine());

        switch (monthNumber) {
            case 1:
                System.out.println("The month is January.");
                break;
            case 2:
                System.out.println("The month is February.");
                break;
            case 3:
                System.out.println("The month is March.");
                break;
            case 4:
                System.out.println("The month is April.");
            case 5:
                System.out.println("The month is May.");
                break;
            case 6:
                System.out.println("The month is June.");
                break;
            case 7:
                System.out.println("The month is July.");
                break;
            case 8:
                System.out.println("The month is August.");
                break;
            case 9:
                System.out.println("The month is Septemeber.");
                break;
            case 10:
                System.out.println("The month is October.");
                break;
            case 11:
                System.out.println("The month is November.");
                break;
            case 12:
                System.out.println("The month is December.");
                break;

            default:
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
    }
}

