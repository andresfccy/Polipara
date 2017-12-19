package Polipara.Mundo;

import java.io.Serializable;

/**
 * Clase que modela los arbitros que participan en la copa con sus datos personales e historial
 * hereda de la clase persona
 * @author usuario
 */
public class Arbitro extends Persona {

    /**
     * Atributo que modela los partidos pitados en la copa por el arbitro
     */
    private int partidosPitados;

    /**
     * Constructor de un arbitro con atributos heredados de la clase Persona
     * @param pNombre - String, nombre del arbitro
     * @param pApellido-String, apellido del arbitro
     * @param pIdentificación - identificacion del arbitro
     * @param pCiudad -String, la ciudad de donde es el arbitro
     * @param partidosPitados -int, el  numero de partidos que ha pitado el arbitro en la copa 
     */
    public Arbitro(int partidosPitados, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.partidosPitados = partidosPitados;
    }

     /**
     * Método que obtiene los partidos pitados por el arbitro
     * @return String - El nombre del arbitro
     */
    public int getPartidosPitados() {
        return partidosPitados;
    }

    /**
     * Método que cambia el numero de partidos pitados por el arbitro
     * @param partidosPitados - int no nulo 
     */
    public void setPartidosPitados(int partidosPitados) {
        this.partidosPitados = partidosPitados;
    }

    
}
