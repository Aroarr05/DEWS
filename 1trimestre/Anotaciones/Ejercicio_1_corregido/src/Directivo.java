public class Directivo extends Empleado {
    private int codigoDespacho;

    public Directivo(String nombre, String apellido, String direccion, String dni, String telefono, int codigoDespacho) {
        super(nombre, apellido, direccion, dni, telefono);
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Directivo: \n");
        sb.append("Codigo de despacho: " + codigoDespacho+"\n");
        sb.append(super.toString());

        return sb.toString();
    }
}
