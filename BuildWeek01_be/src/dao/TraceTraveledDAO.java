package dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.TraceTraveled;
import utils.JpaUtil;

public class TraceTraveledDAO {
    public void save(TraceTraveled traceTraveled) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(traceTraveled);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error while saving TraceTraveled: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(Set<TraceTraveled> traceTraveledSet) {
        for (TraceTraveled traceTraveled : traceTraveledSet) {
            save(traceTraveled);
        }
    }

    public TraceTraveled getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        TraceTraveled traceTraveled = null;
        try {
            em.getTransaction().begin();
            traceTraveled = em.find(TraceTraveled.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error while getting TraceTraveled with id %d: %s", id, e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return traceTraveled;
    }

    public void update(TraceTraveled traceTraveled) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(traceTraveled);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error while updating TraceTraveled: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<TraceTraveled> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<TraceTraveled> traceTraveledList = null;
        try {
            em.getTransaction().begin();
            TypedQuery<TraceTraveled> query = em.createQuery("SELECT t FROM TraceTraveled t", TraceTraveled.class);
            traceTraveledList = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error while getting all TraceTraveled: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return traceTraveledList;
    }

}
