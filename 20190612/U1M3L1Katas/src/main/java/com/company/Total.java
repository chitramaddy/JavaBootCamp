package com.company;

import java.util.ArrayList;
import java.util.List;

public class Total {

    public static void main(String[] args) {

        int[] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        int total = 0;

       List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(numbers[i]);
            total += numbersList.get(i);
        }
        System.out.println("The sum of the numbers in  " + total);

    }

}
