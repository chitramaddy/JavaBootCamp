package com.company;

import java.util.ArrayList;
import java.util.List;

public class ReverseAndPrint {

    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        System.out.println("--------------");
        System.out.println("Normal");
        System.out.println("--------------");

        for(int element : numbers) {
            System.out.println(element);
        }

        List<Integer> numbersArrayList = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++){
            numbersArrayList.add(numbers[i]);
        }

        List<Integer> reversedNumbersArrayList = new ArrayList<>();

        for(int i =0; i < numbersArrayList.size(); i++){
            reversedNumbersArrayList.add(i, numbersArrayList.get(numbersArrayList.size()-(i+1)));
        }
        System.out.println("Reversed Array List: ");
        for(int num: reversedNumbersArrayList){
            System.out.println(num);
        }
    }
}
