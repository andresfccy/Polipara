/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author usuario
 */
public class PanelOpcionesIniciales extends JPanel implements ActionListener {

    private final static String AGREGAR_PROPIETARIO = "Agregar propietario";
    private final static String EDITAR_PROPIETARIO = "Editar propietario";
    private final static String AGREGAR_TECNICO = "Agregar técnico";
    private final static String EDITAR_TECNICO = "Editar técnico";
    private final static String AGREGAR_JUGADOR = "Agregar jugador";
    private final static String EDITAR_JUGADOR = "Editar jugador";
    private final static String AGREGAR_AUXILIAR = "Agregar auxiliar";
    private final static String EDITAR_AUXILIAR = "Editar auxiliar";
    private final static String AGREGAR_ARBITRO = "Agregar árbitro";
    private final static String EDITAR_ARBITRO = "Editar árbitro";
    
    private final static String LISTAR_AMARILLAS = "Listar jugadores amarillas";
    private final static String LISTAR_ROJAS = "Listar jugadores rojas";
    private final static String LISTAR_LESIONADOS = "Listar lesionados";
    private final static String LISTAR_SUSPENDIDOS = "Listar suspendidos";
    private final static String RECAUDO = "Recaudo entre fechas";
    private final static String RECAUDO_PUBLICIDAD = "Recaudo publicidad entre fechas";
    
    private final static String PROGRAMAR_PARTIDO = "Programar partido";
    private final static String REGISTRAR_GOLES_PARTIDO = "Registrar goles";
    private final static String REGISTRAR_RECAUDO = "Registrar recaudo";
    private final static String REGISTRAR_RECUAUDO_PUBLICIDAD = "Registrar publicidad";
    private final static String VER_RESULTADO = "Ver resultado";
    
    private final static String REGISTRAR_ESTADIO = "Registrar estadio";
    private final static String LISTAR_ESTADIOS = "Listar estadios";

    private PoliparaPrincipal principal;

    private JPanel opcionesPersonas;
    private JPanel opcionesEquipos;
    private JPanel opcionesEstadios;
    private JPanel opcionesAdministrativas;

    private JPanel opcPropietarios;
    private JPanel opcTecnicos;
    private JPanel opcJugadores;
    private JPanel opcAuxiliares;
    private JPanel opcArbitros;
    
    private JPanel opcPartidos;

    private JButton btnAgregarPropietario;
    private JButton btnEditarPropietario;
    private JButton btnAgregarTecnico;
    private JButton btnEditarTecnico;
    private JButton btnAgregarJugador;
    private JButton btnEditarJugador;
    private JButton btnAgregarAuxiliar;
    private JButton btnEditarAuxiliar;
    private JButton btnAgregarArbitro;
    private JButton btnEditarArbitro;
    
    private JButton btnAmarillas;
    private JButton btnRojas;
    private JButton btnLesionados;
    private JButton btnSuspendidos;
    private JButton btnRecaudo;
    private JButton btnRecaudoPublicidad;
    
    private JButton btnProgramarPartido;
    private JButton btnRegistrarGoles;
    private JButton btnRegistrarRecaudo;
    private JButton btnRegistrarRecaudoPublicidad;
    private JButton btnVerResultados;
    
    private JButton btnRegistrarEstadio;
    private JButton btnListarEstadios;

