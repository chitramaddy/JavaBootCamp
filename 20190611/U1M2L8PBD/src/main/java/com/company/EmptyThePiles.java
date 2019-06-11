package com.company;

import java.util.Scanner;

public class EmptyThePiles {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("A: 3 \t B: 3 \t C:3");


        //Three piles
        //counters set 3 in each
        int counterA = 3;
        int counterB = 3;
        int counterC = 3;

        //Boolean to check exit condition, isEmpty is set to true and while loop exits when all the three counters are empty or negative.
        boolean isEmpty = false;


        while (isEmpty == false) {

            //user chooses the pile name
            System.out.println("Choose a pile: ");
            String choicePileName = scan.nextLine();

            System.out.format("How many to remove from pile: %s \n", choicePileName);

            //user chooses the number of sticks to remove
            int remove = Integer.parseInt(scan.nextLine());
            System.out.println(remove);

                if (choicePileName.equals("A")) {
                    counterA -= remove;
                } else if (choicePileName.equals("B")) {
                    counterB -= remove;
                } else if (choicePileName.equals("C")){
                    counterC -= remove;
                }

                //every time when the stick is removed from the pile, check if exit condition is met.
                if(counterA <= 0 && counterB <= 0 && counterC <= 0){
                    isEmpty = true;
                }

                //print the remaining sticks in each pile after every removal.

            System.out.format("A: %d \t B: %d \t C: %d \t", counterA, counterB, counterC);
            }

        }


    }

