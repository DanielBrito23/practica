/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.PersonaDB;
import vista.PersonaVista;

/**
 *
 * @author LENOVO
 */
public class personaControlador {

    private final PersonaDB modelo;
    private final PersonaVista vista;

    public personaControlador(PersonaDB modelo, PersonaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);

    }

    public PersonaDB getModelo() {
        return modelo;
    }

    public PersonaVista getVista() {
        return vista;
    }

    public void iniciaControl() {

        vista.getBtnGuardar().addActionListener(e -> insertarPersona());
        vista.getBtnEditar().addActionListener(e -> Editar());
        vista.getBtnEliminar().addActionListener(e -> eliminador());
        vista.getBtn_guardaredicion().addActionListener(e -> guardaractualizacion());
        cargarLista();
    }

    public void eliminador() {
        int fila_seleccionada = vista.getTabla().getSelectedRow();
        if (fila_seleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Seguro de hacer eliminar el registro", "ELIMINAR", JOptionPane.YES_NO_CANCEL_OPTION);
            if (i == 0) {
                String codigo = String.valueOf(vista.getTabla().getValueAt(fila_seleccionada, 0));
                modelo.eliminar(codigo);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");

                if (1 == 2) {
                    eliminador();
                }

            }
        }
        cargarLista();
    }

    private void Editar() {

        int fila_seleccionada = vista.getTabla().getSelectedRow();
        if (fila_seleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {

            vista.getTxtCedula().setText((String) vista.getTabla().getValueAt(fila_seleccionada, 0));
            vista.getTxtNombre().setText((String) vista.getTabla().getValueAt(fila_seleccionada, 1));
            vista.getTxtApellido().setText((String) vista.getTabla().getValueAt(fila_seleccionada, 2));
            vista.getTxtCorreo().setText((String) vista.getTabla().getValueAt(fila_seleccionada, 3));
            vista.getTxtDomicilio().setText((String) vista.getTabla().getValueAt(fila_seleccionada, 4));
            vista.getTxtCelular().setText((String) vista.getTabla().getValueAt(fila_seleccionada, 5));
            vista.getComboSexo().addItem((String) vista.getTabla().getValueAt(fila_seleccionada, 6));

        }
        vista.getTxtCedula().enable(false);

    }

    private void cargarLista() {
        DefaultTableModel modeloTabla;
        modeloTabla = (DefaultTableModel) vista.getTabla().getModel();
        for (int i = vista.getTabla().getRowCount() - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
        List<Persona> lista = modelo.listaPersonas();
        int columnas = modeloTabla.getColumnCount();
        for (int i = 0; i < lista.size(); i++) {
            modeloTabla.addRow(new Object[columnas]);
            vista.getTabla().setValueAt(lista.get(i).getIdpersona(), i, 0);
            vista.getTabla().setValueAt(lista.get(i).getNombres(), i, 1);
            vista.getTabla().setValueAt(lista.get(i).getApellidos(), i, 2);
            vista.getTabla().setValueAt(lista.get(i).getCorreo(), i, 3);
            vista.getTabla().setValueAt(lista.get(i).getDomicilio(), i, 4);
            vista.getTabla().setValueAt(lista.get(i).getTelefono(), i, 5);
            vista.getTabla().setValueAt(lista.get(i).getSexo(), i, 6);

        }

    }

    private void insertarPersona() {
        modelo.setIdpersona(vista.getTxtCedula().getText());
        modelo.setNombres(vista.getTxtNombre().getText());
        modelo.setApellidos(vista.getTxtApellido().getText());
        modelo.setCorreo(vista.getTxtCorreo().getText());
        modelo.setDomicilio(vista.getTxtDomicilio().getText());
        modelo.setTelefono(vista.getTxtCelular().getText());
        modelo.setSexo(vista.getComboSexo().getSelectedItem().toString());

        if (modelo.insertar()) {
            JOptionPane.showMessageDialog(null, "Datos insertatdos correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar datos");

        }

// if (vista.getBtnGuardar().getText().contentEquals("Crear")) {
//
//            if (modelo.insertar()) {
//                JOptionPane.showMessageDialog(null, "Datos insertatdos correctamente");
//              
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al ingresar datos");
//
//            }
//        } else {
//            if (modelo.actualizar()) {
//                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al actualizar datos");
//            }
//        } cargarLista();
    }

    private void guardaractualizacion() {
        modelo.setIdpersona(vista.getTxtCedula().getText());
        modelo.setNombres(vista.getTxtNombre().getText());
        modelo.setApellidos(vista.getTxtApellido().getText());
        modelo.setCorreo(vista.getTxtCorreo().getText());
        modelo.setDomicilio(vista.getTxtDomicilio().getText());
        modelo.setTelefono(vista.getTxtCelular().getText());
        modelo.setSexo(vista.getComboSexo().getSelectedItem().toString());
        System.out.println(modelo.actualizar());
        modelo.actualizar();
        System.out.println(modelo.actualizar());
        JOptionPane.showMessageDialog(null, "Datos han sido actualizados correctamente");
    }
}
