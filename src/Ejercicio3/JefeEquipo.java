package Ejercicio3;

public class JefeEquipo extends Usuario {

    //Constructor
    public JefeEquipo(String nombreIn, double salarioIn) {
        super(nombreIn, salarioIn);
        super.setRol("Jefe de equipo");
    }

    public void crearTarea() {
        System.out.println("Se ha a�adido una nueva tarea a la lista");
    }

    public void crearTarea(Usuario usuario1) {
        System.out.println("Se ha a�adido una nueva tarea a la lista asignada a " + usuario1.getNombre());
    }

    public void asignarTarea(Usuario usuario1) {
        System.out.println("Se asign� una tarea a " + usuario1.getNombre());
    }

    public void contratarEmpleado(Desarrollador usuario1) {
        usuario1.pedirDatos();
    }
}
