/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Mundo;

import java.io.Serializable;

/**
 * Clases que modela el pais
 * @author usuario
 */
public class Pais implements Serializable{
    
    /**
     * Atributo que modela el nombre del pais
     */
    private String nombre;

     /**
     * Constructor de un pais
     * @param nombre - String, nombre del pais
     */
    public Pais(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene el nombre del pais
     * @return nombre - nombre del pais
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que cambia el nombre del pais
     * @param nombre - String no nulo .
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
