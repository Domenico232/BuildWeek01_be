package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.ITraceDAO;
import models.Trace;
import utils.JpaUtil;

import java.util.Set;
import java.util.List;

public class TraceDAO implements ITraceDAO{
	@Override
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
	@Override
    public void saveAll(Set<Trace> traces) {
        for (Trace trace : traces) {
            save(trace);
        }
    }
	@Override
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
	@Override
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
	@Override
    public List<Trace> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Trace> traces = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Trace> query = em.createQuery("SELECT t FROM Trace t", Trace.class);
            traces = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all traces: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return traces;
    }

}
