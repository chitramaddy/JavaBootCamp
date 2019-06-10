//code must declare the following array [1, 2, 3, 4, 5], create another
//array of equal length, and fill that array with values from the original array
//but in reverse order. Finally, your code must print the contents of both arrays
// to the screen.


package com.company;

import java.util.Scanner;

public class ArrayFunReverseIt {

        public static void main(String[] args) {

            int[] userArray = {1,2,3,4,5};
            int[] userArrayReversed = new int[5];
            System.out.println("The original numbers are 1,2,3,4,5");

            System.out.print("The numbers in reverse order is ");

            for(int i=0; i < userArray.length; i++){
                userArrayReversed[i] = userArray.length - (i);
                System.out.print( userArrayReversed[i]+" ");
            }

        }
    }


