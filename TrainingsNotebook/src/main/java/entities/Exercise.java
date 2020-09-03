package entities;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Optional;

public class Exercise {

    private int id;
    private String name;
    private String type;
    private String description;
    private int reps;
    private int duration;
    private Workout workout;


    private Exercise(ExerciseBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.reps = builder.reps;
        this.duration = builder.time;
        this.workout = builder.workout;
    }

    public static void insertExercise(Connection con, Exercise exercise) {

        Optional<Exercise> optionalExercise = Optional.of(exercise);

        String query_part1 = "INSERT INTO exercises ( ";
        String query_part2 = "VALUES (";
        String name = exercise.getName();
        String type = exercise.getType();

        if(name.isEmpty()) {
            throw new NullPointerException("Exercise name not provided");
        }
        if(type != null) {

        }
        EntityManagement.doQuery(con, "temp");

    }

    public int getId() {
        return id;
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
        private int id;
        private String name;
        private String type;
        private String description;
        private int reps;
        private int time;
        private Workout workout;

        public ExerciseBuilder(int id, String name, Workout workout) {
            this.id = id;
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
