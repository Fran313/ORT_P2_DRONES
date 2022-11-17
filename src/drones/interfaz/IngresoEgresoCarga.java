/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drones.interfaz;

import drones.dominio.Articulo;
import drones.dominio.Funcionario;
import drones.dominio.Posicion;
import drones.dominio.Sistema;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @author nrusso
 */
public class IngresoEgresoCarga extends javax.swing.JFrame {

  private Sistema sistema;
  private int areaSeleccionada;
  JButton[][] buttons;

  /**
   * Creates new form IngresoEgresoCarga
   *
   * @param s
   */
  public IngresoEgresoCarga(Sistema s) {
    this.sistema = s;
    this.areaSeleccionada = 0;
    this.buttons = new JButton[12][10];

    initComponents();

    for (int y = 0; y < 12; y++) {
      for (int x = 0; x < 10; x++) {
        JButton nuevo = new JButton(" ");
        nuevo.setMargin(new Insets(-5, -5, -5, -5));
        nuevo.setBackground(Color.WHITE);
        nuevo.setForeground(Color.BLACK);
        nuevo.setText((y + 1) + ":" + (x + 1)); // texto ejemplo, a completar

        this.buttons[y][x] = nuevo;

        ButtonsGrid.add(nuevo);
      }
    }

    hydrate();
  }

