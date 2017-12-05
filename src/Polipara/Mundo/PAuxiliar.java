package Polipara.Mundo;

public class PAuxiliar extends Persona {

    private int Rol;

    public PAuxiliar(int Rol, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.Rol = Rol;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    
}
