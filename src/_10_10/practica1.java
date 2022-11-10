package _10_10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class practica1 {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1010\\fichero.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
            System.out.println("Que texto desea añadir?");
            Scanner sc = new Scanner(System.in);
            String texto = (sc.nextLine());
            char[] texto2 = texto.toCharArray();

            for (int i = 0; i< texto2.length; i++){
                bw.append(texto2[i]);

            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
