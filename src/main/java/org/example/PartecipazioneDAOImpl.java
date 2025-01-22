package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Partecipazione;

import java.util.List;

public class PartecipazioneDAOImpl {

    private EntityManager entityManager;

    public PartecipazioneDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create: aggiungi una nuova partecipazione
    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(partecipazione);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Read: trova una partecipazione per ID
    public Partecipazione findById(Long id) {
        return entityManager.find(Partecipazione.class, id);
    }

    // Read: recupera tutte le partecipazioni
    public List<Partecipazione> findAll() {
        return entityManager.createQuery("SELECT p FROM Partecipazione p", Partecipazione.class).getResultList();
    }

    // Update: aggiorna una partecipazione
    public void update(Partecipazione partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(partecipazione);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Delete: elimina una partecipazione per ID
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Partecipazione partecipazione = entityManager.find(Partecipazione.class, id);
            if (partecipazione != null) {
                entityManager.remove(partecipazione);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}