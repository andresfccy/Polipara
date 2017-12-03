package Polipara.Mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import javax.swing.JOptionPane;

public class Polipara implements Serializable {

    // ---------------------------------------------------------------------------------------------------------
    // Atributos Privados
    // ---------------------------------------------------------------------------------------------------------
    private String serializacionUrl = "src/Polipara/Persistencia/polipara.ser";

    // ---------------------------------------------------------------------------------------------------------
    // Atributos Públicos
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Lista de equipos que participarán en la copa Polipara
     */
    public ArrayList<Equipo> equipos;

    /**
     * Constructor de la clase principal
     */
    public Polipara() {
        // Iniciar el programa cargando el archivo de propiedades si existe.

        if (this.validarSerializacion()) {
            int response = JOptionPane.showConfirmDialog(null, "Hay una versión anterior de una copa,\n"
                    + "¿Desea cargar esa versión? (Al seleccionar \"No\", se eliminará el avance anterior y se cargará una copa nueva.)");
            if (response == 0) {
                this.cargarSerializacion();
            } else {
                this.iniciarCopa();
            }
        } else {
            this.iniciarCopa();
            JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios realizados?");
            this.serializar();
        }

//        Scanner scanner = new Scanner(System.in);
//        int op = 0;
//
//        while (op != 6) {
//            System.out.println("1. Registrar Popietario");
//            System.out.println("2. Registrar Tecnico");
//            System.out.println("3. Registrar Arbitro");
//            System.out.println("4. Registrar Personal Auxiliar");
//            System.out.println("5. Registrar Jugador");
//            System.out.println("6. Salir");
//
//            System.out.println("introduzca un numero segun el proceso que desea realizar : ");
//
//            op = scanner.nextInt();
//
//            switch (op) {
//                case 1:
//                    Propietario propietario1 = new Propietario();
//                    propietario1.introducir_datos_personales();
//                    propietario1.introducir_equipo();
//                    propietario1.mostrar_datos_personales();
//                    propietario1.mostrar_datos_propietario();
//
//                    break;
//
//                case 2:
//                    Tecnico tecnico1 = new Tecnico();
//                    tecnico1.introducir_datos_personales();
//                    tecnico1.introducir_numero_campeonatos_ganados();
//                    tecnico1.introducir_numero_campeonatos_perdidos();
//                    tecnico1.mostrar_datos_personales();
//                    tecnico1.mostrar_datos_tecnico();
//
//                    break;
//
//                case 3:
//                    Arbitro arbitro1 = new Arbitro();
//                    arbitro1.introducir_datos_personales();
//                    arbitro1.introducir_partidos_pitados();
//                    arbitro1.mostrar_datos_personales();
//                    arbitro1.mostrar_datos_arbitro();
//
//                    break;
//
//                case 4:
//                    P_Auxiliar auxiliar1 = new P_Auxiliar();
//                    auxiliar1.introducir_datos_personales();
//                    auxiliar1.introducir_rol();
//                    auxiliar1.mostrar_datos_personales();
//                    auxiliar1.mostrar_datos_auxiliar();
//
//                    break;
//
//                case 5:
//                    Jugador jugador1 = new Jugador();
//                    jugador1.introducir_datos_personales();
//                    jugador1.introducir_posicion();
//                    jugador1.mostrar_datos_personales();
//                    jugador1.mostrar_datos_jugador();
//
//                    break;
//
//            }
//        }
    }

    private void iniciarCopa() {
        // Inicializar la lista de equipos que jugarán en la copa
        equipos = new ArrayList<Equipo>();
    }

    // ---------------------------------------------------------------------------------------------------------
    // Métodos Auxiliares
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Método que se encarga de guardar el estado actual de la copa.
     */
    private void serializar() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializacionUrl));
            oos.writeObject(this);
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("Could not create the file \"serialized\"");
        } catch (IOException e) {
            System.err.println("Could not serialize the object");
        }
    }

    /**
     * Método que se encarga de validar si ya se ha serializado una copa
     * anterior.
     */
    private boolean validarSerializacion() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializacionUrl));
            ois.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo de serialización: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error con el archivo de serialización: " + ex.getMessage());
        }
        return false;
    }

    /**
     * Método que se encarga de borrar el archivo de serialización
     */
    private void borrarSerializacion() {
        try {
            File serFile = new File(this.serializacionUrl);
            boolean borrarOk = serFile.delete();
            if (borrarOk) {
                System.out.println("Se eliminó el archivo de serialización correctamente.");
            }
        } catch (Exception ex) {
            System.out.println("Error al intentar borrar los archivos: " + ex.getMessage());
        }
    }

    /**
     * Método que se encarga de cargar el estado anterior de la copa.
     */
    private void cargarSerializacion() {
        try {
            FileInputStream fileIn = new FileInputStream(this.serializacionUrl);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Polipara poli = (Polipara) in.readObject();
            this.equipos = poli.equipos;
            in.close();
            fileIn.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // ---------------------------------------------------------------------------------------------------------
    // Main
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Método principal, es la entrada al momento de correr el proyecto
     *
     * @param args
     */
    public static void main(String[] args) {
        new Polipara();
    }

}
