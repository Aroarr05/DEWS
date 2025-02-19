package org.iesbelen.model;

public class Producto {
    private int idprod;
    private int idcat;
    private String nombre;
    private Double precio;
    private int stock;

    public int getIdprod() {
        return idprod;
    }
    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }
    public int getIdcat() {
        return idcat;
    }
    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}

