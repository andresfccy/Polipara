/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Mundo;

import java.io.Serializable;

/**
 * Clase que modela las interacciones de un jugador en un determinado partido
 * @author usuario
 */
public class Interaccion implements Serializable{
    
    // ---------------------------------------------------------------------------------------------------------
    // Constantes
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Constante que modela una tarjeta AMARILLA como interacción
     */
    public final static int AMARILLA = 0;
    
    /**
     * Constante que modela una tarjeta ROJA como interacción
     */
    public final static int ROJA = 1;
    
    /**
     * Constante que modela una LESION como interacción
     */
    public final static int LESION = 2;
    
    
    // ---------------------------------------------------------------------------------------------------------
    // Atributos Privados
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela el jugador de la interacción
     */
    private Jugador jugador;
    
    private Partido partido;
    
    /**
     * Atributo que modela la interacción presentada con el jugador
     */
    private int interaccion;
    
    /**
     * Atributo que modela si la interacción tiene comentarios adicionales
     */
    private String descripcion;
    
    // ---------------------------------------------------------------------------------------------------------
    // Constructores
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Constructor de una interacción
     * @param pJugador - Jugador, no puede ser nulo
     * @param pInteraccion - int, Tiene que ser un valor modelado en las constantes de esta misma clase
     * @param pDescripcion - String, Puede ser nulo
     * @throws Exception - Si la interacción no coincide con las constantes establecidas, se lanza una excepción
     */
    public Interaccion(Jugador pJugador, Partido pPartido, int pInteraccion, String pDescripcion) throws Exception{
        jugador = pJugador;
        partido = pPartido;
        interaccion = pInteraccion;
        switch(pInteraccion){
            case 0:
                // AMARILLA
                break;
            case 1:
                // ROJA
                break;
            case 2:
                // LESION
                jugador.setEstado(Jugador.LESIONADO);
                break;
            default:
                throw new Exception("Interacción no válida");
        }
    }    

    public Jugador getJugador() {
        return jugador;
    }

    public int getInteraccion() {
        return interaccion;
    }

    public Partido getPartido() {
        return partido;
    }
    
    public String toString(){
        return this.interaccion == 0 ? "le sacaron amarilla." : (this.interaccion == 1 ? "le sacaron roja." : "se lesionó.");
    }
}
