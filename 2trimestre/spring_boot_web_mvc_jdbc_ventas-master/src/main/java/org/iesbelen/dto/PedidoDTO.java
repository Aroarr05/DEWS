package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class PedidoDTO {
    private int id;
    private double total;
    private Date fecha;
    private int id_cliente;
    private int id_comercial;

    private String nombre_cliente;
     private String nombre_comercial;

    public PedidoDTO() {}


}
