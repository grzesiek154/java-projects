package DAO;

import Entities.EntityManagerHelper;
import Entities.Training;


import javax.persistence.*;
import java.util.List;

public class TrainingDaoImpl implements BaseService<Training>{


    @Override
    public Training findById(Long id) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT t FROM Trainings t WHERE t.id = :id";

        TypedQuery<Training> tq = em.createQuery(query, Training.class);
        tq.setParameter("id", id);
        Training training = null;

        try {
            training = tq.getSingleResult();
            System.out.println("Training with id: " + id + " found, " + "name: " + training.getName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return training;
    }

    @Override
    public void save(Training data) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Training training = new Training();

            training.setName(data.getName());
            training.setDate(data.getDate());
            training.setType(data.getType());
            training.setTrainingExercises(data.getTrainingExercises());

            em.persist(training);
            et.commit();
            System.out.println("training added");

        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
                ex.printStackTrace();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Training data) {

    }

    @Override
    public void delete(Long id) {
        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Training training = null;

        try {
            et = em.getTransaction();
            et.begin();
            training = em.find(Training.class, id);
            em.remove(training);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }


    @Override
    public List<Training> getAll() {
        return null;
    }








}
