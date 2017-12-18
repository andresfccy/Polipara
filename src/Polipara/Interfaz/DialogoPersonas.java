/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Interfaz;

import java.awt.BorderLayout;
import javax.swing.JDialog;

/**
 *
 * @author usuario
 */
public class DialogoPersonas extends JDialog {
    private PoliparaPrincipal principal;
    
    private PanelOpcionesPersonas panelOpPersonas;
    
    public DialogoPersonas(PoliparaPrincipal pPrincipal){
        principal = pPrincipal;
        
        panelOpPersonas = new PanelOpcionesPersonas(this);
        
        setTitle( "Opciones de personas" );
        setSize( 250, 90 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        
        setLayout(new BorderLayout());
        
    }

    public void mostrarDialogoPropietarios() {
        
    }

    public void mostrarDialogoTecnicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarDialogoJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarDialogoAuxiliares() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarDialogoArbitros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
