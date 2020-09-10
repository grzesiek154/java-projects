import entities.Exercise;
import entities.Workout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ClassForTesting {

   static Exercise exercise = new Exercise.ExerciseBuilder("exercise one",new Workout("asd zxc")).reps(10).type("chest").build();



    public static void main(String[] args) {

       Stream<Field> fieldStream = Arrays.stream(Exercise.class.getDeclaredFields());
       List<String> fieldNames = new ArrayList<>();

       fieldStream.forEach(x -> fieldNames.add(x.getName()));

       for(String name:fieldNames) {
           System.out.println(name);
       }

        Exercise.insertExercise(exercise);
    }
}
