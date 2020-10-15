import Controllers.*;
import DAO.ExerciseDaoImpl;
import DAO.WorkoutDaoImpl;
import Entities.Exercise;
import Entities.Workout;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder();
        Exercise exercise1 = new Exercise();
        exercise1.setName("clean and press");
        exercise1.setType("weight lifting");
        exercise1.setWorkout(new Workout("clean and press", "clean and press workout"));

        Exercise exercise2 = new Exercise();
        exercise2.setName("exercise2");
        exercise2.setType("strength");

        BaseController controller = new WorkoutController(new WorkoutDaoImpl());

        BaseController exerciseController = new ExerciseController(new ExerciseDaoImpl());


        BaseController controller1 = ControllerFactoryImpl.createController("training");

        




    }
}
