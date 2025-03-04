package org.iesbelen.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //Indica que la clase entidad de JPA
@Table(name="idioma") //Especifica que se mapea con la tabla

@Data //Getters y Setters
@AllArgsConstructor //Crea el constructor
@NoArgsConstructor //Crea un constructor vacio
@Builder

//Si utilizo @OneToMany(FetchType.LAZY) además debo usar
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Idioma {

    @Id //Define el identificador unico de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) //usa auto incremento en la base de datos
    @Column(name = "id_idioma") // Define el nombre de la columna en la base de datos.

    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "idioma") //Un idioma puede estar asociado a muchas peliculas, el mappedBy significa que esta definida en la entidad de Pelicula
    @JsonIgnore // Evita problemas de serialización ciclica en Json(cuando una pelicula tiene un idioma y el idioma tiene peliculas, creando un bucle infinito)
    private List<Pelicula> peliculasIdioma;

}
