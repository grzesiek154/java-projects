import Controllers.ExerciseController;
import Controllers.WorkoutController;
import Entities.Exercise;
import Entities.Workout;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//     WorkoutController.printSingleWorkout(1L);
//     WorkoutController.deleteWorkout(2L);
//     WorkoutController.printAllWorkouts();

        Map<String, Object> exerciseValues = new HashMap<>();
        exerciseValues.put("name", "Stas");
        exerciseValues.put("workoutId", 13L);
        exerciseValues.put("reps", 13);
        exerciseValues.put("DesCription", "this is test workout description");

        ExerciseController.addExercise(exerciseValues);




        Exercise exercise = ExerciseController.createProperExercise(exerciseValues);
        System.out.println(exercise.getName());

        System.out.println(exercise.getDescription());
        System.out.println(exercise.getReps());

    }
}
