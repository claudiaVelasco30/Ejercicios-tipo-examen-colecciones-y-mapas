package Ejercicio3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        //Declaramos todas las variables que vamos a utilizar
        Scanner in = new Scanner(System.in);
        String tarea;
        String tipoTarea;
        int opcion;
        boolean salir = false;
        Usuario usuarioSeleccionado;
        Usuario usuarioActual;
        Desarrollador empleado;
        Tarea tareaActual;
        HashSet<String> tiposTareas = new HashSet<>();
        HashSet<Usuario> equipo = new HashSet<>();
        HashMap<Tarea, Desarrollador> listadoTareas = new HashMap<>();
        Iterator<Usuario> it1;
        double contSalarios = 0;

        //Pedimos 5 tipologías distintas de tareas
        while (tiposTareas.size() < 5) {
            System.out.print("Introduzca un tipo de tarea: ");
            tarea = in.nextLine();
            if (!tiposTareas.contains(tarea)) {
                tiposTareas.add(tarea);
            } else {
                System.out.println("Este tipo ya está en la lista");
            }
        }

        //Creamos el jefe y le añadimos al equipo
        JefeEquipo jefe = new JefeEquipo("A", 2000);
        equipo.add(jefe);

        //Realizamos las acciones mientras el usuario decida no salir
        while (salir == false) {
            System.out.println("");
            System.out.println("1. Elegir a un empleado");
            System.out.println("2. Reunir a los empleados en un daily");
            System.out.println("3. Salir");
            System.out.print("¿Qué quieres hacer?: ");
            opcion = in.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1:
                    usuarioSeleccionado = seleccionarUsuario(equipo);
                    System.out.println("");
                    //Menú de opciones del jefe de equipo
                    if (usuarioSeleccionado.getRol().equalsIgnoreCase("Jefe de equipo")) {
                        System.out.println("1. Crear tareas");
                        System.out.println("2. Asignar tareas");
                        System.out.println("3. Eliminar tareas");
                        System.out.println("4. Contratar empleados");
                        System.out.print("¿Qué quieres hacer?: ");
                        opcion = in.nextInt();
                        System.out.println("");

                        switch (opcion) {
                            case 1:
                                System.out.println("1. Crear una tarea sin usuario asignado");
                                System.out.println("2. Crear una tarea con usuario de base asignado");
                                System.out.print("¿Qué quieres hacer?: ");
                                opcion = in.nextInt();
                                switch (opcion) {
                                    case 1:
                                        tipoTarea = seleccionarTipoTarea(tiposTareas);
                                        listadoTareas.put(new Tarea(tipoTarea), null);
                                        ((JefeEquipo) usuarioSeleccionado).crearTarea();
                                        break;
                                    case 2:
                                        usuarioActual = seleccionarUsuario(equipo);
                                        tipoTarea = seleccionarTipoTarea(tiposTareas);
                                        listadoTareas.put(new Tarea(tipoTarea), (Desarrollador) usuarioActual);
                                        ((JefeEquipo) usuarioSeleccionado).crearTarea(usuarioActual);
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta");
                                }
                                break;
                            case 2:
                                tareaActual = seleccionarTarea(listadoTareas);
                                usuarioActual = seleccionarUsuario(equipo);
                                if (listadoTareas.get(tareaActual) == null) {
                                    listadoTareas.replace(tareaActual, (Desarrollador) usuarioActual);
                                    ((JefeEquipo) usuarioSeleccionado).asignarTarea(usuarioActual);
                                } else {
                                    System.out.println("Esta tarea ya está asignada a un empleado");
                                }

                                break;
                            case 3:
                                tareaActual = seleccionarTarea(listadoTareas);
                                listadoTareas.remove(tareaActual);
                                ((JefeEquipo) usuarioSeleccionado).eliminarTarea();
                                break;
                            case 4:
                                empleado = new Desarrollador();

                                ((JefeEquipo) usuarioSeleccionado).contratarEmpleado(empleado);
                                if (!equipo.contains(empleado)) {
                                    it1 = equipo.iterator();
                                    while (it1.hasNext()) {
                                        contSalarios += it1.next().getSalario();
                                    }
                                    if ((contSalarios + empleado.getSalario()) <= 8000) {
                                        equipo.add(empleado);
                                        System.out.println(empleado.getNombre() + " ha sido añadido al equipo de trabajo");
                                    } else {
                                        System.out.println("No se puede añadir al empleado");
                                    }

                                } else {
                                    System.out.println(empleado.getNombre() + " ya está en el equipo");
                                }
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                        //Menú de opciones de los desarrolladores
                    } else {
                        if (!listadoTareas.isEmpty()) {
                            System.out.println("1. Completar tarea");
                            System.out.println("2. Eliminar tarea");
                            System.out.print("¿Qué quieres hacer?: ");
                            opcion = in.nextInt();
                            System.out.println("");

                            switch (opcion) {
                                case 1:
                                    tareaActual = seleccionarTarea(listadoTareas);
                                    tareaActual.setCompletada(true);
                                    ((Desarrollador) usuarioSeleccionado).completarTarea();
                                    break;
                                case 2:
                                    tareaActual = seleccionarTarea(listadoTareas);
                                    listadoTareas.remove(tareaActual);
                                    ((Desarrollador) usuarioSeleccionado).eliminarTarea();
                                    break;
                                default:
                                    System.out.println("Opcion incorrecta");
                            }
                        } else {
                            System.out.println("No hay tareas activas, no puedes hacer nada");
                        }

                    }

                    break;
                case 2:
                    System.out.println("Se reunió a todo el equipo en un  daily. Este es el estado actual de todas las tareas: ");
                    if (!listadoTareas.isEmpty()) {
                        verListadoTareas(listadoTareas);
                    } else {
                        System.out.println("No hay ninguna tarea activa");
                    }

                    break;
                case 3:
                    //Confirmación para salir
                    System.out.print("¿Estás seguro de que quieres salir? (1. Sí, 2. No): ");
                    opcion = in.nextInt();
                    switch (opcion) {
                        case 1:
                            salir = true;
                            System.out.println("Saliendo del programa...");
                            break;
                        case 2:
                            System.out.println("Has decicido no salir");
                            break;
                        default:
                            System.out.println("Opción incorrecta. Supongo que no quieres salir");
                            break;
                    }
                    break;

                default:
                    System.out.println("Opcion incorrecta");

            }
        }
    }

    /**
     * Función para imprimir todos los miembros del equipo y para que el usuario
     * elija uno
     *
     * @param equipo HashSet con el equipo de trabajo
     * @return el empleado que seleccione el usuario
     */
    public static Usuario seleccionarUsuario(HashSet<Usuario> equipo) {
        Scanner in = new Scanner(System.in);
        int cont = 1;
        int opcion;
        Usuario usuarioSeleccionado = null;
        Iterator<Usuario> it = equipo.iterator();
        while (it.hasNext()) {
            System.out.println(cont + ". " + it.next());
            cont++;
        }

        System.out.print("Introduce el número correspondiente al empleado que desees elegir: ");
        opcion = in.nextInt();
        it = equipo.iterator();
        cont = 1;
        while (it.hasNext()) {
            if (cont == opcion) {
                usuarioSeleccionado = it.next();
                break;
            } else {
                it.next();
            }
            cont++;
        }

        return usuarioSeleccionado;
    }

    /**
     * Función para imprimir todas las tipologías de las tareas y para que el
     * usuario elija una
     *
     * @param tiposTareas HashSet con las tipologías de las tareas
     * @return el tipo de tarea que ha seleccionado el usuario
     */
    public static String seleccionarTipoTarea(HashSet<String> tiposTareas) {
        Scanner in = new Scanner(System.in);
        int cont = 1;
        int opcion;
        Iterator<String> it = tiposTareas.iterator();
        String tipoTarea = "";
        while (it.hasNext()) {
            System.out.println("Tipología " + cont + ": " + it.next());
            cont++;
        }
        System.out.println("¿De que tipología quieres crear la tarea?: ");
        opcion = in.nextInt();

        it = tiposTareas.iterator();
        cont = 1;
        while (it.hasNext()) {
            if (cont == opcion) {
                tipoTarea = it.next();
                break;
            } else {
                it.next();
            }
            cont++;
        }

        return tipoTarea;
    }

    /**
     * Función para que el usuario elija una tarea de la lista
     *
     * @param listadoTareas
     * @return tarea seleccionada por el usuario
     */
    public static Tarea seleccionarTarea(HashMap<Tarea, Desarrollador> listadoTareas) {
        Scanner in = new Scanner(System.in);
        Tarea tareaActual = null;
        int cont = 1;
        int opcion;
        Iterator<Tarea> it;
        verListadoTareas(listadoTareas);

        System.out.print("Introduce el número correspondiente a la tarea que desees elegir: ");
        opcion = in.nextInt();

        it = listadoTareas.keySet().iterator();
        while (it.hasNext()) {
            if (cont == opcion) {
                tareaActual = it.next();
                break;
            } else {
                it.next();
            }
        }

        return tareaActual;
    }

    /**
     * Función para imprimir todas las tareasy el empleado a las que están
     * asignadas
     *
     * @param listadoTareas HashMap con el listado de las tareas y el empleado a
     * las que están asignadas
     */
    public static void verListadoTareas(HashMap<Tarea, Desarrollador> listadoTareas) {
        Tarea tareaActual;
        String usuarioActual;
        int cont = 1;
        Iterator<Tarea> it = listadoTareas.keySet().iterator();
        while (it.hasNext()) {
            tareaActual = it.next();
            if (listadoTareas.get(tareaActual) != null) {
                usuarioActual = listadoTareas.get(tareaActual).getNombre();
            } else {
                usuarioActual = "no está asigando a ningún empleado";
            }
            System.out.println(cont + ". " + tareaActual.toString() + ", empleado asignado: " + usuarioActual);
            cont++;
        }
    }

}
