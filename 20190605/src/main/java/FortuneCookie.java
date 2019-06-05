import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {

        String question1="You will win the lotto today!!!";
        String question2="Today is the day!!!";
        String question3="4 is your number!!!";
        String question4="Today you will finish homework";
        String question5="WARNING! Do not eat your fortune!";
        String question6="No fortune for you";

        Random random = new Random();
        int fortune = random.nextInt(6);
        int generateRandom1 = random.nextInt(54)+1;
        int generateRandom2 = random.nextInt(54)+1;
        int generateRandom3 = random.nextInt(54)+1;
        int generateRandom4 = random.nextInt(54)+1;
        int generateRandom5 = random.nextInt(54)+1;
        int generateRandom6 = random.nextInt(54)+1;


        switch (fortune){
            case 0:
                System.out.println("Fortune cookie says: " + question1);
                break;
            case 1:
                System.out.println("Fortune cookie says: " + question2);
                break;
            case 2:
                System.out.println("Fortune cookie says: " + question3);
                break;
            case 3:
                System.out.println("Fortune cookie says: " + question4);
                break;
            case 4:
                System.out.println("Fortune cookie says: " + question5);
                break;
            case 5:
                System.out.println("Fortune cookie says: " + question6);
                break;
        }
        System.out.println(generateRandom1+"-"+generateRandom2+"-"+generateRandom3+"-"+generateRandom4+"-"+generateRandom5+"-"+generateRandom6);
    }
}
