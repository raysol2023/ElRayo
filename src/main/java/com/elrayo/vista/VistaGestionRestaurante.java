package com.elrayo.vista;

import com.elrayo.dao.RestauranteDAO;
import com.elrayo.entidad.Restaurante;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaGestionRestaurante extends javax.swing.JFrame {

    public VistaGestionRestaurante() {
        initComponents();
        cargarTabla();
        
    }

    public void cargarTabla() {
        RestauranteDAO dao = new RestauranteDAO();
        List<Restaurante> lista = dao.obtenerTodos();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Convenio");

        for (Restaurante r : lista) {
            Object[] fila = {
                r.getNombre(),
                r.getDireccion(),
                r.getTelefono(),
                r.isTieneConvenio() ? "Sí" : "No"
            };
            modelo.addRow(fila);
        }

        TablaRestaurantes.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaRestaurantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        TablaRestaurantes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaRestaurantes);

        jLabel1.setText("GESTION DE REGISTRO DE RESTAURANTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBuscar)
                        .addComponent(btnEditar)
                        .addComponent(btnCrear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnCrear)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila = TablaRestaurantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona una fila para eliminar.");
            return;
        }

        String nombre = TablaRestaurantes.getValueAt(fila, 0).toString();

        int confirmar = JOptionPane.showConfirmDialog(this, "¿Eliminar restaurante \"" + nombre + "\"?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) {
            return;
        }

        RestauranteDAO dao = new RestauranteDAO();
        if (dao.eliminarPorNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "✅ Eliminado.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al eliminar.");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = TablaRestaurantes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona una fila para editar.");
            return;
        }

        String nombre = TablaRestaurantes.getValueAt(fila, 0).toString();
        String direccionActual = TablaRestaurantes.getValueAt(fila, 1).toString();
        String telefonoActual = TablaRestaurantes.getValueAt(fila, 2).toString();
        String convenioActual = TablaRestaurantes.getValueAt(fila, 3).toString();

        String nuevaDireccion = JOptionPane.showInputDialog(this, "📍 Nueva dirección:", direccionActual);
        if (nuevaDireccion == null) {
            return;
        }

        String nuevoTelefono = JOptionPane.showInputDialog(this, "📞 Nuevo teléfono:", telefonoActual);
        if (nuevoTelefono == null) {
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this, "¿Tiene convenio?", "Convenio", JOptionPane.YES_NO_OPTION);
        boolean nuevoConvenio = (resp == JOptionPane.YES_OPTION);

        Restaurante actualizado = new Restaurante(nombre, nuevoTelefono, nuevaDireccion, nuevoConvenio);
        RestauranteDAO dao = new RestauranteDAO();
        if (dao.actualizar(actualizado)) {
            JOptionPane.showMessageDialog(this, "✅ Restaurante actualizado.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al actualizar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String filtro = JOptionPane.showInputDialog(this, "🔎 Buscar por nombre o teléfono:");
        if (filtro == null || filtro.trim().isEmpty()) {
            return;
        }

        RestauranteDAO dao = new RestauranteDAO();
        List<Restaurante> resultados = dao.buscar(filtro.trim());

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❌ No se encontró ningún restaurante.");
            return;
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Convenio");

        for (Restaurante r : resultados) {
            modelo.addRow(new Object[]{
                r.getNombre(),
                r.getDireccion(),
                r.getTelefono(),
                r.isTieneConvenio() ? "Sí" : "No"
            });
        }

        TablaRestaurantes.setModel(modelo);
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestionRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestionRestaurante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaRestaurantes;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
