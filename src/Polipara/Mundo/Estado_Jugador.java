
package Polipara.Mundo;

import java.util.Scanner; 

public class Estado_Jugador 
{
private Scanner reader;
private String nombre_jugador;
private String Estado;


public Estado_Jugador()
{
reader=new Scanner(System.in);
}
public void introducir_datos_estado()
{
System.out.print("Introduzca el nombre del jugador: ");
nombre_jugador=reader.next();
System.out.print("Introduzca Su Estado: "); // estado: Lesionado, Enfermo, suspendido, incapacitado
Estado=reader.next();


}
public void mostrar_datos_estado(){
System.out.println("El nombre del jugador es : "+nombre_jugador);
System.out.println("El estado del jugador es : "+Estado);

}
}
