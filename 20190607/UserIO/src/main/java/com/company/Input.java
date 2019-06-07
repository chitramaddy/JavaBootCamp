package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    Scanner scan = new Scanner(System.in);


    public int readInt(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        int input = Integer.parseInt(userInput);
        return input;
    }

    public long readLong(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        long input = Long.parseLong(userInput);
        return input;

    }

    public double readDouble(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        double input = Double.parseDouble(userInput);
        return input;

    }

    public float readFloat(String prompt) {

        System.out.println(prompt);

        String userInput = scan.nextLine();
        float input = Float.parseFloat(userInput);
        return input;


    }

    public String readString(String prompt) {
        System.out.println(prompt);

        String input = scan.nextLine();

        return input;


    }
}
