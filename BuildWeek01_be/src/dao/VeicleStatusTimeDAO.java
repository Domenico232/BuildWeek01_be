package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import interfaces.IVeicleStatusTimeDAO;
import models.VeicleStatusTime;
import utils.JpaUtil;

public class VeicleStatusTimeDAO implements IVeicleStatusTimeDAO {

    public void save(VeicleStatusTime veicleStatusTime) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(veicleStatusTime);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante il salvataggio dello stato del veicolo: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void saveAll(List<VeicleStatusTime> veicleStatusTimes) {
        for (VeicleStatusTime veicleStatusTime : veicleStatusTimes) {
            save(veicleStatusTime);
        }
    }

    public VeicleStatusTime getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        VeicleStatusTime veicleStatusTime = null;
        try {
            em.getTransaction().begin();
            veicleStatusTime = em.find(VeicleStatusTime.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la ricerca dello stato del veicolo con id %d: %s", id, e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return veicleStatusTime;
    }

    public void update(VeicleStatusTime veicleStatusTime) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(veicleStatusTime);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante l'aggiornamento dello stato del veicolo: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void remove(VeicleStatusTime veicleStatusTime) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(veicleStatusTime);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la rimozione dello stato del veicolo: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<VeicleStatusTime> getAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        List<VeicleStatusTime> veicleStatusTimes = null;
        try {
            em.getTransaction().begin();
            TypedQuery<VeicleStatusTime> query = em.createQuery("SELECT v FROM VeicleStatusTime v",
                    VeicleStatusTime.class);
            veicleStatusTimes = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante la ricerca di tutti gli stati dei veicoli: %s", e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return veicleStatusTimes;
    }

    public LocalDate getLastEndDate() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        LocalDate lastEndDate = null;
        try {
            em.getTransaction().begin();
            TypedQuery<LocalDate> query = em.createQuery("SELECT v.endDate FROM VeicleStatusTime v ORDER BY v.id DESC",
                    LocalDate.class);
            query.setMaxResults(1);
            lastEndDate = query.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(
                    String.format(
                            "Errore durante il recupero della data di fine dell'ultimo record inserito: %s",
                            e.getMessage()));
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return lastEndDate;
    }

}
