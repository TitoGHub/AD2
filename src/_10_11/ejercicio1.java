package _10_11;

import java.io.*;


public class ejercicio1 {
    public static void main(String[] args) {

        File fl = new File("C:\\Users\\DAM2\\Desktop\\f.txt");
        mostrarInformacionFichero(fl);

        mostrarPalabrasQueEmpiezePor(fl,"b");


    }

    private static void mostrarPalabrasQueEmpiezePor(File fl, String b) {
        try {
            FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String palabra;
            System.out.println("Palabras que empiece con " + b);
            while ((linea=br.readLine()) != null) {
                String[] palabras = linea.split(" ");


                for (int i = 0; i < palabras.length; i++) {
                    palabra = palabras[i];

                    char[] letras = palabra.toCharArray();
                    if (b.equalsIgnoreCase(String.valueOf(letras[0]))){
                        System.out.println(palabra);
                    }

                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void mostrarInformacionFichero(File fl) {
        try {
            FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);

            int contador = 0;
            int contadorP = 0;
            int contadorL = 0;
            String linea;
            while ((linea=br.readLine()) != null) {
                contador++;

                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                    contadorP++;
                }

                char[] letras = linea.toCharArray();
                for (int i = 0; i < letras.length; i++) {
                    contadorL++;
                }
            }

            System.out.println("Hay " + contadorP + " palabras");
            System.out.println("Hay " + contador + " lineas");
            System.out.println("Hay " + contadorL + " letras");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}