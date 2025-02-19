public class ProductoDatos {
    String nombre;
    double precio;
    String categoria;
    int cantidad;
    public ProductoDatos(String nombre, double precio, String categoria, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " " + precio + " " + categoria + " " + cantidad;
    }


}
