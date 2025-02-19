package org.iesbelen.model;

import java.util.List;
import java.util.Optional;

public class    FabricanteDTO extends Fabricante{
    private int numProductos;


    public FabricanteDTO(Fabricante fabricante, int numProductos) {
        this.setIdFabricante(fabricante.getIdFabricante());
        this.setNombre(fabricante.getNombre());
        this.setNumProductos(numProductos);
    }


    public int getNumProductos() {
        return numProductos;
    }
    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }
}
