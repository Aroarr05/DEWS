package org.iesbelen.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesbelen.validador.ValidarAno;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {
    private int id;
    private double total;

    @ValidarAno
    //@Min()
    //@Max()
    //private int year;
    private LocalDate fecha;
    private int id_cliente;
    private int id_comercial;

}
