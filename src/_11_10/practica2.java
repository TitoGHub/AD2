package _11_10;

import java.io.*;
import java.util.ArrayList;

public class practica2 {
    public static void main(String[] args) {
        try {
        File fichero = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1110\\alumnos.dat");
        String[] alumnos = {"alex", "daniel", "francisco", "monkey", "emilio", "hernesto"};
        int[] edad = {18,19,20,21,22,23};


            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);
           for (int i = 0; i < alumnos.length; i++){
              // int r = (int)(Math.random()*3);
               //String alumno = alumnos[i];
                dos.writeUTF(alumnos[i]);
                dos.writeUTF(" ");

                //int edadr = edad[r];
                dos.writeInt(edad[i]);
           }
            dos.close();
            dos.flush();

            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);

            for (int u = 0; u < alumnos.length; u++){
               String nombrea = dis.readUTF();
               int edada = dis.readInt();
                System.out.println("nombre: " + nombrea + " ||edad: " + edada);

            }

            fis.close();
            dis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
