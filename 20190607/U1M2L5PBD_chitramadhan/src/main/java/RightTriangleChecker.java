//Write a program to allow the user to enter three integers. You must use do-while or while loops to
// enforce that these integers are in ascending order, though duplicate numbers are allowed.
//        Tell the user whether or not these integers would represent the sides of a right triangle.

import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isAscending = false;

        int a = 0;
        int b = 0;
        int c = 0;

        while (!isAscending) {

            System.out.println("Your numbers should be in ascending order.");
            System.out.println("Enter side 1: ");
            a = Integer.parseInt(scan.nextLine());
            System.out.println("Enter side 2: ");
            b = Integer.parseInt(scan.nextLine());
            System.out.println("Enter side 3: ");
            c = Integer.parseInt(scan.nextLine());
            if (a <= b && b <= c) {
                isAscending = true;
            }
        }

        if (c * c == (a * a) + (b * b)) {
            System.out.println("The sides form right triangle.");
        } else {
            System.out.println("The sides do not form a right triangle.");
        }


    }

}

