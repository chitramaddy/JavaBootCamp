/*Create an ArrayList of Integers. Fill up the list
with ten random numbers, each from 1 to 100. Then
display the contents of the ArrayList on the screen.*/

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {

    public static void main(String[] args) {
        List<Integer> basicArray = new ArrayList<>();

        Random random = new Random();
        int random1 = random.nextInt(100)+1;

        for( int i = 0; i < 10; i++){
            random1 = random.nextInt(100)+1;
            basicArray.add(random1);
        }

        System.out.println( "ArrayList: " + basicArray);
    }
}
