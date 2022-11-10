package _10_11;


import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Empleado implements Serializable {

    public String codigo;
    public String nombre;
    public double salario;
    public String localidad;

    public Empleado(String codigo, String nombre, double salario, String localidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", localidad='" + localidad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return codigo.equals(empleado.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public static boolean nuevoFicheroEmpleadosLocalidad(File fl, String localidad, File localidadF) {
        try {

            FileOutputStream fos = new FileOutputStream(fl);
            FileInputStream fis = new FileInputStream(fl);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ObjectInputStream ois = new ObjectInputStream(fis);


            Object lectura2 = null;
            while ((lectura2 = (Empleado) ois.readObject()) != null) {
                String localidadE = ((Empleado) lectura2).getLocalidad();
                String nombreE = ((Empleado) lectura2).getNombre();
                String codigoE = ((Empleado) lectura2).getCodigo();
                double salarioE = ((Empleado) lectura2).getSalario();


                if (localidadE.equalsIgnoreCase(localidad)) {

                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

}

