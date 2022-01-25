import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileStatisticsServiceImpl fileStatisticsService = new FileStatisticsServiceImpl();
        List<String> wordsList = new LinkedList<>();

        try {
           wordsList = new ReadTxtFileServiceImpl().readFile("books/book1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //wordsList.forEach((word) -> System.out.println("word: " + word));
        System.out.println(fileStatisticsService.getLongestWord(wordsList));
        System.out.println(fileStatisticsService.getMostPopularWord(wordsList));
        System.out.println(fileStatisticsService.getMostUniqueWord(wordsList));
        System.out.println(fileStatisticsService.getShortestWord(wordsList));

    }

    static void displayMainOptions() {
        System.out.println("1. Enter the input manually");
        System.out.println("2. Paste the path to the file (txt, html)");
        System.out.println("3. Exit");
        System.out.println("4. Back to main menu");
    }

    static void displayStatOption(boolean isOpen) {
        System.out.println("1. Get longest word");
        System.out.println("2. Get  shortest word");
        System.out.println("3. Exit");
        System.out.println("4. Back to main menu");
        isOpen = false;
    }

    static void mangeMenu(Scanner sc) {
        displayMainOptions();


        boolean isOpen = true;
        boolean forward = true;
        while (isOpen) {
            int firstOption = sc.nextInt();
            sc.nextLine();
            switch (firstOption) {
                case 1:
                    System.out.println("Option 1 selected");
                    displayStatOption(true);
                    // how to await user input for stat options
                    break;
                case 2:
                    System.out.println("Option 2 selected");
                    displayMainOptions();
                    isOpen = false;
                    break;
                case 3:
                    System.out.println("Option 3 selected");
                    isOpen = false;
                    break;
                case 4:
                    displayMainOptions();
                    isOpen = false;
                    break;


            }
        }
    }
}
