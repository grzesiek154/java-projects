package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Workouts")
@Table(name = "workouts")
public class Workout implements Serializable{


    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Workout() {
    }

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
