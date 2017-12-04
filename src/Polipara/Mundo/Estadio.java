
package Polipara.Mundo;

import java.util.Scanner; 

public class Estadio 
{
private Scanner reader;
private String nombre_estadio;
private String ciudad;
private String pais;

public Estadio()
{
reader=new Scanner(System.in);
}
public void introducir_datos_estadio()
{
System.out.print("Introduzca el nombre del estadio: ");
nombre_estadio=reader.next();
System.out.print("Introduzca la ciudad donde se encuentra: ");
ciudad=reader.next();
System.out.print("Introduzca el pais donde se encuentra: ");
pais=reader.next();

}
public void mostrar_datos_estadio(){
System.out.println("Su Nombre es : "+nombre_estadio);
System.out.println("Su Apellido es : "+ciudad);
System.out.println("Su nacionalidad es : "+pais);
}
}
