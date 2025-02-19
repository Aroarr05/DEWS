package org.iesbelen.dao;

import org.iesbelen.modelo.Pelicula;

import java.util.List;

public interface PeliculaDAO {

    public void create(Pelicula cliente);
    public List<Pelicula> getAll();

}
