package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListReverseAndPrint {

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

        LinkedList<Integer> numbersLinkedList = new LinkedList<>();

        for(int i = 0; i < numbers.length; i++){
            numbersLinkedList.add(numbers[i]);
       }

        LinkedList<Integer> reversedNumbersLinkedList = new LinkedList<>();

        for(int i =0; i < numbersLinkedList.size(); i++){
            reversedNumbersLinkedList.add(numbersLinkedList.get(numbersLinkedList.size()-(i+1)));
        }
        System.out.println("Reversed Linked List: ");
        for(int num: reversedNumbersLinkedList){
            System.out.println(num);
        }

    }

}
