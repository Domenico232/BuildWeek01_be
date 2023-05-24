package dao;

import javax.persistence.EntityManager;

import models.Trace;
import utils.JpaUtil;

import java.util.List;

public class TraceDAO {
    public void save(Trace trace) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(trace);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante il salvataggio della trace: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<Trace> traces) {
        for (Trace trace : traces) {
            save(trace);
        }
    }

    public Trace getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Trace trace = null;
        try {
            em.getTransaction().begin();
            trace = em.find(Trace.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la ricerca della trace con id %d: %s", id, e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return trace;
    }

    public void update(Trace trace) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(trace);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante il salvataggio della trace: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

}