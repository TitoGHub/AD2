package AcesoT1;

import java.io.File;

public class practicaDos {
        public static void main(String[] args){
        File cuenta = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos");
        File[] lista = cuenta.listFiles();

        for (int i = 0; i < lista.length; i++) {
            System.out.println(" ");
            System.out.println("Nombre del archivo: " + lista[i].getName());
            System.out.println("Ruta: " + lista[i].getPath());
            System.out.println("Ruta absoluta: " + lista[i].getAbsolutePath());
            System.out.println("Se puede leer? " + lista[i].canRead());
            System.out.println("Se puede escribir? " + lista[i].canWrite());
            System.out.println("Tamaño: " + lista[i].length());
            System.out.println("Es un directorio? " + lista[i].isDirectory());
            System.out.println("Es un fichero? " + lista[i].isFile());
            System.out.println("A que directorio pertenece? " + lista[i].getParent());
            System.out.println(" ");


        }
    }
}
