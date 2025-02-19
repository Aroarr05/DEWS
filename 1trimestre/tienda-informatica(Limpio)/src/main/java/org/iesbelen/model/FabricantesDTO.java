package org.iesbelen.model;

public class FabricantesDTO extends Fabricante{

    private int Nproductos;

    public FabricantesDTO(Fabricante fabricante, int Nproductos) {
        this.setIdFabricante(fabricante.getIdFabricante());
        this.setNombre(fabricante.getNombre());
        this.setNproductos(Nproductos);
    }

    public int getNproductos() {return Nproductos;}

    public void setNproductos(int nproductos) {Nproductos = nproductos;}
}
