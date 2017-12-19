package Polipara.Mundo;

/**
 * Clases que modela a los Tecnicos, hereda de la clase Persona
 * @author usuario
 */
public class Tecnico extends Persona {

    /**
     * Atributo que modela el numero de campeonatos ganados por el tecnico
     */
    private int campeonatosGanados;
    /**
     * Atributo que modela el numero de campeonatos perdidos por el tecnico
     */
    private int campeonatosPerdidos;

     /**
     * Constructor de un Tecnico con atributos heredados de la clase Persona
     * @param pNombre - String, nombre del jugador
     * @param pApellido -String, apellido del jugador
     * @param pIdentificación - identificacion del jugador
     * @param pCiudad -String, ciudad de donde es el jugador
     * @param campeonatosGanados- Int,  numero de campeonatos ganados por el tecnico
     * @param campeonatosPerdidos- Int,  numero de campeonatos perdidos por el tecnico
     */
    public Tecnico(int campeonatosGanados, int campeonatosPerdidos, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.campeonatosGanados = campeonatosGanados;
        this.campeonatosPerdidos = campeonatosPerdidos;
    }
     /**
     * Método que obtiene el numero de campeonatos ganados por el tecnico
     * @return campeonatosGanados - campeonatos perdidos por el tecnico
     */
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }
    /**
     * Método que cambia el el numero de campeonatos ganados por el tecnico
     * @param campeonatosGanados - Int no nulo .
     */
    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    /**
     * Método que obtiene el numero de campeonatos perdidos por el tecnico
     * @return campeonatosPerdidos - campeonatos perdidos por el tecnico
     */
    public int getCampeonatosPerdidos() {
        return campeonatosPerdidos;
    }
    /**
     * Método que cambia el el numero de campeonatos perdidos por el tecnico
     * @param campeonatosPerdidos - Int no nulo .
     */
    public void setCampeonatosPerdidos(int campeonatosPerdidos) {
        this.campeonatosPerdidos = campeonatosPerdidos;
    }
}
