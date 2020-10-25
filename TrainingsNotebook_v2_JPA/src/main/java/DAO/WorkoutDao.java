package DAO;

import Entities.Workout;

import java.util.List;

public interface WorkoutDao extends BaseService<Workout>{

    Workout findById(Long id);
    void save(Workout workout);
    void update(Workout workout);
    void delete(Long id);
    List<Workout> getAll();
}
