package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IUserDAO;
import models.User;
import utils.JpaUtil;

public class UserDAO implements IUserDAO {

    @Override
    public void save(User u) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
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
    public void saveAll(List<User> users) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(users);
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
    public void delete(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            User u = em.find(User.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

    @Override
    public User getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            User u = em.find(User.class, id);
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
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Errore su salvataggio!!");
        } finally {
            em.close();
        }
    }

    public List<User> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<User> users = null;
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u", User.class);
            users = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all users: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return users;
    }

    public List<User> getAllWithoutCard() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<User> users = null;
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u LEFT JOIN Card c ON u.id=c.user.id WHERE c.id IS NULL",
                    User.class);
            users = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all users without card: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return users;
    }

}
