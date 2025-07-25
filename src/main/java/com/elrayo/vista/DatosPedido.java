package com.elrayo.vista;

import com.elrayo.controlador.ControladorCliente;
import com.elrayo.controlador.ControladorMotorizado;
import com.elrayo.controlador.ControladorRestaurante;

import com.elrayo.entidad.Cliente;
import com.elrayo.entidad.ComandaTemporal;
import com.elrayo.entidad.Restaurante;
import com.elrayo.entidad.Motorizado;
import com.elrayo.entidad.SesionComanda;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatosPedido extends javax.swing.JPanel {

    ControladorCliente objControladorCliente = new ControladorCliente();
    ControladorMotorizado objControladorMotorizado = new ControladorMotorizado();
    ControladorRestaurante objControladorRestaurante = new ControladorRestaurante();

    public DatosPedido() throws Exception {
        initComponents();
        InitStyles();
        cargarClientes();
        cargarRestaurantes();
        cargarMotorizados();
        importes();
    }

    private void InitStyles() throws Exception {
        title.putClientProperty("FlatLaf.style", "font: light $h1.regular.font");
        title.setForeground(Color.black);
    }

    void cargarClientes() throws Exception {
        List<Cliente> listaClientes = objControladorCliente.mostrarClientes("");

        for (Cliente cliente : listaClientes) {
            cboCliente.addItem(cliente);
        }
    }

    void cargarRestaurantes() throws Exception {
        List<Restaurante> listaRestaurantes = objControladorRestaurante.mostrarRestaurantes("");

        for (Restaurante restaurante : listaRestaurantes) {
            cboRestaurant.addItem(restaurante);
        }
    }

    void cargarMotorizados() throws Exception {
        List<Motorizado> listaMotorizados = objControladorMotorizado.mostrarMotorizados("");

        for (Motorizado motorizado : listaMotorizados) {
            cboMotorizados.addItem(motorizado);
        }
    }
    
    void importes(){
        txtImporte.setText(String.valueOf(SesionComanda.getComanda().getMontoPedido()));
        txtDelivery.setText(String.valueOf(SesionComanda.getComanda().getMontoDelivery()));
    }
    
    void resumen(){
        double totalPedido = SesionComanda.getComanda().getMontoPedido()+SesionComanda.getComanda().getMontoDelivery();
        Cliente clienteSeleccionado = (Cliente) cboCliente.getSelectedItem();
        Restaurante restaurantSeleccionado = (Restaurante) cboRestaurant.getSelectedItem();
        Motorizado motorizadoSeleccionado = (Motorizado) cboMotorizados.getSelectedItem();
        SesionComanda.setIdCliente(clienteSeleccionado);
        SesionComanda.setIdRestaurante(restaurantSeleccionado);
        SesionComanda.setIdMotorizado(motorizadoSeleccionado);
        SesionComanda.setObservacion(txtOservacion.getText());
        SesionComanda.setTarifaTotal(totalPedido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        apPLbl = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        apMLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        domLbl = new javax.swing.JLabel();
        txtDelivery = new javax.swing.JTextField();
        btnResumen = new javax.swing.JButton();
        cboCliente = new javax.swing.JComboBox<>();
        txtWhatsApp = new javax.swing.JTextField();
        apPLbl1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        apMLbl1 = new javax.swing.JLabel();
        cboRestaurant = new javax.swing.JComboBox<>();
        domLbl1 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        apMLbl2 = new javax.swing.JLabel();
        cboMotorizados = new javax.swing.JComboBox<>();
        apPLbl2 = new javax.swing.JLabel();
        txtOservacion = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(750, 510));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 510));

        title.setText("Datos del pedido");

        nameLbl.setText("Seleccione el cliente");

        apPLbl.setText("Nombre del cliente");

        apMLbl.setText("WhatsApp del cliente");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        domLbl.setText("Importe del delivery");

        txtDelivery.setToolTipText("");

        btnResumen.setBackground(new java.awt.Color(18, 90, 173));
        btnResumen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnResumen.setForeground(new java.awt.Color(255, 255, 255));
        btnResumen.setText("Ver resumen");
        btnResumen.setBorderPainted(false);
        btnResumen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenActionPerformed(evt);
            }
        });

        cboCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboClienteItemStateChanged(evt);
            }
        });
        cboCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboClienteMouseClicked(evt);
            }
        });

        apPLbl1.setText("Doreccion de entrega");

        apMLbl1.setText("Restaurante");

        cboRestaurant.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboRestaurantItemStateChanged(evt);
            }
        });
        cboRestaurant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboRestaurantMouseClicked(evt);
            }
        });

        domLbl1.setText("Importe del pedido");

        txtImporte.setToolTipText("");

        apMLbl2.setText("Motorizado");

        cboMotorizados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMotorizadosItemStateChanged(evt);
            }
        });
        cboMotorizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMotorizadosMouseClicked(evt);
            }
        });

        apPLbl2.setText("Observacion");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(553, 553, 553))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(apPLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(188, 188, 188))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(apMLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboRestaurant, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(txtWhatsApp)
                                    .addComponent(apPLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(apMLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDelivery)
                            .addComponent(btnResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtImporte)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(domLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(domLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(220, 220, 220))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(apMLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(118, 118, 118))
                            .addComponent(cboMotorizados, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(apPLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addComponent(txtOservacion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(72, 72, 72))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apPLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apMLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apPLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apMLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(domLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(domLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(apMLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMotorizados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(apPLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(txtOservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnResumen))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenActionPerformed
        resumen();
        try {
            Dashboard.ShowJPanelContent(new ResumenPedidos());
        } catch (Exception ex) {
            Logger.getLogger(DatosPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResumenActionPerformed

    private void cboClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboClienteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Cliente clienteSeleccionado = (Cliente) cboCliente.getSelectedItem();
            if (clienteSeleccionado != null) {
                txtNombre.setText(clienteSeleccionado.getNombre());
                txtWhatsApp.setText(clienteSeleccionado.getTelefono());
                txtDireccion.setText(clienteSeleccionado.getDireccion());
            }
        }
    }//GEN-LAST:event_cboClienteItemStateChanged

    private void cboClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboClienteMouseClicked

    }//GEN-LAST:event_cboClienteMouseClicked

    private void cboRestaurantItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboRestaurantItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRestaurantItemStateChanged

    private void cboRestaurantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboRestaurantMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRestaurantMouseClicked

    private void cboMotorizadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMotorizadosItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMotorizadosItemStateChanged

    private void cboMotorizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMotorizadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMotorizadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apMLbl;
    private javax.swing.JLabel apMLbl1;
    private javax.swing.JLabel apMLbl2;
    private javax.swing.JLabel apPLbl;
    private javax.swing.JLabel apPLbl1;
    private javax.swing.JLabel apPLbl2;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnResumen;
    private javax.swing.JComboBox<Cliente> cboCliente;
    private javax.swing.JComboBox<Motorizado> cboMotorizados;
    private javax.swing.JComboBox<Restaurante> cboRestaurant;
    private javax.swing.JLabel domLbl;
    private javax.swing.JLabel domLbl1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtDelivery;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOservacion;
    private javax.swing.JTextField txtWhatsApp;
    // End of variables declaration//GEN-END:variables
}
