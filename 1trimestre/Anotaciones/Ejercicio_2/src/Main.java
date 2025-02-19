public class Main {

    public static void main(String[] args) {
        Empresa operario = Empresa.cargadorOficial("Belen");
        Empresa tecnico = Empresa.cargadoTecnico("Belen");
        Empresa directivo = Empresa.cargadoDirectivo("Belen");
        System.out.println(operario.toString());
        System.out.println(tecnico.toString());
        System.out.println(directivo.toString());
    }
}