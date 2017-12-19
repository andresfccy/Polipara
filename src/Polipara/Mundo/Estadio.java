package Polipara.Mundo;

import java.io.Serializable;


/**
 * Clases que modela los estadios en los que se realizara la copa
 * @author usuario
 */
public class Estadio implements Serializable{

    /**
     * Atributos que modelan la clase estadio 
     */
    private String nombre_estadio;
    private Ciudad ciudad;
    
    /**
     * Constructor del estadio
     * @param nombre_estadio- nombre del estadio
     * @param ciudad - Ciudad donde se encuentra ubicado el estadio
     */

    public Estadio(String nombre_estadio, Ciudad ciudad) {
        this.nombre_estadio = nombre_estadio;
        this.ciudad = ciudad;
    }

    /**
     * Método que obtiene el nombre del estadio
     * @return String - El nombre del estadio
     */
    public String getNombre_estadio() {
        return nombre_estadio;
    }
    /**
     * Método que cambia el nombre del estadio
     * @param nombre_estadio - String no nulo 
     */
    public void setNombre_estadio(String nombre_estadio) {
        this.nombre_estadio = nombre_estadio;
    }
    /**
     * Método que obtiene la ciudad donde se encuentra el estadio
     * @return String - la ciudad donde se encuentra el estadio
     */
    public Ciudad getCiudad() {
        return ciudad;
    }
     /**
     * Método que cambia la ciudad donde se encuentra el estadio
     * @param ciudad - String no nulo 
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
     /**
     * Método que obtiene el pais donde se encuentra el estadio
     * @return String - pais donde se encuentra el estadio
     */
    public Pais getPais() {
        return this.ciudad.getPais();
    }

    public String toString(){
        return this.getNombre_estadio();
    }
}
