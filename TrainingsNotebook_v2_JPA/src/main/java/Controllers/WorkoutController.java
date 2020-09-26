package Controllers;

import Entities.Workout;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class WorkoutController {

    private List<String> columnsName;
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
        String query = "SELECT w FROM workouts w WHERE c.id = :id";

        TypedQuery<Workout> tq = em.createQuery(query, Workout.class);
        tq.setParameter("id", id);
        Workout workout = null;

        try {
            workout = tq.getSingleResult();
            System.out.println("Workout with id:" + id + "found" + "name: " + workout.getName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return workout;
    }


    private Workout checkFiledToUpdate(String field, String value, Workout workout) {


        if (field.toLowerCase() == Workout.class.ge) {
            workout.setName(value);
        } else if (field.toLowerCase() == workout.getDescription().toLowerCase()) {

        }
    }
    public static void updateWorkout(Long id, String field, String value) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        Workout workout;

        try {
            et = em.getTransaction();
            et.begin();
            workout = em.find(Workout.class, id);


        }

    }
}
