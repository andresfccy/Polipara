package Polipara.Mundo;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Clases que modela la persona 
 * @author usuario
 */
public class Persona implements Serializable{
    
    /**
     * Atributo que modela el nombre de la persona
     */
    protected String nombre;
    /**
     * Atributo que modela el apellido de la persona
     */
    protected String apellido;
    /**
     * Atributo que modela la identificacion de la persona
     */
    protected int identificacion;
    /**
     * Atributo que modela la ciudad de donde es la persona
     */
    protected Ciudad ciudad;

    
    /**
     * Constructor de una persona 
     * @param pNombre - String, nombre del jugador
     * @param pApellido -String, apellido del jugador
     * @param Identificacion - identificacion del jugador
     * @param pCiudad -String, ciudad de donde es el jugador
     */
    public Persona(String pNombre, String pApellido, Ciudad pCiudad, int Identificacion) {
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.ciudad = pCiudad;
    }
     /**
     * Método que obtiene el nombre de la persona
     * @return nombre - nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que cambia el el nombre de la persona
     * @param nombre - String no nulo .
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que obtiene el apellido de la persona
     * @return apellido - apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Método que cambia el el apellido de la persona
     * @param apellido - String no nulo .
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
     /**
     * Método que obtiene la ciudad donde nacio la persona
     * @return ciudad - ciudad donde nacio la persona
     */
    public Ciudad getNacionalidad() {
        return ciudad;
    }
     /**
     * Método que cambia la ciudad donde nacio la persona
     * @param ciudad - String no nulo .
     */
    public void setNacionalidad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Método que obtiene la identificacion de la persona
     * @return identificacion -identificacion de la persona
     */
    public int getIdentificacion() {
        return identificacion;
    }
    /**
     * Método que cambia la la identificacion de la persona
     * @param identificacion - String no nulo .
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    /**
     * Método que obtiene la ciudad de la persona
     * @return ciudad - ciudad de la persona
     */
    public Ciudad getCiudad() {
        return ciudad;
    }
     /**
     * Método que cambia la ciudad de la persona
     * @param ciudad - String no nulo .
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public String toString(){
        return this.getNombre() + " " + this.getApellido() + " Id #." + this.getIdentificacion();
    }
}
