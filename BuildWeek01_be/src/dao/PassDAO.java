package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IPassDAO;
import utils.JpaUtil;
import models.Pass;
import models.Ticket;
import models.User;

public class PassDAO implements IPassDAO {
	
	@Override
    public void save(Pass p) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error saving pass: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

	
	@Override
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
                            "Error getting pass by id: %s", id));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loan;
    }

	@Override
    public List<Pass> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Pass> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Pass> query = em.createQuery(
                    "SELECT p FROM pass p", Pass.class);
            loans = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all passes: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loans;
    }

    @Override
    public void update(Pass pass) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pass);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error updating pass: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }


    @Override
    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Pass pass = em.find(Pass.class, id);
            em.remove(pass);
            em.getTransaction().commit();
            System.out.println("Elemento cancellato dal DB!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error removing pass by id: %s", id));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}
