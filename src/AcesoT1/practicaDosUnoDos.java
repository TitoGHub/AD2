package AcesoT1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class practicaDosUnoDos {
    public static void main(String[] args) {
        try {
            File cc = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\carpeta\\carpeta");
            if (cc.exists()) {
                System.out.println("ya existe");
                System.out.println("el directorio no se pudo crear");
                System.out.println(" ");
            }
            else {
                System.out.println(cc.mkdir());
            }

            do {
                System.out.println("Nombre fichero");
                Scanner sc = new Scanner(System.in);
                String fichero = sc.next();
                File cf = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\carpeta\\" + fichero + ".txt");
                if (cf.exists()) {
                    System.out.println("Ya existe");
                    System.out.println("el fichero" + ".txt" + " no se pudo crear");
                    System.out.println(" ");
                } else {
                    cf.createNewFile();
                }
                System.out.println("Desea continuar?");
                Scanner sc2 = new Scanner(System.in);
                String continuar = sc.next();
                if (continuar.equalsIgnoreCase("no")) {
                    break;
                }
            } while (true);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    File cuenta = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\carpeta");
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

