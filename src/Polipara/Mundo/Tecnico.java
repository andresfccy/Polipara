package Polipara.Mundo;


public class Tecnico extends Persona
{
    private int campG;
    private int campP;

public Tecnico()
{
System.out.println("Nuevo Tecnico");
}
public void introducir_numero_campeonatos_ganados()
{
System.out.print("Introduzca cuantos campeonatos ha ganado: ");
campG=reader.nextInt();
}
public void introducir_numero_campeonatos_perdidos()
{
System.out.print("Introduzca cuantos campeonatos ha perdido: ");
campP=reader.nextInt();
}
public void mostrar_datos_tecnico()
{
System.out.println("Los campeonatos que Usted ha ganado son: "+campG); 
System.out.println("Los campeonatos que Usted ha perdido son: "+campP); 
}
}
