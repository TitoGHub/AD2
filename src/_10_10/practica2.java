package _10_10;

import java.io.*;
import java.util.Scanner;

public class practica2 {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1010\\fichero.dat");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
            int contador = 1;
            for (int i = 0; i< 100; i++){
                bw.write(String.valueOf(contador));
                //bw.write(contador);
                contador++;
                bw.newLine();
            }
;            bw.close();


            BufferedReader br = new BufferedReader(new FileReader (fichero));
            String linea;
            while ((linea=br.readLine()) != null)
                System.out.println(linea);
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

