package com.example.examenarr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "product")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String descrip;
    private String imagen_url;
    private double precio;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Cart> cartProduct;




}
