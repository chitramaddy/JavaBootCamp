package com.company;

public class App {

    public static void main(String[] args) {
        Flavors newFlavor = new Flavors("Chocolate", 2.75);
        IceCreamShop ics1 = new IceCreamShop("1",2, newFlavor, true, false);
        IceCreamShop ics2 = new IceCreamShop("1",2, newFlavor, true, false);
        IceCreamShop ics3 = new IceCreamShop("1",2, newFlavor, true, false);

        double total1 = ics1.calculatePrice();
        double total2 = ics2.calculatePrice();
        double total3 = ics3.calculatePrice();

        double total = total1+total2+total3;

        System.out.format("Your total price is $%.2f\n", total);

        Flavors newFlavorFactory = new Flavors ("Chocolate", 30);

        IceCreamFactory icf = new IceCreamFactory(newFlavorFactory, 30, 60);

        double factoryPrice = icf.calcTotal();
        System.out.format ("Factory price for %d gallons of %s ice cream is $%.2f", icf.getQuantity(), newFlavorFactory.getFlavorName(), factoryPrice);
    }
}
