package Ejercicio3;

import java.util.Objects;
import java.util.Scanner;

public abstract class Usuario {

    //Atributos
    private Scanner in = new Scanner(System.in);
    private String nombre;
    private String rol;
    private double salario;

    //Constructores
    public Usuario(String nombreIn, double salarioIn) {
        this.nombre = nombreIn;
        this.salario = salarioIn;
    }

    public Usuario() {

    }

    public void eliminarTarea() {
        System.out.println("El " + this.rol + " " + this.nombre + " eliminó una tarea");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        System.out.print("Escribe el nombre del empleado que va a ser contratado: ");
        this.nombre = in.nextLine();
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario() {
        System.out.print("Escribe el salario del empleado que va a ser contratado: ");
        this.salario = in.nextDouble();
    }

    @Override
    public String toString() {
        String frase = "Nombre: " + getNombre() + ", rol: " + getRol();
        return frase;
    }

    @Override
    public boolean equals(Object otroUsuario) {
        if (this.nombre.equalsIgnoreCase(((Usuario) otroUsuario).getNombre())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.in);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.rol);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        return hash;
    }
}
