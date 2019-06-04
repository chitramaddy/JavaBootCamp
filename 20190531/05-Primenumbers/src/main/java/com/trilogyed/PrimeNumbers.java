package com.trilogyed;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String userInput = myScan.nextLine();
        int ceiling = Integer.parseInt(userInput);

        //printing the only even prime number.
        System.out.println(2);

        //Iterating through the numbers excluding all the even numbers as we already
        for (int i = 3; i < ceiling; i += 2) {
            boolean isPrime = true;

            for (int j = 3; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                System.out.println(i);
            }
        }
    }
}

