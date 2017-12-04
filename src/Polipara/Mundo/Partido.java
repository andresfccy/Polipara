
package Polipara.Mundo;
import java.util.Scanner;

public class Partido 
{
private Scanner reader;
private String anfitrion;
private String visitante;
private int gol_anfitrion;
private int gol_visitante;

public Partido()
{
reader=new Scanner(System.in);
}
public void introducir_datos_partido()
{
System.out.print("Introduzca el nombre del equipo anfitrion: ");
anfitrion=reader.next();
System.out.print("Introduzca el nombre del equipo visitante: "); 
visitante=reader.next();
System.out.print("Introduzca el numero de goles del equipo anfitrion: "); 
gol_anfitrion=reader.nextInt();
System.out.print("Introduzca el numero de goles del equipo visitante: "); 
gol_visitante=reader.nextInt();


}
public void mostrar_datos_estado(){
System.out.println("El equipo Anfitrion es : "+anfitrion);
System.out.println("El equipo Visitante es : "+visitante);

if(gol_anfitrion > gol_visitante)
{
    System.out.println("El equipo Anfitrion es el ganador con : "+gol_anfitrion);
    System.out.println("El equipo Visitante es el perdedor con : "+gol_visitante);

    if(gol_visitante==gol_anfitrion)
    {
         System.out.println("Los equipos quedaron empatados: "+gol_anfitrion+"-"+gol_visitante);
    }
    else
    {
        System.out.println("El equipo Visitante es el ganador con : "+gol_visitante); 
        System.out.println("El equipo Anfitrion es el perdedor con : "+gol_anfitrion);
    }
       
    }
} 
}
