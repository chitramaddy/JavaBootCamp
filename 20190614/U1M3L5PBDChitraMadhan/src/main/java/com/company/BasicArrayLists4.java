/*      Create an ArrayList of Integers
        Fill the ArrayList with ten random numbers (1-100)
        Copy each value from the ArrayList into another ArrayList of the same capacity
        Change the last value in the first ArrayList to a -7
        Display the contents of both ArrayLists*/

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists4 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers1 = new ArrayList<>();

        Random random = new Random();
        int random1;

        for(int i =0; i < 10; i++){
            random1 = random.nextInt(100)+1;
            numbers.add(random1);
            numbers1.add(numbers.get(i));
        }
        numbers.set(9, -7);
        System.out.println(numbers);
        System.out.println(numbers1);    }

}
