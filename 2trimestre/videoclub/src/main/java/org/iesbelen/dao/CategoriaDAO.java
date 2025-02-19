package org.iesbelen.dao;

import org.iesbelen.modelo.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaDAO {

    public List<Categoria> getAll();
    public Optional<Categoria> find(int id);
}
