package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaUtil;
import models.Pass;

public class TicketDAO extends Pass{
    public void save(Pass ticket) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error saving loan: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<Pass> ticket) {
        for (Pass ticketl : ticket) {
            save(ticketl);
        }
    }

    public Pass getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Pass loan = null;
        try {
            em.getTransaction().begin();
            loan = em.find(Pass.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting ticket by id: %s", id));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loan;
    }

    public List<Pass> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Pass> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Pass> query = em.createQuery(
                    "SELECT l FROM Ticket l", Pass.class);
            loans = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all loans: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loans;
    }

    public void update(Pass ticket) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error updating loan: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void removeById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Pass ticket = em.find(Pass.class, id);
            em.remove(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error removing loan by id: %s", id));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

}