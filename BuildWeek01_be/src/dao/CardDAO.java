package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.ICardDAO;
import models.Card;
import models.Subscription;
import utils.JpaUtil;

public class CardDAO implements ICardDAO {

    public void save(Card card) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(card);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante il salvataggio della carta: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<Card> cards) {
        for (Card card : cards) {
            save(card);
        }
    }

    public Card getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Card card = null;
        try {
            em.getTransaction().begin();
            card = em.find(Card.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la ricerca della carta con id %d: %s", id, e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return card;
    }

    public void update(Card card) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(card);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante l'aggiornamento della carta: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void remove(Card card) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(card);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la rimozione della carta: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Card> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Card> cards = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Card> query = em.createQuery("SELECT c FROM Card c", Card.class);
            cards = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la ricerca di tutte le carte: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return cards;
    }
    
}
