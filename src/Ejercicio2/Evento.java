package Ejercicio2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Evento {

    //Atributos
    private Scanner in = new Scanner(System.in);
    private String[] artistas = new String[3];
    private String fecha;
    private String localizacion;
    private int aforoMax;
    private double precio;
    private int idEvento;
    private static int contEventos = 1000;

    //Constructor
    public Evento() {
        setArtistas();
        setFecha();
        setLocalizacion();
        setAforoMax();
        setPrecio();
        contEventos++;
        this.idEvento = contEventos;
    }

    public Evento(int idEventoIn) {
        this.idEvento = idEventoIn;
    }

    public String[] getArtistas() {
        return artistas;
    }

    public void setArtistas() {
        for (int i = 0; i < artistas.length; i++) {
            System.out.print("Introduce el nombre del artista " + (i + 1) + ": ");
            this.artistas[i] = in.nextLine();
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha() {
        System.out.print("Introduce la fecha del evento: ");
        this.fecha = in.nextLine();
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion() {
        System.out.print("Introduce la localización del evento: ");
        this.localizacion = in.nextLine();
    }

    public int getAforoMax() {
        return aforoMax;
    }

    public void setAforoMax() {
        System.out.print("Introduce el aforo del evento: ");
        this.aforoMax = in.nextInt();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio() {
        System.out.print("Introduce el precio de las entradas: ");
        this.precio = in.nextDouble();
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    //Sobreescribimos el método toString para poder imprimir la información de los eventos
    @Override
    public String toString() {
        String info = "Identificador del evento: " + this.idEvento + "\nArtistas: " + artistas[0] + ", " + artistas[1] + ", " + artistas[2] + "\nFecha: "
                + this.fecha + "\nLocalización: " + this.localizacion + "\nAforo máximo: " + this.aforoMax
                + "\nPrecio de la entrada: " + this.precio;
        return info;
    }

    //Sobreescribimos el método equals para comparar como queramos los eventos
    @Override
    public boolean equals(Object evento2) {
        if (this.idEvento == ((Evento) evento2).getIdEvento()) {
            return true;
        }
        return false;
    }

    //Se sobreescribe el método hashCode al sobreescribir equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.artistas);
        hash = 59 * hash + Objects.hashCode(this.fecha);
        hash = 59 * hash + Objects.hashCode(this.localizacion);
        hash = 59 * hash + this.aforoMax;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }
}
