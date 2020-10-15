package Controllers;

import DAO.TrainingDaoImpl;
import Entities.Training;

import java.util.List;

public class TrainingController implements BaseController<Training> {

    private TrainingDaoImpl trainingDAO;

    public TrainingController(TrainingDaoImpl trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @Override
    public void saveData(Training data) {
        trainingDAO.save(data);
    }

    @Override
    public void deleteData(Long id) {
        trainingDAO.delete(id);

    }

    @Override
    public Training findDataById(Long id) {
        return trainingDAO.findById(id);
    }

    @Override
    public void updateData(Training data) {
            trainingDAO.update(data);
    }

    @Override
    public List<Training> getAllData() {
        return trainingDAO.getAll();
    }
}
