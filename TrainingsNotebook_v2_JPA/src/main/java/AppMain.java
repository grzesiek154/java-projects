import java.io.IOException;
import java.util.Scanner;

public class AppMain {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select correct option:");
        System.out.println("1. Add Workout");
        System.out.println("2. Add Exercise");
        System.out.println("3. Add Training");
        System.out.println("4. Close App");

        while (sc.hasNext()) {


            int firstOption = sc.nextInt();
            System.out.println("User choice: " + firstOption);
            if(firstOption == 1) {
                System.out.println(sc.nextInt());
                System.out.println("1. Save Data");
            } else if(firstOption == 4) {
                break;
            }



        }
    }

    private static void clearScreen() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
