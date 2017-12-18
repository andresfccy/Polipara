/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Interfaz;

import java.awt.BorderLayout;
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

    private PoliparaPrincipal principal;

    private JPanel opcionesPersonas;
    private JPanel opcionesEquipos;
    private JPanel opcionesEstadios;
    private JPanel opacionesAdministrativas;

    private JPanel opcPropietarios;
    private JPanel opcTecnicos;
    private JPanel opcJugadores;
    private JPanel opcAuxiliares;
    private JPanel opcArbitros;

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

    public PanelOpcionesIniciales(PoliparaPrincipal pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Opciones de la copa"));

        setLayout(new BorderLayout());

        opcionesPersonas = new JPanel();
        opcionesPersonas.setBorder(new TitledBorder("Opciones de personas"));
        opcionesPersonas.setLayout(new GridLayout(5, 1));
        opcionesEquipos = new JPanel();
        opcionesEquipos.setBorder(new TitledBorder("Opciones de equipos"));
        opcionesEstadios = new JPanel();
        opcionesEstadios.setBorder(new TitledBorder("Opciones de estadios"));
        opacionesAdministrativas = new JPanel();
        opacionesAdministrativas.setBorder(new TitledBorder("Opciones administrativas"));
        

        btnAgregarPropietario = new JButton(AGREGAR_PROPIETARIO);
        btnAgregarPropietario.setActionCommand(AGREGAR_PROPIETARIO);
        btnAgregarPropietario.addActionListener(this);
        add(btnAgregarPropietario);

        btnEditarPropietario = new JButton(EDITAR_PROPIETARIO);
        btnEditarPropietario.setActionCommand(EDITAR_PROPIETARIO);
        btnEditarPropietario.addActionListener(this);
        add(btnEditarPropietario);

        btnAgregarTecnico = new JButton(AGREGAR_TECNICO);
        btnAgregarTecnico.setActionCommand(AGREGAR_TECNICO);
        btnAgregarTecnico.addActionListener(this);
        add(btnAgregarTecnico);

        btnEditarTecnico = new JButton(EDITAR_TECNICO);
        btnEditarTecnico.setActionCommand(EDITAR_TECNICO);
        btnEditarTecnico.addActionListener(this);
        add(btnEditarTecnico);

        btnAgregarJugador = new JButton(AGREGAR_JUGADOR);
        btnAgregarJugador.setActionCommand(AGREGAR_JUGADOR);
        btnAgregarJugador.addActionListener(this);
        add(btnAgregarJugador);

        btnEditarJugador = new JButton(EDITAR_JUGADOR);
        btnEditarJugador.setActionCommand(EDITAR_JUGADOR);
        btnEditarJugador.addActionListener(this);
        add(btnEditarJugador);

        btnAgregarAuxiliar = new JButton(AGREGAR_AUXILIAR);
        btnAgregarAuxiliar.setActionCommand(AGREGAR_AUXILIAR);
        btnAgregarAuxiliar.addActionListener(this);
        add(btnAgregarAuxiliar);

        btnEditarAuxiliar = new JButton(EDITAR_AUXILIAR);
        btnEditarAuxiliar.setActionCommand(EDITAR_AUXILIAR);
        btnEditarAuxiliar.addActionListener(this);
        add(btnEditarAuxiliar);

        btnAgregarArbitro = new JButton(AGREGAR_ARBITRO);
        btnAgregarArbitro.setActionCommand(AGREGAR_ARBITRO);
        btnAgregarArbitro.addActionListener(this);
        add(btnAgregarArbitro);

        btnEditarArbitro = new JButton(EDITAR_ARBITRO);
        btnEditarArbitro.setActionCommand(EDITAR_ARBITRO);
        btnEditarArbitro.addActionListener(this);
        add(btnEditarArbitro);

        opcPropietarios = new JPanel();
        opcPropietarios.setBorder(new TitledBorder("Propietarios"));
        opcPropietarios.add(btnAgregarPropietario);
        opcPropietarios.add(btnEditarPropietario);
        opcTecnicos = new JPanel();
        opcTecnicos.setBorder(new TitledBorder("Técnicos"));
        opcTecnicos.add(btnAgregarTecnico);
        opcTecnicos.add(btnEditarTecnico);
        opcJugadores = new JPanel();
        opcJugadores.setBorder(new TitledBorder("Jugadores"));
        opcJugadores.add(btnAgregarJugador);
        opcJugadores.add(btnEditarJugador);
        opcAuxiliares = new JPanel();
        opcAuxiliares.setBorder(new TitledBorder("Auxiliares"));
        opcAuxiliares.add(btnAgregarAuxiliar);
        opcAuxiliares.add(btnEditarAuxiliar);
        opcArbitros = new JPanel();
        opcArbitros.setBorder(new TitledBorder("Árbitros"));
        opcArbitros.add(btnAgregarArbitro);
        opcArbitros.add(btnEditarArbitro);

        opcionesPersonas.add(opcPropietarios);
        opcionesPersonas.add(opcTecnicos);
        opcionesPersonas.add(opcJugadores);
        opcionesPersonas.add(opcAuxiliares);
        opcionesPersonas.add(opcArbitros);

        add(opcionesPersonas, BorderLayout.CENTER);
        add(opcionesEquipos, BorderLayout.WEST);
        add(opcionesEstadios, BorderLayout.EAST);
        add(opacionesAdministrativas, BorderLayout.SOUTH);
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
    }
}
