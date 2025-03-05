package org.iesbelen.videoclub.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = "idPelicula")

@Entity
@Table(name="pelicula")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//usa en una entidad para indicar que el valor de la clave primaria (@Id) será autogenerado por la base de datos utilizando una columna con auto-incremento.
    @Column(name="id_pelicula")
    private long idPelicula;

    private String titulo;

    private String descripcion;

    @Column(name = "anyo_lanzamiento")
    @JsonFormat(pattern = "yyyy",  shape = JsonFormat.Shape.STRING)
    private Year anyoLanzamiento;

    // relacion de muchos a uno
    @ManyToOne()
    @JoinColumn(name = "id_idioma", nullable = false)
    private Idioma idioma;

    private int duracion;

    // relacion de muchos a muchos
    @ManyToMany
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"))
    Set<Categoria> categorias = new HashSet<>();

}
