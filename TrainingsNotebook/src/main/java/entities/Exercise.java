package entities;

import Exceptions.DataDoNotExistInDb;

import java.sql.Connection;
import java.util.*;

public class Exercise extends BaseEntity {


    private String name;
    private String type;
    private String description;
    private int reps;
    private int duration;
    private Workout workout;


    private Exercise(ExerciseBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.reps = builder.reps;
        this.duration = builder.time;
        this.workout = builder.workout;
    }

    private Map<String,String> getPresentData(Exercise exercise) {

        Map queryValues = new HashMap();

        String name = exercise.getName();
        String type = exercise.getType();
        String description = exercise.getDescription();
        int duration = exercise.getDuration();
        int reps = exercise.getReps();

        if(name.isEmpty()) {
            throw new NullPointerException("Exercise name not provided");
        } else {
            queryValues.put("name", name);
        }

        if(type != null) {
            queryValues.put("type", type);
        }
        if(description != null) {
            queryValues.put("description", description);
        }
        if(duration != 0) {
            queryValues.put("duration", String.valueOf(duration));
        }
        if(reps != 0) {
            queryValues.put("reps", String.valueOf(reps));
        }
        return queryValues;
    }

    public static void insertExercise(Connection con, Exercise exercise) {

        StringBuffer part1_buffer = new StringBuffer();
        StringBuffer part2_buffer = new StringBuffer();
        String query_part1;
        String query_part2;
        String finalQuery;

        Map<String,String> queryData = exercise.getPresentData(exercise);
        queryData.entrySet().stream().forEach(e ->  part1_buffer.append(e.getKey().toLowerCase()+ ","));
        queryData.entrySet().stream().forEach(e -> part2_buffer.append("'" + e.getValue().toLowerCase()+"',"));

        query_part1 = "INSERT INTO exercises (" + part1_buffer.deleteCharAt(part1_buffer.length()-1).toString() + ") ";
        query_part2 = "VALUES( " + part2_buffer.deleteCharAt(part2_buffer.length()-1) + ")";
        finalQuery = query_part1 + query_part2;
        System.out.println(finalQuery);

        EntityManagement.doQuery(con, finalQuery);

    }


//    public static void updateExerciseData(Connection con, Exercise exercise) {
//
//        boolean isWorkoutInDb = Workout.isWorkoutExist(con, oldValue);
//
//
//        if(!isWorkoutInDb) {
//            try {
//                throw new DataDoNotExistInDb("Workout with name: " + oldValue + " do not exist in database");
//            } catch (DataDoNotExistInDb dataDoNotExistInDb) {
//                dataDoNotExistInDb.printStackTrace();
//            }
//        }
//
//        String query = "UPDATE workouts SET name = "+ "'" + newValue + "'" + " WHERE name = " + "'" + oldValue + "'";
//        EntityManagement.doQuery(con, query);
//    }



    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getReps() {
        return reps;
    }

    public int getDuration() {
        return duration;
    }




    public static class ExerciseBuilder {
        private String name;
        private String type;
        private String description;
        private int reps;
        private int time;
        private Workout workout;

        public ExerciseBuilder(String name, Workout workout) {
            this.name = name;
            this.workout = workout;
        }

        public ExerciseBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ExerciseBuilder description(String description) {
            this.description = description;
            return this;
        }
        public ExerciseBuilder reps(int reps) {
            this.reps = reps;
            return this;
        }

        public ExerciseBuilder time(int time) {
            this.time = time;
            return this;
        }


        public Exercise build() {
            Exercise exercise = new Exercise(this);
            return exercise;
        }
    }


}
