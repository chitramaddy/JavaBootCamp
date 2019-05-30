package com.trilogyed;

import java.util.Scanner;

public class LuxuryTaxCalculator {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        //Ask for player1 salary
        System.out.println("Enter player1 salary: ");
        int playerOneSalary = Integer.parseInt(myScan.nextLine());
        System.out.println("Enter player2 salary: ");
        int playerTwoSalary = Integer.parseInt(myScan.nextLine());
        System.out.println("Enter player3 salary: ");
        int playerThreeSalary = Integer.parseInt(myScan.nextLine());

        double total = playerOneSalary + playerTwoSalary + playerThreeSalary;

        //Calculate the total salary. Print the team spending as a $ value with two decimal places.
        System.out.format("The team spending is $%,.2f\n\n", total);

        int spendingLimit = 40000000;

        //If the total exceeds spending limit, calculate 18% luxury tax on the overspending. Print the luxury tax as $ value with two decimal places.
        if(total > spendingLimit){
            double difference = total-spendingLimit;
            double luxuryTax = difference * 18/100;
            System.out.format("The team spending went overboard. Your tax is $%,.2f\n\n", luxuryTax);
        }
        //Otherwise, print an encouraging message.
        else{
            System.out.println("Good planning!");
        }

    }
}
