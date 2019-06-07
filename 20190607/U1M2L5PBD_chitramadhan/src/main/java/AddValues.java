import java.util.Scanner;
//Write a program that gets several integers from the user.
// Sum up all the integers they give you. Stop looping when they enter a 0.
// Display the total at the end.

public class AddValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");

        boolean isZeroEntered = false;
        int sum = 0;

        while (isZeroEntered == false) {

            int input;
            System.out.println("Number: ");
            input = Integer.parseInt(scan.nextLine());
            sum += input;

            if (input == 0) {
                isZeroEntered = true;
                System.out.println("The total is "+ sum +".");
            }
        }

    }

}
