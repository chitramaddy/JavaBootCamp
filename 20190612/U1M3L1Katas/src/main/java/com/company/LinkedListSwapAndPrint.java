package com.company;

import java.util.LinkedList;
import java.util.List;

public class LinkedListSwapAndPrint {

    public static void main(String[] args) {

        int [] numbers = {2, 4, 5, 3,
                7, 6, 1, 9,
                10, 13, 56, 43};

        System.out.println("==============================");
        System.out.println("Original Array");

        for(int element : numbers) {
            System.out.println(element);
        }

       System.out.println("==============================");

        List<Integer> numbersLinkedList = new LinkedList<>();

        for(int i =0; i < numbers.length; i++){
            numbersLinkedList.add(numbers[i]);
        }

        int tempFirst = numbersLinkedList.get(0);
        int tempLast = numbersLinkedList.get(numbersLinkedList.size()-1);
        numbersLinkedList.set(0, tempLast);
        numbersLinkedList.set(numbersLinkedList.size()-1, tempFirst);

        System.out.println("Swapped Linked List");
        for(Integer num : numbersLinkedList){
            System.out.println(num);
        }

    }
}

