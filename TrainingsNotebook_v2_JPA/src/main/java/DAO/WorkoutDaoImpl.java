package DAO;


import Entities.EntityManagerHelper;
import Entities.Workout;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class WorkoutDaoImpl implements WorkoutDao{



    public void save(Workout newWorkout) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Workout workout = new Workout();
            workout.setName(newWorkout.getName());
            workout.setDescription(newWorkout.getDescription());

            em.persist(workout);
            et.commit();
            System.out.println("workout added");
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void update(Workout update) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Workout workout = new Workout();
            workout.setName(update.getName());
            workout.setDescription(update.getDescription());

            em.persist(workout);
            et.commit();
            System.out.println("workout added");
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Workout findById(Long id) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT w FROM Workouts w WHERE w.id = :id";

        TypedQuery<Workout> tq = em.createQuery(query, Workout.class);
        tq.setParameter("id", id);
        Workout workout = null;

        try {
            workout = tq.getSingleResult();
            System.out.println("Workout with id: " + id + " found" + "name: " + workout.getName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return workout;
    }


    public static void printSingleWorkout(Long id) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT w FROM Workouts w WHERE w.id = :id";

        TypedQuery<Workout> tq = em.createQuery(query, Workout.class);
        tq.setParameter("id", id);
        Workout workout = null;

        try {
            workout = tq.getSingleResult();
            System.out.println("Workout with id: " + id + " found, " + "name: " + workout.getName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Workout> getAll() {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT w FROM Workouts w WHERE w.id IS NOT NULL";

        TypedQuery<Workout> tq = em.createQuery(query, Workout.class);
        List<Workout> workouts = new ArrayList<>();

        try {
            workouts = tq.getResultList();
            workouts.forEach(workout -> System.out.println("Name: " + workout.getName() + ", Description: " + workout.getDescription()));
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return workouts;
    }


    public void delete(Long id) {

        EntityManager em = EntityManagerHelper.ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Workout workout = null;

        try {
            et = em.getTransaction();
            et.begin();
            workout = em.find(Workout.class, id);
            em.remove(workout);
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
}
