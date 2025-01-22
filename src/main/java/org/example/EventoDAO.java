package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Evento;

import java.util.List;

public class EventoDAO {

    private EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create: aggiungi un nuovo evento
    public void save(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(evento);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Read: trova un evento per ID
    public Evento findById(Long id) {
        return entityManager.find(Evento.class, id);
    }

    // Read: recupera tutti gli eventi
    public List<Evento> findAll() {
        return entityManager.createQuery("SELECT e FROM Evento e", Evento.class).getResultList();
    }

    // Update: aggiorna un evento
    public void update(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(evento);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Delete: elimina un evento per ID
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Evento evento = entityManager.find(Evento.class, id);
            if (evento != null) {
                entityManager.remove(evento);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}