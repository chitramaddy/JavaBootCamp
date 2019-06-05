import java.util.Random;
import java.util.Scanner;

//user can guess until they get it right. That means it will keep looping as long as the guess is different from the secret number.

public class KeepGuessing {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Random random = new Random();

        int computerGuess = random.nextInt(10) + 1;
        System.out.println(computerGuess);
        int yourGuess = 0;
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        while (yourGuess != computerGuess) {
            yourGuess = Integer.parseInt(myScan.nextLine());
            if (yourGuess == computerGuess) {
                System.out.println("That's right! You're a good guesser.\n");
            } else {
                System.out.format("Your Guess is %d.\nThat is incorrect. Guess again.\n", yourGuess);
            }
        }
    }
}
