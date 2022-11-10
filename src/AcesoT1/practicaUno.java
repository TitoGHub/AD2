package AcesoT1;

import java.io.File;

public class practicaUno {
    public static void main(String[] args) {

        File cuenta = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos");
        File[] lista = cuenta.listFiles();
        int contador=0;

        for (int i = 0; i < lista.length; i++) {

                System.out.print("Nombre: " + lista[i].getName());
                System.out.print(" Fichero? " + lista[i].isFile());
                System.out.print(" Carpeta? " + lista[i].isDirectory());
                System.out.println(" ");

            contador++;
        }
        System.out.println("Hay " + contador + " archivos");




    }
}
