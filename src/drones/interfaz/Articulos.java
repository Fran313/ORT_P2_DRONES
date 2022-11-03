/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drones.interfaz;

/**
 *
 * @author nrusso
 */
public class Articulos extends javax.swing.JFrame {

    /**
     * Creates new form Articulos
     */
    public Articulos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Input = new javax.swing.JPanel();
        NombreLabel = new javax.swing.JLabel();
        NombreInput = new javax.swing.JTextField();
        DescripcionLabel = new javax.swing.JLabel();
        DescripcionInput = new javax.swing.JTextField();
        Filler = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        Agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArticulosTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        Input.setLayout(new java.awt.GridLayout(3, 2));

        NombreLabel.setText("Nombre");
        Input.add(NombreLabel);

        NombreInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreInputActionPerformed(evt);
            }
        });
        Input.add(NombreInput);

        DescripcionLabel.setText("Descripción");
        Input.add(DescripcionLabel);

        DescripcionInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionInputActionPerformed(evt);
            }
        });
        Input.add(DescripcionInput);
        Input.add(Filler);

        Agregar.setText("Agregar");
        Input.add(Agregar);

        getContentPane().add(Input);

        ArticulosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ArticulosTable);

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreInputActionPerformed

    private void DescripcionInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Articulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTable ArticulosTable;
    private javax.swing.JTextField DescripcionInput;
    private javax.swing.JLabel DescripcionLabel;
    private javax.swing.Box.Filler Filler;
    private javax.swing.JPanel Input;
    private javax.swing.JTextField NombreInput;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
