package org.iesbelen.service;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.mapstruct.PedidoMapper;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoDAO pedidoDAO;
    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ComercialDAO comercialDAO;

    public List<Pedido> listAll(){
        return pedidoDAO.getAll();
    }

    public List<Pedido> listPedidos(int idComercial) {

        List<Pedido> pedidos = pedidoDAO.getById_comercial(idComercial);
        pedidos.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));

        return pedidos;
    }

    public void newPedido (Pedido pedido) {
        pedidoDAO.create(pedido);
    }

    public void replacePedido (Pedido pedido) {
        pedidoDAO.update(pedido);
    }


    public void deletePedido(int id) {
        clienteDAO.delete(id);
    }

   /* tabal que aparece en la vita de detalle comercial

   public List<PedidoDTO> listPedidosDTO(int idComercial) {

        List<Cliente> clientes = clienteDAO.getAll();
        List<Pedido> pedidos = pedidoDAO.getById_comercial(idComercial);

        pedidos.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));

        List<PedidoDTO> pedidosDTO = new ArrayList<>();

      for (Pedido p : pedidos) {
            int idC = p.getId_cliente();
            for (Cliente c : clientes) {
                if (c.getId() == idC) {
                    pedidosDTO.add(pedidoMapper.pedidoAPedidosDTO(p, c.getNombre() + " " + c.getApellido1()
                            + " " + (c.getApellido2() != null ? c.getApellido2() : "")));
                }
            }
        }

        System.out.println("Pasa por aquí" + pedidosDTO);
        return pedidosDTO;
    }*/

    public List<PedidoDTO> listPedidosDTO() {

        List<Cliente> listaCliente = clienteDAO.getAll();
        List<Comercial> listaComercial = comercialDAO.getAll();
        List<Pedido> listPedidos = pedidoDAO.getAll();


        return listPedidos.stream()
                .map(pedido -> {
                    Cliente cliente = listaCliente.stream()
                            .filter(c -> c.getId() == pedido.getId_cliente())
                            .findFirst()
                            .orElse(null);

                    Comercial comercial = listaComercial.stream()
                            .filter(c -> c.getId() == pedido.getId_comercial())
                            .findFirst()
                            .orElse(null);

                    return (cliente != null && comercial != null)
                            ? pedidoMapper.pedidoAPedidosDTO(pedido, cliente.getNombre(), comercial.getNombre())
                            : null;
                })
                .filter(dto -> dto != null)
                .collect(Collectors.toList());
    }

    public Pedido one(Integer id) {
        Optional<Pedido> optCom = pedidoDAO.find(id);
        if (optCom.isPresent())
            return optCom.get();
        else
            return null;
    }
}