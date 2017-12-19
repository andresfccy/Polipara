package Polipara.Mundo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 * Clases que modela los partidos de la copa
 * @author usuario
 */
public class Partido implements Serializable {

    // ---------------------------------------------------------------------------------------------------------
    // Atributos Publicos
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela el partido programado
     */
    public final static int PROGRAMADO = 0;
    /**
     * Atributo que modela el registro del partido
     */
    public final static int REGISTRADO = 1;
    
    // ---------------------------------------------------------------------------------------------------------
    // Atributos Privados
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela el equipo anfitrion
     */
    private Equipo anfitrion;
    /**
     * Atributo que modela el equipo visitante
     */
    private Equipo visitante;
    /**
     * Atributo que modela los goles del equipo anfitrion en el partido
     */
    private int golAnfitrion;
    /**
     * Atributo que modela los goles del equipo visitante en el partido
     */
    private int golVisitante;
    /**
     * Atributo que modela la fecha en que se jugara o se jugo el partido
     */
    private Date fechaPartido;
    /**
     * Atributo que modela el estado del partido si ya se jugo o esta pendiente
     */
    private int estado;
    /**
     * Atributo que modela el valor del recaudo del partido
     */
    private double recaudo;
     /**
     * Atributo que modela el valor del recaudo por publicidad del partido
     */
    private double recaudoPublicidad;
     /**
     * Atributo que modela el estadio donde se jugo o jugara el partido
     */
    private Estadio estadio;

     /**
     * Constructor de un partido
     * @param anfitrion - String, equipo anfitrion
     * @param visitante -String, equipo visitante
     * @param golAnfitrion - Int, Goles del equipo anfitrion en el partido
     * @param golVisitante -Int, Goles del equipo vivitante en el partido
     * @param fechaPartido - date,  fecha en la que se jugara el partido
     * @param estado - String,  estado e el que se encuentra el partido
     * @param estadio - String,  estadio donde se jugara el partido
     */
    public Partido(Equipo anfitrion, Equipo visitante, int golAnfitrion, int golVisitante, Date fechaPartido, int estado, Estadio estadio) {
        this.anfitrion = anfitrion;
        this.visitante = visitante;
        this.golAnfitrion = golAnfitrion;
        this.golVisitante = golVisitante;
        this.fechaPartido = fechaPartido;
        this.estado = estado;
        this.estadio = estadio;
    }
    /**
     * Método que obtiene el Estadio donde se jugara el partido
     * @return Estadio - Estadio donde se jugara el partido
     */
    public Estadio getEstadio() {
        return estadio;
    }
     /**
     * Método que cambia el estadio donde se jugara el partido
     * @param estadio - String no nulo .
     */
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
     /**
     * Método que obtiene el valor recaudado en el partido
     * @return recaudo - valor recaudado en el partido
     */
    public double getRecaudo() {
        return recaudo;
    }
     /**
     * Método que cambia el valor del recaudo
     * @param recaudo - Int no nulo .
     */
    public void setRecaudo(double recaudo) {
        this.recaudo = recaudo;
    }
    /**
     * Método que obtiene el valor recaudado por publicidad en el partido
     * @return recaudoPublicidad -  valor recaudado por publicidad en el partido
     */
    public double getRecaudoPublicidad() {
        return recaudoPublicidad;
    }
    /**
     * Método que cambia el valor del recaudo por publicidad
     * @param recaudoPublicidad - Int no nulo .
     */
    public void setRecaudoPublicidad(double recaudoPublicidad) {
        this.recaudoPublicidad = recaudoPublicidad;
    }
     /**
     * Método que obtiene el estado en que se encuentra el partido
     * @return estado -  estado en que se encuentra el partido
     */
    public int getEstado() {
        return estado;
    }
    /**
     * Método que cambia el estado en que se encuentra el partido
     * @param estado - String no nulo .
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    /**
     * Método que obtiene la fecha en la que se juega el partido
     * @return fechaPartido -  fecha en la que se juega el partido
     */
    public Date getFechaPartido() {
        return fechaPartido;
    }
    /**
     * Método que cambia la fecha en la que se juega el partido
     * @param fechaPartido - date no nulo .
     */
    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }
    /**
     * Método que obtiene el equipo anfitrion
     * @return anfitrion -  equipo anfitrion
     */
    public Equipo getAnfitrion() {
        return anfitrion;
    }
    /**
     * Método que cambia el equipo anfitrion
     * @param anfitrion - String no nulo .
     */
    public void setAnfitrion(Equipo anfitrion) {
        this.anfitrion = anfitrion;
    }
    /**
     * Método que obtiene el equipo visitante
     * @return visitante -  equipo visitante
     */
    public Equipo getVisitante() {
        return visitante;
    }
    /**
     * Método que cambia el equipo visitante
     * @param visitante - String no nulo .
     */
    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }
    /**
     * Método que obtiene los goles del equipo anfitrion
     * @return golAnfitrion -  goles del equipo anfitrion
     */
    public int getGolAnfitrion() {
        return golAnfitrion;
    }
     /**
     * Método que cambia los goles del equipo anfitrion
     * @param golAnfitrion - Int no nulo .
     */
    public void setGolAnfitrion(int golAnfitrion) {
        this.golAnfitrion = golAnfitrion;
    }
    /**
     * Método que obtiene los goles del equipo visitante
     * @return golVisitante -  goles del equipo visitante
     */
    public int getGolVisitante() {
        return golVisitante;
    }
     /**
     * Método que cambia los goles del equipo visitante
     * @param golVisitante - Int no nulo .
     */
    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    /**
     * Método que muestra todos los datos del partido.
     */
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
        
            JOptionPane.showMessageDialog(null, message);
        }
    }

    public String toString() {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(this.getFechaPartido()) + " : " + this.getAnfitrion().getNombre() + " vs " + this.getVisitante().getNombre();
    }
}
