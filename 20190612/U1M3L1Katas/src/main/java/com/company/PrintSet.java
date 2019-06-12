package com.company;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrintSet {
    public static void main(String[] args) {
        Set<Integer> print = new HashSet<>();

        print.add(5);
        print.add(1);
        print.add(2);
        print.add(1);
        print.add(4);
        print.add(1);
        print.add(5);

        Iterator<Integer> iter = print.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }


    }


}
