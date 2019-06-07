//Write a program to take the square root of a number
// typed in by the user. Your program should use a loop to
// ensure that the number they typed in is positive. If the
// number is negative, you should print out some sort of warning
// and make them type it in again. Note that it is possible to do
// this program with either a while loop or a do-while loop.
// (Though personally, I think this one is easier with a while loop.)
//You can get the square root of a number n with Math.sqrt(n). Make sure
// you don't do this until the loop is done and you know for sure you've
// got a positive number.

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isPositive = false;
        double userInput;
        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number: ");


        while(isPositive == false){

            System.out.println("Try Again: ");
            userInput = Integer.parseInt(scan.nextLine());
            if(userInput < 0){
                System.out.println("You can't take the square root of a negative number, silly.");
            }
            else{
                double sqrt = Math.sqrt(userInput);
                System.out.format("The square root of %f is %f", userInput, sqrt);
                isPositive = true;
            }
        }

    }




}
