package com.company;

public class Warrior extends Human{

    static int strength;
    static int health;
    static int stamina;
    static int speed;
    static int attackPower;
    static int shieldStrength;

    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super(name, strength, health, stamina, speed, attackPower);
    }


    public void run(int speed){
        System.out.println("Warrior " + this.getName() +" is running at speed "+ speed);
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

    public int decreaseSheildStrenth(){
        return this.shieldStrength -=10;
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

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
