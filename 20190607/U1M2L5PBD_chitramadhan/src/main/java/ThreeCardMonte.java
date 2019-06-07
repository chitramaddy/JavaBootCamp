import java.util.Random;
import java.util.Scanner;

//Pick a random number as the ball number
//sout the player to guess the cup that has the ball.
//take the user guess in a scanner
//compare user guess with the random number and say if the user wins

public class ThreeCardMonte {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Random random = new Random();
        String[][] gameArr = {
                {"#", "#", "#"},
                {"#", "#", "#"},
                {"1", "2", "3"}
        };


        int aceNumber = random.nextInt(3) + 1;

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.\n" +
                "Which one is ace?");


        for (int i = 0; i < gameArr.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < gameArr[i].length; j++) {
                System.out.print(gameArr[i][j] + "\t");
            }
        }


        int userGuess = Integer.parseInt(scan.nextLine());

        if (userGuess == aceNumber) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");

        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + aceNumber + ".\n");
        }
        for (int k = 0; k < gameArr.length; k++) {
            for (int l = 0; l < (gameArr[k].length); l++) {
                if (l == (aceNumber-1)) {
                    gameArr[0][l] = "AA";
                    gameArr[1][l] = "AA";
                    System.out.println(gameArr[k][l]);
                } else {
                    System.out.print(gameArr[k][l]+"\t");

                }
            }

        }

    }


}

