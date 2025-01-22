package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Persona;

import java.util.List;

public class PersonaDAOImpl {

    private EntityManager entityManager;

    public PersonaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create: aggiungi una nuova persona
    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(persona);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Read: trova una persona per ID
    public Persona findById(Long id) {
        return entityManager.find(Persona.class, id);
    }

    // Read: recupera tutte le persone
    public List<Persona> findAll() {
        return entityManager.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }

    // Update: aggiorna una persona
    public void update(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(persona);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Delete: elimina una persona per ID
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Persona persona = entityManager.find(Persona.class, id);
            if (persona != null) {
                entityManager.remove(persona);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}