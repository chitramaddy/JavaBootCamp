package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {

    public static void main(String[] args) {
        List<Integer> basicArray = new ArrayList<>();

        Random random = new Random();
        int random1;

        for( int i = 0; i < 1000; i++){
            random1 = random.nextInt((90)-1)+10;
            basicArray.add(random1);
        }
       }
}
