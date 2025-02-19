package aroa.proyecto.tienda.dao;

import aroa.proyecto.tienda.model.Skin;

import java.util.List;
import java.util.Optional;

public interface SkinDAO {

    public void create(Skin skin);
    public List<Skin> getAll();
    public Optional<Skin> find(int id);
    public void update(Skin skin);
    public void delete(int id);
    public List<Skin> filtro(String nombre);
}
