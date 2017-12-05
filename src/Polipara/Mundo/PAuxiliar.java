package Polipara.Mundo;

public class PAuxiliar extends Persona {

    private String Rol;

    public PAuxiliar(String Rol, String pNombre, String pApellido, Ciudad pCiudad, int pIdentificación) {
        super(pNombre, pApellido, pCiudad, pIdentificación);
        this.Rol = Rol;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    
}
