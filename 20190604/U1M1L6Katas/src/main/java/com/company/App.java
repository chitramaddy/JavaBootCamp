package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] numbers = arrayInput();
        String[] strings = stringArrayInput();

        int secondMaxNumber = secondLargestNumber(numbers);
        System.out.println("Second Largest Number is " + secondMaxNumber);
        System.out.println("-----------------------------------");

        int[] reversedArray = reverse(numbers);
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.println(reversedArray[i]);
        }
        System.out.println("-----------------------------------");

        int sum = total(numbers);
        System.out.println("The total is " + sum);
        System.out.println("-----------------------------------");

        int sumOfOddIndex = totalOdd(numbers);
        System.out.println("Total (even place) " + sumOfOddIndex);
        System.out.println("-----------------------------------");

        int sumOfEvenIndex = totalEven(numbers);
        System.out.println("Total (odd place) " + sumOfEvenIndex);
        System.out.println("-----------------------------------");

        String[] swappedArray = swapFirstAndLast(strings);
        for (String i : swappedArray) {
            System.out.println(i);
        }

        String concatenatedString = concatenateString(strings);
        System.out.println("Concatenated String is " + concatenatedString);
        System.out.println("-----------------------------------");

        int[] thirdElements = everyThird(numbers);
        for (int i = 0; i < thirdElements.length - 1; i++) {
            System.out.println(thirdElements[i]);
        }
        System.out.println("---------------------------------");

        int[] lessThanFive = lessThanFive(numbers);
        for(int i=0; i < lessThanFive.length; i++){
            System.out.println(lessThanFive[i]);
        }
        System.out.println("---------------------------------");

    }

    public static int[] arrayInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many numbers do you want to enter? ");
        int arraySize = Integer.parseInt(myScanner.nextLine());
        int[] arrayInput = new int[arraySize];

        for (int i = 0; i < arrayInput.length; i++) {
            System.out.println("Enter your number (" + (i + 1) + ")");
            arrayInput[i] = Integer.parseInt(myScanner.nextLine());
        }
        return arrayInput;
    }

    public static String[] stringArrayInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many words do you want to enter?");
        int stringArraySize = Integer.parseInt(myScanner.nextLine());
        String[] stringArray = new String[stringArraySize];

        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Enter your word (" + (i + 1) + ")");
            stringArray[i] = myScanner.nextLine();
        }
        return stringArray;
    }

    public static int total(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int totalOdd(int[] arr) {
        int sumOfOddIndex = 0;
        for (int i = 1; i < arr.length; i += 2) {
            sumOfOddIndex += arr[i];
        }
        return sumOfOddIndex;
    }

    public static int totalEven(int[] arr) {
        int sumOfEvenIndex = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sumOfEvenIndex += arr[i];
        }
        return sumOfEvenIndex;
    }

    public static int[] reverse(int[] arr) {

        int[] reverseArray = new int[arr.length];

        //take the last element in the array, push it as the first element in the new array
        for (int i = 0; i < arr.length; i++) {
            reverseArray[i] = arr[arr.length - (i + 1)];
        }
        return reverseArray;
    }

    public static int secondLargestNumber(int[] arr) {

        int maxNumber = arr[0];
        int secondMaxNumber = arr[1];

        if (arr[1] > arr[0]) {
            maxNumber = arr[1];
            secondMaxNumber = arr[0];
        } else {
            maxNumber = arr[0];
            secondMaxNumber = arr[1];
        }


        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > maxNumber) {
                secondMaxNumber = maxNumber;
                maxNumber = arr[i];
            } else if (arr[i] > secondMaxNumber) {
                secondMaxNumber = arr[i];
            }
        }
        return secondMaxNumber;
    }

    public static String[] swapFirstAndLast(String[] arr) {

        String[] resultArr = new String[arr.length];

        resultArr[0] = arr[arr.length - 1];
        resultArr[arr.length - 1] = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            resultArr[i] = arr[i];
        }

        return resultArr;
    }

    public static String concatenateString(String[] arr) {
        String concatenatedString = "";

        for (String element : arr) {
            concatenatedString += element;
        }

        return concatenatedString;
    }

    public static int[] everyThird(int[] arr) {
        if (arr.length > 2) {
            int[] thirdElement = new int[arr.length / 3];
            for (int i = 2; i < arr.length; i += 3) {
                thirdElement[(i + 1) - 3] = arr[i];
                System.out.println(thirdElement[(i + 1) - 3]);
            }
            return thirdElement;
        } else {
            return null;
        }
    }

    public static int[] lessThanFive(int[] arr) {
        int counter = 0;
        int j = 0;

        for (int element : arr) {
            if (element < 5) {
                counter++;
            }
        }

        int[] lessThanFiveArray = new int[counter];

        for (int i : arr) {
            if (i < 5) {
                lessThanFiveArray[j] = i;
                j++;
            }
        }
        if (lessThanFiveArray.length != 0) {
            return lessThanFiveArray;

        } else {
            return null;
        }
    }
}


