package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import interfaces.IResellerDAO;
import models.Reseller;
import utils.JpaUtil;

public class ResellerDAO implements IResellerDAO{

	 @Override
		public void save(Reseller r  ) {
	        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.persist(r);
	            em.getTransaction().commit();
	            System.out.println("Reseller salvato nel DB!!");
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
	            Reseller r  = em.find(Reseller.class, id );
	            em.remove(r);
	            em.getTransaction().commit();
	            System.out.println("Reseller cancellato dal DB!!");
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Errore su salvataggio!!");
	        } finally {
	            em.close();
	        }
	    }
		
		@Override
		public Reseller getById(Long id){
	        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            Reseller r =  em.find(Reseller.class, id);
	            em.getTransaction().commit();
	            return r;
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Errore su salvataggio!!");
	            return null;
	        } finally {
	            em.close();
	        }
	    }

		@Override
	    public void update(Reseller r) {
	        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.merge(r);
	            em.getTransaction().commit();
	            System.out.println("Veicle salvato nel DB!!");
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Errore su salvataggio!!");
	        } finally {
	            em.close();
	        }
	    }

		
	    @Override
	    public List<Reseller> getAll() {
	        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            Query q = em.createNamedQuery("tuttiReseller");
	            return q.getResultList();
	        } finally {
	            em.close();
	        }
	    }


		

}
