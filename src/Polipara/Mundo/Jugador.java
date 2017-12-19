package Polipara.Mundo;

/**
 * Clases que modela los jugadores, hereda de la clase Persona
 * @author usuario
 */
public class Jugador extends Persona {

    // ---------------------------------------------------------------------------------------------------------
    // Atributos Publicos
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela a un jugador que no tiene equipo
     */
    public final static int SIN_EQUIPO = -1;
    /**
     * Atributo que modela a un jugador que se encuentra habilitado
     */
    public final static int HABILITADO = 0;
    /**
     * Atributo que modela a un jugador que se encuentra lesionado
     */
    public final static int LESIONADO = 1;
    /**
     * Atributo que modela a un jugador que se encuentra suspendido
     */
    public final static int SUSPENDIDO = 2;

    // ---------------------------------------------------------------------------------------------------------
    // Atributos Privados
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Atributo que modela el estado en que se encuentra un jugador segun los atributos publicos
     */
    private int estado;
     /**
     * Atributo que modela la posicion en la que juega un jugador
     */
    private String posicion;

    
    /**
     * Constructor de un jugador con atributos heredados de la clase Persona
     * @param pNombre - String, nombre del jugador
     * @param pApellido -String, apellido del jugador
     * @param Identificacion - int, identificacion del jugador
     * @param pCiudad -String, ciudad de donde es el jugador
     * @param estado -int,  estado del jugador 
     * @param posicion - String , posicion en la que juega el jugador
     */
    public Jugador(int estado, String posicion, String pNombre, String pApellido, Ciudad pCiudad, int Identificacion) {
        super(pNombre, pApellido, pCiudad, Identificacion);
        this.estado = estado;
        this.posicion = posicion;
    }    
     /**
     * Método que obtiene el estado del jugador
     * @return int - estado del jugador
     */
    public int getEstado() {
        return estado;
    }
    /**
     * Método que cambia el estado del jugador
     * @param estado - int no nulo 
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
     /**
     * Método que obtiene la posicion de un jugador
     * @return String - posicion del jugador
     */
    public String getPosicion() {
        return posicion;
    }
    /**
     * Método que cambia la posicion de un jugador
     * @param posicion - String no nulo 
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
