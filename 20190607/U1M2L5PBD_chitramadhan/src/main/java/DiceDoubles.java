

import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("HERE COMES THE DICE!");

        int random1 = random.nextInt(6)+1;
        int random2 = random.nextInt(6)+1;

        while(random1 != random2){
            random1 = random.nextInt(6)+1;
            random2 = random.nextInt(6)+1;
            System.out.println("Roll #1: "+random1);
            System.out.println("Roll #2: "+random2);
            int total = random1+random2;
            System.out.println("The total is "+ total +"!\n");

        }
    }
}
