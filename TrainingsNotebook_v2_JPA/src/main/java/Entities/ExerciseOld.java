package Entities;


import javax.persistence.*;
import java.io.Serializable;

//@Entity(name = "Exercises")
//@Table(name = "exercises")
public class ExerciseOld implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true, nullable = false)

    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "reps")
    private int reps;

    @Column(name = "duration")
    private int duration;

    @Column(name = "workoutId", nullable = false)
    private Long workoutId;


    public ExerciseOld() {
    }

    public ExerciseOld(String name, String type) {
        this.name = name;
        this.type = type;
    }

    private ExerciseOld(ExerciseBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.reps = builder.reps;
        this.duration = builder.time;
        this.workoutId = builder.workoutId;
    }

    public static class ExerciseBuilder {
        private String name;
        private String type;
        private String description;
        private int reps;
        private int time;
        private Long workoutId;

        public ExerciseBuilder() {

        }


        public ExerciseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ExerciseBuilder workoutId(Long workoutID) {
            this.workoutId = workoutID;
            return this;
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


        public ExerciseOld build() {
            ExerciseOld exercise = new ExerciseOld(this);
            return exercise;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }
}
