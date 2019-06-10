package com.company;

public class Store {

    private Chips chips;
    private SodaPop sp;
    private Chocolate choc;

    public Store(Chips chips, SodaPop sp, Chocolate choc) {
        this.chips = chips;
        this.sp = sp;
        this.choc = choc;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public SodaPop getSp() {
        return sp;
    }

    public void setSp(SodaPop sp) {
        this.sp = sp;
    }

    public Chocolate getChoc() {
        return choc;
    }

    public void setChoc(Chocolate choc) {
        this.choc = choc;
    }
}
