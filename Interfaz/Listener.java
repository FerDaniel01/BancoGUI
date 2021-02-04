/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import aplicacionbanco.Banco;
import aplicacionbanco.Cuenta;
import aplicacionbanco.CuentaAhorros;
import aplicacionbanco.CuentaCorriente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author FERNANDO RINCON
 */
public class Listener implements ActionListener {

    JTextField campoTextoNombre;
    JTextField campoTextoNumeroCuenta;
    JRadioButton radioButtonAhorros;
    JTextArea areaInfo;

    public Listener(JTextField campoTextoNumeroCuenta, JTextField campoTextoNombre, JRadioButton radioButtonAhorros, JTextArea areaInfo) {
        this.campoTextoNombre = campoTextoNombre;
        this.campoTextoNumeroCuenta = campoTextoNumeroCuenta;
        this.radioButtonAhorros = radioButtonAhorros;
        this.areaInfo = areaInfo;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Agregar Cuenta")) {

            String nombre = campoTextoNombre.getText();

            int numeroCuenta = Integer.parseInt(campoTextoNumeroCuenta.getText());

            boolean ahorros = radioButtonAhorros.isSelected();
            Cuenta cuentaNueva;
            if (ahorros) {
                cuentaNueva = new CuentaAhorros(numeroCuenta, nombre, false);
            } else {
                cuentaNueva = new CuentaCorriente(numeroCuenta, nombre, 10, 234);
            }

            Banco.obtenerInstancia().agregarCuenta(cuentaNueva);
            areaInfo.setText("Cuenta agregada Exitosamente");
        } else if (ae.getActionCommand().equals("Ver cuenta")) {
            
            int numeroCuenta = Integer.parseInt(campoTextoNumeroCuenta.getText());
            Cuenta cuentaEncontrada = Banco.obtenerInstancia().buscarCuenta(numeroCuenta);
            if (cuentaEncontrada != null) {
                areaInfo.setText(cuentaEncontrada.toString());
                //System.out.println(cuentaEncontrada.detallesCuenta());
            } else {
                areaInfo.setText("Cuenta no encotrada");
            }

        }else if (ae.getActionCommand().equals("Todas las cuentas")){
        
        areaInfo.setText(Banco.obtenerInstancia().todasLasCuentas());
        }
    }
}
