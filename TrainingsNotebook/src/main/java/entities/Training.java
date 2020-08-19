package entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Training {

    private int id;
    private String name;
    private String type;
    private LocalDateTime date;
    private List<Exercise> exercises;

    public Training(int id, String name, String type, LocalDateTime date, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.exercises = exercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", exercises=" + exercises +
                '}';
    }
}
