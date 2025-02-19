package org.iesbelen.mapstruct;

import org.iesbelen.dto.ComercialDetalleDTO;
import org.iesbelen.modelo.Comercial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComercialMapper {

        @Mapping(target = "totalPedidos", source = "totalPedidos")
        @Mapping(target = "mediaPrecio", source = "mediaPrecio")
        public ComercialDetalleDTO comercialADetalleDTO(Comercial comercial, int totalPedidos,double mediaPrecio);
        public Comercial comercialDTOdetalle(ComercialDetalleDTO comercal);
}
