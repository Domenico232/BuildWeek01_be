package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import interfaces.IVendingMachineDAO;
import models.TraceTravel;
import models.VendingMachine;
import utils.JpaUtil;

public class VendingMachineDAO implements IVendingMachineDAO{

	@Override
	public void save(VendingMachine vm) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(vm);
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
	public VendingMachine getById(Long id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            VendingMachine tt = em.find(VendingMachine.class, id);
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
    public void update(VendingMachine vm) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(vm);
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
    public List<VendingMachine> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query q = em.createNamedQuery("tuttiTraceTravel");
            return q.getResultList();
        } finally {
            em.close();
        }
    }


	
	
	
	
}