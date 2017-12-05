package Polipara.Mundo;

import java.util.Scanner;

public class Estadio {

    private String nombre_estadio;
    private String ciudad;
    private String pais;

    public Estadio(String nombre_estadio, String ciudad, String pais) {
        this.nombre_estadio = nombre_estadio;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getNombre_estadio() {
        return nombre_estadio;
    }

    public void setNombre_estadio(String nombre_estadio) {
        this.nombre_estadio = nombre_estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
