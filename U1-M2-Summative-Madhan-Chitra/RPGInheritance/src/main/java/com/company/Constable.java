package com.company;

public class Constable extends Human{

    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;
    private String jurisdiction;

    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction) {
        super(name, strength, health, stamina, speed, attackPower);
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
        this.jurisdiction = jurisdiction;
    }

    public void run(int speed){
        System.out.println("Constable" + this.getName() +"running slow at speed "+ speed);
    }

    public int attack(){
        return this.attackPower = attackPower--;
    }

    public int heal(){
        return this.strength++;

    }

    public int decreaseHealth(){
        return this.health -= 5;
    }

    public  int decreaseStamina(){
        return this.stamina -= 10;
    }

  public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

}
