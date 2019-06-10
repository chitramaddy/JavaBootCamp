package com.company;

public class VendingMachine {
    private Chips chips;
    private SodaPop sp;
    private Gum gums;
    private Chocolate choco;
    private Mints mint;
    private PopCorn pc;

    public VendingMachine(Chips chips, SodaPop sp, Gum gums, Chocolate choco, Mints mint, PopCorn pc) {
        this.chips = chips;
        this.sp = sp;
        this.gums = gums;
        this.choco = choco;
        this.mint = mint;
        this.pc = pc;
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

    public Gum getGums() {
        return gums;
    }

    public void setGums(Gum gums) {
        this.gums = gums;
    }

    public Chocolate getChoco() {
        return choco;
    }

    public void setChoco(Chocolate choco) {
        this.choco = choco;
    }

    public Mints getMint() {
        return mint;
    }

    public void setMint(Mints mint) {
        this.mint = mint;
    }

    public PopCorn getPc() {
        return pc;
    }

    public void setPc(PopCorn pc) {
        this.pc = pc;
    }

    public void refillItem(String item){
        System.out.println("Refilled "+item);
    }
}
