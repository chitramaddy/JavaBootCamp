import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(10)+1;

        Scanner scan = new Scanner(System.in);


        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.println("your Guess: ");
        String guess = scan.nextLine();
        int yourGuess = Integer.parseInt(guess);


        if(numberToGuess == yourGuess){
            System.out.println("That's right!  My secret number was " + numberToGuess +" !");
        }else{
            System.out.println("Sorry, but I was really thinking of " + numberToGuess + ".");
        }
    }
}
