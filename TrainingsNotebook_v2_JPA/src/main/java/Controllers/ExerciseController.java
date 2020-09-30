package Controllers;

import Entities.Exercise;
import Entities.Workout;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class ExerciseController {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("TrainingsNotebook_v2_JPA");


//
//    private static Exercise checkValues(String field, String value, Exercise exercise) {
//
//        if (field.toLowerCase() == "name") {
//            exercise.setName(value);
//        } else if (field.toLowerCase() == "description") {
//            exercise.setDescription(value);
//        }
//        return exercise;
//    }

    public static Exercise createProperExercise(Map<String,Object> values) {

        Exercise.ExerciseBuilder exercise = new Exercise.ExerciseBuilder();

         for(Map.Entry<String, Object> entry : values.entrySet()) {

             Object mapValue = entry.getValue();
             String mapKey = entry.getKey().toLowerCase();
             System.out.println("map key " + mapKey);

             if(mapKey == "name") {
                 exercise.name(mapValue.toString());
             } else if (mapValue == "workoutId") {
                 WorkoutController.getWorkout(Long.valueOf(mapValue.toString()));
             } else if (mapKey.equalsIgnoreCase("description")) {
                 exercise.description(mapValue.toString());
             } else if (mapKey.equalsIgnoreCase("type")) {
                 exercise.type(mapValue.toString());
             } else if (mapKey.equalsIgnoreCase("reps")) {
                 exercise.reps(Integer.valueOf(mapValue.toString()));
             } else if (mapKey.equalsIgnoreCase("time")) {
                 exercise.time(Integer.valueOf(mapValue.toString()));
             }
         }

         return exercise.build();
    }

    public static void addExercise(Map<String,Object> exerciseData) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();

            Exercise exercise = ExerciseController.createProperExercise(exerciseData);


            em.persist(exercise);
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

//    public static void updateExercise(Long id, String field, String value) {
//        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction et = null;
//
//        Exercise exercise;
//        Exercise updatedExercise;
//
//        try {
//            et = em.getTransaction();
//            et.begin();
//            exercise = em.find(Exercise.class, id);
//            updatedExercise = ExerciseController.checkValues(field, value, exercise);
//
//            em.persist(updatedExercise);
//            et.commit();
//        } catch (Exception ex) {
//
//            if (et != null) {
//                et.rollback();
//            }
//        } finally {
//            em.close();
//        }
//    }

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
