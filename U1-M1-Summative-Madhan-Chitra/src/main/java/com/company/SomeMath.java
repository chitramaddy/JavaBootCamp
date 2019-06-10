package com.company;

public class SomeMath {
    public static void main(String[] args) {
        int printTotal = total5(1, 3, 5, 7, 9);
        System.out.println("The total is "+ printTotal + ".");

        double printAverage = average5(1, 3, 5, 7, 9);
        System.out.println("The average is "+ printAverage);

        double largest = largest5(42.0, 35.1, 2.3, 40.2, 15.6);
        System.out.println("The largest number is "+ largest + ".");
    }

    public static int total5(int a, int b, int c, int d, int e){
        int sum = 0;
        sum = a+b+c+d+e;
        return sum;
    }

    public static double average5(int a, int b, int c, int d, int e){
        int sum = 0;
        double average;

        sum = a+b+c+d+e;
        average = sum/5;

        return average;
    }

    public static double largest5(double a, double b, double c, double d, double e){

        double[] valuesArray = { a, b, c, d, e};
        double largest = valuesArray[0];

        for(int i = 1; i < valuesArray.length; i++){
            if(valuesArray[i] > largest){
                largest = valuesArray[i];
            }
        }
        return largest;
    }




}
