package _11_10;

import java.io.*;

public class practica1 {
    public static void main(String[] args) {
        File foto = new File("C:/Users/DAM2/Desktop/AcessoDatos/_1110/foto.png");
        File foto2 = new File("C:/Users/DAM2/Desktop/AcessoDatos/_1110/foto2.png");

        try {
            FileInputStream fis = new FileInputStream(foto);
            FileOutputStream fos = new FileOutputStream(foto2);


            int i = 0;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
