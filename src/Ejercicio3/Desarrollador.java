package Ejercicio3;

public class Desarrollador extends Usuario {

    //Constructor
    public Desarrollador() {
        super();
        super.setRol("Desarrollador");
    }

    public void completarTarea() {
        System.out.println("Se completó una tarea");
    }

    public void pedirDatos() {
        setNombre();
        setSalario();
    }
}
