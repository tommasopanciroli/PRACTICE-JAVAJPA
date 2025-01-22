package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.Location;

import java.util.List;

public class LocationDAOImpl {

    private EntityManager entityManager;

    public LocationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create: aggiungi una nuova location
    public void save(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(location);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Read: trova una location per ID
    public Location findById(Long id) {
        return entityManager.find(Location.class, id);
    }

    // Read: recupera tutte le location
    public List<Location> findAll() {
        return entityManager.createQuery("SELECT l FROM Location l", Location.class).getResultList();
    }

    // Update: aggiorna una location
    public void update(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(location);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    // Delete: elimina una location per ID
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Location location = entityManager.find(Location.class, id);
            if (location != null) {
                entityManager.remove(location);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}