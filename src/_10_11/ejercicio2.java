package _10_11;



import java.io.*;
import java.util.ArrayList;

import static _10_11.Empleado.nuevoFicheroEmpleadosLocalidad;

public class ejercicio2 {
    public static void main(String[] args) {


        File fl = new File("C:\\Users\\DAM2\\IdeaProjects\\AD2\\src\\_10_11\\empleados.dat");
        File fls = new File("C:\\Users\\DAM2\\IdeaProjects\\AD2\\src\\_10_11\\empleadosMadrid.dat");


        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("H1", "Spidy", 500.0, "Barcelona"));
        empleados.add(new Empleado("H2", "Emis", 200.0, "Reus"));
        empleados.add(new Empleado("M3", "Shugo", 500.0, "Madrid"));
        empleados.add(new Empleado("M4", "Anri", 600.0, "Madrid"));




            try {
                FileOutputStream fos  = new FileOutputStream(fl);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for (int i = 0; i < empleados.size(); i++) {
                    oos.writeObject(empleados);
                }
                fos.close();
                oos.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



            nuevoFicheroEmpleadosLocalidad(fl, "Madrid", fls);



    }
}
