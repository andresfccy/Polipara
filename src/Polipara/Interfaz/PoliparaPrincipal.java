/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Interfaz;

import Polipara.Mundo.Polipara;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author usuario
 */
public class PoliparaPrincipal extends JFrame {

    /**
     * Clase principal del mundo
     */
    private Polipara mundo;

    private PanelImagen panelImagen;
    private PanelOpcionesIniciales panelOpcionesIniciales;

    public PoliparaPrincipal() {
        setTitle("Copa Polipara");
        setSize(714, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelImagen = new PanelImagen();
        panelOpcionesIniciales = new PanelOpcionesIniciales(this);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelImagen, BorderLayout.NORTH);
        getContentPane().add(panelOpcionesIniciales, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);

        //mundo = new Polipara();
    }

    public static void main(String[] pArgs) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            PoliparaPrincipal interfaz = new PoliparaPrincipal();
            interfaz.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarDialogoPersonas() {
        
    }

    public void mostrarDialogoEquipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarDialogoEstadios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarDialogoAdministrativo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
