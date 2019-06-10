package com.company;

//code must read 5 ints from the user, put them in an array, and print the array elements to the screen.

import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] userArray = new int[5];

        for ( int i = 0; i < userArray.length; i++){
            System.out.print("Enter your number "+(i+1)+":");
            userArray[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println(" ");

        for(int element : userArray){
            System.out.print(+ element + " ");
        }

    }
}
