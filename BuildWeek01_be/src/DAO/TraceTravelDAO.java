package DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Reseller;
import models.TraceTravel;
import utils.JpaUtil;

public class TraceTravelDAO implements ITraceTravelDAO{

	@Override
	public void save(TraceTravel tt  ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tt);
            em.getTransaction().commit();
            System.out.println("TraceTravel salvato nel DB!!");
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
            TraceTravel tt  = em.find(TraceTravel.class, id );
            em.remove(tt);
            em.getTransaction().commit();
            System.out.println("TraceTravel cancellato dal DB!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }
	
	@Override
	public TraceTravel getById(Long id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            TraceTravel tt =  em.find(TraceTravel.class, id);
            em.getTransaction().commit();
            return tt;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
            return null;
        } finally {
            em.close();
        }
    }

	@Override
    public void update(TraceTravel tt) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tt);
            em.getTransaction().commit();
            System.out.println("TraceTravel salvato nel DB!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

	
    @Override
    public List<TraceTravel> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query q = em.createNamedQuery("tuttiTraceTravel");
            return q.getResultList();
        } finally {
            em.close();
        }
    }


	
	
	
	
}
