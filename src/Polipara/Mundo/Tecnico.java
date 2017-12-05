package Polipara.Mundo;

public class Tecnico extends Persona {

    private int campeonatosGanados;
    private int campeonatosPerdidos;

    public Tecnico(int campeonatosGanados, int campeonatosPerdidos, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.campeonatosGanados = campeonatosGanados;
        this.campeonatosPerdidos = campeonatosPerdidos;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    public int getCampeonatosPerdidos() {
        return campeonatosPerdidos;
    }

    public void setCampeonatosPerdidos(int campeonatosPerdidos) {
        this.campeonatosPerdidos = campeonatosPerdidos;
    }
}
