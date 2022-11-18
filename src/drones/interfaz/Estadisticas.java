/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drones.interfaz;

import drones.dominio.Dron;
import drones.dominio.Sistema;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Franc
 */
public class Estadisticas extends javax.swing.JFrame {

  private Sistema sistema;

  /** Creates new form Statistics */
  public Estadisticas() {
    initComponents();
  }

  public Estadisticas(Sistema s) {
    this.sistema = s;
    initComponents();

    lstDronesConVuelos.addListSelectionListener(
        new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent arg0) {
            if (!(arg0.getValueIsAdjusting())) {
              Dron dron = sistema.buscarDron(lstDronesConVuelos.getSelectedValue());

              lstInfoVuelos.setListData(
                  dron.getVuelos().stream().map(v -> v.toString()).toArray(String[]::new));
            }
          }
        });
    hydrate();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlContenido = new javax.swing.JPanel();
    pnlDrones = new javax.swing.JPanel();
    pnlDronesConVuelos = new javax.swing.JPanel();
    lblDronesConVuelos = new javax.swing.JLabel();
    scrollDronesConVuelos = new javax.swing.JScrollPane();
    lstDronesConVuelos = new javax.swing.JList<>();
    pnlDronesSinVuelos = new javax.swing.JPanel();
    lblDronesSinVuelos = new javax.swing.JLabel();
    scrollDronesSinVuelos = new javax.swing.JScrollPane();
    lstDronesSinVuelos = new javax.swing.JList<>();
    pnlInfoVuelos = new javax.swing.JPanel();
    lblInformacionVuelos = new javax.swing.JLabel();
    scrollInfoVuelos = new javax.swing.JScrollPane();
    lstInfoVuelos = new javax.swing.JList<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Estadísticas");
    setPreferredSize(new java.awt.Dimension(700, 700));
    setResizable(false);
    setSize(new java.awt.Dimension(700, 700));

    pnlContenido.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
    pnlContenido.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

    pnlDrones.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

    pnlDronesConVuelos.setLayout(new java.awt.BorderLayout());

    lblDronesConVuelos.setText("Drones con vuelos");
    pnlDronesConVuelos.add(lblDronesConVuelos, java.awt.BorderLayout.NORTH);

    scrollDronesConVuelos.setViewportView(lstDronesConVuelos);

    pnlDronesConVuelos.add(scrollDronesConVuelos, java.awt.BorderLayout.CENTER);

    pnlDrones.add(pnlDronesConVuelos);

    pnlDronesSinVuelos.setLayout(new java.awt.BorderLayout());

    lblDronesSinVuelos.setText("Drones sin vuelos");
    pnlDronesSinVuelos.add(lblDronesSinVuelos, java.awt.BorderLayout.NORTH);

    scrollDronesSinVuelos.setViewportView(lstDronesSinVuelos);

    pnlDronesSinVuelos.add(scrollDronesSinVuelos, java.awt.BorderLayout.CENTER);

    pnlDrones.add(pnlDronesSinVuelos);

    pnlContenido.add(pnlDrones);

    pnlInfoVuelos.setLayout(new java.awt.BorderLayout());

    lblInformacionVuelos.setText("Informacion vuelos");
    pnlInfoVuelos.add(lblInformacionVuelos, java.awt.BorderLayout.NORTH);

    scrollInfoVuelos.setViewportView(lstInfoVuelos);

    pnlInfoVuelos.add(scrollInfoVuelos, java.awt.BorderLayout.CENTER);

    pnlContenido.add(pnlInfoVuelos);

    getContentPane().add(pnlContenido, java.awt.BorderLayout.CENTER);

    pack();
  } // </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel lblDronesConVuelos;
  private javax.swing.JLabel lblDronesSinVuelos;
  private javax.swing.JLabel lblInformacionVuelos;
  private javax.swing.JList<String> lstDronesConVuelos;
  private javax.swing.JList<String> lstDronesSinVuelos;
  private javax.swing.JList<String> lstInfoVuelos;
  private javax.swing.JPanel pnlContenido;
  private javax.swing.JPanel pnlDrones;
  private javax.swing.JPanel pnlDronesConVuelos;
  private javax.swing.JPanel pnlDronesSinVuelos;
  private javax.swing.JPanel pnlInfoVuelos;
  private javax.swing.JScrollPane scrollDronesConVuelos;
  private javax.swing.JScrollPane scrollDronesSinVuelos;
  private javax.swing.JScrollPane scrollInfoVuelos;
  // End of variables declaration//GEN-END:variables

  private void hydrate() {
    ArrayList<Dron> drones = this.sistema.getDrones();

    lstDronesConVuelos.setListData(
        drones.stream()
            .filter(d -> !d.getVuelos().isEmpty())
            .map(d -> d.toString())
            .toArray(String[]::new));

    lstDronesSinVuelos.setListData(
        drones.stream()
            .filter(d -> d.getVuelos().isEmpty())
            .map(d -> d.toString())
            .toArray(String[]::new));
  }
}
