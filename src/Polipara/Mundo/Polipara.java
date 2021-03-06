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
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public ArrayList<Partido> partidos;

    public ArrayList<Arbitro> arbitros;

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
        partidos = new ArrayList<Partido>();
        arbitros = new ArrayList<Arbitro>();

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
                    + "1. Opciones de personas.\n"
                    + "2. Opciones de equipos.\n"
                    + "3. Opciones administrativas.\n"
                    + "0. Salir",
                    // Título y tipo de mensaje.
                    "Menú principal", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(seleccion);
            switch (op) {
                case 1:
                    // Opciones PERSONAS
                    this.menuPersonas();
                    break;
                case 2:
                    // Opciones EQUIPOS
                    this.menuEquipos();
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
                    + "3. Agregar propietario del equipo.\n"
                    + "4. Agregar técnico del equipo.\n"
                    + "5. Agregar jugador al equipo.\n"
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
                    Equipo equipo2 = this.seleccionaEquipo();
                    String nuevoNombre = JOptionPane.showInputDialog(null, "Introduce el nuevo nombre para el equipo " + equipo2.getNombre() + ": ");
                    if (nuevoNombre != null && !nuevoNombre.trim().equals("")) {
                        Equipo existente = this.buscarEquipoPorNombre(nuevoNombre);
                        if (existente != null) {
                            JOptionPane.showMessageDialog(null, "El nombre escrito ya está en uso.");
                        } else {
                            equipo2.setNombre(nuevoNombre);
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
    private void menuPersonas() {
        int op = -1;
        while (op != 0) {
            // Interacción inicial con el usuario
            String seleccion = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "A continuación se lista una serie de opciones de las que tendrás que escoger una y escribir el número de la opción en la caja de texto.\n\n"
                    + "1. Opciones de propietarios.\n"
                    + "2. Opciones de técnicos.\n"
                    + "3. Opciones de jugadores.\n"
                    + "4. Opciones de auxiliares.\n"
                    + "5. Opciones de árbitros.\n"
                    + "0. Salir",
                    // Título y tipo de mensaje.
                    "Menú personas", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(seleccion);
            switch (op) {
                case 1:
                    // Opciones PROPIETARIOS
                    this.menuPropietarios();
                    break;
                case 2:
                    // Opciones TECNICOS
                    this.menuTecnicos();
                    break;
                case 3:
                    // Opciones Jugadores
                    this.menuJugadores();
                    break;
                case 4:
                    // Opciones AUXILIARES
                    this.menuAuxiliares();
                    break;
                case 5:
                    // Opciones ÁRBITROS
                    this.menuArbitros();
                    break;
            }
        }
    }

    /**
     * Método que muestra el menú de opciones administrativas de la copa, en
     * este menú se puede: Calcular recaudos y resultados; Registrar las
     * interacciones entre equipos, jugadores, árbitros; Finalizar la copa.
     */
    private void menuAdministrativo() {
        int op = -1;
        while (op != 0) {
            // Interacción inicial con el usuario
            String seleccion = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "A continuación se listan algunas opciones administrativas del sistema.\n\n"
                    + "1. Opciones de partidos.\n"
                    + "2. Listar jugadores con tarjetas amarillas.\n"
                    + "3. Listar jugadores con tarjetas rojas.\n"
                    + "4. Listar jugadores lesionados.\n"
                    + "5. Listar jugadores suspendidos.\n"
                    + "6. Calcular recaudo entre dos fechas.\n"
                    + "7. Calcular recaudo por publicidad entre dos fechas.\n"
                    + "0. Salir",
                    // Título y tipo de mensaje.
                    "Menú administrativo", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(seleccion);
            switch (op) {
                case 1:
                    // Opciones PROPIETARIOS
                    this.menuPartidos();
                    break;
                case 2:
                    // Opciones TECNICOS
                    //this.listarJugadoresAmarillas();
                    break;
                case 3:
                    // Opciones Jugadores
                    //this.listarJugadoresRojas();
                    break;
                case 4:
                    // Opciones AUXILIARES
                    //this.listarJugadoresLesionados();
                    break;
                case 5:
                    // Opciones ÁRBITROS
                    //this.listarJugadoresSuspendidos();
                    break;
                case 6:
                    // Opciones ÁRBITROS
                    //this.calcularRecaudoEntreFechas();
                    break;
                case 7:
                    // Opciones ÁRBITROS
                    //this.calcularRecaudoPublicidadEntreFechas();
                    break;
            }
        }
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
                    + "5. Editar POSICIÓN del jugador.\n"
                    + "6. Editar ESTADO del jugador.\n"
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
                            "Introduce el apellido del nuevo jugador: ",
                            "Creación de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoJugador == null || apellidoJugador.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String identificacionJugador = JOptionPane.showInputDialog(null,
                            "Introduce la identificación del nuevo jugador: ",
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

                    Jugador nuevo = new Jugador(Jugador.SIN_EQUIPO, posicionJugador, nombreJugador, apellidoJugador, ciudadJugador, identificacionNJugador);

                    jugadores.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Jugador creado exitosamente!");

                    break;
                case 2:
                    Jugador jugador2 = this.seleccionarJugador();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del jugador: ",
                            "Edición de jugador",
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
                            "Edición de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    jugador3.setApellido(nuevoApellido);
                    break;
                case 4:
                    Jugador jugador4 = this.seleccionarJugador();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    jugador4.setNacionalidad(nuevaCiudad);
                    break;
                case 5:
                    Jugador jugador5 = this.seleccionarJugador();
                    String nuevaPosicion = JOptionPane.showInputDialog(null,
                            "Introduce la posición del jugador: ",
                            "Edición de jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevaPosicion == null || nuevaPosicion.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    jugador5.setPosicion(nuevaPosicion);
                    break;
                case 6:
                    Jugador jugador6 = this.seleccionarJugador();
                    int nuevoEstado = this.seleccionarEstado();

                    jugador6.setEstado(nuevoEstado);
                    break;
                default:
                    break;
            }
        }
    }

    private void menuPropietarios() {
        int op = -1;
        while (op != 0) {
            String selPropietarios = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Agregar propietario.\n"
                    + "2. Editar NOMBRE del propietario.\n"
                    + "3. Editar APELLIDO del propietario.\n"
                    + "4. Editar NACIONALIDAD del propietario.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de propietarios", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selPropietarios);
            switch (op) {
                case 1:
                    Ciudad ciudadPropietario = null;
                    String nombrePropietario = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo propietario: ",
                            "Creación de propietario",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombrePropietario == null || nombrePropietario.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String apellidoPropietario = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del nuevo propietario: ",
                            "Creación de propietario",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoPropietario == null || apellidoPropietario.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String identificacionPropietario = JOptionPane.showInputDialog(null,
                            "Introduce la identificación del nuevo propietario: ",
                            "Creación de propietario",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (identificacionPropietario == null || identificacionPropietario.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int identificacionNPropietario = -1;
                    try {
                        identificacionNPropietario = Integer.parseInt(identificacionPropietario);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    ciudadPropietario = this.seleccionarCiudad();

                    Propietario nuevo = new Propietario(nombrePropietario, apellidoPropietario, ciudadPropietario, identificacionNPropietario);

                    propietarios.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Propietario creado exitosamente!");

                    break;
                case 2:
                    Propietario propietario2 = this.seleccionarPropietario();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del propietario: ",
                            "Edición de propietario",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    propietario2.setNombre(nuevoNombre);
                    break;
                case 3:
                    Propietario propietario3 = this.seleccionarPropietario();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del propietario: ",
                            "Edición de propietario",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    propietario3.setApellido(nuevoApellido);
                    break;
                case 4:
                    Propietario propietario4 = this.seleccionarPropietario();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    propietario4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    private void menuTecnicos() {
        int op = -1;
        while (op != 0) {
            String selTecnicos = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Agregar técnico.\n"
                    + "2. Editar NOMBRE del técnico.\n"
                    + "3. Editar APELLIDO del técnico.\n"
                    + "4. Editar NACIONALIDAD del técnico.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de técnicos", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selTecnicos);
            switch (op) {
                case 1:
                    Ciudad ciudadTecnico = null;
                    String nombreTecnico = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo técnico: ",
                            "Creación de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombreTecnico == null || nombreTecnico.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String apellidoTecnico = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del nuevo técnico: ",
                            "Creación de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoTecnico == null || apellidoTecnico.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String identificacionTecnico = JOptionPane.showInputDialog(null,
                            "Introduce la identificación del nuevo técnico: ",
                            "Creación de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (identificacionTecnico == null || identificacionTecnico.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int identificacionNTecnico = -1;
                    try {
                        identificacionNTecnico = Integer.parseInt(identificacionTecnico);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String campGanadosTecnico = JOptionPane.showInputDialog(null,
                            "Introduce los campeonatos ganados del técnico: ",
                            "Creación de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (campGanadosTecnico == null || campGanadosTecnico.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int campGanadosTecnicoNTecnico = -1;
                    try {
                        campGanadosTecnicoNTecnico = Integer.parseInt(campGanadosTecnico);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String campPerdidosTecnico = JOptionPane.showInputDialog(null,
                            "Introduce los campeonatos perdidos del técnico: ",
                            "Creación de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (campPerdidosTecnico == null || campPerdidosTecnico.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int campPerdidosTecnicoNTecnico = -1;
                    try {
                        campPerdidosTecnicoNTecnico = Integer.parseInt(campPerdidosTecnico);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    ciudadTecnico = this.seleccionarCiudad();

                    Tecnico nuevo = new Tecnico(campGanadosTecnicoNTecnico, campPerdidosTecnicoNTecnico, nombreTecnico, apellidoTecnico, ciudadTecnico, identificacionNTecnico);

                    tecnicos.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Técnico creado exitosamente!");

                    break;
                case 2:
                    Tecnico tecnico2 = this.seleccionarTecnico();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del técnico: ",
                            "Edición de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    tecnico2.setNombre(nuevoNombre);
                    break;
                case 3:
                    Tecnico tecnico3 = this.seleccionarTecnico();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del técnico: ",
                            "Edición de técnico",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    tecnico3.setApellido(nuevoApellido);
                    break;
                case 4:
                    Tecnico tecnico4 = this.seleccionarTecnico();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    tecnico4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    private void menuAuxiliares() {
        int op = -1;
        while (op != 0) {
            String selAuxiliares = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Agregar auxiliar.\n"
                    + "2. Editar NOMBRE del auxiliar.\n"
                    + "3. Editar APELLIDO del auxiliar.\n"
                    + "4. Editar NACIONALIDAD del auxiliar.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de auxiliares", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selAuxiliares);
            switch (op) {
                case 1:
                    Ciudad ciudadAuxiliar = null;
                    String nombreAuxiliar = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo auxiliar: ",
                            "Creación de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombreAuxiliar == null || nombreAuxiliar.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String apellidoAuxiliar = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del nuevo auxiliar: ",
                            "Creación de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoAuxiliar == null || apellidoAuxiliar.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String identificacionAuxiliar = JOptionPane.showInputDialog(null,
                            "Introduce la identificación del nuevo auxiliar: ",
                            "Creación de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (identificacionAuxiliar == null || identificacionAuxiliar.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int identificacionNAuxiliar = -1;
                    try {
                        identificacionNAuxiliar = Integer.parseInt(identificacionAuxiliar);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String rolAuxiliar = JOptionPane.showInputDialog(null,
                            "Introduce el rol del nuevo auxiliar: ",
                            "Creación de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (rolAuxiliar == null || rolAuxiliar.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    ciudadAuxiliar = this.seleccionarCiudad();

                    PAuxiliar nuevo = new PAuxiliar(rolAuxiliar, nombreAuxiliar, apellidoAuxiliar, ciudadAuxiliar, identificacionNAuxiliar);

                    auxiliares.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Auxiliar creado exitosamente!");

                    break;
                case 2:
                    PAuxiliar auxiliar2 = this.seleccionarAuxiliar();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del auxiliar: ",
                            "Edición de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    auxiliar2.setNombre(nuevoNombre);
                    break;
                case 3:
                    PAuxiliar auxiliar3 = this.seleccionarAuxiliar();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del auxiliar: ",
                            "Edición de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    auxiliar3.setApellido(nuevoApellido);
                    break;
                case 4:
                    PAuxiliar auxiliar4 = this.seleccionarAuxiliar();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    auxiliar4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    private void menuArbitros() {
        int op = -1;
        while (op != 0) {
            String selArbitros = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Agregar árbitro.\n"
                    + "2. Editar NOMBRE del árbitro.\n"
                    + "3. Editar APELLIDO del árbitro.\n"
                    + "4. Editar NACIONALIDAD del árbitro.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de árbitros", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selArbitros);
            switch (op) {
                case 1:
                    Ciudad ciudadArbitro = null;
                    String nombreArbitro = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del nuevo árbitro: ",
                            "Creación de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nombreArbitro == null || nombreArbitro.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    String apellidoArbitro = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del nuevo árbitro: ",
                            "Creación de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (apellidoArbitro == null || apellidoArbitro.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String identificacionArbitro = JOptionPane.showInputDialog(null,
                            "Introduce la identificación del nuevo árbitro: ",
                            "Creación de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (identificacionArbitro == null || identificacionArbitro.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int identificacionNArbitro = -1;
                    try {
                        identificacionNArbitro = Integer.parseInt(identificacionArbitro);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    String partidosPitados = JOptionPane.showInputDialog(null,
                            "Introduce el rol del nuevo árbitro: ",
                            "Creación de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (partidosPitados == null || partidosPitados.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int partidosPitadosNAuxiliar = -1;
                    try {
                        partidosPitadosNAuxiliar = Integer.parseInt(partidosPitados);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    ciudadArbitro = this.seleccionarCiudad();

                    Arbitro nuevo = new Arbitro(partidosPitadosNAuxiliar, nombreArbitro, apellidoArbitro, ciudadArbitro, identificacionNArbitro);

                    arbitros.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Auxiliar creado exitosamente!");

                    break;
                case 2:
                    PAuxiliar auxiliar2 = this.seleccionarAuxiliar();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del auxiliar: ",
                            "Edición de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    auxiliar2.setNombre(nuevoNombre);
                    break;
                case 3:
                    PAuxiliar auxiliar3 = this.seleccionarAuxiliar();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del auxiliar: ",
                            "Edición de auxiliar",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    auxiliar3.setApellido(nuevoApellido);
                    break;
                case 4:
                    PAuxiliar auxiliar4 = this.seleccionarAuxiliar();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    auxiliar4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    private void menuPartidos() {
        int op = -1;
        while (op != 0) {
            String selArbitros = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Programar partido.\n"
                    + "2. Registrar resultados de un partido programado.\n"
                    + "3. Ver resultados de un partido.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de partidos", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selArbitros);
            switch (op) {
                case 1:
                    Date fechaDatePartido = null;
                    JOptionPane.showMessageDialog(null, "A continuación se listarán los equipos, selecciona el equipo anfitrión.");
                    Equipo anfitrion = seleccionaEquipo();

                    JOptionPane.showMessageDialog(null, "A continuación se listarán los equipos, selecciona el equipo visitante.");
                    Equipo visitante = seleccionaEquipo();

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaPartido = JOptionPane.showInputDialog(null, "Introduce la fecha del encuentro (dd/mm/aaaa):");
                    
                    try {
                        fechaDatePartido = formatter.parse(fechaPartido);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar guardar la fecha del encuentro.");
                        System.out.println(e.getMessage());
                        break;
                    }
                    
                    Partido nuevo = new Partido(anfitrion, visitante, 0, 0, fechaDatePartido);
                    
                    JOptionPane.showMessageDialog(null, "¡Partido programado exitosamente!");

                    break;
                case 2:

                    break;
                case 3:

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

    private Jugador seleccionarJugadorSinEquipo() {
        if (jugadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
            return null;
        } else {
            boolean entro = false;
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

    private Equipo seleccionaEquipo() {
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

    private Tecnico seleccionarTecnico() {
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

    private Propietario seleccionarPropietario() {
        if (propietarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay propietarios registrados.");
            return null;
        } else {
            String message = "Selecciona el propietario: \n";
            for (int i = 0; i < propietarios.size(); i++) {
                message += (i + 1) + ". " + propietarios.get(i).getNombre() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de propietario", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Propietario) propietarios.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar propietario.");
            }
        }
        return null;
    }

    private PAuxiliar seleccionarAuxiliar() {
        if (auxiliares.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay auxiliares registrados.");
            return null;
        } else {
            String message = "Selecciona el auxiliar: \n";
            for (int i = 0; i < auxiliares.size(); i++) {
                message += (i + 1) + ". " + auxiliares.get(i).getNombre() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de auxiliar", JOptionPane.QUESTION_MESSAGE);

            try {
                return (PAuxiliar) auxiliares.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar auxiliar.");
            }
        }
        return null;
    }

    private Partido seleccionarPartido() {
        if (partidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay partidos registrados.");
            return null;
        } else {
            String message = "Selecciona el partido: \n";
            for (int i = 0; i < partidos.size(); i++) {
                message += (i + 1) + ". " + partidos.get(i).toString() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de partidos", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Partido) partidos.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar partido.");
            }
        }
        return null;
    }

    private int seleccionarEstado() {
        String message = "Selecciona el nuevo estado del jugador: \n";

        message += "1. SIN_EQUIPO\n";
        message += "2. HABILITADO\n";
        message += "3. LESIONADO\n";
        message += "4. SUSPENDIDO\n";

        String seleccion = JOptionPane.showInputDialog(null, message, "Selección de estado de jugador", JOptionPane.QUESTION_MESSAGE);

        switch (seleccion) {
            case "1":
                return -1;
            case "2":
                return 0;
            case "3":
                return 1;
            case "4":
                return 2;
            default:
                JOptionPane.showMessageDialog(null, "Error al seleccionar el estado de jugador.");
        }

        return -2;
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
