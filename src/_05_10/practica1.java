package _05_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class practica1 {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_0510\\Fichero1.txt");
        try {

            FileWriter fw = new FileWriter(fichero);
            fw.write("Hola Mundo22");
            fw.append(". Esto es una continuacion");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
