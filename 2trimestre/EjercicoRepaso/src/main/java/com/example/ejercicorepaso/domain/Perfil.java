package com.example.ejercicorepaso.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "perfil")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;
}
