package Polipara.Mundo;

/**
 * Clases que modela los propietarios, hereda de la clase Persona
 * @author usuario
 */
public class Propietario extends Persona 
{
     /**
     * Constructor de un propietario con atributos heredados de la clase Persona
     * @param pNombre - String, nombre del jugador
     * @param pApellido -String, apellido del jugador
     * @param pIdentificación - identificacion del jugador
     * @param pCiudad -String, ciudad de donde es el jugador
     */
    public Propietario(String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
    }
}
