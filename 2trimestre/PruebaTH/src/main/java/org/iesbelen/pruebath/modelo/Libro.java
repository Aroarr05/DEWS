package org.iesbelen.pruebath.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private String editorial;


}
