/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Mundo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que modela los equipos
 * @author usuario
 */
public class Equipo implements Serializable{
    // ---------------------------------------------------------------------------------------------------------
    // Atributos Privados
    // ---------------------------------------------------------------------------------------------------------
    
    /**
     * Atributo que modela el propietario del equipo
     */
    private Propietario propietario;
    
    /**
     * Atributo que modela el técnico del equipo
     */
    private Tecnico tecnico;
    
    /**
     * Atributo que modela el nombre del equipo
     */
    private String nombre;
    
    /**
     * Atributo que modela la lista de jugadores del equipo
     */
    private ArrayList<Jugador> jugadores;
    
    /**
     * Atributo que modela la lista de jugadores del equipo
     */
    private ArrayList<PAuxiliar> auxiliares;
    
    // ---------------------------------------------------------------------------------------------------------
    // Constructores
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Constructor de la clase.
     * @param nombre - String: Nombre que va a identificar el equipo, este es único y no nulo
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
        jugadores = new ArrayList<Jugador>();
        auxiliares = new ArrayList<PAuxiliar>();
    }
    
    // ---------------------------------------------------------------------------------------------------------
    // Getters y Setters
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Método que obtiene el nombre del equipo
     * @return String - El nombre del equipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que obtiene el propietario del equipo
     * @return Propietario - Propietario del equipo
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Método que cambia el nombre del equipo
     * @param nombre - String no nulo que iene que venir verificado para que no sea duplicado
     *                 de un equipo existente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    /**
     * Método que cambia el propietario del equipo
     * @param propietario - Objeto no nulo que modela el propietario del equipo
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * Método que obtiene el Tecnico del equipo
     * @return Tecnico - Tecnico del equipo
     */
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * Método que cambia el técnico del equipo
     * @param tecnico - Objeto no nulo que modela el técnico del equipo
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * Método que obtiene los Jugadores del equipo
     * @return Jugador - Jugadores del equipo
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Método que cambia los jugadores del equipo
     * @param jugadores - Lista no vacía que modela los jugadores del equipo
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Método que obtiene los Auxiliares del equipo
     * @return Auxiliar - Auxiliares del equipo
     */
    public ArrayList<PAuxiliar> getAuxiliares() {
        return auxiliares;
    }

    /**
     * Método que cambia los auxiliares del equipo
     * @param auxiliares - Lista no vacía que modela los auxiliares del equipo
     */
    public void setAuxiliares(ArrayList<PAuxiliar> auxiliares) {
        this.auxiliares = auxiliares;
    }
    
}
