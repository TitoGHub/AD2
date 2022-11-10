package _24_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class practica1 {
    public static void main(String[] args) {


        ArrayList<empleados> empleados = new ArrayList<>();
        empleados.add(new empleados(01, "Juan", "Garcia", 23, 'f'));
        empleados.add(new empleados(02, "Luis", "Lopez", 51, 'c'));
        empleados.add(new empleados(03, "Lucia", "Mendoza", 34, 'g'));
        empleados.add(new empleados(04, "Natalia", "Gonzalez", 32, 'b'));


        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_2410\\fichero1.dat", "rw");
            for (empleados efe : empleados){
                raf.writeInt(efe.getId()); //4 bytes
                        // Los strings, se les asigna una longitud
                StringBuffer sb = new StringBuffer(efe.getNombre());
                sb.setLength(10); //10*2 = 20 bytes
                StringBuffer sb2 = new StringBuffer(efe.getApellido());
                sb2.setLength(10); //10*2 = 20 bytes
                raf.writeChars(sb.toString());
                raf.writeChars(sb2.toString());
                raf.writeDouble(efe.getSalario()); //8 bytes
                raf.writeChar(efe.getDep()); // 2 bytes
            }

            System.out.println("Que empleado buscar? (Id 1-4)");
            Scanner sc = new Scanner(System.in);
            int numid = sc.nextInt();

            int pos = (numid - 1) * 54;

                        //pos busca la posicion segun los bytes que ocupa cada linea por el calculo realizado antes
            raf.seek(pos);
            System.out.println("ID: " + raf.readInt());
            String nom = "";
            for (int i = 0; i<10; i++){
                nom += raf.readChar();
            }
            System.out.println("NOMBRE: " + nom);

            String ape = "";
            for (int i = 0; i<10; i++){
                ape += raf.readChar();
            }
            System.out.println("APELLIDO: " + ape);

            System.out.println("SALARIO: " + raf.readDouble());

            System.out.println("DEPARTAMENTO: " + raf.readChar());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}