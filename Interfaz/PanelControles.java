/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author FERNANDO RINCON
 */
public class PanelControles extends JPanel {

    JTextArea areaInfo;

    public PanelControles(JTextArea areaInfo) {
        this.areaInfo= areaInfo;
        initComponets();

    }

    private void initComponets() {
        int margenBotones = 20;
        setLayout(new GridLayout(10, 11));

        JLabel labelNumeroCuenta = new JLabel("Numero de la cuenta");
        JLabel labelNombre = new JLabel("Nombre del propietario");

        JTextField campoTextoNumeroCuenta = new JTextField(10);
        JTextField campoTextoNombre = new JTextField(10);

        JRadioButton radioButtonAhorros = new JRadioButton("Ahorros");
        Listener listener = new Listener(campoTextoNumeroCuenta, campoTextoNombre, radioButtonAhorros, areaInfo);
        JButton botonAgregar = new JButton("Agregar Cuenta");
        botonAgregar.setMargin(new Insets(0, margenBotones, 0, margenBotones));
       
        botonAgregar.addActionListener(listener);

        JButton botonVerCuenta = new JButton("Ver cuenta");
        botonVerCuenta.setMargin(new Insets(0, margenBotones, 0, margenBotones));
        botonVerCuenta.addActionListener(listener);
        
        JButton botonTodasLasCuentas = new JButton("Todas las cuentas");
        botonTodasLasCuentas.setMargin(new Insets(0, margenBotones, 0, margenBotones));
        botonTodasLasCuentas.addActionListener(listener);

        add(labelNumeroCuenta);
        add(campoTextoNumeroCuenta);

        add(labelNombre);
        add(campoTextoNombre);

        add(radioButtonAhorros);

        add(botonAgregar);
        add(botonVerCuenta);
        add(botonTodasLasCuentas);

    }

}
