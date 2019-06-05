import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Random random = new Random();

        int computerGuess = random.nextInt(10) + 1;
        System.out.println(computerGuess);
        int yourGuess = 0;
        int counter = 0;
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        while (yourGuess != computerGuess) {
            yourGuess = Integer.parseInt(myScan.nextLine());
            counter++;
            if (yourGuess == computerGuess) {
                System.out.format("That's right! You're a good guesser.\nIt only took you %d guesses.", counter);
            } else {
                System.out.format("Your Guess is %d.\nThat is incorrect. Guess again.\n", yourGuess);
            }
        }
    }
}