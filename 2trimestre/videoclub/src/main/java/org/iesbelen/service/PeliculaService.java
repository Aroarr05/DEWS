package org.iesbelen.service;

import org.iesbelen.dao.PeliculaDAO;
import org.iesbelen.modelo.Pelicula;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class PeliculaService {


    private final PeliculaDAO peliculaDAO;

    public PeliculaService(PeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }

    public List<Pelicula> listAll() {
        return peliculaDAO.getAll();
    }

    public void newPelicula(Pelicula pelicula) {
        peliculaDAO.create(pelicula);
    }

}
