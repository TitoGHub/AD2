package _24_10;

import java.util.Objects;

public class empleados {
    private int id;
    private String nombre;
    private String apellido;
    private int salario;
    private char dep;


    public empleados(int id, String nombre, String apellido, int salario, char dep) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public char getDep() {
        return dep;
    }

    public void setDep(char dep) {
        this.dep = dep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        empleados empleados = (empleados) o;
        return id == empleados.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