  private void hydrate() {
    CardLayout cl = (CardLayout) (pnlRight.getLayout());

    lblArea.setText("Area " + Posicion.areaCode(areaSeleccionada));

    // Mostramos el filler en el panel de la derecha antes de actualizar
    // los botones
    cl.show(pnlRight, "filler");

    lstFuncionarios.setListData(
        sistema.getFuncionarios().stream().map(f -> f.toString()).toArray(String[]::new));

    lstArticulos.setListData(
        sistema.getArticulos().stream().map(f -> f.toString()).toArray(String[]::new));

    // Botones sin carga
    for (int y = 0; y < buttons.length; y++) {
      JButton[] row = buttons[y];
      for (int x = 0; x < row.length; x++) {
        JButton button = row[x];

        if (button.getModel().isRollover()) {
          button.setBackground(Color.RED);
          button.setForeground(Color.WHITE);
        } else {
          button.setBackground(Color.WHITE);
          button.setForeground(Color.BLACK);
        }

        removeAllActionListeners(button);
        final int _x = x;
        final int _y = y;

        button.addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent e) {

                hydrate();

                cl.show(pnlRight, "ingreso");

                removeAllActionListeners(btnIngresar);
                btnIngresar.addActionListener(
                    new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                        Funcionario f = sistema.getFuncionarios().get(lstFuncionarios.getSelectedIndex());
                        Articulo a = sistema.getArticulos().get(lstArticulos.getSelectedIndex());
                        int cantidad = Integer.parseInt(fieldIngresoCantidad.getText());
                        int codigo = Integer.parseInt(fieldIngresoCodigo.getText());

                        Posicion posicion = new Posicion(areaSeleccionada, _x, _y);

                        sistema.agregarCarga(codigo, a, f, cantidad, posicion);
                        hydrate();
                      }
                    });
              }
            });
      }
    }

    // Botones con carga
    sistema.getCargas().stream()
        .filter(c -> c.getPosicion().getArea() == areaSeleccionada)
        .forEach(
            c -> {
              Posicion p = c.getPosicion();

              JButton b = this.buttons[p.getFila()][p.getColumna()];

              removeAllActionListeners(b);
              b.addActionListener(
                  new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                      hydrate();

                      cl.show(pnlRight, "egreso");

                      lblCodigoContent.setText("" + c.getCodigo());
                      lblArticuloContent.setText(c.getArticulo().toString());
                      lblCantidadContent.setText("" + c.getCantidad());
                      lblFuncionarioContent.setText(c.getFuncionario().toString());

                      btnEgresar.addActionListener(
                          new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                              sistema.eliminarCarga(c);
                              hydrate();
                            }
                          });
                    }
                  });
            });
  }

  private void removeAllActionListeners(JButton b) {
    for (ActionListener al : b.getActionListeners()) {
      b.removeActionListener(al);
    }
  }

  private void setAreaSeleccionada(int area) {
    if (area >= 0 && area < 5) {
      this.areaSeleccionada = area;
      hydrate();
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the
   * Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        lblArea = new javax.swing.JLabel();
        ButtonsPanel = new javax.swing.JPanel();
        XLabels = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        XLabel1 = new javax.swing.JLabel();
        XLabel2 = new javax.swing.JLabel();
        XLabel3 = new javax.swing.JLabel();
        XLabel4 = new javax.swing.JLabel();
        XLabel5 = new javax.swing.JLabel();
        XLabel6 = new javax.swing.JLabel();
        XLabel7 = new javax.swing.JLabel();
        XLabel8 = new javax.swing.JLabel();
        XLabel9 = new javax.swing.JLabel();
        XLabel10 = new javax.swing.JLabel();
        YLabels = new javax.swing.JPanel();
        YLabel1 = new javax.swing.JLabel();
        YLabel2 = new javax.swing.JLabel();
        YLabel3 = new javax.swing.JLabel();
        YLabel4 = new javax.swing.JLabel();
        YLabel5 = new javax.swing.JLabel();
        YLabel6 = new javax.swing.JLabel();
        YLabel7 = new javax.swing.JLabel();
        YLabel8 = new javax.swing.JLabel();
        YLabel9 = new javax.swing.JLabel();
        YLabel10 = new javax.swing.JLabel();
        YLabel11 = new javax.swing.JLabel();
        YLabel12 = new javax.swing.JLabel();
        ButtonsGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviousAreaButton = new javax.swing.JButton();
        NextAreaButton = new javax.swing.JButton();
        pnlRight = new javax.swing.JPanel();
        pnlIngreso = new javax.swing.JPanel();
        lblIngreso = new javax.swing.JLabel();
        pnlIngresoContent = new javax.swing.JPanel();
        pnlFuncionarios = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        scrollFuncionarios = new javax.swing.JScrollPane();
        lstFuncionarios = new javax.swing.JList<>();
        pnlArticulos = new javax.swing.JPanel();
        lblArticulos = new javax.swing.JLabel();
        scrollArticulos = new javax.swing.JScrollPane();
        lstArticulos = new javax.swing.JList<>();
        pnlCantidadCodigo = new javax.swing.JPanel();
        pnlCantidad = new javax.swing.JPanel();
        lblIngresoCantidad = new javax.swing.JLabel();
        fieldIngresoCantidad = new javax.swing.JTextField();
        pnlCodigo = new javax.swing.JPanel();
        lblIngresoCodigo = new javax.swing.JLabel();
        fieldIngresoCodigo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        pnlEgreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblCodigoContent = new javax.swing.JLabel();
        lblArticulo = new javax.swing.JLabel();
        lblArticuloContent = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCantidadContent = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        lblFuncionarioContent = new javax.swing.JLabel();
        btnEgresar = new javax.swing.JButton();
        fillerRight = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso/Egreso Carga");
        setMinimumSize(new java.awt.Dimension(1200, 500));
        setPreferredSize(new java.awt.Dimension(1200, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        pnlLeft.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlLeft.setLayout(new java.awt.BorderLayout());

        lblArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArea.setText("Area: A");
        pnlLeft.add(lblArea, java.awt.BorderLayout.NORTH);

        ButtonsPanel.setLayout(new java.awt.BorderLayout());

        XLabels.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        XLabels.setLayout(new java.awt.GridLayout(1, 11));
        XLabels.add(filler1);

        XLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel1.setText("1");
        XLabels.add(XLabel1);

        XLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel2.setText("2");
        XLabels.add(XLabel2);

        XLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel3.setText("3");
        XLabels.add(XLabel3);

        XLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel4.setText("4");
        XLabels.add(XLabel4);

        XLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel5.setText("5");
        XLabels.add(XLabel5);

        XLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel6.setText("6");
        XLabels.add(XLabel6);

        XLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel7.setText("7");
        XLabels.add(XLabel7);

        XLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel8.setText("8");
        XLabels.add(XLabel8);

        XLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel9.setText("9");
        XLabels.add(XLabel9);

        XLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XLabel10.setText("10");
        XLabels.add(XLabel10);

        ButtonsPanel.add(XLabels, java.awt.BorderLayout.NORTH);

        YLabels.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        YLabels.setLayout(new java.awt.GridLayout(12, 1));

        YLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel1.setText("1");
        YLabels.add(YLabel1);

        YLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel2.setText("2");
        YLabels.add(YLabel2);

        YLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel3.setText("3");
        YLabels.add(YLabel3);

        YLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel4.setText("4");
        YLabels.add(YLabel4);

        YLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel5.setText("5");
        YLabels.add(YLabel5);

        YLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel6.setText("6");
        YLabels.add(YLabel6);

        YLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel7.setText("7");
        YLabels.add(YLabel7);

        YLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel8.setText("8");
        YLabels.add(YLabel8);

        YLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel9.setText("9");
        YLabels.add(YLabel9);

        YLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel10.setText("10");
        YLabels.add(YLabel10);

        YLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel11.setText("11");
        YLabels.add(YLabel11);

        YLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YLabel12.setText("12");
        YLabels.add(YLabel12);

        ButtonsPanel.add(YLabels, java.awt.BorderLayout.WEST);

        ButtonsGrid.setBackground(new java.awt.Color(255, 255, 153));
        ButtonsGrid.setLayout(new java.awt.GridLayout(12, 10));
        ButtonsPanel.add(ButtonsGrid, java.awt.BorderLayout.CENTER);

        pnlLeft.add(ButtonsPanel, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        PreviousAreaButton.setText("<<<");
        PreviousAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousAreaButtonActionPerformed(evt);
            }
        });
        jPanel3.add(PreviousAreaButton);

        NextAreaButton.setText(">>>");
        NextAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextAreaButtonActionPerformed(evt);
            }
        });
        jPanel3.add(NextAreaButton);

        pnlLeft.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlLeft);

        pnlRight.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        pnlRight.setToolTipText("");
        pnlRight.setLayout(new java.awt.CardLayout());

        pnlIngreso.setBackground(new java.awt.Color(51, 255, 51));
        pnlIngreso.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlIngreso.setName(""); // NOI18N
        pnlIngreso.setLayout(new java.awt.BorderLayout());

        lblIngreso.setForeground(new java.awt.Color(0, 0, 0));
        lblIngreso.setText("Ingreso");
        pnlIngreso.add(lblIngreso, java.awt.BorderLayout.NORTH);

        pnlIngresoContent.setLayout(new java.awt.GridLayout(1, 3));

        pnlFuncionarios.setBackground(new java.awt.Color(51, 255, 51));
        pnlFuncionarios.setLayout(new java.awt.BorderLayout());

        lblFuncionarios.setBackground(new java.awt.Color(0, 0, 0));
        lblFuncionarios.setForeground(new java.awt.Color(0, 0, 0));
        lblFuncionarios.setText("Funcionarios");
        pnlFuncionarios.add(lblFuncionarios, java.awt.BorderLayout.NORTH);

        lstFuncionarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollFuncionarios.setViewportView(lstFuncionarios);

        pnlFuncionarios.add(scrollFuncionarios, java.awt.BorderLayout.CENTER);

        pnlIngresoContent.add(pnlFuncionarios);

        pnlArticulos.setBackground(new java.awt.Color(51, 255, 51));
        pnlArticulos.setLayout(new java.awt.BorderLayout());

        lblArticulos.setForeground(new java.awt.Color(0, 0, 0));
        lblArticulos.setText("Artículos");
        pnlArticulos.add(lblArticulos, java.awt.BorderLayout.NORTH);

        lstArticulos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollArticulos.setViewportView(lstArticulos);

        pnlArticulos.add(scrollArticulos, java.awt.BorderLayout.CENTER);

        pnlIngresoContent.add(pnlArticulos);

        pnlCantidadCodigo.setBackground(new java.awt.Color(51, 255, 51));
        pnlCantidadCodigo.setLayout(new java.awt.GridLayout(3, 1));

        pnlCantidad.setBackground(new java.awt.Color(51, 255, 51));
        pnlCantidad.setLayout(new java.awt.GridLayout(2, 1));

        lblIngresoCantidad.setForeground(new java.awt.Color(0, 0, 0));
        lblIngresoCantidad.setText("Cantidad");
        pnlCantidad.add(lblIngresoCantidad);

        fieldIngresoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIngresoCantidadActionPerformed(evt);
            }
        });
        pnlCantidad.add(fieldIngresoCantidad);

        pnlCantidadCodigo.add(pnlCantidad);

        pnlCodigo.setBackground(new java.awt.Color(51, 255, 51));
        pnlCodigo.setLayout(new java.awt.GridLayout(2, 1));

        lblIngresoCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lblIngresoCodigo.setText("Código");
        pnlCodigo.add(lblIngresoCodigo);
        pnlCodigo.add(fieldIngresoCodigo);

        pnlCantidadCodigo.add(pnlCodigo);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        pnlCantidadCodigo.add(btnIngresar);

        pnlIngresoContent.add(pnlCantidadCodigo);

        pnlIngreso.add(pnlIngresoContent, java.awt.BorderLayout.CENTER);

        pnlRight.add(pnlIngreso, "ingreso");

        pnlEgreso.setBackground(new java.awt.Color(51, 153, 255));
        pnlEgreso.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlEgreso.setName(""); // NOI18N
        pnlEgreso.setLayout(new java.awt.BorderLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Egreso");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlEgreso.add(jLabel1, java.awt.BorderLayout.NORTH);

        pnlDatos.setBackground(new java.awt.Color(51, 153, 255));
        pnlDatos.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlDatos.setLayout(new java.awt.GridLayout(4, 2));

        lblCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigo.setLabelFor(lblCodigoContent);
        lblCodigo.setText("Código");
        lblCodigo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblCodigo);

        lblCodigoContent.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigoContent.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblCodigoContent);

        lblArticulo.setForeground(new java.awt.Color(0, 0, 0));
        lblArticulo.setLabelFor(lblArticuloContent);
        lblArticulo.setText("Artículo");
        lblArticulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblArticulo);

        lblArticuloContent.setForeground(new java.awt.Color(0, 0, 0));
        lblArticuloContent.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblArticuloContent);

        lblCantidad.setForeground(new java.awt.Color(0, 0, 0));
        lblCantidad.setLabelFor(lblCantidadContent);
        lblCantidad.setText("Cantidad");
        lblCantidad.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblCantidad);

        lblCantidadContent.setForeground(new java.awt.Color(0, 0, 0));
        lblCantidadContent.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblCantidadContent);

        lblFuncionario.setForeground(new java.awt.Color(0, 0, 0));
        lblFuncionario.setLabelFor(lblFuncionarioContent);
        lblFuncionario.setText("Funcionario");
        lblFuncionario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblFuncionario);

        lblFuncionarioContent.setForeground(new java.awt.Color(0, 0, 0));
        lblFuncionarioContent.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pnlDatos.add(lblFuncionarioContent);

        pnlEgreso.add(pnlDatos, java.awt.BorderLayout.CENTER);

        btnEgresar.setText("Egresar");
        btnEgresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresarActionPerformed(evt);
            }
        });
        pnlEgreso.add(btnEgresar, java.awt.BorderLayout.SOUTH);

        pnlRight.add(pnlEgreso, "egreso");
        pnlRight.add(fillerRight, "filler");

        getContentPane().add(pnlRight);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void PreviousAreaButtonActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_PreviousAreaButtonActionPerformed
    if (this.areaSeleccionada > 0) {
      setAreaSeleccionada(this.areaSeleccionada - 1);
    }
  } // GEN-LAST:event_PreviousAreaButtonActionPerformed

  private void NextAreaButtonActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_NextAreaButtonActionPerformed
    if (this.areaSeleccionada < 5) {
      setAreaSeleccionada(areaSeleccionada + 1);
    }
  } // GEN-LAST:event_NextAreaButtonActionPerformed

  private void btnEgresarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnEgresarActionPerformed
  } // GEN-LAST:event_btnEgresarActionPerformed

  // /**
  // * @param args the command line arguments
  // */
  // public static void main(String args[]) {
  // /* Set the Nimbus look and feel */
  // //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code
  // (optional) ">
  // /* If Nimbus (introduced in Java SE 6) is not available, stay with the
  // default look and
  // feel.
  // * For details see
  // http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
  // */
  // try {
  // for (javax.swing.UIManager.LookAndFeelInfo info :
  // javax.swing.UIManager.getInstalledLookAndFeels()) {
  // if ("Nimbus".equals(info.getName())) {
  // javax.swing.UIManager.setLookAndFeel(info.getClassName());
  // break;
  // }
  // }
  // } catch (ClassNotFoundException ex) {
  //
  // java.util.logging.Logger.getLogger(IngresoEgresoCarga.class.getName()).log(java.util.logging.Level.SEVERE,
  // null, ex);
  // } catch (InstantiationException ex) {
  //
  // java.util.logging.Logger.getLogger(IngresoEgresoCarga.class.getName()).log(java.util.logging.Level.SEVERE,
  // null, ex);
  // } catch (IllegalAccessException ex) {
  //
  // java.util.logging.Logger.getLogger(IngresoEgresoCarga.class.getName()).log(java.util.logging.Level.SEVERE,
  // null, ex);
  // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
  //
  // java.util.logging.Logger.getLogger(IngresoEgresoCarga.class.getName()).log(java.util.logging.Level.SEVERE,
  // null, ex);
  // }
  // //</editor-fold>
  //
  // /* Create and display the form */
  // java.awt.EventQueue.invokeLater(new Runnable() {
  // public void run() {
  // new IngresoEgresoCarga().setVisible(true);
  // }
  // });
  // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsGrid;
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JButton NextAreaButton;
    private javax.swing.JButton PreviousAreaButton;
    private javax.swing.JLabel XLabel1;
    private javax.swing.JLabel XLabel10;
    private javax.swing.JLabel XLabel2;
    private javax.swing.JLabel XLabel3;
    private javax.swing.JLabel XLabel4;
    private javax.swing.JLabel XLabel5;
    private javax.swing.JLabel XLabel6;
    private javax.swing.JLabel XLabel7;
    private javax.swing.JLabel XLabel8;
    private javax.swing.JLabel XLabel9;
    private javax.swing.JPanel XLabels;
    private javax.swing.JLabel YLabel1;
    private javax.swing.JLabel YLabel10;
    private javax.swing.JLabel YLabel11;
    private javax.swing.JLabel YLabel12;
    private javax.swing.JLabel YLabel2;
    private javax.swing.JLabel YLabel3;
    private javax.swing.JLabel YLabel4;
    private javax.swing.JLabel YLabel5;
    private javax.swing.JLabel YLabel6;
    private javax.swing.JLabel YLabel7;
    private javax.swing.JLabel YLabel8;
    private javax.swing.JLabel YLabel9;
    private javax.swing.JPanel YLabels;
    private javax.swing.JButton btnEgresar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JTextField fieldIngresoCantidad;
    private javax.swing.JTextField fieldIngresoCodigo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler fillerRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblArticulo;
    private javax.swing.JLabel lblArticuloContent;
    private javax.swing.JLabel lblArticulos;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadContent;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoContent;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblFuncionarioContent;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblIngreso;
    private javax.swing.JLabel lblIngresoCantidad;
    private javax.swing.JLabel lblIngresoCodigo;
    private javax.swing.JList<String> lstArticulos;
    private javax.swing.JList<String> lstFuncionarios;
    private javax.swing.JPanel pnlArticulos;
    private javax.swing.JPanel pnlCantidad;
    private javax.swing.JPanel pnlCantidadCodigo;
    private javax.swing.JPanel pnlCodigo;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlEgreso;
    private javax.swing.JPanel pnlFuncionarios;
    private javax.swing.JPanel pnlIngreso;
    private javax.swing.JPanel pnlIngresoContent;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JScrollPane scrollArticulos;
    private javax.swing.JScrollPane scrollFuncionarios;
    // End of variables declaration//GEN-END:variables
}
