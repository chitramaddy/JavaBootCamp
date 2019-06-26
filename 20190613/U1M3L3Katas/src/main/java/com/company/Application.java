package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {


        int petIndex = 0;

        //To check if the petIndex entered by the user is a valid entry ie within the Array index limits.
        do {
            try {
                petIndex = Pets.choosePet();

                String chosenPet = Pets.retrievePet(petIndex);

                Pets.readPetsFromFile();

                Pets.writePetToFile(chosenPet);

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.\n");
            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Please choose an available pet.\n");
            } catch (FileNotFoundException e) {

                System.out.println("Oops - I couldn't find your file: " + e.getMessage() + "\n");
            } catch (IOException e) {

                System.out.println("ERROR: Could not write to file: " + e.getMessage() + "\n");
            }

        } while (petIndex < 0 || petIndex > 5);

                    System.out.println( "Have a nice day!");


    }

}