    public PanelOpcionesIniciales(PoliparaPrincipal pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Opciones de la copa"));

        setLayout(new FlowLayout());

        opcionesPersonas = new JPanel();
        opcionesPersonas.setBorder(new TitledBorder("Opciones de personas"));
        opcionesPersonas.setLayout(new GridLayout(5, 1));
        opcionesEquipos = new JPanel();
        opcionesEquipos.setBorder(new TitledBorder("Opciones de equipos"));
        opcionesEstadios = new JPanel();
        opcionesEstadios.setBorder(new TitledBorder("Opciones de estadios"));
        opcionesAdministrativas = new JPanel();
        opcionesAdministrativas.setBorder(new TitledBorder("Opciones administrativas"));
        opcionesAdministrativas.setLayout(new GridLayout(2,3));

        opcPropietarios = new JPanel();
        opcPropietarios.setBorder(new TitledBorder("Propietarios"));
        opcTecnicos = new JPanel();
        opcTecnicos.setBorder(new TitledBorder("Técnicos"));
        opcJugadores = new JPanel();
        opcJugadores.setBorder(new TitledBorder("Jugadores"));
        opcAuxiliares = new JPanel();
        opcAuxiliares.setBorder(new TitledBorder("Auxiliares"));
        opcArbitros = new JPanel();
        opcArbitros.setBorder(new TitledBorder("Árbitros"));
        
        opcPartidos = new JPanel();
        opcPartidos.setBorder(new TitledBorder("Opciones partidos"));
        opcPartidos.setLayout(new FlowLayout());
        
        btnAgregarPropietario = new JButton(AGREGAR_PROPIETARIO);
        btnAgregarPropietario.setActionCommand(AGREGAR_PROPIETARIO);
        btnAgregarPropietario.addActionListener(this);
        opcPropietarios.add(btnAgregarPropietario);
        btnEditarPropietario = new JButton(EDITAR_PROPIETARIO);
        btnEditarPropietario.setActionCommand(EDITAR_PROPIETARIO);
        btnEditarPropietario.addActionListener(this);
        opcPropietarios.add(btnEditarPropietario);
        btnAgregarTecnico = new JButton(AGREGAR_TECNICO);
        btnAgregarTecnico.setActionCommand(AGREGAR_TECNICO);
        btnAgregarTecnico.addActionListener(this);
        opcTecnicos.add(btnAgregarTecnico);
        btnEditarTecnico = new JButton(EDITAR_TECNICO);
        btnEditarTecnico.setActionCommand(EDITAR_TECNICO);
        btnEditarTecnico.addActionListener(this);
        opcTecnicos.add(btnEditarTecnico);
        btnAgregarJugador = new JButton(AGREGAR_JUGADOR);
        btnAgregarJugador.setActionCommand(AGREGAR_JUGADOR);
        btnAgregarJugador.addActionListener(this);
        opcJugadores.add(btnAgregarJugador);
        btnEditarJugador = new JButton(EDITAR_JUGADOR);
        btnEditarJugador.setActionCommand(EDITAR_JUGADOR);
        btnEditarJugador.addActionListener(this);
        opcJugadores.add(btnEditarJugador);
        btnAgregarAuxiliar = new JButton(AGREGAR_AUXILIAR);
        btnAgregarAuxiliar.setActionCommand(AGREGAR_AUXILIAR);
        btnAgregarAuxiliar.addActionListener(this);
        opcAuxiliares.add(btnAgregarAuxiliar);
        btnEditarAuxiliar = new JButton(EDITAR_AUXILIAR);
        btnEditarAuxiliar.setActionCommand(EDITAR_AUXILIAR);
        btnEditarAuxiliar.addActionListener(this);
        opcAuxiliares.add(btnEditarAuxiliar);
        btnAgregarArbitro = new JButton(AGREGAR_ARBITRO);
        btnAgregarArbitro.setActionCommand(AGREGAR_ARBITRO);
        btnAgregarArbitro.addActionListener(this);
        opcArbitros.add(btnAgregarArbitro);
        btnEditarArbitro = new JButton(EDITAR_ARBITRO);
        btnEditarArbitro.setActionCommand(EDITAR_ARBITRO);
        btnEditarArbitro.addActionListener(this);
        opcArbitros.add(btnEditarArbitro);
        
        
        btnAmarillas = new JButton(LISTAR_AMARILLAS);
        btnAmarillas.setActionCommand(LISTAR_AMARILLAS);
        btnAmarillas.addActionListener(this);
        opcionesAdministrativas.add(btnAmarillas);
        btnLesionados = new JButton(LISTAR_LESIONADOS);
        btnLesionados.setActionCommand(LISTAR_LESIONADOS);
        btnLesionados.addActionListener(this);
        opcionesAdministrativas.add(btnLesionados);
        btnRecaudo = new JButton(RECAUDO);
        btnRecaudo.setActionCommand(RECAUDO);
        btnRecaudo.addActionListener(this);
        opcionesAdministrativas.add(btnRecaudo);
        btnRojas = new JButton(LISTAR_ROJAS);
        btnRojas.setActionCommand(LISTAR_ROJAS);
        btnRojas.addActionListener(this);
        opcionesAdministrativas.add(btnRojas);
        btnSuspendidos = new JButton(LISTAR_SUSPENDIDOS);
        btnSuspendidos.setActionCommand(LISTAR_SUSPENDIDOS);
        btnSuspendidos.addActionListener(this);
        opcionesAdministrativas.add(btnSuspendidos);
        btnRecaudoPublicidad = new JButton(RECAUDO_PUBLICIDAD);
        btnRecaudoPublicidad.setActionCommand(RECAUDO_PUBLICIDAD);
        btnRecaudoPublicidad.addActionListener(this);
        opcionesAdministrativas.add(btnRecaudoPublicidad);
                
        btnProgramarPartido = new JButton(PROGRAMAR_PARTIDO);
        btnProgramarPartido.setActionCommand(PROGRAMAR_PARTIDO);
        btnProgramarPartido.addActionListener(this);
        opcPartidos.add(btnProgramarPartido);
        btnRegistrarGoles = new JButton(REGISTRAR_GOLES_PARTIDO);
        btnRegistrarGoles.setActionCommand(REGISTRAR_GOLES_PARTIDO);
        btnRegistrarGoles.addActionListener(this);
        opcPartidos.add(btnRegistrarGoles);
        btnRegistrarRecaudo = new JButton(REGISTRAR_RECAUDO);
        btnRegistrarRecaudo.setActionCommand(REGISTRAR_RECAUDO);
        btnRegistrarRecaudo.addActionListener(this);
        opcPartidos.add(btnRegistrarRecaudo);
        btnRegistrarRecaudoPublicidad = new JButton(REGISTRAR_RECUAUDO_PUBLICIDAD);
        btnRegistrarRecaudoPublicidad.setActionCommand(REGISTRAR_RECUAUDO_PUBLICIDAD);
        btnRegistrarRecaudoPublicidad.addActionListener(this);
        opcPartidos.add(btnRegistrarRecaudoPublicidad);
        btnVerResultados = new JButton(VER_RESULTADO);
        btnVerResultados.setActionCommand(VER_RESULTADO);
        btnVerResultados.addActionListener(this);
        opcPartidos.add(btnVerResultados);

        opcionesPersonas.add(opcPropietarios);
        opcionesPersonas.add(opcTecnicos);
        opcionesPersonas.add(opcJugadores);
        opcionesPersonas.add(opcAuxiliares);
        opcionesPersonas.add(opcArbitros);

        add(opcionesPersonas);
        add(opcionesEquipos);
        add(opcionesEstadios);
        add(opcPartidos);
        add(opcionesAdministrativas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (AGREGAR_PROPIETARIO.equals(comando)) {
            principal.mostrarDialogoAgregarPropietario();
        } else if (EDITAR_PROPIETARIO.equals(comando)) {
            principal.mostrarDialogoEditarPropietario();
        } else if (AGREGAR_TECNICO.equals(comando)) {
            principal.mostrarDialogoAgregarTecnico();
        } else if (EDITAR_TECNICO.equals(comando)) {
            principal.mostrarDialogoEditarTecnico();
        } else if (AGREGAR_JUGADOR.equals(comando)) {
            principal.mostrarDialogoAgregarJugador();
        } else if (EDITAR_JUGADOR.equals(comando)) {
            principal.mostrarDialogoEditarJugador();
        } else if (AGREGAR_AUXILIAR.equals(comando)) {
            principal.mostrarDialogoAgregarAuxiliar();
        } else if (EDITAR_AUXILIAR.equals(comando)) {
            principal.mostrarDialogoEditarAuxiliar();
        } else if (AGREGAR_ARBITRO.equals(comando)) {
            principal.mostrarDialogoAgregarArbitro();
        } else if (EDITAR_ARBITRO.equals(comando)) {
            principal.mostrarDialogoEditarArbitro();
        } 
        
        else if (LISTAR_AMARILLAS.equals(comando)){
            principal.listarAmarillas();
        } else if (LISTAR_ROJAS.equals(comando)){
            principal.listarRojas();
        } else if (LISTAR_LESIONADOS.equals(comando)){
            principal.listarLesionados();
        } else if (LISTAR_SUSPENDIDOS.equals(comando)){
            principal.listarSuspendidos();
        } else if (RECAUDO.equals(comando)){
            principal.recaudo();
        } else if (RECAUDO_PUBLICIDAD.equals(comando)){
            principal.recaudoPublicidad();
        }
    }
}
