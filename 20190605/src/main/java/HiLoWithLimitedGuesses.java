//Write a program that picks a random number from 1-100. The user keeps guessing as long as their guess is wrong,
// and they've guessed less than 7 times. If their guess is higher than the number, say "Too high." If their guess
// is lower than the number, say "Too low." When they get it right, the game stops. Or, if they hit seven guesses,
// the game stops even if they never got it right.

import java.util.Scanner;
import java.util.Random;

public class HiLoWithLimitedGuesses {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int computerGuess;
        int userInput = 0;
        int guesses = 0;
        boolean stopGame = false;

        //generate random number
        Random computerRandom = new Random();
        computerGuess = computerRandom.nextInt(100) + 1;
        System.out.println(computerGuess);
        System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses.");
        System.out.println("First Guess: ");

        while (userInput != computerGuess && stopGame == false) {

            System.out.println("Guess #" + (guesses+1));
            userInput = myScanner.nextInt();
            guesses++;

            if (guesses == 7 && userInput != computerGuess) {
                System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
                stopGame = true;
            } else if (userInput < computerGuess) {
                System.out.println("Sorry, you are too low.");
            } else if (userInput > computerGuess) {
                System.out.println("Sorry, you are too high.");
            } else if (userInput == computerGuess) {
                stopGame = true;
                System.out.println("You guessed it!  What are the odds?!?");
            }

        }
    }
}