package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import interfaces.IVeicleDAO;
import models.Veicle;
import utils.JpaUtil;

public class VeicleDAO implements IVeicleDAO {
	
	public int getNumberOfTicketsByVeicleId(long veicleId) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    Query query = em.createQuery("SELECT COUNT(p) FROM Pass p WHERE p.veicle.id = :veicleId");
	    query.setParameter("veicleId", veicleId);
	    Long count = (Long) query.getSingleResult();
	    return count.intValue();
	}

    @Override
    public void save(Veicle v) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Veicle v = em.find(Veicle.class, id);
            em.remove(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

    @Override
    public Veicle getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Veicle v = em.find(Veicle.class, id);
            em.getTransaction().commit();
            return v;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Veicle v) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Veicle> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Veicle> query = em.createQuery("SELECT v FROM Veicle v", Veicle.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Errore su salvataggio!!");
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public List<Veicle> getVeiclesInService() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Veicle> veicles = null;
        try {
            TypedQuery<Veicle> query = em.createQuery("SELECT v FROM Veicle v WHERE v.typeStatus = 'SERVICE'",
                    Veicle.class);
            veicles = query.getResultList();
        } catch (Exception e) {
            System.out.println("Errore: impossibile recuperare i veicoli in servizio");
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return veicles;
    }

}
