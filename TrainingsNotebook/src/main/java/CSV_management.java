import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV_management {

    private String path;
    private List<String[]> list = new ArrayList();

    public CSV_management(String path) {
        this.path = path;
    }

    public void printContent(){
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(path));

            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Line from a file: " + line.toString());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String[]> readFile() {
        CSVReader reader = null;
        List<String[]> tempList = list;
        try {
            reader = new CSVReader(new FileReader(path));

            String[] line;
            while ((line = reader.readNext()) != null) {
                tempList.add(line);
                for(String word: line) {
                    System.out.println("line: " + word);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempList;
    }
    public void writeFile(String[] content){

        List<String[]> tempList = readFile();

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(path), ',');
            tempList.add(content);
            writer.writeAll(tempList);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
