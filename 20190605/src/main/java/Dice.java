import java.util.Random;


//Write a program that simulates a dice roll by picking a random number
// from 1-6 and then picking a second random number from 1-6.
// Add the two values together, and display the total.

public class Dice {
    public static void main(String[] args) {
        Random random = new Random();

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        int total = dice1+dice2;

        System.out.println("Here comes the Dice!!!");
        System.out.println("Roll #1: " + dice1);
        System.out.println("Roll #2: " + dice2);
        System.out.println("The total is "+ total+".");

    }
}
