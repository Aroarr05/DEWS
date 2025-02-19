public class Main { // Definición de la clase principal del programa
    public static void main(String[] args) { // Método principal, punto de entrada de la aplicación
        Empresa empresa = Empresa.cargadorDeContexto(); // Llama al método estático cargadorDeContexto() de la clase Empresa para cargar un objeto Empresa
        System.out.println(empresa); // Imprime la representación en cadena del objeto empresa en la consola
    }
}
