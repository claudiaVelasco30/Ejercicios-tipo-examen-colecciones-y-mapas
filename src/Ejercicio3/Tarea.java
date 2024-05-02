package Ejercicio3;

import java.util.Objects;

public class Tarea {

    //Atributos
    private int id;
    private String tipo;
    private boolean completada;
    private static int contTareas = 1000;

    //Constructor
    public Tarea(String tipoIn) {
        this.tipo = tipoIn;
        this.completada = false;
        contTareas++;
        this.id = contTareas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String info = "Id tarea: " + this.id + ", tipo de tarea: " + this.tipo + ", completada: " + this.completada;
        return info;
    }

    @Override
    public boolean equals(Object otraTarea) {
        if (this.id == ((Tarea) otraTarea).getId()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + (this.completada ? 1 : 0);
        return hash;
    }
}
