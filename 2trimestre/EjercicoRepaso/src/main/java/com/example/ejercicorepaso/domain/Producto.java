package com.example.ejercicorepaso.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of= "nombre")

@Entity
@Table(name="producto")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_producto")
    private int idProducto;

    @NaturalId
    private Tienda mainTienda;


    @ManyToMany(
            mappedBy = "producto")

    Set<Orden> orden = new HashSet<>();

}
