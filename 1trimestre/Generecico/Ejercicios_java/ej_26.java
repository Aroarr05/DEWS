package Ejercicios_java;
import java.util.Scanner;

public class ej_26 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        String nuem = entrada.nextLine();
        System.out.print("Introduce un digito: ");
        String digito = entrada.nextLine();
        for (int i = 0; i < nuem.length(); i++) {
            if (nuem.charAt(i) == digito.charAt(0)) {
                System.out.println("Se encuentra en la posicion: " + i++);                
            }
          
            entrada.close();
        }
    }
}
