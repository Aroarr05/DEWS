package com.example.ejercicorepaso.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
public class Tienda {
    private String nombre;
    private String descripcion;
    private String imagen;
    private String categoria;
}
