package com.example.ejercicorepaso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orden")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_orden")
    private long idOrden;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "orden")
    @JsonIgnore
    private List<Usuario> usuarioOrden;

    @ManyToMany
    @JoinTable(
            name="orden_producto",
            joinColumns = @JoinColumn(name = "id_orden", referencedColumnName= "id_orden"),
            inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id_producto"))
    Set<Producto> producto = new HashSet<>();
}
