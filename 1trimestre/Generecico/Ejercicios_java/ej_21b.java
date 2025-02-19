package Ejercicios_java;
import java.util.Scanner;

public class ej_21b {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int option;
        int contador = 0;
        int contadorimpar = 0;
        int mediaimpar = 0;
        int mayorpar = 0;
        do{
            System.out.print("Introduce un numero: ");
            option = Integer.parseInt(entrada.nextLine());
            if (option> 0) {
                contador ++;
                if (option%2 == 0) {
                    if (option > mayorpar) {
                        mayorpar = option;
                    }
                }else{
                    contadorimpar ++;
                    mediaimpar = option + mediaimpar;
                }
            }
        }while(option>0);
        mediaimpar = mediaimpar/contadorimpar;
        System.out.println("Has introducio " + contador + " nuemros");
        System.out.println("La media de los numeros impares es de "+ mediaimpar);
        System.out.println("El numero mayor de los pares es el " + mayorpar);
        entrada.close();
    }
}
