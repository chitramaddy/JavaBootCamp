package com.company;

import java.util.LinkedList;

public class LinkedListTotal {

    public static void main(String[] args) {

        int[] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

       int total = 0;

        LinkedList<Integer> numbersList = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(numbers[i]);
            total += numbersList.get(i);
        }
        System.out.println("The total of the numbers in  " + total);
    }

}