package org.iesbelen.modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pelicula {

    public int id_pelicula;
    @NotBlank(message = "{error.nombre}")
    @Size(min=2, message = "{error.mini.2}")
    public String titulo;
    @Size(max=300, message = "{error.maximo.300}")
    public String descripcion;
    @Max(value = 1895, message = "{max.fecha}")
    public int anyo_lanzamiento;
    public int id_idioma;
    @Max(value = 0, message = "{max.duracion}")
    public int duracion;

    public Pelicula() {super();}
}
