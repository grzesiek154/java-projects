package DAO;

import Entities.Exercise;
import Entities.Workout;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExerciseDaoImpl implements ExerciseDao{

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TrainingsNotebook_v2_JPA");



//    private static Exercise adjustPropertiesInExerciseObject(Exercise newExercise) {
//
//        Exercise exercise = new Exercise();
//
//             if(newExercise.getName() != null && !newExercise.getName().isEmpty()) {
//                 exercise.setName(newExercise.getName());
//             }  else if (mapKey.equalsIgnoreCase("description")) {
//                 exercise.setDescription(mapValue.toString());
//             } else if (mapKey.equalsIgnoreCase("type")) {
//                 exercise.setType(mapValue.toString());
//             } else if (mapKey.equalsIgnoreCase("reps")) {
//                 exercise.setReps(Integer.valueOf(mapValue.toString()));
//             } else if (mapKey.equalsIgnoreCase("time")) {
//                 exercise.setDuration(Integer.valueOf(mapValue.toString()));
//             }
//
//
//         return exercise;
//
//    }

    public void save(Exercise newExercise) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Exercise exercise = newExercise;

            em.persist(exercise);
            et.commit();
            System.out.println("exercise added");
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
                ex.printStackTrace();
            }
        } finally {
            em.close();
        }
    }

    public void update(Exercise exercise) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            em.persist(exercise);
            et.commit();
            System.out.println("exercise added");
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
                ex.printStackTrace();
            }
        } finally {
            em.close();
        }
    }

    public Exercise findById(Long id) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT w FROM Workouts w WHERE w.id = :id";

        TypedQuery<Exercise> tq = em.createQuery(query, Exercise.class);
        tq.setParameter("id", id);
        Exercise exercise = null;

        try {
            exercise = tq.getSingleResult();
            System.out.println("Workout with id: " + id + " found" + "name: " + exercise.getName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return exercise;
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

    public List<Exercise> getAll() {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT w FROM Workouts w WHERE w.id IS NOT NULL";

        TypedQuery<Exercise> tq = em.createQuery(query, Exercise.class);
        List<Exercise> exercises = new ArrayList<>();

        try {
            exercises = tq.getResultList();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return exercises;
    }

    public void delete(Long id) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Exercise exercise = null;

        try {
            et = em.getTransaction();
            et.begin();
            exercise = em.find(Exercise.class, id);
            em.remove(exercise);
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
