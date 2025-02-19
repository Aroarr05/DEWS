public class Oficial extends Operario {
    private String categoria;

    public Oficial(String nombre, String apellidos, String direccion, String dni, String telefono, int codigoTaller, String categoria) {
        super(nombre, apellidos, direccion, dni, telefono, codigoTaller);
        this.categoria = categoria;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Oficial: ");
        sb.append("\nCategoria: "+this.categoria+"\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
