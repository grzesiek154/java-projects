package Entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public abstract class BaseController {

    protected static void addData(EntityManager entityManager, String name, String description) {

        EntityManager em = entityManager;

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

    protected static Workout getSingleData(EntityManager em, Long id, String query) {

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

    protected static void printSingleData(EntityManager em, Long id, String query) {

        TypedQuery<Workout> tq = em.createQuery(query, Workout.class);
        tq.setParameter("id", id);
        Workout workout = null;

        try {
            workout = tq.getSingleResult();
            System.out.println("Workout with id:" + id + "found, " + "name: " + workout.getName());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}
