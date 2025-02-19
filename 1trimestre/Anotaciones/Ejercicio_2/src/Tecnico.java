public class Tecnico extends Operario{

    private String perfil;

    public Tecnico( String nombre, String apellidos, String direccion, String dni, String telefono, int codigoTaller, String perfil) {
        super (nombre, apellidos, direccion, dni, telefono, codigoTaller);
        this.perfil = perfil;

    }
    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tecnico: ");
        sb.append("\nPerfil: "+this.perfil+"\n");
        sb.append(super.toString());

        return sb.toString();
    }

}
