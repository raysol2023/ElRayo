package com.elrayo.vista;

import java.awt.Color;

public class DatosPedido extends javax.swing.JPanel {

    public DatosPedido() {
        initComponents();
        InitStyles();
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: light $h1.regular.font");
        title.setForeground(Color.black);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        apPLbl = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        apMLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        domLbl = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        cboPedidos = new javax.swing.JComboBox<>();
        txtDni1 = new javax.swing.JTextField();
        apPLbl1 = new javax.swing.JLabel();
        txtDni2 = new javax.swing.JTextField();
        apMLbl1 = new javax.swing.JLabel();
        cboPedidos1 = new javax.swing.JComboBox<>();
        domLbl1 = new javax.swing.JLabel();
        txtDomicilio1 = new javax.swing.JTextField();
        apMLbl2 = new javax.swing.JLabel();
        cboPedidos2 = new javax.swing.JComboBox<>();
        apPLbl2 = new javax.swing.JLabel();
        txtDni3 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 510));

        title.setText("Datos del pedido");

        nameLbl.setText("Seleccione el cliente");

        apPLbl.setText("Nombre");

        apMLbl.setText("WhatsApp");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        domLbl.setText("Importe del delivery");

        txtDomicilio.setToolTipText("");

        btnRegistrar.setBackground(new java.awt.Color(18, 90, 173));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Ver resumen");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cboPedidos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPedidosItemStateChanged(evt);
            }
        });
        cboPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPedidosMouseClicked(evt);
            }
        });

        apPLbl1.setText("Doreccion de entrega");

        apMLbl1.setText("Restaurante");

        cboPedidos1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPedidos1ItemStateChanged(evt);
            }
        });
        cboPedidos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPedidos1MouseClicked(evt);
            }
        });

        domLbl1.setText("Importe del pedido");

        txtDomicilio1.setToolTipText("");

        apMLbl2.setText("Motorizado");

        cboPedidos2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPedidos2ItemStateChanged(evt);
            }
        });
        cboPedidos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPedidos2MouseClicked(evt);
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
                                    .addComponent(cboPedidos1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDni2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboPedidos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                        .addComponent(apPLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(182, 182, 182))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                        .addComponent(apMLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(180, 180, 180))
                                    .addComponent(txtDni)
                                    .addComponent(txtDni1))
                                .addGap(68, 68, 68)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDomicilio)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDomicilio1)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(domLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(domLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(220, 220, 220))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(apMLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(118, 118, 118))
                            .addComponent(cboPedidos2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(apPLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addComponent(txtDni3, javax.swing.GroupLayout.Alignment.TRAILING))
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
                        .addComponent(cboPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apPLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apMLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDni1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apPLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(txtDni2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apMLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(domLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(domLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDomicilio1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(apMLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPedidos2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(apPLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(txtDni3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnRegistrar))
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cboPedidosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPedidosItemStateChanged
        String tipoPedido = cboPedidos.getSelectedItem().toString();

        switch (tipoPedido) {
            case "Regular":
            Dashboard.ShowJPanelheader(new TPRegular());
            break;
            case "Courrier":
            Dashboard.ShowJPanelheader(new TPCourrier());
            break;
            case "Hora":
            Dashboard.ShowJPanelheader(new TPHora());
            break;
            case "Comision":
            Dashboard.ShowJPanelheader(new TPComision());
            break;
            case "Tarifa Plana":
            Dashboard.ShowJPanelheader(new TPPlana());
            break;
        }
    }//GEN-LAST:event_cboPedidosItemStateChanged

    private void cboPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPedidosMouseClicked

    }//GEN-LAST:event_cboPedidosMouseClicked

    private void cboPedidos1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPedidos1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPedidos1ItemStateChanged

    private void cboPedidos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPedidos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPedidos1MouseClicked

    private void cboPedidos2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPedidos2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPedidos2ItemStateChanged

    private void cboPedidos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPedidos2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPedidos2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apMLbl;
    private javax.swing.JLabel apMLbl1;
    private javax.swing.JLabel apMLbl2;
    private javax.swing.JLabel apPLbl;
    private javax.swing.JLabel apPLbl1;
    private javax.swing.JLabel apPLbl2;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboPedidos;
    private javax.swing.JComboBox<String> cboPedidos1;
    private javax.swing.JComboBox<String> cboPedidos2;
    private javax.swing.JLabel domLbl;
    private javax.swing.JLabel domLbl1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDni1;
    private javax.swing.JTextField txtDni2;
    private javax.swing.JTextField txtDni3;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtDomicilio1;
    // End of variables declaration//GEN-END:variables
}
