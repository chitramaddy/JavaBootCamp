package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Enter your lucky Number: ");
        int luckyNumber = Integer.parseInt(myScan.nextLine());

        luckyNumber = luckyNumber + 13;
        System.out.println("My lucky number is " + luckyNumber + ".");

    }
}
