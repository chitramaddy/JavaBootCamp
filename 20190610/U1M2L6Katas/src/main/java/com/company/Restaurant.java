package com.company;

public class Restaurant {

    private SodaPop sodaPop;

    public Restaurant(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public void installSodaPop(){
        System.out.println("Sodapop installed");
    }
}
