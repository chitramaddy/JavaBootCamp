//Write an interactive quiz. It should ask the user three multiple-choice
// or true/false questions about something. It must keep track of how many
// they get wrong, and print out a "score" at the end.

import java.util.Scanner;

public class LittleQuiz {

    public static void main(String[] args) {
        int correct = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Are you ready for a quiz? Y/N");
        String wantToPlay = scan.nextLine();

        if (wantToPlay.equals("Y") || wantToPlay.equals("y")) {

            System.out.println("Ok! Here it comes");


             String[] questionArray = new String[3];

            String[] ansArray = new String[3];

            questionArray[0] = "Q1. What is the capital of Alaska?\n"
                    + "1) Melbourne\n" +
                    "2) Anchorage\n" +
                    "3) Juneau";

            questionArray[1] = "Q2. Can you store the value \"cat\" in a variable of type int?\n"
                    + "1) yes \n"
                    + "2) no \n";

            questionArray[2] = "Q3) What is the result of 9+6/3?\n"
                    + "1) 5\n" +
                    "2) 11\n" +
                    "3) 15/3";

            for (int i = 0; i < questionArray.length; i++) {
                System.out.println(questionArray[i]);
                String answer = scan.nextLine();
                if (answer == ansArray[i]) {
                    correct++;
                    System.out.println("That is correct!");
                } else {
                    System.out.println("Sorry! But the correct answer is " + ansArray[i]);
                }
            }
            System.out.format("You got %d out of 3 questions correct.", correct);
        } else {
            return;
        }
    }
}
