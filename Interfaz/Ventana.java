/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author FERNANDO RINCON
 */
public class Ventana extends JFrame {

    public Ventana() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        pack();
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new GridLayout(1, 2));//a la ventana se le da un layout de tyipo grid con una fila  y dos columnas

         JPanel PanelInfo = new JPanel();
        
        JTextArea areaInfo=new JTextArea(DatosConfiguracion.anchoAreaTexto, DatosConfiguracion.altoAreaTexto);//gracias a que las variables son estaticas yo puedo llamar a las variables sin crear una instancia de datos de configuración
       
        //JTextArea areaInfo = new JTextArea(20, 25);
        areaInfo.setEnabled(false);
        areaInfo.setBackground(Color.BLACK);
        PanelInfo.add(areaInfo);
        
        PanelControles panelControles = new PanelControles(areaInfo);

        add(panelControles);//se agreagan a la ventana el panel controles y el panel info
        add(PanelInfo);//esta es la linea para agregar al panel info

    }
}
