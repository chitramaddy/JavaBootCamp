package com.company;

public class IceCreamFactory {
    private Flavors flavor;
    private double deliveryCost;
    private int quantity;
    private int numberOfFlavors;
    private int milesFromFactory;
    private double total;

    public IceCreamFactory(Flavors flavor, int quantity, int milesFromFactory) {
        this.flavor = flavor;
        this.quantity = quantity;
        this.numberOfFlavors = numberOfFlavors;
    }

    public Flavors getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavors flavor) {
        this.flavor = flavor;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMilesFromFactory() {
        return milesFromFactory;
    }

    public void setMilesFromFactory(int milesFromFactory) {
        this.milesFromFactory = milesFromFactory;
    }
    public int getNumberOfFlavors() {
        return numberOfFlavors;
    }

    public void setNumberOfFlavors(int numberOfFlavors) {
        this.numberOfFlavors = numberOfFlavors;
    }

//    public void calculatePrice() {
//
//        switch (flavor.getFlavorName()){
//            case "Chocolate":
//            case "Cookie-dough":
//                flavor.setFlavorPrice(30);
//                break;
//
//            case "Strawberry":
//                flavor.setFlavorPrice(25);
//                break;
//
//            case "Vanilla":
//                flavor.setFlavorPrice(27.50);
//                break;
//
//            case "Mint":
//                flavor.setFlavorPrice(24.50);
//                break;
//
//            case "Coffee":
//                flavor.setFlavorPrice(29.75);
//                break;
//
//        }
//        }


    public double calcDeliveryCost(int milesFromFactory) {
        if (this.milesFromFactory <= 10) {
            deliveryCost = 5.00;
        } else if (this.milesFromFactory > 10 && this.milesFromFactory <= 25) {
            deliveryCost = milesFromFactory * 0.75;
        }

        return deliveryCost;
    }


       public double calcTotal(){
        double subTotal = ( flavor.getFlavorPrice()*this.getQuantity()) ;
        total = subTotal+ this.calcDeliveryCost(milesFromFactory);

        return total;
    }


}
