package com.company;

public class IceCreamShop {

    private String orderNo;
    private int numberOfScoops;
    private Flavors flavor;
    private boolean isCone;
    private boolean isTopping;
    private double toppingsPrice = 0.75;
    private double conePrice = 0.75;
    private double salesTax = 0.07;
    private double total;

    public IceCreamShop(String orderNo, int numberOfScoops, Flavors flavor, boolean isCone, boolean isTopping) {
        this.orderNo = orderNo;
        this.numberOfScoops = numberOfScoops;
        this.flavor = flavor;
        this.isCone = isCone;
        this.isTopping = isTopping;
    }

    public int getNumberOfScoops() {
        return numberOfScoops;
    }

    public void setNumberOfScoops(int numberOfScoops) {
        this.numberOfScoops = numberOfScoops;
    }

    public Flavors getFlavorName() {
        return flavor;
    }

    public void setFlavorName(Flavors flavor) {
        this.flavor = flavor;
    }

    public boolean isCone() {
        return isCone;
    }

    public void setCone(boolean cone) {
        isCone = cone;
    }

    public double getToppingsPrice() {
        return toppingsPrice;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double toppingsPrice() {
        if (isTopping) {
            return toppingsPrice;
        } else {
            return 0;
        }
    }

    private double conePrice() {
        if (isCone) {
            return conePrice;
        } else {
            return 0;
        }
    }

    public double calculatePrice() {

        double calcSalesTax = ((flavor.getFlavorPrice() * numberOfScoops) + this.toppingsPrice() + this.conePrice()) * this.salesTax;
        total = calcSalesTax+flavor.getFlavorPrice();

        return total;
    }
}
