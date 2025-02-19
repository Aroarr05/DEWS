package org.iesbelen.dao;

import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoDAO {
    public List<Pedido> getAll();

    public void create(Pedido pedido);

    public Optional<Pedido> find(int id);

    public void update(Pedido pedido);

    public void delete(long id);

    public List<Pedido> getById_comercial(int idComercial);
}
