package org.iesbelen.mapstruct;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

   @Mapping(target = "nombre_cliente", source = "nombreCliente")
   @Mapping(target = "nombre_comercial", source = "nombreComercial")
   public PedidoDTO pedidoAPedidosDTO(Pedido pedido, String nombreCliente, String nombreComercial);
   public Pedido pedidoDTOAPedidos(PedidoDTO pedido);

}