package org.iesbelen.service;

import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    public CategoriaService() {}

    public List<Categoria> listAll() {
        return categoriaDAO.getAll();
    }

    public Categoria one(Integer id) {
        Optional<Categoria> optCli = categoriaDAO.find(id);
        if (optCli.isPresent())
            return optCli.get();
        else
            return null;
    }
}
