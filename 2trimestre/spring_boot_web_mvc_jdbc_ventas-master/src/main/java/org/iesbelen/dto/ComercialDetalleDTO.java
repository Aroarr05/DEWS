package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ComercialDetalleDTO {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private float comision;

    private int totalPedidos;
    private double mediaPrecio;

}
