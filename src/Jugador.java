
public class Jugador extends Persona {
    
    private int posicion;
    

public Jugador()
{
System.out.println("Nuevo Jugador");
}
public void introducir_posicion()
{
System.out.print("Introduzca en que posicion juega: ");
posicion=reader.nextInt();
}

public void mostrar_datos_jugador()
{
System.out.println("Usted juega en la posicion de  : "+posicion); 

}
}
