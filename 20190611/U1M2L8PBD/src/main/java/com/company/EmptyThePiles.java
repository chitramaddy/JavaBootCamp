package com.company;

import java.util.Scanner;

public class EmptyThePiles {
    //Scanner
    //Three piles
    //counters set 3 in each

    //while(the counters are not zero){
    //prompt the player to select a pile
    //match the pile in an array
    //ask how many they want to pick
    //subtract from the pile
//}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("A: 3 \t B: 3 \t C:3");

        int counterA = 3;
        int counterB = 3;
        int counterC = 3;

        boolean isEmpty = false;


        while (isEmpty == false) {

            System.out.println("Choose a pile: ");
            String choicePileName = scan.nextLine();

            System.out.format("How many to remove from pile: %s \n", choicePileName);

            int remove = Integer.parseInt(scan.nextLine());
            System.out.println(remove);
            if (counterA != 0 && counterB != 0 && counterC != 0) {
                if (choicePileName == "A") {
                    counterA -= remove;
                } else if (choicePileName == "B") {
                    counterB -= remove;
                } else if (choicePileName == "C") {
                    counterC -= remove;
                }
                else{
                    System.out.println("A: 0, B: 0, C: 0");
                    isEmpty = true;
                }
                System.out.format("A: %d \t B: %d \t C: %d \t", counterA, counterB, counterC);
            }

        }


    }
}
