package com.elrayo.vista;

import com.elrayo.entidad.Motorizado;
import com.elrayo.dao.MotorizadoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaGestionMotorizado extends javax.swing.JFrame {

    public VistaGestionMotorizado() {
        initComponents();
        cargarTabla();
    }

    public void cargarTabla() {
        MotorizadoDAO dao = new MotorizadoDAO();
        List<Motorizado> lista = dao.obtenerTodos();

        DefaultTableModel modelo = new DefaultTableModel(
                new String[]{"Nombre", "Teléfono", "DNI", "Activo"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 2; 
            }
        };

        for (Motorizado m : lista) {
            Object[] fila = {
                m.getNombre(),
                m.getTelefono(),
                m.getDni(),
                m.isActivo() ? "Sí" : "No"
            };
            modelo.addRow(fila);
        }

        TablaMotorizado.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaMotorizado = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setText("GESTION DE MOTORIZADOS");

        TablaMotorizado.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaMotorizado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMotorizadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaMotorizado);

        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("BORRAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar))
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String dniBuscar = JOptionPane.showInputDialog(this, "🔍 Ingresa el DNI del motorizado a buscar:");

    if (dniBuscar == null || dniBuscar.trim().isEmpty()) {
        return;
    }

    int filaEncontrada = -1;

    for (int i = 0; i < TablaMotorizado.getRowCount(); i++) {
        String dniTabla = TablaMotorizado.getValueAt(i, 2).toString();

        if (dniTabla.equalsIgnoreCase(dniBuscar.trim())) {
            filaEncontrada = i;
            break;
        }
    }

    if (filaEncontrada != -1) {
        TablaMotorizado.setRowSelectionInterval(filaEncontrada, filaEncontrada);
        TablaMotorizado.scrollRectToVisible(TablaMotorizado.getCellRect(filaEncontrada, 0, true));
    } else {
        JOptionPane.showMessageDialog(this, "❌ No se encontró el motorizado con DNI: " + dniBuscar);
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = TablaMotorizado.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona un motorizado para eliminar.");
            return;
        }

     
        String dni = TablaMotorizado.getValueAt(fila, 2).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de eliminar al motorizado con DNI: " + dni + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            MotorizadoDAO dao = new MotorizadoDAO();
            boolean exito = dao.eliminarPorDni(dni);

            if (exito) {
                JOptionPane.showMessageDialog(this, "✅ Motorizado eliminado correctamente.");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "❌ No se pudo eliminar.");
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Detectar fila
        int fila = TablaMotorizado.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona una fila para editar.");
            return;
        }


        String nombre = TablaMotorizado.getValueAt(fila, 0).toString();
        String telefono = TablaMotorizado.getValueAt(fila, 1).toString();
        String dni = TablaMotorizado.getValueAt(fila, 2).toString();
        String activoStr = TablaMotorizado.getValueAt(fila, 3).toString();
        boolean activo = activoStr.equalsIgnoreCase("Sí");


        Motorizado m = new Motorizado(dni, activo, nombre, telefono);
        MotorizadoDAO dao = new MotorizadoDAO();
        boolean exito = dao.actualizar(m);

        if (exito) {
            JOptionPane.showMessageDialog(this, "✅ Motorizado actualizado correctamente.");
            cargarTabla(); 
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al actualizar motorizado.");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void TablaMotorizadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMotorizadoMouseClicked
      int fila = TablaMotorizado.getSelectedRow();
    if (fila != -1) {
        btnEditar.setEnabled(true); 
    }
    }//GEN-LAST:event_TablaMotorizadoMouseClicked

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        VistaRegistroMotorizado ventanaRegistro = new VistaRegistroMotorizado(this);
ventanaRegistro.setLocationRelativeTo(this);
ventanaRegistro.setVisible(true); 

    }//GEN-LAST:event_btnCrearActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestionMotorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMotorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMotorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionMotorizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestionMotorizado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMotorizado;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
