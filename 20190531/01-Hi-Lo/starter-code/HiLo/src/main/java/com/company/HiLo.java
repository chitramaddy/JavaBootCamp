package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {

        System.out.println("Welcome to Hi-Low!");

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your name, please");
        String name = myScanner.nextLine();

        System.out.println("OK, " + name + ", here are the rules: ");

        int computerGuess;
        int userInput;
        int guesses = 0;
        boolean youWin = false;

        //generate random number
        Random computerRandom = new Random();
        computerGuess = computerRandom.nextInt(100) + 1;
        System.out.println(computerGuess);


        while (youWin == false) {
            System.out.println("Guess a number between 1 and 100");
            userInput = Integer.parseInt(myScanner.nextLine());
            guesses++;

            if (userInput == computerGuess) {
                System.out.format("Congratulations, %s! You win!\nIt took you %d guesses to find my number!", name, guesses);
                youWin = true;
            } else if (userInput < computerGuess) {
                System.out.println("Too Low!");

            } else if (userInput > computerGuess){
                System.out.println("Too High!");
            }
        }
    }
}