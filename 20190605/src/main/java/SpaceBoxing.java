//ask what the earth weight is, and to enter a number for the planet he wants to fight on.
// It should then compute his weight on the destination planet based on the table below:

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        System.out.println("Please enter your current earth weight(lbs): ");

        float weight = Float.parseFloat(myScan.nextLine());

        System.out.println("I have the information for following planets: \n");
        System.out.println("1. Venus\t 2. Mars\t 3. Jupiter\n");
        System.out.println("4. Saturn \t 5. Uranus\t 6. Neptune\n");

        System.out.println("Enter the number of the planet number you are visiting: ");

        int planetNumber = Integer.parseInt(myScan.nextLine());
        float calculatedWeight = 0.0f;


        if (planetNumber == 1) {
            calculatedWeight = weight * 0.78f;
        } else if (planetNumber == 2) {
            calculatedWeight = weight * 0.39f;
        } else if (planetNumber == 3) {
            calculatedWeight = weight * 2.65f;
        } else if (planetNumber == 4) {
            calculatedWeight = weight * 1.17f;
        } else if (planetNumber == 5) {
            calculatedWeight = weight * 1.05f;
        } else if (planetNumber == 6) {
            calculatedWeight = weight * 1.23f;
        }


        System.out.format("Your weight would be %.2f pounds on that planet.", calculatedWeight);
    }
}
