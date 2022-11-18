/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drones.interfaz;

import drones.dominio.Posicion;
import drones.dominio.Sistema;
import drones.dominio.Vuelo;

import java.awt.Color;
import java.io.File;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
  }

  private void hydrate(Vuelo v) {
    if (v == null) {
      DefaultTableCellRenderer nullRenderer = new DefaultTableCellRenderer();

      for (int col = 1; col <= 10; col++) {
        tblDiff.getColumnModel().getColumn(col).setCellRenderer(nullRenderer);
        for (int row = 0; row < 2; row++) {
          tblDiff.setValueAt(null, row, col);
        }
      }

      lblFila.setText("");
      lblTotalCoincidencias.setText("");
      lblTotalDiferencias.setText("");

      return;
    }
    lblFila.setText("Area: " + String.valueOf(Posicion.areaCode(v.getArea())) + " Fila: " + (v.getFila() + 1));

    DefaultTableCellRenderer redRenderer = new DefaultTableCellRenderer();
    redRenderer.setBackground(Color.RED);
    redRenderer.setHorizontalAlignment(JLabel.CENTER);
    DefaultTableCellRenderer greenRenderer = new DefaultTableCellRenderer();
    greenRenderer.setBackground(Color.GREEN);
    greenRenderer.setHorizontalAlignment(JLabel.CENTER);

    for (int col = 0; col < v.getDatos().size(); col++) {
      tblDiff.getColumnModel().getColumn(col + 1).setCellRenderer(v.getDiff()[col] == 1 ? greenRenderer : redRenderer);
    }

    lblTotalCoincidencias.setText("Total de coincidencias: " + v.getCoincidencias());
    lblTotalDiferencias.setText("Total de diferencias: " + v.getDiferencias());

    for (int col = 0; col < 10; col++) {
      tblDiff.setValueAt(v.getReading()[col], 0, col + 1);
      tblDiff.setValueAt(v.getManual()[col], 1, col + 1);
    }

  }

  private void jFileChooser1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jFileChooser1ActionPerformed
    if (evt.getActionCommand() == JFileChooser.APPROVE_SELECTION) {
      try {
        Vuelo vuelo = Vuelo.fromFile(
            Paths.get(jFileChooser1.getSelectedFile().getAbsolutePath()), this.sistema);
        hydrate(vuelo);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Mal formato de archivo", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(System.out);
      }
    } else if (evt.getActionCommand() == JFileChooser.CANCEL_SELECTION) {
      hydrate(null);

    }
  } // GEN-LAST:event_jFileChooser1ActionPerformed

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the
   * Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContent = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        pnlDiff = new javax.swing.JPanel();
        lblFila = new javax.swing.JLabel();
        pnlCoincidencias = new javax.swing.JPanel();
        lblTotalCoincidencias = new javax.swing.JLabel();
        lblTotalDiferencias = new javax.swing.JLabel();
        scrollDiff = new javax.swing.JScrollPane();
        tblDiff = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Vuelo");
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));

        pnlContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        pnlContent.setLayout(new java.awt.GridLayout(2, 1));

        jFileChooser1.setApproveButtonToolTipText("");
        jFileChooser1.setCurrentDirectory(null);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        pnlContent.add(jFileChooser1);

        pnlDiff.setLayout(new java.awt.BorderLayout());
        pnlDiff.add(lblFila, java.awt.BorderLayout.NORTH);

        pnlCoincidencias.setLayout(new java.awt.GridLayout(2, 1));
        pnlCoincidencias.add(lblTotalCoincidencias);
        pnlCoincidencias.add(lblTotalDiferencias);

        pnlDiff.add(pnlCoincidencias, java.awt.BorderLayout.SOUTH);

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
        scrollDiff.setViewportView(tblDiff);
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

        pnlDiff.add(scrollDiff, java.awt.BorderLayout.CENTER);

        pnlContent.add(pnlDiff);

        getContentPane().add(pnlContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel lblFila;
    private javax.swing.JLabel lblTotalCoincidencias;
    private javax.swing.JLabel lblTotalDiferencias;
    private javax.swing.JPanel pnlCoincidencias;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDiff;
    private javax.swing.JScrollPane scrollDiff;
    private javax.swing.JTable tblDiff;
    // End of variables declaration//GEN-END:variables
}
