package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IResellerDAO;
import models.Reseller;
import utils.JpaUtil;

public class ResellerDAO implements IResellerDAO {

	@Override
	public void save(Reseller r) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
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
			Reseller r = em.find(Reseller.class, id);
			em.remove(r);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}
	}

	@Override
	public Reseller getById(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Reseller r = em.find(Reseller.class, id);
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
			TypedQuery<Reseller> q = em.createQuery("SELECT r FROM Reseller r", Reseller.class);
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
