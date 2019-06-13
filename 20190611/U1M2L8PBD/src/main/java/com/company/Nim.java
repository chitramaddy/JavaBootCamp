package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        //Counter for three piles of sticks.
        String[] pileNames = {"A", "B", "C"};
        int[] sticksArray = {4, 5, 6};

        //user choice for pilename
        String pileChoice = "";

        //to remove the sticks as per user input
        int remove = 0;

        //Total number of sticks available.
        int total = 15;


        String[] playerArray = new String[2];

        System.out.println("Player 1: Enter your name: ");
        playerArray[0] = scan.nextLine();

        System.out.println("Player 2: Enter your name: ");
        playerArray[1] = scan.nextLine();

        System.out.println("A: " + sticksArray[0] + "\t B: " + sticksArray[1] + "\t C: " + sticksArray[2]);

        boolean isPlaying = true;

        String lastPlayer = playerArray[0];

        while (isPlaying) {

            for (int i = 0; i < playerArray.length; i++) {
                System.out.println(playerArray[i] + " Choose a pile: ");
                pileChoice = scan.nextLine();

                System.out.println("How many to remove from pile: " + pileChoice);
                remove = Integer.parseInt(scan.nextLine());

                for (int j = 0; j < pileNames.length; j++) {
                    if (pileChoice.equals(pileNames[j])) {
                        sticksArray[j] -= remove;
                        total -= remove;

                    }
                }
                System.out.println("A: " + sticksArray[0] + "\t B: " + sticksArray[1] + "\t C: " + sticksArray[2]);

            }
            if (total == 0) {
                System.out.println(playerArray[0]+ " you lose. " + playerArray[1] +" is the winner.");
                isPlaying = false;

            }
        }
    }}
