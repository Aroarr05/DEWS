package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeliculaDTO {
    public int id_pelicula;
    public String titulo;
    public String descripcion;
    public int anyo_lanzamiento;
    public int id_idioma;
    public int duracion;

    private int totalPeliculas;
    private double mediaPeliculas;
}
