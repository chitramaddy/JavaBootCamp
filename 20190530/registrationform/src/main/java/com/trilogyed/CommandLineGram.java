package com.trilogyed;

import java.util.Scanner;

public class CommandLineGram {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter your first name, please");
        String firstName = myScanner.nextLine();

        System.out.println("Enter your last name, please");
        String lastName = myScanner.nextLine();

        System.out.println("email address: ");
        String email = myScanner.nextLine();

        System.out.println("Twitter handle: ");
        String twitterHandle = myScanner.nextLine();

        System.out.println("Age: ");
        String age = myScanner.nextLine();

        System.out.println("Country: ");
        String country = myScanner.nextLine();

        System.out.println("Profession: ");
        String profession = myScanner.nextLine();

        System.out.println("Favorite Operating System: ");
        String favorite_OS = myScanner.nextLine();

        System.out.println("Favorite Programing Language: ");
        String favoriteProgramingLanguage = myScanner.nextLine();

        System.out.println("Favorite computer scientist: ");
        String favoriteComputerScientist = myScanner.nextLine();

        System.out.println("Favorite keyboard shortcut: ");
        String favoriteKeyboardShortcut = myScanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String trueOrFalse = myScanner.nextLine();

        System.out.println("If you could be any super hero, who would it be?");
        String superHero = myScanner.nextLine();

        System.out.println("Hi! "+ firstName + lastName + "!");

        System.out.format("Your email is %s; " +
                "twitter handle is %s.\n", email, twitterHandle);

        System.out.format("You are %s years old. You are from %s. Your profession is %s.\n", age, country, profession);

        System.out.format("Your favorite: \n" +
                "Operating System is %s; " +
                "Programming Language is %s; " +
                "Computer Scientist is %s.\n",
                favorite_OS, favoriteProgramingLanguage, favoriteComputerScientist);

        System.out.format("'%s' is my favorite keyboard shortcut, too.\n", favoriteKeyboardShortcut);

        System.out.format("You said '%s' to whether you have a built a question. Is that correct?\n", trueOrFalse);

        System.out.format("You are really a %s.\n", superHero);
    }
}
