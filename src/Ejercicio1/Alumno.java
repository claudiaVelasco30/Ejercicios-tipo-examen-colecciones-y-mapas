package Ejercicio1;

import java.util.Objects;

public class Alumno {

    //Atributos
    private String nombre;
    private String fechaNac;
    private String grupo;

    //Constructor
    public Alumno(String nombre, String fechaNac, String grupo) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    //Sobreescribimos el método toString para poder imprimir la información de los alumnos
    @Override
    public String toString() {
        String info = "Nombre: " + this.nombre + ", Fecha de nacimiento: " + this.fechaNac + ", Grupo: " + this.grupo;
        return info;
    }

    /**
     * Método equals sobreescrito
     *
     * @param Alumno2 Otro onjeto de la clase alumno
     * @return true si todos los atributos son iguales, false si hay algún
     * atributo diferente Sobreescribimos este método para que a la hora de
     * comparar dos objetos alumno en el hashSet se comparen los atributos y no
     * las direcciones de memoria
     */
    @Override
    public boolean equals(Object Alumno2) {
        if ((this.nombre).equalsIgnoreCase(((Alumno) Alumno2).getNombre())) {
            if (this.fechaNac.equalsIgnoreCase(((Alumno) Alumno2).getFechaNac())) {
                if (this.grupo.equalsIgnoreCase(((Alumno) Alumno2).getGrupo())) {
                    return true;
                }
            }
        }
        return false;
    }

    //Se sobreescribe el método hashCode al sobreescribir equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.fechaNac);
        hash = 53 * hash + Objects.hashCode(this.grupo);
        return hash;
    }
}
