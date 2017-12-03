
public class Arbitro extends Persona {
      private int P_Pitados;
    

public Arbitro()
{
System.out.println("Nuevo Arbitro");
}
public void introducir_partidos_pitados()
{
System.out.print("Introduzca cuantos cuantos partidos ha pitados: ");
P_Pitados=reader.nextInt();
}

public void mostrar_datos_arbitro()
{
System.out.println("Los partidos que usted ha pitado son: "+P_Pitados); 

}
}
