package entities;

import Exceptions.DataAlreadyInDb;
import Exceptions.DataDoNotExistInDb;

import java.sql.Connection;


public class Workout {


    private String name;


    public Workout(String name) {
        this.name = name;
    }


    public static void insertWorkout(Connection con, Workout workout) {

        boolean isAlreadyInDb = isWorkoutExist(con, workout.getName());

        if (isAlreadyInDb) {
            try {
                throw new DataAlreadyInDb("Workout with name: " + workout.getName() + " already exist in database");
            } catch (DataAlreadyInDb dataAlreadyInDb) {
                dataAlreadyInDb.printStackTrace();
            }
        }
        String query = "INSERT INTO workouts (name) VALUES('" + workout.getName().toLowerCase() +"')";
        EntityManagement.doQuery(con,query);
    }


    public static void deleteWorkout(Connection con, String workoutName) {

        String query = "DELETE FROM workouts WHERE name = '" + workoutName.toLowerCase() +"'";
        EntityManagement.doQuery(con, query);
    }

    public static void printWorkouts(Connection con) {

            EntityManagement.printData(con, "workouts");
    }
    
    public static boolean isWorkoutExist(Connection con, int id) {

        boolean isExist = EntityManagement.getDataById(con,"workouts", id);

        return isExist ? true : false;
    }

    public static boolean isWorkoutExist(Connection con, String name) {

        boolean isExist = EntityManagement.getDataByName(con, "workouts", name.toLowerCase());

        return isExist ? true : false;
    }

    public static void updateWorkoutName(Connection con, String oldName, String newName) {
        boolean isWorkoutInDb = Workout.isWorkoutExist(con, oldName);

        if(!isWorkoutInDb) {
            try {
                throw new DataDoNotExistInDb("Workout with name: " + oldName + " do not exist in database");
            } catch (DataDoNotExistInDb dataDoNotExistInDb) {
                dataDoNotExistInDb.printStackTrace();
            }
        }

        String query = "UPDATE workouts SET name = "+ "'" + newName + "'" + " WHERE name = " + "'" + oldName + "'";
        EntityManagement.doQuery(con, query);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
