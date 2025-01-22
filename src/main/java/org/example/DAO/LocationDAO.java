package org.example.DAO;

import org.example.Evento;
import org.example.Location;

import java.util.List;

public interface LocationDAO {
    void save(Evento evento);

    Evento findById(Long id);

    void deleteById(Long id);

    List<Location> findAll();
}

