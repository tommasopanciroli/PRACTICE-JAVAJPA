package org.example.DAO;

import org.example.Evento;
import org.example.Partecipazione;

import java.util.List;

public interface PartecipazioneDAO {
    void save(Evento evento);

    Evento findById(Long id);

    void deleteById(Long id);

    List<Partecipazione> findAll();
}
