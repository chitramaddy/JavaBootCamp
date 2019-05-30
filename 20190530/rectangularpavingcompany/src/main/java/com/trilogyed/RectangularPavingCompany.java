package com.trilogyed;

import java.util.Scanner;

public class RectangularPavingCompany {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the Width of the driveway(in feet): ");
        float width = Float.parseFloat(myScanner.nextLine());

        System.out.println("Enter the length of the driveway(in feet): ");
        float length = Float.parseFloat(myScanner.nextLine());

        System.out.println("Enter the cement price(in $): ");
        float cementCost = Float.parseFloat(myScanner.nextLine());

        System.out.println("Enter the framing/footer price(in $): ");
        float framingCost = Float.parseFloat(myScanner.nextLine());

        //Area of the driveway calculated, stored and displayed as a float with two decimal places.
        float areaOfTheDriveway = width * length;
        System.out.printf("Pavement area is %.2f sq. ft.\n", areaOfTheDriveway);

        //Cement cost for the total area of the driveway calculated, stored and displayed as a float with two decimal places.
        float cementCostForThePavement = cementCost * areaOfTheDriveway;
        System.out.printf("Your cement cost for the total area is $ %, .2f\n\n", cementCostForThePavement);

        //perimeter of the driveway calculated, stored and displayed as a float with two decimal places.
        float perimeterOfTheDriveway = 2 * (width + length);
        System.out.printf("Fence length is %.2f ft.\n", perimeterOfTheDriveway);

        //total fence cost calculated, stored and displayed as a float with two decimal places.
        float framingCostForThePavament = framingCost * perimeterOfTheDriveway;
        System.out.printf("Your fence cost for the total area is $ %, .2f\n", framingCostForThePavament);
    }
}
