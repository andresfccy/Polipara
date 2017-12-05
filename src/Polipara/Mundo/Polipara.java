package Polipara.Mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
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
    public ArrayList<Persona> tecnicos;

    /**
     * Lista de equipos que participan en la copa Polipara.
     */
    public ArrayList<Persona> propietarios;

    /**
     * Lista de equipos que participan en la copa Polipara.
     */
    public ArrayList<Persona> auxiliares;

    public ArrayList<Persona> jugadores;

    public ArrayList<Ciudad> ciudades;

    // ---------------------------------------------------------------------------------------------------------
    // Constructores
    // ---------------------------------------------------------------------------------------------------------
    /**
     * Constructor de la clase principal.
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
        tecnicos = new ArrayList<Persona>();
        propietarios = new ArrayList<Persona>();
        auxiliares = new ArrayList<Persona>();
        jugadores = new ArrayList<Persona>();
        ciudades = new ArrayList<Ciudad>();

        // Llenar la lista de paises iniciales predeterminados
        Pais pais1 = new Pais("Colombia");

        // Llenar la lista de ciudades iniciales predeterminados de los respectivos países
        Ciudad ciudad1 = new Ciudad("Bogotá", pais1);
        Ciudad ciudad2 = new Ciudad("Medellín", pais1);
        Ciudad ciudad3 = new Ciudad("Cali", pais1);
        Ciudad ciudad4 = new Ciudad("Barranquilla", pais1);
        Ciudad ciudad5 = new Ciudad("Bucaramanga", pais1);

        // Añadir las ciudades creadas dentro de la lista de ciudades predeterminadas
        ciudades.add(ciudad1);
        ciudades.add(ciudad2);
        ciudades.add(ciudad3);
        ciudades.add(ciudad4);
        ciudades.add(ciudad5);

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
        int op = -1;
        while (op != 0) {
            String selEquipos = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Agregar equipo.\n"
                    + "2. Editar NOMBRE de un equipo.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de equipos", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selEquipos);
            switch (op) {
                case 1:
                    String nombreEquipo = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo equipo: ",
                            "Creación de equipo",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombreEquipo != null && !nombreEquipo.trim().equals("")) {
                        Equipo existente = this.buscarEquipoPorNombre(nombreEquipo);
                        if (existente != null) {
                            JOptionPane.showMessageDialog(null, "El nombre escrito ya está en uso.");
                        } else {
                            Equipo nuevo = new Equipo(nombreEquipo);
                            equipos.add(nuevo);
                            JOptionPane.showMessageDialog(null, "¡El equipo ha sido agregado exitosamente!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre no puede ser vacío.");
                    }
                    break;
                case 2:
                    if (equipos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Aún no hay equipos registrados.");
                    } else {
                        String message = "Selecciona el equipo que quieres editar: \n";
                        for (int i = 0; i < equipos.size(); i++) {
                            message += (i + 1) + ". " + equipos.get(i).getNombre() + "\n";
                        }
                        String eqSeleccionado = JOptionPane.showInputDialog(null, message, "Selección de equipo a editar", JOptionPane.QUESTION_MESSAGE);

                        try {
                            Equipo seleccionado = equipos.get(Integer.parseInt(eqSeleccionado));
                            String nuevoNombre = JOptionPane.showInputDialog(null, "Introduce el nuevo nombre para el equipo " + seleccionado.getNombre() + ": ");
                            if (nuevoNombre != null && !nuevoNombre.trim().equals("")) {
                                Equipo existente = this.buscarEquipoPorNombre(nuevoNombre);
                                if (existente != null) {
                                    JOptionPane.showMessageDialog(null, "El nombre escrito ya está en uso.");
                                } else {
                                    seleccionado.setNombre(nuevoNombre);
                                }
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Hubo un problema con la selección de equipo.\n"
                                    + "es posible que hayas introducido un valor no válido.");
                        }
                    }
                    break;
                default:
                    break;
            }
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

    /**
     * Método que muestra el menú de opciones para jugadores
     */
    private void menuJugadores() {
        int op = -1;
        while (op != 0) {
            String selJugadores = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Agregar jugador.\n"
                    + "2. Editar NOMBRE del jugador.\n"
                    + "3. Editar APELLIDO del jugador.\n"
                    + "4. Editar NACIONALIDAD del jugador.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de jugadores", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selJugadores);
            switch (op) {
                case 1:
                    Ciudad ciudadJugador = null;
                    String nombreJugador = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombreJugador == null || nombreJugador.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String apellidoJugador = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoJugador == null || apellidoJugador.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String identificacionJugador = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (identificacionJugador == null || identificacionJugador.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int identificacionNJugador = -1;
                    try {
                        identificacionNJugador = Integer.parseInt(identificacionJugador);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    ciudadJugador = this.seleccionarCiudad();

                    String posicionJugador = JOptionPane.showInputDialog(null,
                            "Introduce la posición del nuevo jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (posicionJugador == null || posicionJugador.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    Jugador nuevo = new Jugador(Jugador.HABILITADO, posicionJugador, nombreJugador, apellidoJugador, ciudadJugador, identificacionNJugador);

                    jugadores.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Jugador creado exitosamente!");

                    break;
                case 2:
                    Jugador jugador2 = this.seleccionarJugador();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    jugador2.setNombre(nuevoNombre);
                    break;
                case 3:
                    Jugador jugador3 = this.seleccionarJugador();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    jugador3.setNombre(nuevoApellido);
                    break;
                case 4:
                    Jugador jugador4 = this.seleccionarJugador();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    jugador4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    private Jugador seleccionarJugador() {
        if (jugadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
            return null;
        } else {
            String message = "Selecciona el jugador: \n";
            for (int i = 0; i < jugadores.size(); i++) {
                message += (i + 1) + ". " + jugadores.get(i).getNombre() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de jugador", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Jugador) jugadores.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar jugador.");
            }
        }
        return null;
    }
    
    private Equipo seleccionaEquipo(){
        if (equipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos registrados.");
            return null;
        } else {
            String message = "Selecciona el equipo: \n";
            for (int i = 0; i < equipos.size(); i++) {
                message += (i + 1) + ". " + equipos.get(i).getNombre() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de equipo", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Equipo) equipos.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar equipo.");
            }
        }
        return null;
    }

    private Ciudad seleccionarCiudad() {
        if (ciudades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ciudades registradas.");
            return null;
        } else {
            String message = "Selecciona la ciudad: \n";
            for (int i = 0; i < ciudades.size(); i++) {
                message += (i + 1) + ". " + ciudades.get(i).getNombre() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de ciudad", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Ciudad) ciudades.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar ciudad.");
            }
        }
        return null;
    }

    private Tecnico seleccionarTecnico(){
        if (tecnicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tecnicos registradas.");
            return null;
        } else {
            String message = "Selecciona el técnico: \n";
            for (int i = 0; i < tecnicos.size(); i++) {
                message += (i + 1) + ". " + tecnicos.get(i).getNombre() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de técnico", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Tecnico) tecnicos.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar técnico.");
            }
        }
        return null;
    }
    
    /**
     * Dado un nombre, busca en la lista de equipos de la copa un equipo que
     * coincida con dicho nombre
     *
     * @param buscado - String nombre del equipo que se busca
     * @return Equipo que coincida con el nombre buscado, NULL si ninguno
     * coincide
     */
    private Equipo buscarEquipoPorNombre(String buscado) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombre().equalsIgnoreCase(buscado)) {
                return equipos.get(i);
            }
        }
        return null;
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
