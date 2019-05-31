package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("Enter your favorite programming language: ");
            userInput = myScanner.nextLine();

            if(userInput.equals("Java")){
                System.out.println("That's what I was looking for! Java is definitely the answer!");
            }
        } while (!userInput.equals("Java"));
    }
}
