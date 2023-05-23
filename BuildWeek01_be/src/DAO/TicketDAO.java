package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import utils.JpaUtil;
import models.Reseller;
import models.Ticket;
import models.User;

public class TicketDAO implements ITicketDAO{
    public void save(Ticket ticket) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List <Ticket> prendi = ticket.getReseller().getTicketSell();
        List <Ticket> prendilista = ticket.getReseller().setTicketSell(prendi);
        prendilista.add(ticket);
        try {
            em.getTransaction().begin();
            em.persist(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error saving loan: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(Ticket ticket) {
        
    }

    public Ticket getById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Ticket loan = null;
        try {
            em.getTransaction().begin();
            loan = em.find(Ticket.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting ticket by id: %s", id));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loan;
    }

    public List<Ticket> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<Ticket> loans = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Ticket> query = em.createQuery(
                    "SELECT l FROM Ticket l", Ticket.class);
            loans = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error getting all loans: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return loans;
    }

    public void update(Ticket ticket) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error updating loan: %s",
                            e.getMessage()));
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void removeById(Long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Ticket ticket = em.find(Ticket.class, id);
            em.remove(ticket);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Error removing loan by id: %s", id));
            em.getTransaction().rollback();
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
            Ticket u  = em.find(Ticket.class, id);
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

}