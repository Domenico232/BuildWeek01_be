package dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.internal.build.AllowSysOut;

import interfaces.IPassDAO;
import utils.JpaUtil;
import models.Pass;

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
    public Pass getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Pass pass = null;
        try {
            em.getTransaction().begin();
            pass = em.find(Pass.class, id);
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
        return pass;
    }

	@Override
    public List<Pass> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Pass> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Pass> query = em.createQuery(
                    "SELECT p FROM Pass p", Pass.class);
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
    public void delete(long id) {
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
    
    public List<Pass> listaTotPass(long id, LocalDate inizio, LocalDate fine) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Pass p WHERE p.reseller.id = :id AND p.emissionDate BETWEEN :startDate AND :endDate");
            query.setParameter("id", id);
            query.setParameter("startDate", inizio);
            query.setParameter("endDate", fine);
            List<Pass> listPass = query.getResultList();
            if (listPass.isEmpty()) {
            	System.out.println("Non ci sono biglietti venduti per questa ricerca!");
            }
            return listPass;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la ricerca di tutte le carte: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
            return null ;
        } finally {
            em.close();
        }
    }
}
