package aroa.proyecto.tienda.dao;


import aroa.proyecto.tienda.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaDAO {

    public void create(Categoria categoria);
    public List<Categoria> getAll();
    public Optional<Categoria>  find(int id);
    public void update(Categoria categoria);
    public void delete(int id);
    public List<Categoria> filtro(String nombre);
}
