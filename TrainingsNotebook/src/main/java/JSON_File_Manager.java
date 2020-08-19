import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Exercise;
import entities.Training;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class JSON_File_Manager {

    private final String path;

    public JSON_File_Manager(String path) {
        this.path = path;
    }

    public void writeTraining(Training training,String fileName) {

        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path + fileName));

            Map<String, Object> trainingMap = new HashMap<>();
            trainingMap.put("id", training.getId());
            trainingMap.put("name", training.getName());
            trainingMap.put("type", training.getType());
            trainingMap.put("date", training.getDate());
            trainingMap.put("exercises", training.getExercises());

            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(trainingMap));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTraining(String fileName) {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(path + fileName));

            ObjectMapper mapper = new ObjectMapper();

            JsonNode parser = mapper.readTree(reader);
            System.out.println(parser.path("id").asInt());
            System.out.println(parser.path("name").asText());
            System.out.println(parser.path("type").asText());
            JsonNode date = parser.path("date");
            System.out.println(convertToDate(date));

            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeExercise(Exercise exercise, String fileName) {

        String pathToFile = path + fileName;
        System.out.println(pathToFile);
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathToFile));

            Map<String, Object> trainingMap = new HashMap<>();
            trainingMap.put("id", exercise.getId());
            trainingMap.put("name", exercise.getName());
            trainingMap.put("type", exercise.getType());
            if (exercise.getDescription() != null){
                trainingMap.put("description", exercise.getDescription());
            }
            if (Integer.valueOf(exercise.getReps()) != 0) {
                trainingMap.put("reps", exercise.getReps());
            }
            if (Integer.valueOf(exercise.getDuration()) != 0) {
                trainingMap.put("time", exercise.getDuration());
            }



            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(trainingMap));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LocalDateTime convertToDate(JsonNode date) {

        int year = date.path("year").asInt();
        int month = date.path("monthValue").asInt();
        int dayOfMonth = date.path("dayOfMonth").asInt();
        int hour = date.path("hour").asInt();
        int minutes = date.path("minute").asInt();

        LocalDateTime convertedDate = LocalDateTime.of(year, month, dayOfMonth, hour,minutes);

        return convertedDate;
    }
}
