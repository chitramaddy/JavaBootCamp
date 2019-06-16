package com.company;

public class Human {

    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public Human(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    public void run(int speed){

    }
    public int attack(){
        return  this.attackPower--;
    }
    public int heal(){
        return this.strength += 10;
    }
    public int decreaseHealth(){
        return this.health -= 5;
    }
    public int decreaseStamina(){
        return this.stamina -= 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
