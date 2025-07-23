package com.elrayo.vista;

import com.elrayo.controlador.ControladorComanda;
import com.elrayo.dao.ClienteDAO;
import com.elrayo.dao.ComandaDAO;
import com.elrayo.dao.RestauranteDAO;
import com.elrayo.entidad.Cliente;
import com.elrayo.entidad.Comanda;
import com.elrayo.entidad.Restaurante;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaGestionComanda extends javax.swing.JFrame {

    private JComboBox<Cliente> cbxCliente;
    private JComboBox<Restaurante> cbxRestaurante;

    public VistaGestionComanda() {
        initComponents();
        cbxCliente = new JComboBox<>();
        cbxRestaurante = new JComboBox<>();

        cbxCliente.setBounds(130, 35, 200, 30);
        cbxRestaurante.setBounds(130, 90, 200, 30);

        add(cbxCliente);
        add(cbxRestaurante);

        cargarClientes();
        cargarRestaurantes();
        cargarTabla();

    }

    private void cargarClientes() {
//        ClienteDAO dao = new ClienteDAO();
//        List<Cliente> lista = dao.ObtenerTodos();
//        cbxCliente.removeAllItems();
//        cbxCliente.addItem(null);
//        for (Cliente c : lista) {
//            cbxCliente.addItem(c);
//        }
    }

    private void cargarRestaurantes() {
        RestauranteDAO dao = new RestauranteDAO();
        List<Restaurante> lista = dao.obtenerTodos();
        cbxRestaurante.removeAllItems();
        cbxRestaurante.addItem(null);

        for (Restaurante r : lista) {
            cbxRestaurante.addItem(r);
        }
    }

    private void cargarTabla() {
        ComandaDAO dao = new ComandaDAO();
        List<Comanda> lista = dao.obtenerTodas();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("Restaurante");
        modelo.addColumn("Compra");
        modelo.addColumn("Distancia (km)");
        modelo.addColumn("Tarifa (S/.)");
        modelo.addColumn("Fecha");

        for (Comanda c : lista) {
            Object[] fila = {
                c.getIdComanda(),
                c.getCliente() != null ? c.getCliente().getNombre() : "(sin cliente)",
                c.getRestaurante() != null ? c.getRestaurante().getNombre() : "(sin restaurante)",
                c.isRequiereCompra() ? "Sí" : "No",
                c.getDistanciaKm(),
                c.getTarifaTotal(),
                c.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            };
            modelo.addRow(fila);
        }

        tablaComandas.setModel(modelo);

        tablaComandas.getColumnModel().getColumn(6).setMinWidth(150);
        tablaComandas.getColumnModel().getColumn(6).setMaxWidth(150);
        tablaComandas.getColumnModel().getColumn(6).setWidth(150);
        tablaComandas.getColumnModel().getColumn(4).setMinWidth(100);
        tablaComandas.getColumnModel().getColumn(4).setMaxWidth(100);
        tablaComandas.getColumnModel().getColumn(4).setWidth(100);
        tablaComandas.getColumnModel().getColumn(0).setMinWidth(40);
        tablaComandas.getColumnModel().getColumn(0).setMaxWidth(40);
        tablaComandas.getColumnModel().getColumn(0).setWidth(40);
    }

    private int obtenerIdComandaDesdeFila(int fila) {
        return Integer.parseInt(tablaComandas.getValueAt(fila, 0).toString()); // ID está en la columna 0
    }

    private String quitarTildes(String texto) {
        if (texto == null) {
            return "";
        }
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return patron.matcher(normalizado).replaceAll("").toLowerCase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxRequiereCompra = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtDistancia = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComandas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("REGISTRO COMANDA");

        jLabel2.setText("Cliente           :");

        jLabel3.setText("Restaurante :");

        jLabel4.setText("¿REQUIERE COMPRA?");

        jLabel5.setText("Distancia     :");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaComandas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaComandas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel3)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 268, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel4)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxRequiereCompra)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxRequiereCompra)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Cliente cliente = (Cliente) cbxCliente.getSelectedItem();
        System.out.println("🟡 ID del cliente seleccionado: " + cliente.getId());
        Restaurante restaurante = (Restaurante) cbxRestaurante.getSelectedItem();
        boolean requiereCompra = cbxRequiereCompra.isSelected();

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona un cliente.");
            return;
        }
        System.out.println("🟡 ID del cliente seleccionado: " + cliente.getId());

        String distanciaStr = txtDistancia.getText().trim();
        if (distanciaStr.isEmpty() || !distanciaStr.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "⚠ Ingresa una distancia válida.");
            return;
        }

        double distancia = Double.parseDouble(distanciaStr);

        Comanda comanda = new Comanda();
        comanda.setIdCliente(cliente.getId());
        comanda.setIdRestaurante(restaurante != null ? restaurante.getId() : null);
        comanda.setRequiereCompra(requiereCompra);
        comanda.setDistanciaKm(distancia);
        comanda.setFechaHora(LocalDateTime.now());

        ControladorComanda controlador = new ControladorComanda();
        if (controlador.registrarComanda(comanda)) {
            JOptionPane.showMessageDialog(this, "✅ Comanda registrada.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al registrar.");
        }

        txtDistancia.setText("");
        cbxRequiereCompra.setSelected(false);
        cbxCliente.setSelectedIndex(0);
        cbxRestaurante.setSelectedIndex(0);


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaComandas.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "⚠ Selecciona una comanda para eliminar.");
            return;
        }

        int idComanda = obtenerIdComandaDesdeFila(fila);
        ComandaDAO dao = new ComandaDAO();

        if (dao.eliminarPorId(idComanda)) {
            JOptionPane.showMessageDialog(this, "✅ Comanda eliminada correctamente.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "❌ No se pudo eliminar la comanda.");
        }
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta comanda?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String criterio = JOptionPane.showInputDialog(this, "🔎 Ingrese el nombre del cliente o fecha (YYYY-MM-DD):");
        if (criterio == null || criterio.trim().isEmpty()) {
            return;
        }

        criterio = quitarTildes(criterio);

        DefaultTableModel modelo = (DefaultTableModel) tablaComandas.getModel();
        boolean encontrado = false;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String cliente = quitarTildes(modelo.getValueAt(i, 1).toString()); // columna cliente
            String fecha = modelo.getValueAt(i, 6).toString().toLowerCase();   // columna fecha

            if (cliente.contains(criterio) || fecha.contains(criterio)) {
                tablaComandas.setRowSelectionInterval(i, i);
                tablaComandas.scrollRectToVisible(tablaComandas.getCellRect(i, 0, true));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "❌ No se encontró ninguna comanda con ese criterio.");
        }
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
            java.util.logging.Logger.getLogger(VistaGestionComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestionComanda().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox cbxRequiereCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaComandas;
    private javax.swing.JTextField txtDistancia;
    // End of variables declaration//GEN-END:variables
}
