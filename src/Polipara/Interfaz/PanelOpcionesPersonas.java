/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author usuario
 */
class PanelOpcionesPersonas extends JPanel implements ActionListener {
    private final static String OPCIONES_PROPIETARIOS = "Propietarios";
    private final static String OPCIONES_TECNICOS = "Técnicos";
    private final static String OPCIONES_JUGADORES = "Jugadores";
    private final static String OPCIONES_AUXILIARES = "Auxiliares";
    private final static String OPCIONES_ARBITROS = "Árbitros";
    
    private DialogoPersonas dialogoPersonas;
    
    private JButton btnPropietarios;
    private JButton btnTecnicos;
    private JButton btnJugadores;
    private JButton btnAuxiliares;
    private JButton btnArbitros;
    
    public PanelOpcionesPersonas(DialogoPersonas pDialogoPersonas){
        dialogoPersonas = pDialogoPersonas;
        
        setBorder( new TitledBorder( "Opciones de la copa" ) );
        
        btnPropietarios = new JButton( OPCIONES_PROPIETARIOS );
        btnPropietarios.setActionCommand( OPCIONES_PROPIETARIOS );
        btnPropietarios.addActionListener(this);
        add( btnPropietarios );
        
        btnTecnicos = new JButton( OPCIONES_TECNICOS );
        btnTecnicos.setActionCommand( OPCIONES_TECNICOS );
        btnTecnicos.addActionListener(this);
        add( btnTecnicos );
        
        btnJugadores = new JButton( OPCIONES_JUGADORES );
        btnJugadores.setActionCommand( OPCIONES_JUGADORES );
        btnJugadores.addActionListener(this);
        add( btnJugadores );
        
        btnAuxiliares = new JButton( OPCIONES_AUXILIARES );
        btnAuxiliares.setActionCommand( OPCIONES_AUXILIARES );
        btnAuxiliares.addActionListener(this);
        add( btnAuxiliares );
        
        btnArbitros = new JButton( OPCIONES_ARBITROS );
        btnArbitros.setActionCommand( OPCIONES_ARBITROS );
        btnArbitros.addActionListener(this);
        add( btnArbitros );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand( );
        if( OPCIONES_PROPIETARIOS.equals(comando)){
            dialogoPersonas.mostrarDialogoPropietarios();
        } else if( OPCIONES_TECNICOS.equals(comando)){
            dialogoPersonas.mostrarDialogoTecnicos();
        } else if( OPCIONES_JUGADORES.equals(comando)){
            dialogoPersonas.mostrarDialogoJugadores();
        } else if( OPCIONES_AUXILIARES.equals(comando)){
            dialogoPersonas.mostrarDialogoAuxiliares();
        } else if( OPCIONES_ARBITROS.equals(comando)){
            dialogoPersonas.mostrarDialogoArbitros();
        }
    }
}
