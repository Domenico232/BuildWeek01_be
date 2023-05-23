package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import interfaces.IUserDAO;
import models.User;
import utils.JpaUtil;

public class UserDAO implements IUserDAO{

	
	
	@Override
    public void save(User u) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            System.out.println("User salvato nel DB!!");
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
            User u  = em.find(User.class, id );
            em.remove(u);
            em.getTransaction().commit();
            System.out.println("Elemento cancellato dal DB!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }
	
	@Override
	public User getById(Long id){
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            User u =  em.find(User.class, id);
            em.getTransaction().commit();
            return u;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
            return null;
        } finally {
            em.close();
        }
    }

	@Override
    public void update(User u) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            System.out.println("User salvato nel DB!!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

	
    @Override
    public List<User> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query q = em.createNamedQuery("tuttiUser");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
	

	
}
