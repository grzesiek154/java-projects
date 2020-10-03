package Controllers;


import Entities.Workout;

import javax.persistence.*;

import java.util.Arrays;
import java.util.List;


public class WorkoutController {


    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TrainingsNotebook_v2_JPA");


    public static void addWorkout(String name, String description) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Workout workout = new Workout();
            workout.setName(name);
            workout.setDescription(description);

            em.persist(workout);
            et.commit();
            System.out.println("workout added");
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    public static Workout getWorkout(Long id) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
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

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
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

    public static void printAllWorkouts() {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT w FROM Workouts w WHERE w.id IS NOT NULL";

        TypedQuery<Workout> tq = em.createQuery(query, Workout.class);
        List<Workout> workouts;

        try {
            workouts = tq.getResultList();
            workouts.forEach(workout -> System.out.println("Name: " + workout.getName() + ", Description: " + workout.getDescription()));
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static Workout checkFiledToUpdate(String field, String value, Workout workout) {

        if (field.toLowerCase() == "name") {
            workout.setName(value);
        } else if (field.toLowerCase() == "description") {
            workout.setDescription(value);
        }
        return workout;
    }

    public static void updateWorkout(Long id, String field, String value) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        Workout workout;
        Workout updatedWorkout;

        try {
            et = em.getTransaction();
            et.begin();
            workout = em.find(Workout.class, id);
            updatedWorkout = WorkoutController.checkFiledToUpdate(field, value, workout);

            em.persist(updatedWorkout);
            et.commit();
        } catch (Exception ex) {

            if (et != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    public static void deleteWorkout(Long id) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
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
