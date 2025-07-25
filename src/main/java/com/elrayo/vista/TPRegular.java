package com.elrayo.vista;

import java.awt.Color;

public class TPRegular extends javax.swing.JPanel {

    public TPRegular() {
        initComponents();
        InitStyles();    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: light $h4.regular.font");
        title.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        addButton1 = new javax.swing.JButton();
        txtNombre1 = new javax.swing.JTextField();
        nameLbl2 = new javax.swing.JLabel();
        addButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 150));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        title.setText("Tarifa Regular: S/ 2 por Km. Con una base de S/ 6.00");

        nameLbl.setText("Disntancia Km");

        addButton1.setBackground(new java.awt.Color(18, 90, 173));
        addButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton1.setForeground(new java.awt.Color(255, 255, 255));
        addButton1.setText("Calcular");
        addButton1.setBorderPainted(false);
        addButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        nameLbl2.setText("Monto S/");

        addButton2.setBackground(new java.awt.Color(18, 90, 173));
        addButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton2.setForeground(new java.awt.Color(255, 255, 255));
        addButton2.setText("Siguente");
        addButton2.setBorderPainted(false);
        addButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addGap(18, 18, 18)
                        .addComponent(addButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(nameLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(208, 208, 208)
                        .addComponent(addButton2)
                        .addGap(45, 45, 45)))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton1)
                        .addComponent(addButton2)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton1ActionPerformed

    private void addButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2ActionPerformed
        Dashboard.ShowJPanelContent(new DatosPedido());
    }//GEN-LAST:event_addButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JButton addButton2;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl2;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    // End of variables declaration//GEN-END:variables
}
