package Polipara.Mundo;

import java.util.Scanner; 

public class Persona 
{
protected Scanner reader;
protected String nombre;
protected String apellido;
protected String nacionalidad;

public Persona()
{
reader=new Scanner(System.in);
}
public void introducir_datos_personales()
{
System.out.print("Introduzca nombre: ");
nombre=reader.next();
System.out.print("Introduzca apellido: ");
apellido=reader.next();
System.out.print("Introduzca nacionalidad: ");
nacionalidad=reader.next();

}
public void mostrar_datos_personales(){
System.out.println("Su Nombre es : "+nombre);
System.out.println("Su Apellido es : "+apellido);
System.out.println("Su nacionalidad es : "+nacionalidad);
}
}
