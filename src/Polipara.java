

import java.util.Scanner; 


public class Polipara 
{

   
    public static void main(String[] args) 
    {
        
        Scanner scanner=new Scanner(System.in);
        int op = 0;
        
        while (op!=6)
        {
            System.out.println("1. Registrar Popietario");
            System.out.println("2. Registrar Tecnico");
            System.out.println("3. Registrar Arbitro");
            System.out.println("4. Registrar Personal Auxiliar");
            System.out.println("5. Registrar Jugador");
            System.out.println("6. Salir"); 
            
            System.out.println("introduzca un numero segun el proceso que desea realizar : "); 
            
             op= scanner.nextInt();
             
             switch(op)
             {
                 case 1:
                      Propietario propietario1=new Propietario();
                      propietario1.introducir_datos_personales();
                      propietario1.introducir_equipo();
                      propietario1.mostrar_datos_personales();
                      propietario1.mostrar_datos_propietario();
                      
                   break;
                 
                 case 2: 
                     Tecnico tecnico1=new Tecnico();
                     tecnico1.introducir_datos_personales();
                     tecnico1.introducir_numero_campeonatos_ganados();
                     tecnico1.introducir_numero_campeonatos_perdidos();
                     tecnico1.mostrar_datos_personales();
                     tecnico1.mostrar_datos_tecnico();
                     
                   break;
                   
                 case 3: 
                     Arbitro arbitro1=new Arbitro();
                     arbitro1.introducir_datos_personales();
                     arbitro1.introducir_partidos_pitados();
                     arbitro1.mostrar_datos_personales();
                     arbitro1.mostrar_datos_arbitro();
                     
                   break;
                   
                 case 4: 
                     P_Auxiliar auxiliar1=new P_Auxiliar();
                     auxiliar1.introducir_datos_personales();
                     auxiliar1.introducir_rol();
                     auxiliar1.mostrar_datos_personales();
                     auxiliar1.mostrar_datos_auxiliar();
                     
                   break;
                   
                 case 5: 
                    Jugador jugador1=new Jugador();
                     jugador1.introducir_datos_personales();
                     jugador1.introducir_posicion();
                     jugador1.mostrar_datos_personales();
                     jugador1.mostrar_datos_jugador();
                     
                   break;
                   
             }
        }
        
        
        
        
        
       
       
    }
    
}
