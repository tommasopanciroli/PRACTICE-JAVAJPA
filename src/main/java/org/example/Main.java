package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Evento;
import org.example.Persona;
import org.example.Partecipazione;
import org.example.EventoDAOImplementation;
import org.example.PersonaDAOImpl;
import org.example.PartecipazioneDAOImpl;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi"); // Sostituisci "pu_name" con il nome della tua persistence-unit
        EntityManager em = emf.createEntityManager();

        // Inizializza i DAO
        EventoDAOImplementation eventoDAO = new EventoDAOImplementation(em);
        PersonaDAOImpl personaDAO = new PersonaDAOImpl(em);
        PartecipazioneDAOImpl partecipazioneDAO = new PartecipazioneDAOImpl(em);

        try {
            // Crea un nuovo evento
            Evento evento = new Evento("Concerto di Lazza", LocalDate.of(2025, 5, 20), "Grande concerto di Jacopo Lazzarini", "Musica", 10000);
            eventoDAO.save(evento);
            System.out.println("Evento salvato con ID: " + evento.getId());

            // Crea una nuova persona
            Persona persona = new Persona("Tommaso", "Panciroli", "to.pan@example.com", LocalDate.of(2003, 9, 21), "maschio");
            personaDAO.save(persona);
            System.out.println("Persona salvata con ID: " + persona.getId());

            // Crea una partecipazione
            Partecipazione partecipazione = new Partecipazione(persona, evento, "confermata");
            partecipazioneDAO.save(partecipazione);
            System.out.println("Partecipazione salvata con ID: " + partecipazione.getId());

            // Leggi dati dal database
            Evento eventoTrovato = eventoDAO.findById(evento.getId());
            System.out.println("Evento trovato: " + eventoTrovato.getTitolo());

            Persona personaTrovata = personaDAO.findById(persona.getId());
            System.out.println("Persona trovata: " + personaTrovata.getNome() + " " + personaTrovata.getCognome());

            // Aggiorna dati
            personaTrovata.setEmail("nuova.email@example.com");
            personaDAO.update(personaTrovata);
            System.out.println("Email della persona aggiornata: " + personaTrovata.getEmail());

            // Elimina dati
            partecipazioneDAO.delete(partecipazione.getId());
            System.out.println("Partecipazione eliminata con ID: " + partecipazione.getId());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi le risorse
            em.close();
            emf.close();
        }

    }
}