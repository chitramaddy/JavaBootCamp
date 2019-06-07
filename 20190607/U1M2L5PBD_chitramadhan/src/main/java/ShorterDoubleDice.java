
import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        Random random = new Random();
        int random1;
        int random2;

        System.out.println("HERE COMES THE DICE!");

        do {
            random1 = random.nextInt(6) + 1;
            random2 = random.nextInt(6) + 1;
            System.out.println("Roll #1: " + random1);
            System.out.println("Roll #2: " + random2);
            int total = random1 + random2;
            System.out.println("The total is " + total + "!\n");
        }while(random1 != random2);

        }
    }
