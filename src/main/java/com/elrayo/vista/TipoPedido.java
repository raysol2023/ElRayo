package com.elrayo.vista;
import com.elrayo.vista.Dashboard;

import com.elrayo.controlador.ControladorCliente;
import com.elrayo.entidad.SesionComanda;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class TipoPedido extends javax.swing.JPanel {

    public TipoPedido() throws Exception {
        initComponents();
        InitStyles();
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: light $h2.regular.font");
        title.setForeground(Color.black);
    }
    
    void showOptions(){
        String optionSelected = cboPedidos.getSelectedItem().toString();
        Dashboard.ShowJPanelContent(new Pedidos());
        SesionComanda.setTipoPedido(optionSelected);

        switch (optionSelected) {
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        cboPedidos = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(750, 60));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 60));

        title.setText("Tipos de pedidos: Selecciona uno");

        cboPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Courrier", "Hora", "Comision", "Tarifa Plana" }));
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

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(cboPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(37, 37, 37))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cboPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPedidosMouseClicked
        
    }//GEN-LAST:event_cboPedidosMouseClicked

    private void cboPedidosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPedidosItemStateChanged
       showOptions(); 
    }//GEN-LAST:event_cboPedidosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> cboPedidos;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
