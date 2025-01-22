package org.example.DAO;

import org.example.Evento;

import java.util.List;

public interface EventoDAO {

    void save (Evento evento);

    Evento findById (Long id);

    void deleteById (Long id);

    List<Evento> findAll();
}