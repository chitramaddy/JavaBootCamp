/*Create an ArrayList that can hold Integers, and fill each slot with a different random
value from 1-50. Display those values on the screen, and then prompt the user for an integer.
Search through the ArrayList, and if the item is present, say so. It is not necessary to
display anything if the value was not found. If the item is in the ArrayList multiple times,
it's okay if the program prints the message more than once.*/

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BasicArrayLists5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        int random1;

        for (int i = 0; i < 10; i++) {
            random1 = random.nextInt(50) + 1;
            numbers.add(random1);
        }
        System.out.println(numbers);
        System.out.println("Enter a number between 1 and 50: ");
        int input = Integer.parseInt(scan.nextLine());

        for(int i=0; i < numbers.size(); i++){
            if(numbers.get(i) == input){
                System.out.println(numbers.get(i) + " is in the ArrayList.");
            }
        }

    }
}
