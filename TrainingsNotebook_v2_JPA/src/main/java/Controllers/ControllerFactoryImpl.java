package Controllers;

import DAO.BaseService;
import DAO.ExerciseDaoImpl;
import DAO.TrainingDaoImpl;
import DAO.WorkoutDaoImpl;

public class ControllerFactoryImpl{

    public static BaseController createController(String controllerType) {
        if("Workout".equalsIgnoreCase(controllerType)) {
            return new WorkoutController(new WorkoutDaoImpl());
        } else if ("Exercise".equalsIgnoreCase(controllerType)) {
            return new ExerciseController(new ExerciseDaoImpl());
        } else if ("Training".equalsIgnoreCase(controllerType)) {
            return new TrainingController(new TrainingDaoImpl());
        }
        return null;
    }
}
