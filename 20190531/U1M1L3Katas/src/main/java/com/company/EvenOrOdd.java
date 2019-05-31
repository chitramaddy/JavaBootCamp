package com.company;

import java.util.Scanner;

public class EvenOrOdd {


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;

        System.out.println("Enter a number: ");
        userInput = myScanner.nextLine();
        userInt = Integer.parseInt(userInput);

        if(userInt % 2 == 0){
            System.out.println("The number you entered is even.");
        }else {
            System.out.println("The number you entered is odd.");
        }
    }
}
