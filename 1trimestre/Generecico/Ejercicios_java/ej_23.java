package Ejercicios_java;
import java.util.Scanner;

public class ej_23 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca la base imponible:");
        float baseimpo = Integer.parseInt(entrada.nextLine());
        System.out.print("Introduzaca el tipo de Iva(general, reducido o superreducido):");
        String tipoiva = entrada.nextLine();
        System.out.print("Introduzaca el codigo promocional(nopro, mitad, menos o sproc):");
        String codipro = entrada.nextLine();

        String ivat = "";
        float iva = 0;
        float baseiva = 0;
        switch (tipoiva.charAt(0)) {
            case 'g':
            ivat = "21%";
            iva = baseimpo * 21;
            iva = iva / 100;
            baseiva = iva + baseimpo;
            break;
            case 'r':
            ivat = "10%";
            iva = baseimpo * 10;
            iva = iva / 100;
            baseiva = iva + baseimpo;
            break;
            case 's':
            ivat = "4%";
            iva = baseimpo * 4;
            iva = iva / 100;
            baseiva = iva + baseimpo;
            break;
        }
        String codi = "";
        float basecodi = 0;
        switch (codipro.charAt(0)) {
            case 'n':
                codi = "0";
                break;
            case 'm':
                if(codipro.charAt(1) == 'i'){
                    codi ="- " + String.valueOf(baseiva / 2);
                    basecodi = baseiva - baseiva /2;
                }else{
                    codi = "- 5";
                    basecodi = baseiva - 5;
                }
                break;
            case 's':
                codi = "- "+ String.valueOf(baseiva * 5 /100);
                basecodi = baseiva * 5;
                basecodi = basecodi/100;
            break;
        }
        Float total = baseiva - basecodi;
        System.out.println("Base imponible: "+baseimpo);
        System.out.println("IVA("+ivat+"): " + iva );        
        System.out.println("Precio con iva: " + baseiva );        
        System.out.println("Cod. promo.("+codi+"): " + basecodi );        
        System.out.println("Total: " + total );        
        entrada.close();

    }

}
