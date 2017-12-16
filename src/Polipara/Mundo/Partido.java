package Polipara.Mundo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Partido implements Serializable {

    private Equipo anfitrion;
    private Equipo visitante;
    private int golAnfitrion;
    private int golVisitante;
    private Date fechaPartido;

    public Partido(Equipo anfitrion, Equipo visitante, int golAnfitrion, int golVisitante, Date fechaPartido) {
        this.anfitrion = anfitrion;
        this.visitante = visitante;
        this.golAnfitrion = golAnfitrion;
        this.golVisitante = golVisitante;
        this.fechaPartido = fechaPartido;
    }

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public Equipo getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(Equipo anfitrion) {
        this.anfitrion = anfitrion;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public int getGolAnfitrion() {
        return golAnfitrion;
    }

    public void setGolAnfitrion(int golAnfitrion) {
        this.golAnfitrion = golAnfitrion;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    public void mostrarDatosPartido() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy = new Date();

        if (hoy.before(this.getFechaPartido())) {
            JOptionPane.showMessageDialog(null, "El partido aún no se ha jugado");
        } else {
            String message = "";
            message += "El equipo anfitrión es: " + this.getAnfitrion().getNombre() + "\n";
            message += "El equipo visitante es: " + this.getVisitante().getNombre() + "\n\n";

            if (golAnfitrion > golVisitante) {
                message += "El equipo Anfitrion es el ganador con : " + golAnfitrion + " goles\n";
                message += "El equipo Visitante es el perdedor con : " + golVisitante + " goles\n";
            } else if (golAnfitrion < golVisitante) {
                message += "El equipo Visitante es el ganador con : " + golVisitante + " goles\n";
                message += "El equipo Anfitrión es el perdedor con : " + golAnfitrion + " goles\n";
            } else {
                message += "Los equipos quedaron empatados a: " + golAnfitrion + "-" + golVisitante + " goles";
            }
        }
    }

    public String toString() {
        return this.getFechaPartido().toString() + " : " + this.getAnfitrion() + " vs " + this.getVisitante();
    }
}
