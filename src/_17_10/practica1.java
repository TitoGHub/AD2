package _17_10;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class practica1  {
    public static void main(String[] args) {
        try {
        File fPersonas = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_1710\\personas.dat");
        FileOutputStream fos = new FileOutputStream(fPersonas, true);
        FileInputStream fis = new FileInputStream(fPersonas);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectInputStream ois = new ObjectInputStream(fis);


        System.out.println("cuantas personas quieres ingresar?");
        Scanner sc = new Scanner(System.in);
        int numPersonas = sc.nextInt();
        ArrayList<personas> listaPersonas = new ArrayList<>();

        for (int i = 0; i < numPersonas; i++){
            System.out.println("nombre?");
            String nombre = sc.next();
            System.out.println("edad?");
            int edad = sc.nextInt();
            listaPersonas.add(new personas(nombre,edad));



        }



            for (int i =0; i < listaPersonas.size(); i++){
                oos.writeObject(listaPersonas);
            }


            for (personas personas : listaPersonas){
                System.out.println(personas);
            }

//            System.out.println(ois.readObject());


        fos.close();
        fis.close();
        ois.close();
        oos.close();

        } catch (IOException ioe) {
            System.out.println("error 1");
            ioe.printStackTrace();
        }


    }
}
