import java.io.IOException;
import java.util.Scanner;

public class AppMain {


    public static void main(String[] args) {

        printAppUI();
    }





    private static void clearScreen() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMenu() {
        System.out.println("Select correct option:");
        System.out.println(
                "1. Add Workout\n" +
                "2. Add Exercise\n"+
                "3. Add Training\"\n" +
                "4. Close App");

    }

    private static void printStandardOptions(String entityType) {
        System.out.println("Select correct option:");
        System.out.println(
                "1. Add new "+ entityType +"\n" +
                        "2. Update "+ entityType +"\n" +
                        "3. Delete "+ entityType +"\n" +
                        "4. Find "+ entityType + " by id" + "\n" +
                        "5. Get all "+ entityType +"s" +"\n" +
                        "6. Back to main menu " +"\n" +
                        "7. Close App"
        );

    }

    private static void printAppUI() {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;


        printMenu();

        while (!quit) {
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    printStandardOptions("Workout");
                    break;
                case 2:
                    printStandardOptions("Exercise");
                case 6:
                    printMenu();
                    break;
            }
        }
    }
}
