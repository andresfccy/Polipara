/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polipara.Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class PanelImagen extends JPanel{
    public PanelImagen( )
    {
        JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "./data/imagenes/Encabezado.png" );
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );
    }
}
