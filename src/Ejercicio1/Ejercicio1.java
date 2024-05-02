package Ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
En el instituto se est� organizando una excursi�n para los alumnos de 1�DAM. Te piden que hagas un programa sencillito para apuntar a las
personas que se van inscribiendo. Tiene que hacer lo siguiente:
- Para el alta se requiere el registro del alumno(nombre, fecha de nacimiento y grupo: A o B). 
- Si el alumno ya est� dado de alta no se crear� un nuevo registro, simplemente se dar� un mensaje de error.
- Al finalizar el programa se dar� el reporte final con los datos de cada persona inscrita.
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        //Declaramos todas las variables que vamos a utilizar
        Scanner in = new Scanner(System.in);
        HashSet<Alumno> excursion = new HashSet<>();
        String opcion;
        String nombreAlumno;
        String fechaNacAlumno;
        String grupoAlumno;

        System.out.println("Bienvenido al sistema de inscripci�n para la excursi�n de 1�DAM");

        while (true) {
            System.out.println("�Quieres inscribir un nuevo alumno? (No. 0, Si. cualquier otro n�mero)");
            opcion = in.nextLine();

            if (opcion.equals("0")) {
                break;
            } else {
                System.out.print("Introduce el nombre del alumno: ");
                nombreAlumno = in.nextLine();

                System.out.print("Introduce la fecha de nacimiento del alumno: ");
                fechaNacAlumno = in.nextLine();

                System.out.print("Introduce el grupo del alumno: ");
                grupoAlumno = in.nextLine();

                if (excursion.add(new Alumno(nombreAlumno, fechaNacAlumno, grupoAlumno))) {
                    System.out.println("Alumno a�adido a la lista");
                } else {
                    System.out.println("Este alumno ya est� en la lista");
                }

                System.out.println("");
            }
        }

        ArrayList excursion2 = new ArrayList();
        excursion2.addAll(excursion);

        System.out.println("\nAlumnos inscritos:");
        for (int i = 0; i < excursion2.size(); i++) {
            System.out.println((i + 1) + ". " + excursion2.get(i));
        }

    }

}
