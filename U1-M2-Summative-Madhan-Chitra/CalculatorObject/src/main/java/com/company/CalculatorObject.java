package com.company;

public class CalculatorObject {

    public static void main(String[] args) {
        CalculatorObject calculatorObject = new CalculatorObject();

        int resultInt;
        double resultDouble;

        resultInt = calculatorObject.addInt(1, 1);
        System.out.println("1 + 1 = "+ resultInt);

        resultInt = calculatorObject.subtrctInt(23, 52);
        System.out.println("23 - 52 = "+resultInt);

        resultInt = calculatorObject.multiplyInt(34, 2);
        System.out.println("34 * 2 = "+resultInt);

        resultDouble = calculatorObject.divideInt(12, 3);
        System.out.format("12/3 = %.2f\n", resultDouble);

        resultDouble = calculatorObject.divideInt(12, 7);
        System.out.format("12/7 = %.2f\n", resultDouble);

        resultDouble = calculatorObject.addDouble(3.4, 2.3);
        System.out.format("3.4 + 2.3 = %.2f\n", resultDouble);

        resultDouble = calculatorObject.multiplyDouble(6.7, 4.4);
        System.out.format("6.7 * 4.4 = %.2f\n",resultDouble);

        resultDouble = calculatorObject.subtractDouble(5.5, 0.5);
        System.out.format("5.5 -0.5 = %.2f\n", resultDouble);

        resultDouble = calculatorObject.divideDouble(10.8, 2.2);
        System.out.format("10.8/2.2 = %.2f\n", resultDouble);


    }


   public int addInt( int a, int b){
        return a + b;
    }
    public int subtrctInt( int a, int b){
        return a - b;
    }
    public int multiplyInt( int a, int b){
        return a * b;

    }public double divideInt( int a, int b){
        return a / b ;
   }

    public double addDouble( double a, double b){
        return a + b;
    }
    public double subtractDouble( double a, double b){
        return a - b;
    }
    public double multiplyDouble( double a, double b){
        return a * b;
    }public double divideDouble( double a, double b){
        return a / b;
    }


}
