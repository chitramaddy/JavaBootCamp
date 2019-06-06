package com.company;
//"Zenith" - model -  - screenSize - 83 - channel - "NBC" - volume - 55 - powered - false
//manufacturer - "Sony" - model - "V32" - numSpeaker - 2 - station - "WUNV" - volume - 30 - powered - true
//manufacturer - "Haier" - model - "X1200w" - secondsLeft - 45 - time - "12:00" - running - false
//manufacturer - "Sunbeam" - model - "C12" - carafeSize - 12 - cupsLeft - 8 - powered - true
//make - "Honda" - model - "Accord" - type - "Sedan" - color - "Blue" - engine - "2.6L V6" -
// transmission - "CVT" - numDoors - 4 - mpg - 31.7 - milesDriven - 25218

//manufacturer - "Razer" - model - "Naga" - xPosition - 960 - yPosition - 540 - lastClickedLocation - [0,0]


public class App {

   public static TV createTV(){
       TV tv = new TV ("Zenith", "U2121H", 83, "NBC", 55, false);
        return tv;
    }

    public static Radio createRadio(){
       Radio radio = new Radio("Sony", "V32", 2, "WUNV", 30,true);
       return radio;
    }

    public static Microwave createMicrowave(){
       Microwave microwave = new Microwave("Haier", "X1200w", 45, "12:00", false );
       return microwave;
    }

    public static CoffeeMaker createCoffeeMaker(){
       CoffeeMaker coffeeMaker = new CoffeeMaker("Sunbeam", "C12",   12,  8, true);
    return coffeeMaker;
   }

    public static Car createCar(){
       Car car = new Car ("Honda" ,"Accord",  "Sedan", "Blue", "2.6L V6", "CVT",  4,31.7, 25218  );
    return car;
   }

   public static ComputerMouse createComputerMouse(){
       int[] lCL = new int[]{0,0};


       ComputerMouse computerMouse = new ComputerMouse("Razer", "Naga", 960, 540, lCL);
       return computerMouse;
   }

}
