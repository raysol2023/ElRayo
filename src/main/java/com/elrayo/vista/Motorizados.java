package com.elrayo.vista;

import com.elrayo.vista.MotorizadosUp;
import com.elrayo.controlador.ControladorMotorizado;
import com.elrayo.entidad.Motorizado;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Motorizados extends javax.swing.JPanel {

    ControladorMotorizado objControladorMotorizado = new ControladorMotorizado();

    DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Dni", "Telefono", "Estado"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column != 3; // WhatsApp = columna 5 (index 5)
        }
    };

    public Motorizados() throws Exception {
        initComponents();
        cargarTabla("");

        tbMotorizado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbMotorizado.setRowHeight(30);

        // Alinea los encabezados a la izquierda
        JTableHeader header = tbMotorizado.getTableHeader();
        DefaultTableCellRenderer leftRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        InitStyles();

        SwingUtilities.invokeLater(() -> ajustarColumnasPorPorcentaje());

        JScrollPane scrollPane = (JScrollPane) tbMotorizado.getParent().getParent();
        scrollPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ajustarColumnasPorPorcentaje();
            }
        });

    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: light $h1.regular.font");
        title.setForeground(Color.black);
    }

    public void cargarTabla(String busqueda) throws Exception {
        List<Motorizado> lista = objControladorMotorizado.mostrarMotorizados(busqueda);
        modelo.setRowCount(0); // Limpia la tabla

        for (Motorizado m : lista) {
            Object[] fila = {
                m.getIdMotorizado(), // ID (oculto)
                m.getNombre(),
                m.getDni(),
                m.getTelefono(),
                m.isActivo(),
                "Ver"
            };
            modelo.addRow(fila);
        }

        tbMotorizado.setModel(modelo);
        tbMotorizado.setRowHeight(30);

        // Ocultar la columna ID (index 0)
        tbMotorizado.getColumnModel().getColumn(0).setMinWidth(0);
        tbMotorizado.getColumnModel().getColumn(0).setMaxWidth(0);
        tbMotorizado.getColumnModel().getColumn(0).setWidth(0);

        //agregarBotonWhatsApp(tbMotorizado, 3, 5); // Teléfono está en columna 3, botón en columna 5
    }

    public void ajustarColumnasPorPorcentaje() {
        int totalWidth = tbMotorizado.getParent().getWidth();
        if (totalWidth <= 0) {
            return;
        }

        // Omitimos la columna ID (columna 0)
        int[] porcentajes = {25, 10, 15, 35, 15}; // Para columnas 1 a 5

        for (int i = 0; i < porcentajes.length; i++) {
            int ancho = (totalWidth * porcentajes[i]) / 100;
            tbMotorizado.getColumnModel().getColumn(i + 1).setPreferredWidth(ancho); // desplazado por la columna 0
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMotorizado = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        title.setText("Motorizados");

        btnBuscar.setBackground(new java.awt.Color(18, 90, 173));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tbMotorizado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tbMotorizado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dni", "Teléfono", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbMotorizado.getTableHeader().setReorderingAllowed(false);
        tbMotorizado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbMotorizadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbMotorizado);

        btnEliminar.setBackground(new java.awt.Color(18, 90, 173));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Borrar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(18, 90, 173));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(18, 90, 173));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(427, 427, 427)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(txtBusqueda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addGap(50, 50, 50))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            cargarTabla(txtBusqueda.getText());
            System.out.println("Tabla cargada");
        } catch (Exception ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la tabla: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbMotorizadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMotorizadoMousePressed

    }//GEN-LAST:event_tbMotorizadoMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tbMotorizado.getSelectedRows().length < 1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar uno o más motorizados a eliminar.\n", "AVISO", JOptionPane.ERROR_MESSAGE);
        } else {
            // Recorre en orden descendente para evitar errores al eliminar filas mientras iteras
            int[] filas = tbMotorizado.getSelectedRows();
            Arrays.sort(filas);
            for (int j = filas.length - 1; j >= 0; j--) {
                int i = filas[j];
                int idMotorizado = (int) tbMotorizado.getValueAt(i, 0);

                try {
                    if (objControladorMotorizado.tieneComandas(idMotorizado)) {
                        JOptionPane.showMessageDialog(this, "No puedes eliminar al motorizado con ID " + idMotorizado + " porque tiene comandas registradas.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    objControladorMotorizado.eliminar(idMotorizado);
                    modelo.removeRow(i);
                } catch (Exception e) {
                    System.out.println("Error eliminando motorizado: " + e.getMessage());
                }
            }

            try {
                cargarTabla("");
            } catch (Exception ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tbMotorizado.getSelectedRow() > -1) {
            try {
                int id_motorizado = (int) tbMotorizado.getValueAt(tbMotorizado.getSelectedRow(), 0);
                //Dashboard.ShowJPanel(new MotorizadosUp(objControladorMotorizado.editarUnMotorizado(id_motorizado));
//                System.out.println(clienteId);
//                System.out.println(objControladorCliente.editarUnCliente(clienteId).toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar el motorizado a editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
            //Dashboard.ShowJPanel(new MotorizadosUp());
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMotorizado;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
