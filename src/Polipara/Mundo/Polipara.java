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
    /**
     * Atributo que modela la ruta en el proyecto del archivo de serialización
     * de la copa.
     */
    private String serializacionUrl = "src/Polipara/Persistencia/polipara.ser";

    // ---------------------------------------------------------------------------------------------------------
    // Atributos Públicos
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Lista de equipos que participan en la copa Polipara.
     */
    public ArrayList<Equipo> equipos;
    
    /**
     * Lista de equipos que participan en la copa Polipara.
     */
    public ArrayList<Tecnico> tecnicos;
    
    /**
     * Lista de equipos que participan en la copa Polipara.
     */
    public ArrayList<Propietario> propietarios;
    
    /**
     * Lista de equipos que participan en la copa Polipara.
     */
    public ArrayList<PAuxiliar> auxiliares;

    // ---------------------------------------------------------------------------------------------------------
    // Constructores
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Constructor de la clase principal.
     */
    public Polipara() {
        // Iniciar el programa cargando el archivo de propiedades si existe.

        if (this.validarSerializacion())  {   
            int response = JOptionPane.showConfirmDialog(null, "Hay una versión anterior de una copa,\n"
                    + "¿Desea cargar esa versión? (Al seleccionar \"No\", se eliminará el avance anterior y se cargará una copa nueva.)");
            if (response == 0) {
                this.cargarSerializacion();
            } else {
                this.iniciarCopa();
            }
        } else {
            this.iniciarCopa();
        }
    }

    // ---------------------------------------------------------------------------------------------------------
    // Métodos
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Método que inicializa las listas de la copa y muestra los menús de
     * interacciones con el usuario.
     */
    public void iniciarCopa() {
        // Inicializar listas
        equipos = new ArrayList<Equipo>();

        int op = -1;
        while (op != 0) {
            // Interacción inicial con el usuario
            String seleccion = JOptionPane.showInputDialog(null, "¡Bienvenido a la copa Polipara!\n"
                    // Opciones
                    + "A continuación se lista una serie de opciones de las que tendrás que escoger una y escribir el número de la opción en la caja de texto.\n\n"
                    + "1. Opciones de equipos.\n"
                    + "2. Opciones de árbitros.\n"
                    + "3. Opciones administrativas.\n"
                    + "0. Salir",
                    // Título y tipo de mensaje.
                    "Menú principal", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(seleccion);
            switch (op) {
                case 1:
                    // Opciones EQUIPOS
                    this.menuEquipos();
                    break;
                case 2:
                    // Opciones ÁRBITROS
                    this.menuArbitros();
                    break;
                case 3:
                    // Opciones ADMINISTRATIVAS
                    this.menuAdministrativo();
                    break;
                case 0:
                    // Salida
                    int guardar = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios realizados?");
                    switch (guardar) {
                        case 0:
                            // Sí
                            this.serializar();
                            break;
                        case 1:
                            // No
                            JOptionPane.showMessageDialog(null, "El programa cerrará sin guardar los cambios", "¡Hasta pronto!", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            // Cancelar
                            op = -1;
                            break;
                    }
                    break;
            }
        }

    }

    /**
     * Método que muestra el menú de opciones para equipos, en este menú se
     * puede: Agregar y editar equipos; Agregar y editar personal relacionado
     * con los equipos (Propietario, Técnico, Jugadores, Personal auxiliar).
     */
    private void menuEquipos() {
        String selEquipos = JOptionPane.showInputDialog(null, ""
                // Opciones
                + "1. Agregar equipo.\n"
                + "2. Editar equipo.\n",
                // Título y tipo de mensaje.
                "Menú de equipos", JOptionPane.QUESTION_MESSAGE);
        int op = Integer.parseInt(selEquipos);
        switch (op) {
            case 1:
                
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    /**
     * Método que muestra el menú de opciones para árbitros, en este menú se
     * puede: Agregar y editar árbitros.
     */
    private void menuArbitros() {
        String selEquipos = JOptionPane.showInputDialog(null, "Opciones del menú...", "Menú de árbitros", JOptionPane.QUESTION_MESSAGE);

    }

    /**
     * Método que muestra el menú de opciones administrativas de la copa, en
     * este menú se puede: Calcular recaudos y resultados; Registrar las
     * interacciones entre equipos, jugadores, árbitros; Finalizar la copa.
     */
    private void menuAdministrativo() {
        String selEquipos = JOptionPane.showInputDialog(null, "Opciones del menú...", "Menú administrativo", JOptionPane.QUESTION_MESSAGE);

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
     * Método que se encarga de borrar el archivo de serialización.
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
     * Método principal, es la entrada al momento de correr el proyecto.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Polipara();
    }
}
