package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Veicle;
import utils.JpaUtil;
public class VeicleDAO implements IVeicleDAO{

   @Override
	public void save(Veicle v) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
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
    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Veicle v  = em.find(Veicle.class, id );
            em.remove(v);
            em.getTransaction().commit();
            System.out.println("Veicle cancellato dal DB!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }
	
	@Override
	public Veicle getById(Long id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Veicle v =  em.find(Veicle.class, id);
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
            System.out.println("Veicle salvato nel DB!!");
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
            Query q = em.createNamedQuery("tuttiVeicle");
            return q.getResultList();
        } finally {
            em.close();
        }
    }


	

	
}
