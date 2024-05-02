package Ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
Desde la empresa Entradas Triunfales, SL. requieren un software de organizaci�n de conciertos y t� eres la persona indicada para ello.
El programa debe permitir a los usuarios registrar eventos: tendr�n hasta 3 artistas, la fecha, la localizaci�n de los conciertos y el aforo m�ximo.
Adem�s, necesitas llevar un registro de los tickets vendidos para cada evento y calcular los ingresos generados. El programa debe ofrecer las siguientes
funcionalidades:
- Agregar un nuevo evento al calendario, especificando el artista, la fecha, la localizaci�n y el precio de los tickets.
- Vender tickets para un evento, reduciendo la cantidad de tickets disponibles. Si llega a 0 ya no se podr�n vender m�s.
- Calcular los ingresos generados por un evento en particular.
- Mostrar una lista de todos los eventos programados y sus detalles.
- Eliminar eventos cancelados o pasados del calendario.
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        //Declaramos todas las variables
        Scanner in = new Scanner(System.in);
        HashMap<Evento, Integer> eventos = new HashMap<>();
        int menu = 0;
        int cantidadTickets;
        int idEvento;
        boolean existeEvento = true;
        double ingresosGenerados = 0;
        Evento eventoA�adido;
        Evento eventoActual;
        Iterator<Evento> it;

        //Imprimimos el el men�
        System.out.println("Bienvenido a la gesti�n de eventos de Entradas Triunfales");
        while (menu != 6) {
            System.out.println("");
            System.out.println("---------- Men� ----------");
            System.out.println("1. Mostrar la lista de los eventos");
            System.out.println("2. Agregar un nuevo evento");
            System.out.println("3. Vender tickets");
            System.out.println("4. Calcular ingresos");
            System.out.println("5. Eliminar evento");
            System.out.println("6. Salir");
            System.out.println("�Qu� quieres hacer?");
            menu = in.nextInt();
            in.nextLine();
            System.out.println("");

            switch (menu) {
                case 1:
                    //Imprimimos el hashMap
                    it = eventos.keySet().iterator();
                    while (it.hasNext()) {
                        eventoActual = it.next();
                        System.out.println(eventoActual.toString() + "\nTickets vendidos: " + eventos.get(eventoActual));
                        System.out.println("");
                    }
                    break;
                case 2:
                    //A�adimos el evento que quiera el usuario
                    System.out.print("Introduce los datos del evento que quieres a�adir: \n");
                    eventoA�adido = new Evento();
                    if (!eventos.containsKey(eventoA�adido)) {
                        eventos.put(eventoA�adido, 0);
                        System.out.println("Evento a�adido");
                    } else {
                        System.out.println("Este evento ya est� en la lista");
                    }
                    break;
                case 3:
                    //Aumentamos los tickets vendidos
                    System.out.print("Introduce el n�mero identificador del evento para vender tickets: ");
                    idEvento = in.nextInt();
                    it = eventos.keySet().iterator();
                    while (it.hasNext()) {
                        eventoActual = it.next();
                        if (eventoActual.getIdEvento() == idEvento) {
                            existeEvento = true;
                            System.out.print("Introduce la cantidad de tickets a vender:");
                            cantidadTickets = in.nextInt();
                            in.nextLine();

                            if ((eventos.get(eventoActual) + cantidadTickets) <= eventoActual.getAforoMax()) {
                                eventos.replace(eventoActual, (eventos.get(eventoActual) + cantidadTickets));
                            } else {
                                System.out.println("No hay suficientes tickets disponibles");
                            }
                            break;
                        } else {
                            existeEvento = false;
                        }
                    }

                    if (existeEvento == false) {
                        System.out.println("El evento no existe");
                    } else {
                        System.out.println("Los tickets se vendieron con �xito");
                    }

                    break;
                case 4:
                    //Calculamos los ingresos del evento que escoja el usuario
                    System.out.print("Introduce el n�mero identificador del evento para calcular sus ingresos: ");
                    idEvento = in.nextInt();
                    it = eventos.keySet().iterator();
                    while (it.hasNext()) {
                        eventoActual = it.next();
                        if (eventoActual.getIdEvento() == idEvento) {
                            existeEvento = true;
                            ingresosGenerados = eventoActual.getPrecio() * eventos.get(eventoActual);
                            break;
                        } else {
                            existeEvento = false;
                        }
                    }

                    if (existeEvento == false) {
                        System.out.println("El evento no existe");
                    } else {
                        System.out.println("Los ingresos generados actualmente por este evento son: " + ingresosGenerados);
                    }

                    break;
                case 5:
                    //Eliminamos el evento que quiera el usuario
                    System.out.print("Introduce el n�mero identificador del evento para eliminarlo: ");
                    idEvento = in.nextInt();
                    it = eventos.keySet().iterator();
                    while (it.hasNext()) {
                        eventoActual = it.next();
                        if (eventoActual.getIdEvento() == idEvento) {
                            existeEvento = true;
                            eventos.remove(eventoActual);
                            break;
                        } else {
                            existeEvento = false;
                        }
                    }

                    if (existeEvento == false) {
                        System.out.println("El evento no existe");
                    } else {
                        System.out.println("El evento se elimin� con �xito");
                    }

                    break;
                case 6:
                    System.out.println("�Hasta luego!");
                    break;
                default:
                    System.out.println("Opci�n incorrecta");
            }
        }

    }

}
