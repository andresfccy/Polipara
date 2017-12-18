package Polipara.Mundo;

import java.io.Serializable;

public class Estadio implements Serializable{

    private String nombre_estadio;
    private Ciudad ciudad;

    public Estadio(String nombre_estadio, Ciudad ciudad) {
        this.nombre_estadio = nombre_estadio;
        this.ciudad = ciudad;
    }

    public String getNombre_estadio() {
        return nombre_estadio;
    }

    public void setNombre_estadio(String nombre_estadio) {
        this.nombre_estadio = nombre_estadio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Pais getPais() {
        return this.ciudad.getPais();
    }

    public String toString(){
        return this.getNombre_estadio();
    }
}
