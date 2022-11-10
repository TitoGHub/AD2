package _2_11;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.TransformerException;

import java.io.File;
import java.util.ArrayList;


public class PruebaEmpleado {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        File fl = new File("C:\\Users\\DAM2\\Desktop\\AcessoDatos\\_0211\\empleados.xml");
        empleados.add(new Empleado("01", "Spidy", 200.0, 25));
        empleados.add(new Empleado("02", "Monkey", 20.0, 24));
        empleados.add(new Empleado("03", "Anri", 1000.0, 26));
        empleados.add(new Empleado("04", "Shugo", 500.0, 24));
        empleados.add(new Empleado("05", "Churly", 90.0, 24));

        Empleado.escribirFichero(fl,empleados);
        Empleado.salarioMedio(fl);
    }
}