package DAO;

import Entities.Exercise;
import Entities.Workout;

import java.util.List;

public interface ExerciseDao extends BaseService<Exercise>{

    Exercise findById(Long id);
    void save(Exercise exercise);
    void update(Exercise exercise);
    void delete(Long id);
    List<Exercise> getAll();
}
