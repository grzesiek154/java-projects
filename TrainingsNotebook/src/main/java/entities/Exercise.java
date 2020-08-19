package entities;

public class Exercise {

    private int id;
    private String name;
    private String type;
    private String description;
    private int reps;
    private int duration;


    private Exercise(ExerciseBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.reps = builder.reps;
        this.duration = builder.time;
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

        public ExerciseBuilder(int id, String name) {
            this.id = id;
            this.name = name;
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
