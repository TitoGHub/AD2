package AcesoT1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class practicaDosUno {
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
        }


    }

