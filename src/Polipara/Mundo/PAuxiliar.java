package Polipara.Mundo;

/**
 * Clases que modela el personal auxiliar, hereda de la clase Persona
 * @author usuario
 */
public class PAuxiliar extends Persona { 

    /**
     * Atributo que modela rol del auxiliar (masajista, fisioterapeuta,medico)
     */
    private String Rol;

     /**
     * Constructor de una persona auxiliar con atributos heredados de la clase Persona
     * @param pNombre - String, nombre del jugador
     * @param pApellido -String, apellido del jugador
     * @param pIdentificación - identificacion del jugador
     * @param pCiudad -String, ciudad de donde es el jugador
     * @param Rol - String,  rol que desempeña la persona auxiliar ,(masajista, fisioterapeuta,medico) 
     */
    public PAuxiliar(String Rol, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.Rol = Rol;
    }
    /**
     * Método que obtiene el rol de la persona auxiliar
     * @return Rol - rol que desempeña en el equipo
     */
    public String getRol() {
        return Rol;
    }
    /**
     * Método que cambia el rol de la persona auxiliar
     * @param Rol - String no nulo .
     */
    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    
}
