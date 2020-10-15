package Controllers;

import DAO.ExerciseDao;
import Entities.Exercise;

import java.util.List;

public class ExerciseController implements BaseController<Exercise> {

    private ExerciseDao exerciseDao;

    public ExerciseController(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }


    @Override
    public void saveData(Exercise data) {
        exerciseDao.save(data);
    }

    @Override
    public void deleteData(Long id) {
        exerciseDao.delete(id);
    }

    @Override
    public Exercise findDataById(Long id) {
        return exerciseDao.findById(id);
    }

    @Override
    public void updateData(Exercise data) {
        exerciseDao.update(data);
    }

    @Override
    public List<Exercise> getAllData() {
        return exerciseDao.getAll();
    }
}
