package com.example.ejercicorepaso.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")

    private int idUsuario;
    private String nombre;

    @OneToOne
    private Perfil perfil;

    @ManyToOne()
    @JoinColumn(name= "id_orden",nullable = false)
    private Orden orden;

}
