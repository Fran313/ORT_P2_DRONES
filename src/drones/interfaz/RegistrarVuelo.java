/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drones.interfaz;

import drones.dominio.Posicion;
import drones.dominio.Sistema;
import drones.dominio.Vuelo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Franc
 */
public class RegistrarVuelo extends javax.swing.JFrame {

  Sistema sistema;

  /** Creates new form RegistroDeVuelo */
  public RegistrarVuelo(Sistema s) {
    this.sistema = s;
    initComponents();

    // Set working directory as current directory
    File workingDirectory = new File(System.getProperty("user.dir"));
    jFileChooser1.setCurrentDirectory(workingDirectory);

    // Center all table cells
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    tblDiff.setDefaultRenderer(Object.class, centerRenderer);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        pnlDiff = new javax.swing.JPanel();
        JLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTotalCoincidencias = new javax.swing.JLabel();
        lblTotalDiferencias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDiff = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jFileChooser1.setApproveButtonToolTipText("");
        jFileChooser1.setCurrentDirectory(null);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser1);

        pnlDiff.setLayout(new java.awt.BorderLayout());

        JLabel1.setText("Area: A Fila: 3");
        pnlDiff.add(JLabel1, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        lblTotalCoincidencias.setText("Total de coincidencias: 6");
        jPanel3.add(lblTotalCoincidencias);

        lblTotalDiferencias.setText("Total de diferencias: 4");
        jPanel3.add(lblTotalDiferencias);

        pnlDiff.add(jPanel3, java.awt.BorderLayout.SOUTH);

        tblDiff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Archivo", null, null, null, null, null, null, null, null, null, null},
                {"Manual", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "De", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDiff);
        if (tblDiff.getColumnModel().getColumnCount() > 0) {
            tblDiff.getColumnModel().getColumn(0).setResizable(false);
            tblDiff.getColumnModel().getColumn(1).setResizable(false);
            tblDiff.getColumnModel().getColumn(2).setResizable(false);
            tblDiff.getColumnModel().getColumn(3).setResizable(false);
            tblDiff.getColumnModel().getColumn(4).setResizable(false);
            tblDiff.getColumnModel().getColumn(5).setResizable(false);
            tblDiff.getColumnModel().getColumn(6).setResizable(false);
            tblDiff.getColumnModel().getColumn(7).setResizable(false);
            tblDiff.getColumnModel().getColumn(8).setResizable(false);
            tblDiff.getColumnModel().getColumn(9).setResizable(false);
            tblDiff.getColumnModel().getColumn(10).setResizable(false);
        }

        pnlDiff.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlDiff);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jFileChooser1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jFileChooser1ActionPerformed
    if (evt.getActionCommand() == JFileChooser.APPROVE_SELECTION) {
      try {
        Vuelo v =
            Vuelo.fromFile(
                Paths.get(jFileChooser1.getSelectedFile().getAbsolutePath()), this.sistema);

        for (int i = 0; i < v.getDatos().size(); i++) {
          tblDiff.setValueAt(v.getDatos().get(i), 0, i + 1);
        }

        sistema.getCargas().stream()
            .filter(
                c -> {
                  Posicion p = c.getPosicion();
                  return p.getFila() == v.getFila() && p.getArea() == v.getArea();
                })
            .forEach(
                c -> {
                  tblDiff.setValueAt(c.getCantidad(), 1, c.getPosicion().getColumna());
                });

      } catch (IOException ex) {
        Logger.getLogger(RegistrarVuelo.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  } // GEN-LAST:event_jFileChooser1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotalCoincidencias;
    private javax.swing.JLabel lblTotalDiferencias;
    private javax.swing.JPanel pnlDiff;
    private javax.swing.JTable tblDiff;
    // End of variables declaration//GEN-END:variables
}
