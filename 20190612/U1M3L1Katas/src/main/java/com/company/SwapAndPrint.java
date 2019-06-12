package com.company;

import java.util.ArrayList;
import java.util.List;

public class SwapAndPrint {

    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        System.out.println("----------------");
        System.out.println("Original Array");

        for(int element : numbers) {
            System.out.println(element);
        }

        System.out.println("==============================");

        List<Integer> numbersArray = new ArrayList<>();

        for(int i =0; i < numbers.length; i++){
            numbersArray.add(numbers[i]);
        }

        int temp1 = numbersArray.get(0);
        int tempLast = numbersArray.get(numbersArray.size()-1);
        numbersArray.set(0, tempLast);
        numbersArray.set(numbersArray.size()-1, temp1);

        System.out.println("Swapped Array List");
        for(Integer num : numbersArray){
            System.out.println(num);
        }
    }
}
