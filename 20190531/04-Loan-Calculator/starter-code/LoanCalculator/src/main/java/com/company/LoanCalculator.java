package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter your mortgage amount: ");
        String amountInput = myScan.nextLine();
        int amount_L = Integer.parseInt(amountInput);

        System.out.println("Enter your loan term (in months): ");
        String termInput = myScan.nextLine();
        int term_n = Integer.parseInt(termInput);

        System.out.println("Enter the interest rate per annum (in percentage): ");
        String interestRateInput = myScan.nextLine();
        float interestRate = Float.parseFloat(interestRateInput);
        float c = (interestRate/(100*12));

        double x = Math.pow(1+c, term_n);

        double monthlyPayment = amount_L*(c*x)/x-1;

        System.out.format("Your calculated monthly payment is %f", monthlyPayment);


    }
}
