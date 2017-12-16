package Polipara.Mundo;

import java.io.Serializable;
import java.util.Scanner;

public class Persona implements Serializable{
    protected String nombre;
    protected String apellido;
    protected int identificacion;
    protected Ciudad ciudad;

    public Persona(String pNombre, String pApellido, Ciudad pCiudad, int Identificacion) {
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.ciudad = pCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Ciudad getNacionalidad() {
        return ciudad;
    }

    public void setNacionalidad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
