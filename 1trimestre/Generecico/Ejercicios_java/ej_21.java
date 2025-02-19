package Ejercicios_java;

import java.util.Scanner;

public class ej_21 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Nota Primer control: ");
        int primerexam = Integer.parseInt(entrada.nextLine());
        System.out.println("Nota Sengundo control: ");
        int segunexam = Integer.parseInt(entrada.nextLine());

        int nota = primerexam + segunexam;
         nota = nota/2;
         String apto;
         System.out.println("Nota del primer examen:" + primerexam);
         System.out.println("Nota del segundo examen:" + segunexam);
         if (nota<5){
            System.out.println("¿Cual ha sido ek resultado de la cuperacion?");
            apto = entrada.nextLine();
            if (apto.equals("apto")) {
                nota = 5;
            System.out.println("Tu nota de Programacion: "+ nota);
            }else{
              System.out.println("Estas suspenso de programacion");  
            }
         }else{
            System.out.println("Tu nota de Programacion: "+ nota);
         }

         entrada.close();
    }
    
}