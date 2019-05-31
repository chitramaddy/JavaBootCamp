package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String userInput;
        String userGrade;
        String planningCollege;
        String collegeName;
        String afterHighSchool;
        String job;

        int age;

        System.out.println("Enter your age: ");
        userInput = myScanner.nextLine();
        age = Integer.parseInt(userInput);

        if (age < 14) {
            System.out.println("What grade are you in? ");
            userGrade = myScanner.nextLine();
            System.out.format("Wow! %s grade - that sounds exciting!", userGrade);
        } else if (age >= 14 && age <= 18) {
            System.out.println("Are you planning to go to college? (yes/no)");
            planningCollege = myScanner.nextLine();
            if (planningCollege.equals("yes")) {
                System.out.println("Which college? ");
                collegeName = myScanner.nextLine();
                System.out.format("%s is a great school!", collegeName);
            } else if (planningCollege.equals("no")) {
                System.out.println("What are you planning to do after high school?");
                afterHighSchool = myScanner.nextLine();
                System.out.format("Wow, %s sounds like a plan!", afterHighSchool);
            }

        } else if (age > 18) {
            System.out.println("What is your job?");
            job = myScanner.nextLine();
            System.out.format("%s sounds like a great job!", job);

        }

    }
}
