package aroa.proyecto.tienda.model;

public class DatoPedido {

    public int idDatoPedido;
    public int idPedido;
    public int idSkin;
    public int total;

    public int getIdDatoPedido(){
        return idDatoPedido;
    }

    public void setIdDatoPedido(int idDatoPedido){
        this.idDatoPedido = idDatoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdSkin() {
        return idSkin;
    }

    public void setIdSkin(int idSkin) {
        this.idSkin = idSkin;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
