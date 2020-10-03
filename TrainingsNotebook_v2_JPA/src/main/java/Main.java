import Controllers.ExerciseController;
import Entities.Exercise;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//     WorkoutController.printSingleWorkout(1L);
//     WorkoutController.deleteWorkout(2L);
//     WorkoutController.printAllWorkouts();

        Map<String, Object> exerciseValues = new HashMap<>();
        exerciseValues.put("name", "Zuzia");
        exerciseValues.put("workoutId", 14L);
        exerciseValues.put("reps", 100);
        exerciseValues.put("DesCription", "this is another test workout description");
        exerciseValues.put("type", "legs");

        ExerciseController.addExercise(exerciseValues);
        //ExerciseController.addExercise(exerciseValues);
//       WorkoutController.addWorkout("test workout", "qwe zxc asd");




//        Exercise exercise = ExerciseController.createProperExercise(exerciseValues);
//        System.out.println(exercise.getName());
//
//        System.out.println(exercise.getDescription());
//        System.out.println(exercise.getReps());

    }
}
