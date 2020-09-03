package entities;

import java.sql.Connection;


public class Workout extends EntityManagement{


    private String name;


    public Workout(String name) {
        this.name = name;
    }


    public static void insertWorkout(Connection con, Workout workout) {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
