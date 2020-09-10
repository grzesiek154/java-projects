package entities;

import java.sql.Connection;
import java.util.*;
import java.util.stream.Stream;

public class Exercise extends EntityManagement{


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

    public static void insertExercise(Exercise exercise) {

        String test = "test";


        String query_part2 = "VALUES (";
        StringBuffer part1_buffer = new StringBuffer();
        StringBuffer part2_buffer = new StringBuffer(query_part2);

        String query_part1 = "INSERT INTO exercises (" + part1_buffer + ")";
        Map<String,String> queryValues = exercise.getPresentValues(exercise);



        queryValues.entrySet().stream().forEach(e ->  part1_buffer.append(e.getKey()+ ","));

        System.out.println(query_part1);

        //EntityManagement.doQuery(con, "temp");

    }


    private Map<String,String> getPresentValues(Exercise exercise) {

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
