/*Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50.
Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList,
and if the item is present, give the slot number where it is located. If the value is not in the ArrayList,
display a single message saying so. If the value is present more than once, you may either display
  the message as many times as necessary, or display a single message giving the last slot number in which it appeared.
*/

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BasicArrayLists7 {

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
        boolean isFound = false;

        for(int i=0; i < numbers.size(); i++){
            if(numbers.get(i) == input){
                isFound = true;
                System.out.println((input) + " is in slot " + (i+1) +".");
            }
        }

        if(!isFound){
            System.out.println(input + " is not found in the ArrayList.");
        }
    }
}
