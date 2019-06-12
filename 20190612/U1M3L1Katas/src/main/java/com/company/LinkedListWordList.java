package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListWordList {

    public static void main(String[] args) {

        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        List<String> wordsLinkedList = new LinkedList<>();

        for(String words : wordList){
            wordsLinkedList.add(words);
        }

        System.out.println("\"Words from Linked List: \" ");

        for (String wordsFromLinkedList : wordsLinkedList){
            System.out.println(wordsFromLinkedList);
        }
    }
}
