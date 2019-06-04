package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HowManyTimesTo7 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //User input for number of rolls
        System.out.println("Enter number of rolls: ");
        String userInput = myScanner.nextLine();
        int numberOfRolls = Integer.parseInt(userInput);

        int numberOfTimesTo7 = 0;
        int rolled7 = 0;

        Random randomGenerator = new Random();

        for (int i = 0; i < numberOfRolls; i++) {
            int rollValue1 = randomGenerator.nextInt(6) + 1;
            int rollValue2 = randomGenerator.nextInt(6) + 1;
            numberOfTimesTo7++;

            if (rolled7 == 0 && rollValue1 + rollValue2 == 7) {
                rolled7++;
                System.out.format("You rolled your first seven on try number %d.\n", numberOfTimesTo7);
            } else if (rollValue1 + rollValue2 == 7) {
                rolled7++;
            }
        }
        System.out.format("You rolled seven %d times", rolled7);
    }
}
