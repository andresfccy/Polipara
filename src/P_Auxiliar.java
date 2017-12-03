
public class P_Auxiliar extends Persona
{
    private int Rol;
    

public P_Auxiliar()
{
System.out.println("Nuevo Personal Auxiliar");
}
public void introducir_rol()
{
System.out.print("Introduzca A que se dedica o Rol que cumple en el equipo: ");
Rol=reader.nextInt();
}

public void mostrar_datos_auxiliar()
{
System.out.println("Usted es : "+Rol); 

}
}
