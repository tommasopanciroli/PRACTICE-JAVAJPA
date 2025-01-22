package org.example.DAO;

import org.example.Evento;
import org.example.Persona;

import java.util.List;

public interface PersonaDAO {
    void save(Evento evento);

    Evento findById(Long id);

    void deleteById(Long id);

    List<Persona> findAll();
}
