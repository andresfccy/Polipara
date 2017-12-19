/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Mundo;

import java.io.Serializable;

/**
 * Clases que modela las ciudades en la que se realizara la copa
 * @author usuario
 */
public class Ciudad implements Serializable{
    
    /**
     * Atributos que modela la ciudad 
     */
    private String nombre;
    private Pais pais;

    /**
     * Constructor de la ciudad 
     * @param nombre, nombre de la ciudad
     * @param pais , pais al que pertenece la ciudad
     */
    public Ciudad(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    /**
     * Método que obtiene el nombre de la ciudad
     * @return String - El nombre de la ciudad
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que cambia el nombre de la ciudad
     * @param nombre - String no nulo 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que obtiene el pais donde se encuentra la ciudad
     * @return String - El pais al que pertenece la ciudad
     */
    public Pais getPais() {
        return pais;
    }
     /**
     * Método que cambia el pais
     * @param pais - String no nulo 
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
