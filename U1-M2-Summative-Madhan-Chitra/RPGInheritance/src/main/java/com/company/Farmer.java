package com.company;

public class Farmer extends Human{

        private int strength =  75;
        private int health = 100;
        private int stamina = 75;
        private int speed = 10;
        private int attackPower = 1;

        public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
            super(name, strength, health, stamina, speed, attackPower);
            this.strength = strength;
            this.health = health;
            this.stamina = stamina;
            this.speed = speed;
            this.attackPower = attackPower;
        }

        public void plow() {
            System.out.println("The Farmer is working very hard....plowing.");
        }

        public void harvest() {
            System.out.println("It is harvest time. The farmer is very happy.");
        }

        public void run(int speed){
            System.out.println("Farmer" + this.getName() +"running at speed "+ speed);
        }

        public int attack(){
            System.out.println("Farmers attack only offending small animals.");
            return attackPower;
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

}
