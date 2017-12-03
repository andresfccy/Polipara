package Polipara.Mundo;



public class Propietario extends Persona
{
private String equipo;

public Propietario()
{
System.out.println("Nuevo Propietario");
}
public void introducir_equipo()
{
System.out.print("Introduzca el equipo del que es propietario: ");
equipo=reader.next();
}
public void mostrar_datos_propietario()
{
System.out.println("equipo: "+equipo+"."); 
}

}
