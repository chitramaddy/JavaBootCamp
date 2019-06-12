package com.company;

import java.util.ArrayList;
import java.util.List;

public class WordList {

    public static void main(String[] args) {

        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        List<String> wordsArrayList = new ArrayList<>();

        for(String words : wordList){
            wordsArrayList.add(words);
        }

        for (String wordsFromArray : wordsArrayList){
            System.out.println("Words from Array: " +wordsFromArray);
        }


    }

}
