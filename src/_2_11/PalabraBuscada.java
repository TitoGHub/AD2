package _2_11;

import java.io.*;
import java.util.Scanner;

public class PalabraBuscada {
    public static void main(String[] args) {

        System.out.println("Que fichero quieres leer?");
        File cuenta = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos");
        File[] lista = cuenta.listFiles();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(" ");
            System.out.println("Nombre del archivo: " + lista[i].getName());
        }
        Scanner sc = new Scanner(System.in);
        String fichero = sc.nextLine();
        File cc = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_0211\\" + fichero + ".txt");
        if(cc.exists()){
            try {
            File f = new File ("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_0211\\" + fichero + ".txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

                System.out.println("Que palabra busca encontrar?");
                String palabra = sc.nextLine();

                String linea = "";
                while ((linea = br.readLine()) != null) {
                    obtenerLineaBuscada(f,palabra);
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        else {
            System.out.println("El fichero no existe");
            return;
        }

    }

    private static void obtenerLineaBuscada(File f, String palabra) {
        String palabraB = palabra;
        File rutaf = f;
        String linea2 = " ";
        String[] separacionP = linea2.split(" ");

        for (int i = 0; i< separacionP.length; i++){
            
        }



    }

}
