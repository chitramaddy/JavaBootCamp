package com.company;

public class App {
    public static int subtract(int a, int b) {
        int result = a - b;
        return result;
    }

    public static int subtractOrZero(int a, int b) {
        int result = a - b;
        if (result >= 0) {
            return result;
        } else {
            return 0;
        }
    }

    public static int max(int a, int b, int c) {
        //check for max of the three integers
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static int min(int a, int b, int c) {
        //Check for min of the three integers
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    public static boolean isLarger(int first, int second) {
        //check if first is greater than second
        if (first > second) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int subtractResult = subtract(2, 10);
        System.out.format("subtract Result is %d.%n", subtractResult);
        int subtractOrZeroResult = subtractOrZero(2, 10);
        System.out.format("subtractOrZero Result is %d.%n", subtractOrZeroResult);
        int maxResult = max(3, 3, -4);
        System.out.format("Maximum number is %d.%n", maxResult);
        int minResult = min(3, 3, -4);
        System.out.format("Minimum number is %d.%n", minResult);
        boolean isLargerResult = isLarger(12, 10);
        System.out.format("Is first the greater number? %s.%n", isLargerResult);
    }

}
