package com.elrayo.vista;

import com.elrayo.dao.ClienteDAO;
import com.elrayo.entidad.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaGestionCliente extends javax.swing.JFrame {

    public VistaGestionCliente() {
        initComponents();
        cargarTabla();
    }

    private void cargarTabla() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.ObtenerTodos();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");

        for (Cliente c : lista) {
            Object[] fila = {
                c.getNombre(),
                c.getTelefono(),
                c.getDireccion()
            };
            modelo.addRow(fila);
        }

        TablaClientes.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gestion Cliente");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(btnCrear)
                            .addComponent(btnEditar)
                            .addComponent(btnBorrar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCrear)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String filtro = JOptionPane.showInputDialog(this, "🔎 Ingrese nombre o teléfono:");
        if (filtro == null || filtro.trim().isEmpty()) {
            return;
        }

        ClienteDAO dao = new ClienteDAO();
        List<Cliente> resultado = dao.buscar(filtro.trim());

        if (resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ No se encontró ningún cliente.");
            return;
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");

        for (Cliente c : resultado) {
            modelo.addRow(new Object[]{c.getNombre(), c.getTelefono(), c.getDireccion()});
        }

        TablaClientes.setModel(modelo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila = TablaClientes.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona una fila para eliminar.");
            return;
        }

        String nombre = TablaClientes.getValueAt(fila, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar al cliente \"" + nombre + "\"?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        ClienteDAO dao = new ClienteDAO();
        if (dao.eliminarPorNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "✅ Cliente eliminado.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al eliminar cliente.");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = TablaClientes.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona una fila para editar.");
            return;
        }

        String nombre = TablaClientes.getValueAt(fila, 0).toString();
        String telefono = TablaClientes.getValueAt(fila, 1).toString();
        String direccion = TablaClientes.getValueAt(fila, 2).toString();

        String nuevoNombre = JOptionPane.showInputDialog(this, "? Nuevo Nombre:", nombre);
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            return;
        }
        String nuevoTelefono = JOptionPane.showInputDialog(this, "📞 Nuevo teléfono:", telefono);
        if (nuevoTelefono == null || nuevoTelefono.trim().isEmpty()) {
            return;
        }

        String nuevaDireccion = JOptionPane.showInputDialog(this, "🏠 Nueva dirección:", direccion);
        if (nuevaDireccion == null || nuevaDireccion.trim().isEmpty()) {
            return;
        }

        Cliente objCliente = new Cliente("", nombre, nuevoTelefono.trim(), nuevaDireccion.trim());

//    Cliente c = new Cliente(nombre, nuevoTelefono.trim(), nuevaDireccion.trim());
        ClienteDAO dao = new ClienteDAO();

        if (dao.actualizar(objCliente)) {
            JOptionPane.showMessageDialog(this, "✅ Cliente actualizado.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ No se pudo actualizar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
        int fila = TablaClientes.getSelectedRow();
        if (fila != -1) {
            btnEditar.setEnabled(true);
        }
    }//GEN-LAST:event_TablaClientesMouseClicked

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
            java.util.logging.Logger.getLogger(VistaGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
