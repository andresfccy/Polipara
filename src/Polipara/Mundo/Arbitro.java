package Polipara.Mundo;

import java.io.Serializable;

public class Arbitro extends Persona {

    private int partidosPitados;

    public Arbitro(int partidosPitados, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.partidosPitados = partidosPitados;
    }

    public int getPartidosPitados() {
        return partidosPitados;
    }

    public void setPartidosPitados(int partidosPitados) {
        this.partidosPitados = partidosPitados;
    }

    
}
