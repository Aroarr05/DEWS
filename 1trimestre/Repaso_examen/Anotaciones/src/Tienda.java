import java.util.ArrayList;
import java.util.List;

@Producto(
        nombre = "Laptop",
        precio = 1000.0,
        categoria = "Electrónica",
        cantidad = 50
)
@Producto(
        nombre = "Camiseta",
        precio = 20.0,
        categoria = "Ropa",
        cantidad = 200
)
@Producto(
        nombre = "Teléfono Móvil",
        precio = 600.0,
        categoria = "Electrónica",
        cantidad = 80
)
@Producto(
        nombre = "Zapatos Deportivos",
        precio = 70.0,
        categoria = "Calzado",
        cantidad = 150
)

public class Tienda {

    List<ProductoDatos> listaProductos;
    public Tienda() {
        this.listaProductos = new ArrayList<ProductoDatos>();
        cargadorproductos();
    }

    public void cargadorproductos() {
        Producto[] productos
                = Tienda.class.getAnnotationsByType(Producto.class);

        for (Producto producto : productos) {
            ProductoDatos p = new ProductoDatos(
                    producto.nombre(),
                    producto.precio(),
                    producto.categoria(),
                    producto.cantidad()
            );
        listaProductos.add(p);
        }

    }

    @Override
    public String toString() {
        return "Tienda [listaProductos=" + listaProductos + "]";
    }

    
}
