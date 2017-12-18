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
public class PanelOpcionesIniciales extends JPanel implements ActionListener{
    private final static String OPCIONES_PERSONAS = "Personas";
    private final static String OPCIONES_EQUIPOS = "Equipos";
    private final static String OPCIONES_ESTADIOS = "Estadios";
    private final static String OPCIONES_ADMINISTRATIVO = "Administrativo";
    
    private PoliparaPrincipal principal;
    
    private JButton btnPersonas;
    private JButton btnEquipos;
    private JButton btnEstadios;
    private JButton btnAdministrativo;
    
    public PanelOpcionesIniciales(PoliparaPrincipal pPrincipal){
        principal = pPrincipal;
        
        setBorder( new TitledBorder( "Opciones de la copa" ) );
        
        btnPersonas = new JButton( OPCIONES_PERSONAS );
        btnPersonas.setActionCommand( OPCIONES_PERSONAS );
        btnPersonas.addActionListener(this);
        add( btnPersonas );
        
        btnEquipos = new JButton( OPCIONES_EQUIPOS );
        btnEquipos.setActionCommand( OPCIONES_EQUIPOS );
        btnEquipos.addActionListener(this);
        add( btnEquipos );
        
        btnEstadios = new JButton( OPCIONES_ESTADIOS );
        btnEstadios.setActionCommand( OPCIONES_ESTADIOS );
        btnEstadios.addActionListener(this);
        add( btnEstadios );
        
        btnAdministrativo = new JButton( OPCIONES_ADMINISTRATIVO );
        btnAdministrativo.setActionCommand( OPCIONES_ADMINISTRATIVO );
        btnAdministrativo.addActionListener(this);
        add( btnAdministrativo );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand( );
        if( OPCIONES_PERSONAS.equals(comando)){
            principal.mostrarDialogoPersonas();
        } else if( OPCIONES_EQUIPOS.equals(comando)){
            principal.mostrarDialogoEquipos();
        } else if( OPCIONES_ESTADIOS.equals(comando)){
            principal.mostrarDialogoEstadios();
        } else if( OPCIONES_ADMINISTRATIVO.equals(comando)){
            principal.mostrarDialogoAdministrativo();
        }
    }
}
