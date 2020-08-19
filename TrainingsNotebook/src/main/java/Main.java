
import entities.Exercise;
import entities.Training;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//
//        CSV_management csv_manager = new CSV_management("data/test.csv");
//        csv_manager.writeFile(new String[]{"to", "jest", "test"});
//        csv_manager.printContent();


        JSON_File_Manager jsonFileManager = new JSON_File_Manager("data/");

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise1 = new Exercise.ExerciseBuilder(1,"shoulders").type("Push ups").description("spider push ups").build();
        Exercise exercise2 = new Exercise.ExerciseBuilder(1,"burpees").type("Push ups").description("spider push ups").build();
        exerciseList.add(exercise1);
        Training training = new Training(1,"Wod 3x8","Chest and Shoulders" ,LocalDateTime.now(), exerciseList);
        Training training2 = new Training(2,"Time wod","Time wod for endurance" ,LocalDateTime.now(), exerciseList);
        //jsonFileManager.writeTraining(training);
        jsonFileManager.writeExercise(exercise2, "exercises.json");
        jsonFileManager.readTraining("trainings.json");
    }
}
