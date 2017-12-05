package Polipara.Mundo;

public class Jugador extends Persona {

    public final static int HABILITADO = 0;
    public final static int LESIONADO = 1;
    public final static int SUSPENDIDO = 2;

    private int estado;
    private String posicion;

    public Jugador(int estado, String posicion, String pNombre, String pApellido, Ciudad pCiudad, int Identificacion) {
        super(pNombre, pApellido, pCiudad, Identificacion);
        this.estado = estado;
        this.posicion = posicion;
    }    

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
