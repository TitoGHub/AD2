package _05_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class practica1v2 {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_0510\\Fichero2.txt");
        System.out.println("Introduce el texto que quiera añadir al fichero");
        Scanner sc = new Scanner(System.in);
        String texto  = sc.nextLine() + " ";
        try {
            FileWriter fw = new FileWriter(fichero, true);
            fw.write(texto);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
