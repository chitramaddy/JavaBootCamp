package com.company;

import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] userArray = new String[5];

        for (int i = 0; i < userArray.length; i++) {
            System.out.print("Enter your word #" + (i + 1) + ":");
            userArray[i] = scan.nextLine();
        }
        System.out.print("The words are ");

        for (int i = 0; i < userArray.length; i++) {
            if (i < userArray.length - 1) {
                System.out.print(userArray[i] + ",");
            } else {
                System.out.print(userArray[i] + ".");
            }

        }
    }
}

