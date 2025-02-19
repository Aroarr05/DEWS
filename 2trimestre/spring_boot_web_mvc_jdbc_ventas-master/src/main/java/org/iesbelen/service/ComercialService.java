package org.iesbelen.service;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.ComercialDetalleDTO;
import org.iesbelen.mapstruct.ComercialMapper;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercialService {

    @Autowired
    private ComercialMapper comercialMapper;

    private ComercialDAO comercialDAO;
    private PedidoDAO pedidoDAO;

    public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO) {
        this.comercialDAO = comercialDAO;
        this.pedidoDAO= pedidoDAO;
    }

    public List<Comercial> listAll() {
        return comercialDAO.getAll();
    }

    public Comercial one(Integer id) {
        Optional<Comercial> optCom = comercialDAO.find(id);
        if (optCom.isPresent())
            return optCom.get();
        else
            return null;
    }

    public void newComercial (Comercial comercial) {
        comercialDAO.create(comercial);
    }

    public void replaceComercial (Comercial comercial) {
        comercialDAO.update(comercial);
    }

    public void deleteComercial(int id) {
        comercialDAO.delete(id);
    }

    public ComercialDetalleDTO detalleComercial(int id) {

        List<Pedido> optPedido = pedidoDAO.getById_comercial(id);
        List<Pedido> pedido = pedidoDAO.getAll();

        Optional<Comercial> optCom = comercialDAO.find(id);

        Comercial comercial = optCom.get();

        int pedidoComercial = optPedido.size();

        int totalPedidos = pedido.size();

        double mediaPrecio = (double) pedidoComercial / totalPedidos;
        mediaPrecio=mediaPrecio*100;

        return comercialMapper.comercialADetalleDTO(comercial,pedidoComercial, mediaPrecio);
    }

}
