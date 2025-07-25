package com.elrayo.vista;

import com.elrayo.controlador.ControladorCliente;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class Central extends javax.swing.JPanel {

    ControladorCliente objControladorCliente = new ControladorCliente();

    public Central() throws Exception {
        initComponents();
        InitStyles();
    }

    private void InitStyles() {
        Central.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        Central.setForeground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        Central = new javax.swing.JLabel();
        Central1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(25, 117, 210));
        bg.setPreferredSize(new java.awt.Dimension(750, 60));

        Central.setIcon(new javax.swing.ImageIcon(getClass().getResource("/food-delivery-man-motorcycle-white-icon.png"))); // NOI18N
        Central.setText("Central de delivery El Rayo");
        Central.setIconTextGap(13);

        Central1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(Central)
                .addGap(18, 18, 18)
                .addComponent(Central1)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Central, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Central1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Central;
    private javax.swing.JLabel Central1;
    private javax.swing.JPanel bg;
    // End of variables declaration//GEN-END:variables
}
