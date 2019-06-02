package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        int length = Integer.parseInt(scan.nextLine());

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? ");
        cementCost = Float.parseFloat(scan.nextLine());
        // On line 23 changed the variable name is entered wrong. Changed the variable to 'framingCost'.
        System.out.print("What is the cost of framing/footers per linear foot? ");
        framingCost = Float.parseFloat(scan.nextLine());

        int area = length * width;
        int perimeter = 2*length + 2*width;//Corrected the perimeter formula. Replaced '-' with '+'

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d square feet.%n", perimeter);

        System.out.format("The cost of the cement is %.2f.%n", area*cementCost);//truncated the floating decimals to 2 instead of 6.
        System.out.format("The cost of the framing/footers is %.2f.%n", perimeter*framingCost);//corrected the formula. replaced '+' with '*'.
        //truncated the floating decimals to 2 instead of 6.
    }
}