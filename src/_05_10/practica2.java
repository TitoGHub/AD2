package _05_10;

import java.io.*;
import java.util.Scanner;

public class practica2 {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_0510\\Fichero3.txt");
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String currentline;
            while ((currentline = br.readLine()) != null){
                System.out.println(currentline);

            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
