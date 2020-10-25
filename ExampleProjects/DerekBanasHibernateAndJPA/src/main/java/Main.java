import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int upperLimit = 100;
        double doubleLimit = 100;
        int randomInt = random.nextInt(upperLimit);
        double randomDouble = random.nextDouble() * 100;
        boolean test;

        System.out.println(randomInt);
        System.out.println(randomDouble);

        if(randomDouble < 21) {
            System.out.println("Do the audit: " + randomDouble);
        } else {
            System.out.println("No audit: " + randomDouble);
        }

        test = false;
        if(!test){
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
