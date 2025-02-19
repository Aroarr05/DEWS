public class Operario extends Empleado{
    protected int codigoTaller;

    public Operario(String nombre, String apellido, String direccion, String dni, String telefono, int codigoTaller){
        super(nombre, apellido, direccion, dni, telefono);
        this.codigoTaller = codigoTaller;

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operario: ");
        sb.append("\nCodigoTaller: + " + codigoTaller+"\n");
        sb.append(super.toString());

        return sb.toString();
    }
}
