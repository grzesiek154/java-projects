package Controllers;

import DAO.WorkoutDao;
import Entities.Workout;

import java.util.List;

public class WorkoutController implements BaseController<Workout> {

    private WorkoutDao workoutDao;

    public WorkoutController(WorkoutDao baseService) {
        this.workoutDao = baseService;
    }

    public void saveData(Workout workout) {
        workoutDao.save(workout);
    }

    @Override
    public void deleteData(Long id) {
        workoutDao.delete(id);
    }

    @Override
    public Workout findDataById(Long id) {

        return workoutDao.findById(id);
    }

    @Override
    public void updateData(Workout data) {

    }

    @Override
    public List<Workout> getAllData() {
        return null;
    }


}
