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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
     * Clase que modela la copa
     */
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
    /**
     * Lista de personas auxiliares que participan en la copa Polipara.
     */
    public ArrayList<Persona> jugadores;
    /**
     * Lista de las ciudades.
     */
    public ArrayList<Ciudad> ciudades;
    /**
     * Lista de partidos que se realizaran en a copa polipara.
     */
    public ArrayList<Partido> partidos;
    /**
     * Lista de arbitros participan en la copa Polipara.
     */
    public ArrayList<Arbitro> arbitros;
     /**
     * Lista de interacciones de los jugadores en los partidos.
     */
    public ArrayList<Interaccion> interacciones;
     /**
     * Lista de estadios que participan en la copa Polipara.
     */
    public ArrayList<Estadio> estadios;

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
        interacciones = new ArrayList<Interaccion>();
        estadios = new ArrayList<Estadio>();

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

        this.menuPrincipal();
    }

    private void menuPrincipal() {
        int op = -1;
        while (op != 0) {
            // Interacción inicial con el usuario
            String seleccion = JOptionPane.showInputDialog(null, "¡Bienvenido a la copa Polipara!\n"
                    // Opciones
                    + "A continuación se lista una serie de opciones de las que tendrás que escoger una y escribir el número de la opción en la caja de texto.\n\n"
                    + "1. Opciones de personas.\n"
                    + "2. Opciones de equipos.\n"
                    + "3. Opciones administrativas.\n"
                    + "4. Opciones de estadios.\n"
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
                case 4:
                    this.menuEstadios();
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
                    + "6. Agregar auxiliar al equipo.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de equipos", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selEquipos);
            switch (op) {
                case 1:
                    // Agrega un equipo con su nombre
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
                    // Edita el nombre de un equipo
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
                case 3:
                    // Agrega un propietario de la lista de propietarios a un equipo
                    if(propietarios.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Es necesario registrar propietarios primero.");
                    }else{
                        Equipo equipo3 = this.seleccionaEquipo();
                        Persona propietario = this.seleccionarPropietario();
                        
                        equipo3.setPropietario((Propietario)propietario);
                        JOptionPane.showMessageDialog(null, "¡Propietario registrado a este equipo exitosamente!");
                    }
                    break;
                case 4:
                     // Agrega un tecnico de la lista de tecnicos a un equipo
                   if(tecnicos.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Es necesario registrar técnicos primero.");
                    }else{
                        Equipo equipo4 = this.seleccionaEquipo();
                        Persona tecnico = this.seleccionarTecnico();
                        
                        equipo4.setTecnico((Tecnico)tecnico);
                        JOptionPane.showMessageDialog(null, "¡Técnico registrado a este equipo exitosamente!");
                    }
                    break;
                case 5:
                     // Agrega un jugador de la lista de jugadores a un equipo
                   if(jugadores.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Es necesario registrar jugadores primero.");
                    }else{
                        Equipo equipo5 = this.seleccionaEquipo();
                        Persona jugador = this.seleccionarJugador();
                        
                        ArrayList<Jugador> listaJugadores = equipo5.getJugadores();
                        listaJugadores.add((Jugador)jugador);
                        
                        equipo5.setJugadores(listaJugadores);
                        JOptionPane.showMessageDialog(null, "¡Jugador registrado a este equipo exitosamente!");
                    }
                    break;
                case 6: 
                 // Agrega personal auxiliar de la lista de personal auxiliar a un equipo
                {
                   if(auxiliares.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Es necesario registrar personal auxiliar.");
                    }else{
                        Equipo equipo5 = this.seleccionaEquipo();
                        Persona auxiliar = this.seleccionarAuxiliar();
                        
                        ArrayList<PAuxiliar> listaAuxiliares = equipo5.getAuxiliares();
                        listaAuxiliares.add((PAuxiliar)auxiliar);
                        
                        equipo5.setAuxiliares(listaAuxiliares);
                        JOptionPane.showMessageDialog(null, "¡Auxiliar registrado a este equipo exitosamente!");
                    }
                    break;
                }
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
                     // muestra el menu partidos
                    this.menuPartidos();
                    break;
                case 2:
                     // Lista los jugadores con tarjeta amarilla
                    this.listarInteracciones(Interaccion.AMARILLA);
                    break;
                case 3:
                    // Lista los jugadores con tarjeta roja
                    this.listarInteracciones(Interaccion.ROJA);
                    break;
                case 4:
                    // Lista los jugadores que se encuentran lesionados
                    this.listarInteracciones(Interaccion.LESION);
                    break;
                case 5:
                    // Lista los jugadores que se enceuntran suspendidos
                    this.listarJugadoresPorEstado(Jugador.SUSPENDIDO);
                    break;
                case 6:
                    // muestra el resultado del calculo de recaudos en un rango de fechas
                    this.calcularRecaudoEntreFechas();
                    break;
                case 7:
                    // muestra el resultado del calculo de recaudos por publicidad en un rango de fechas
                    this.calcularRecaudoPorPublicidadEntreFechas();
                    break;
            }
        }
    }

    /**
     * Método que muestra el menú de opciones para jugadores, en este menu se pede agregar,
     * editar los datos de un jugador
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
                    // Agrega un nuevo jugador con su nombre, apellido, ID y posición
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
                    // Edita el nombre de un jugador al seleccionarlo
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
                     // Edita el apellido de un jugador al seleccionarlo
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
                     // Edita la ciudad de un jugador al seleccionarlo
                    Jugador jugador4 = this.seleccionarJugador();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    jugador4.setNacionalidad(nuevaCiudad);
                    break;
                case 5:
                    // Edita la posicion de un jugador al seleccionarlo
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
                    // Edita el estado (activo o suspendido) de un jugador al seleccionarlo
                    Jugador jugador6 = this.seleccionarJugador();
                    int nuevoEstado = this.seleccionarEstado();

                    jugador6.setEstado(nuevoEstado);
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Método que muestra el menú de opciones para los propietarios, en este menu se pede agregar,
     * editar los datos de un propietario
     */
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
                    // agrega a un propietario con su nombre, apellido,ID y ciudad
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
                    // Edita el nombre de un propietario al seleccionarlo
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
                    // Edita el apellido de un propietario al seleccionarlo
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
                    // Edita la ciudad de un propietario al seleccionarlo
                    Propietario propietario4 = this.seleccionarPropietario();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    propietario4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que muestra el menú de opciones para Tecnicos, en este menu se pede agregar,
     * editar los datos e historial de un tecnico
     */
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
                    // agrega un nuevo tecnico con sus datos personales e historial
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
                    // Edita el nombre de un tecnico al seleccionarlo
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
                     // Edita el apellido de un tecnico al seleccionarlo
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
                     // Edita la ciudad de un tecnico al seleccionarlo
                    Tecnico tecnico4 = this.seleccionarTecnico();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    tecnico4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que muestra el menú de opciones para el Personal Auxiliar, en este menu se pede agregar,
     * editar los datos del personal auxiliar( masajistas, fisioterapeutas, medicos)
     */
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
                     // Agrega los datos de una persona auxiliar incluyendo su rol (masajista, fisioterapeuta,medico)
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
                     // Edita el nombre de un auxiliar al seleccionarlo
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
                     // Edita el apellido de un auxiliar al seleccionarlo
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
                     // Edita la ciudad de un auxiliar al seleccionarlo
                    PAuxiliar auxiliar4 = this.seleccionarAuxiliar();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    auxiliar4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que muestra el menú de opciones para Arbitros, en este menu se pede agregar,
     * editar los datos e historial en la copa de los arbitros.
     */
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
                     // crea un Arbitro con sus datos personales y su historial
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
                            "Introduce los partidos pitados del nuevo árbitro: ",
                            "Creación de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (partidosPitados == null || partidosPitados.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    int partidosPitadosNArbitro = -1;
                    try {
                        partidosPitadosNArbitro = Integer.parseInt(partidosPitados);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }

                    ciudadArbitro = this.seleccionarCiudad();

                    Arbitro nuevo = new Arbitro(partidosPitadosNArbitro, nombreArbitro, apellidoArbitro, ciudadArbitro, identificacionNArbitro);

                    arbitros.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Árbitro creado exitosamente!");

                    break;
                case 2:
                     // Edita el nombre de un arbitro al seleccionarlo
                    Arbitro arbitro2 = this.seleccionarArbitro();
                    String nuevoNombre = JOptionPane.showInputDialog(null,
                            "Introduce el nombre del árbitro: ",
                            "Edición de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoNombre == null || nuevoNombre.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    arbitro2.setNombre(nuevoNombre);
                    break;
                case 3:
                    // Edita el apellido de un arbitro al seleccionarlo
                    Arbitro arbitro3 = this.seleccionarArbitro();
                    String nuevoApellido = JOptionPane.showInputDialog(null,
                            "Introduce el apellido del árbitro: ",
                            "Edición de árbitro",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (nuevoApellido == null || nuevoApellido.trim().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                    }
                    arbitro3.setApellido(nuevoApellido);
                    break;
                case 4:
                    // Edita la ciudad de un arbitro al seleccionarlo
                    Arbitro arbitro4 = this.seleccionarArbitro();
                    Ciudad nuevaCiudad = this.seleccionarCiudad();
                    arbitro4.setNacionalidad(nuevaCiudad);
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Método que muestra el menú de opciones para los partidos, en este menu se pede programar un partido,
     * registrar los resultados del partido y los recaudos
     */
    private void menuPartidos() {
        int op = -1;
        while (op != 0) {
            String selPartidos = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Programar partido.\n"
                    + "2. Registrar goles de un partido programado.\n"
                    + "3. Ver resultados de un partido.\n"
                    + "4. Registrar recaudo de un partido.\n"
                    + "5. Registrar recaudo por publicidad de un partido.\n"
                    + "6. Menú de interacciones de un partido.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de partidos", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selPartidos);
            switch (op) {
                case 1:
                    // programar un partido 
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

                    Estadio estadioNuevo = this.seleccionarEstadio();

                    Partido nuevo = new Partido(anfitrion, visitante, 0, 0, fechaDatePartido, Partido.PROGRAMADO, estadioNuevo);

                    this.partidos.add(nuevo);

                    JOptionPane.showMessageDialog(null, "¡Partido programado exitosamente!");

                    break;
                case 2:
                    // Registrar los resultados de un partido
                    Partido seleccionGoles = this.seleccionarPartido();
                    switch (seleccionGoles.getEstado()) {
                        case Partido.PROGRAMADO: {
                            int golesAnfitrion = 0;
                            String golesAnfString = JOptionPane.showInputDialog(null, "Introduce los goles del anfitrión: ");

                            try {
                                golesAnfitrion = Integer.parseInt(golesAnfString);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar guardar los goles del anfitrión.");
                                System.out.println(e.getMessage());
                                break;
                            }

                            int golesVisitante = 0;
                            String golesVisString = JOptionPane.showInputDialog(null, "Introduce los goles del visitante: ");

                            try {
                                golesVisitante = Integer.parseInt(golesAnfString);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar guardar los goles del visitante.");
                                System.out.println(e.getMessage());
                                break;
                            }

                            seleccionGoles.setGolAnfitrion(golesAnfitrion);
                            seleccionGoles.setGolVisitante(golesVisitante);
                            seleccionGoles.setEstado(Partido.REGISTRADO);

                            JOptionPane.showMessageDialog(null, "Se registraron los goles de este partido exitosamente.");
                            break;
                        }
                        case Partido.REGISTRADO: {
                            JOptionPane.showMessageDialog(null, "Ya se habían registrado los goles de este partido.");
                            break;
                        }
                    }

                    break;
                case 3:
                     // Ver resultados de un partido
                    Partido seleccionVer = this.seleccionarPartido();
                    seleccionVer.mostrarDatosPartido();
                    break;
                case 4:
                    // Registrar recaudo de un partido
                    Partido seleccionRegistroRecaudo = this.seleccionarPartido();
                    double recaudo = 0;
                    String recaudoString = JOptionPane.showInputDialog(null, "Introduce el recaudo de este partido: ");
                    try {
                        recaudo = Double.parseDouble(recaudoString);
                        seleccionRegistroRecaudo.setRecaudo(recaudo);

                        JOptionPane.showMessageDialog(null, "Se registró el recaudo para este partido correctamente.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar guardar el recaudo de este partido.");
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case 5:
                    // Registrar recaudo por publicidad de un partido
                    Partido seleccionRegistroPublicidad = this.seleccionarPartido();
                    double recaudoPublicidad = 0;
                    String recaudoPublicidadString = JOptionPane.showInputDialog(null, "Introduce el recaudo por publicidad de este partido: ");
                    try {
                        recaudoPublicidad = Double.parseDouble(recaudoPublicidadString);
                        seleccionRegistroPublicidad.setRecaudoPublicidad(recaudoPublicidad);

                        JOptionPane.showMessageDialog(null, "Se registró el recaudo por publicidad para este partido correctamente.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar guardar el recaudo por publicidad de este partido.");
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case 6:
                // muestra el menu de interacciones de un partido
                {
                    Partido seleccion = this.seleccionarPartido();
                    if(seleccion != null){
                        this.menuInteracciones(seleccion);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                    break;
                }
            }
        }
    }

    /**
     * Método que muestra el menú de opciones de las interacciones
     *
     * @param partido - El partido del que se quieren listar las interacciones,
     * en caso de que sea null, al listar las interacciones de un jugador, se
     * traerán todas las interacciones del jugador de todos los partidos.
     */
    private void menuInteracciones(Partido partido) {
        int op = -1;
        while (op != 0) {
            String selInteracciones = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Registrar interacción (Amarillas, Rojas, Lesiones).\n"
                    + "2. Listar interacciones de un jugador.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de interacciones", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selInteracciones);
            switch (op) {
                case 1:
                    // registra una interaccion seleccionando un jugador de la lista
                    int interaccionRegistro = -1;
                    if (partido == null) {
                        partido = this.seleccionarPartido();
                    }
                    Jugador jugadorSeleccionado = this.seleccionarJugador();

                    String interSeleccionada = JOptionPane.showInputDialog(null, "Selecciona una interacción para este jugador en este partido: \n"
                            + "1. Amarilla.\n"
                            + "2. Roja.\n"
                            + "3. Lesión.\n",
                            "Selecciona de interacción");
                    try {
                        interaccionRegistro = Integer.parseInt(interSeleccionada);
                        Interaccion nuevaInteraccion = new Interaccion(jugadorSeleccionado, partido, interaccionRegistro, "");

                        this.interacciones.add(nuevaInteraccion);

                        JOptionPane.showMessageDialog(null, "¡Interacción registrada exitosamente!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar guardar la interacción.");
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case 2:
                    // Lista los jugadores, el usuario selecciona el jugador, en caso de tarjeta amarilla, roja o lesion
                    Jugador seleccionadoJugadorInteracciones = this.seleccionarJugador();

                    String message = "Las interacciones de " + seleccionadoJugadorInteracciones.getNombre() + " " + seleccionadoJugadorInteracciones + " son:\n";

                    ArrayList<Interaccion> interaccionesJugador = this.bucsarInteraccionesPorJugador(seleccionadoJugadorInteracciones, partido);

                    for (int i = 0; i < interaccionesJugador.size(); i++) {
                        message += interaccionesJugador.get(i).toString() + "\n";
                    }

                    JOptionPane.showMessageDialog(null, message);
                    break;
            }
        }
    }

     /**
     * Método que muestra el menú de opciones para los estadios, en este menu se pede registrar
     * y ver los datos de los estadios
     */
    private void menuEstadios() {
        int op = -1;
        while (op != 0) {
            String selEstadios = JOptionPane.showInputDialog(null, ""
                    // Opciones
                    + "1. Registrar estadio.\n"
                    + "2. Listar estadios.\n"
                    + "0. Menú anterior",
                    // Título y tipo de mensaje.
                    "Menú de estadios", JOptionPane.QUESTION_MESSAGE);
            op = Integer.parseInt(selEstadios);
            switch (op) {
                case 1:
                    // Registra el nombre y la ciudad donde se encuentra el estadio
                    Ciudad ciudadSel = this.seleccionarCiudad();

                    String nombreEstadio = JOptionPane.showInputDialog("Introduce el nombre del estadio");
                    Estadio nuevo = new Estadio(nombreEstadio, ciudadSel);
                    estadios.add(nuevo);

                    JOptionPane.showMessageDialog(null, "Se registró el estadio correctamente.");
                    break;
                case 2:
                    // Muestra una lista de todos los estadios registrados
                    String message = "Los estadios registrados en la plataforma son:\n\n";
                    for (int i = 0; i < this.estadios.size(); i++) {
                        message += this.estadios.get(i).toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    break;
            }
        }
    }
    /**
     * Método que muestra la lista de los jugadores registrados para que el usuario los seleccione
     * 
     */
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
    /**
     *  muestra la lista de los equipos registrados para que el usuario los seleccione
     */
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
    /**
     *  lista las ciudades registradas en el programa para que el usuario las seleccione
     */
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
     /**
     *  lista los tecnicos registrados para que el usuario los seleccione
     */
    private Tecnico seleccionarTecnico() {
        if (tecnicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tecnicos registradas.");
            return null;
        } else {
            String message = "Selecciona el técnico: \n";
            for (int i = 0; i < tecnicos.size(); i++) {
                message += (i + 1) + ". " + tecnicos.get(i).toString() + "\n";
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
     *  lista los propietarios registrados para que el usuario los seleccione
     */
    private Propietario seleccionarPropietario() {
        if (propietarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay propietarios registrados.");
            return null;
        } else {
            String message = "Selecciona el propietario: \n";
            for (int i = 0; i < propietarios.size(); i++) {
                message += (i + 1) + ". " + propietarios.get(i).toString() + "\n";
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
    /**
     *  lista las personas del persona auxiliar registrados para que el usuario los seleccione
     */
    private PAuxiliar seleccionarAuxiliar() {
        if (auxiliares.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay auxiliares registrados.");
            return null;
        } else {
            String message = "Selecciona el auxiliar: \n";
            for (int i = 0; i < auxiliares.size(); i++) {
                message += (i + 1) + ". " + auxiliares.get(i).toString() + "\n";
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
    /**
     *  lista los arbitros registrados para que el usuario los seleccione
     */
    private Arbitro seleccionarArbitro() {
        if (auxiliares.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay árbitros registrados.");
            return null;
        } else {
            String message = "Selecciona el árbitro: \n";
            for (int i = 0; i < arbitros.size(); i++) {
                message += (i + 1) + ". " + arbitros.get(i).toString() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de árbitro", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Arbitro) arbitros.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar árbitro.");
            }
        }
        return null;
    }
    /**
     *  lista los partidos registrados para que el usuario los seleccione
     */
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
    /**
     *  lista los estadios registrados para que el usuario los seleccione
     */
    private Estadio seleccionarEstadio() {
        if (estadios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay partidos registrados.");
            return null;
        } else {
            String message = "Selecciona el estadio: \n";
            for (int i = 0; i < estadios.size(); i++) {
                message += (i + 1) + ". " + estadios.get(i).toString() + "\n";
            }
            String seleccion = JOptionPane.showInputDialog(null, message, "Selección de estadios", JOptionPane.QUESTION_MESSAGE);

            try {
                return (Estadio) estadios.get(Integer.parseInt(seleccion) - 1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar estadio.");
            }
        }
        return null;
    }
    /**
     *  metodo que muestra los estados que se le pueden asignar a un jugador 
     */
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

    private ArrayList<Interaccion> bucsarInteraccionesPorJugador(Jugador jugador, Partido partido) {
        ArrayList<Interaccion> respuesta = new ArrayList<Interaccion>();
        for (int i = 0; i < interacciones.size(); i++) {
            if (interacciones.get(i).getJugador().getIdentificacion() == jugador.getIdentificacion()) {
                if (partido == null) {
                    respuesta.add(interacciones.get(i));
                } else if (partido.toString().equalsIgnoreCase(interacciones.get(i).getPartido().toString())) {
                    respuesta.add(interacciones.get(i));
                }
            }
        }

        return respuesta;
    }
    /**
     *  lista los jugadores segun la interaccion 
     */
    private void listarInteracciones(int interaccion) {
        String message = interaccion == 0 ? "Los jugadores con amarillas son: \n\n" : 
                interaccion == 1 ? "Los jugadores con rojas son: \\n\\n" : 
                "Los jugadores lesionados son: \n\n";
        for (int i = 0; i < this.interacciones.size(); i++) {
            if (this.interacciones.get(i).getInteraccion() == interaccion) {
                message += this.interacciones.get(i).getJugador().toString()
                        /*+ " " + this.interacciones.get(i).toString()*/;
            }
        }

        JOptionPane.showMessageDialog(null, message);
    }
    /**
     *  lista los jugadores segun el estado en que se encuentren
     */
    private void listarJugadoresPorEstado(int estado) {
        String message = "Los jugadores suspendidos son: \n\n";
        for (int i = 0; i < this.jugadores.size(); i++) {
            if (((Jugador) this.jugadores.get(i)).getEstado() == estado) {
                message += this.jugadores.get(i).toString();
            }
        }

        JOptionPane.showMessageDialog(null, message);
    }
    /**
     *  Metodo que realiza el calculo del recaudo segun un rango de fechas
     */
    private void calcularRecaudoEntreFechas() {
        double recaudo = 0;
        String fechaInString = JOptionPane.showInputDialog(null,
                "Escirbe la fecha inicial (dd/mm/aaaa) ej. 07/06/2017",
                "Selección de fechas", JOptionPane.QUESTION_MESSAGE);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaIn = formatter.parse(fechaInString);

            String fechaFnString = JOptionPane.showInputDialog(null,
                    "Escirbe la fecha inicial (dd/mm/aaaa) ej. 07/06/2017",
                    "Selección de fechas", JOptionPane.QUESTION_MESSAGE);
            try {
                Date fechaFn = formatter.parse(fechaFnString);
                
                for (int i = 0; i < partidos.size(); i++) {
                    if(partidos.get(i).getFechaPartido().after(fechaIn) && partidos.get(i).getFechaPartido().before(fechaFn)){
                        recaudo += partidos.get(i).getRecaudo();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar procesar la fecha final.");
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar procesar la fecha inicial.");
            System.out.println(e.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "El recaudo de estas fechas en todos los partidos fue: " + recaudo);
    }
    /**
     *  Metodo que calcula el recaudo por publicidad segun un rango de fechas
     */
    private void calcularRecaudoPorPublicidadEntreFechas() {
        double recaudo = 0;
        String fechaInString = JOptionPane.showInputDialog(null,
                "Escirbe la fecha inicial (dd/mm/aaaa) ej. 07/06/2017",
                "Selección de fechas", JOptionPane.QUESTION_MESSAGE);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaIn = formatter.parse(fechaInString);

            String fechaFnString = JOptionPane.showInputDialog(null,
                    "Escirbe la fecha inicial (dd/mm/aaaa) ej. 07/06/2017",
                    "Selección de fechas", JOptionPane.QUESTION_MESSAGE);
            try {
                Date fechaFn = formatter.parse(fechaFnString);
                
                for (int i = 0; i < partidos.size(); i++) {
                    if(partidos.get(i).getFechaPartido().after(fechaIn) && partidos.get(i).getFechaPartido().before(fechaFn)){
                        recaudo += partidos.get(i).getRecaudoPublicidad();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar procesar la fecha final.");
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar procesar la fecha inicial.");
            System.out.println(e.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "El recaudo de estas fechas en todos los partidos fue: " + recaudo);
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
        this.menuPrincipal();
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
