package com.elrayo.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());
    

    public Dashboard() throws Exception {
        initComponents();
        InitStyles();
        InitContent();
    }

    private void InitStyles() {
        appName.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        appName.setForeground(Color.white);
    }

    private void InitContent() throws Exception {
        ShowJPanelContent(new Principal());
        ShowJPanelheader(new Header());
        ShowJPanelTP(new Central());
    }

    public static void ShowJPanelContent(JPanel p) {
        p.setSize(750, 430);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    public static void ShowJPanelheader(JPanel p) {
        p.setSize(750, 150);
        p.setLocation(0, 0);

        header.removeAll();
        header.add(p, BorderLayout.CENTER);
        header.revalidate();
        header.repaint();
    }

    public static void ShowJPanelTP(JPanel p) {
        p.setSize(750, 150);
        p.setLocation(0, 0);

        tipoPedido.removeAll();
        tipoPedido.add(p, BorderLayout.CENTER);
        tipoPedido.revalidate();
        tipoPedido.repaint();
    }

    public static void mostrable(JPanel p1, JPanel p2, JPanel p3) {
        ShowJPanelTP(p1);
        ShowJPanelheader(p2);
        ShowJPanelContent(p3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        appName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_principal = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_motorizados = new javax.swing.JButton();
        btn_restaurantes = new javax.swing.JButton();
        btn_pedidos = new javax.swing.JButton();
        btn_reportes = new javax.swing.JButton();
        btn_cierres = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        tipoPedido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setBackground(new java.awt.Color(13, 72, 160));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        appName.setText("El Rayo");
        appName.setIconTextGap(13);

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        btn_principal.setBackground(new java.awt.Color(21, 101, 192));
        btn_principal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_principal.setForeground(new java.awt.Color(255, 255, 255));
        btn_principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-outline.png"))); // NOI18N
        btn_principal.setText("Principal");
        btn_principal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_principal.setBorderPainted(false);
        btn_principal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_principal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_principal.setIconTextGap(13);
        btn_principal.setInheritsPopupMenu(true);
        btn_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_principalActionPerformed(evt);
            }
        });

        btn_clientes.setBackground(new java.awt.Color(21, 101, 192));
        btn_clientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_clientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png"))); // NOI18N
        btn_clientes.setText("Clientes");
        btn_clientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_clientes.setBorderPainted(false);
        btn_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_clientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_clientes.setIconTextGap(13);
        btn_clientes.setInheritsPopupMenu(true);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_motorizados.setBackground(new java.awt.Color(21, 101, 192));
        btn_motorizados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_motorizados.setForeground(new java.awt.Color(255, 255, 255));
        btn_motorizados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/food-delivery-man-motorcycle-white-icon.png"))); // NOI18N
        btn_motorizados.setText("Motorizados");
        btn_motorizados.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_motorizados.setBorderPainted(false);
        btn_motorizados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_motorizados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_motorizados.setIconTextGap(13);
        btn_motorizados.setInheritsPopupMenu(true);
        btn_motorizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_motorizadosActionPerformed(evt);
            }
        });

        btn_restaurantes.setBackground(new java.awt.Color(21, 101, 192));
        btn_restaurantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_restaurantes.setForeground(new java.awt.Color(255, 255, 255));
        btn_restaurantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cutlery.png"))); // NOI18N
        btn_restaurantes.setText("Restaurantes");
        btn_restaurantes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_restaurantes.setBorderPainted(false);
        btn_restaurantes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_restaurantes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_restaurantes.setIconTextGap(13);
        btn_restaurantes.setInheritsPopupMenu(true);
        btn_restaurantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restaurantesActionPerformed(evt);
            }
        });

        btn_pedidos.setBackground(new java.awt.Color(21, 101, 192));
        btn_pedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_pedidos.setForeground(new java.awt.Color(255, 255, 255));
        btn_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/to-do-list.png"))); // NOI18N
        btn_pedidos.setText("Pedidos");
        btn_pedidos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_pedidos.setBorderPainted(false);
        btn_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_pedidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pedidos.setIconTextGap(13);
        btn_pedidos.setInheritsPopupMenu(true);
        btn_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidosActionPerformed(evt);
            }
        });

        btn_reportes.setBackground(new java.awt.Color(21, 101, 192));
        btn_reportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reportes.setForeground(new java.awt.Color(255, 255, 255));
        btn_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chart.png"))); // NOI18N
        btn_reportes.setText("Reportes");
        btn_reportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_reportes.setBorderPainted(false);
        btn_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_reportes.setIconTextGap(13);
        btn_reportes.setInheritsPopupMenu(true);
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });

        btn_cierres.setBackground(new java.awt.Color(21, 101, 192));
        btn_cierres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cierres.setForeground(new java.awt.Color(255, 255, 255));
        btn_cierres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file-chart.png"))); // NOI18N
        btn_cierres.setText("Cierres");
        btn_cierres.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_cierres.setBorderPainted(false);
        btn_cierres.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_cierres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cierres.setIconTextGap(13);
        btn_cierres.setInheritsPopupMenu(true);
        btn_cierres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cierresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btn_restaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_motorizados, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_cierres, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btn_restaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(btn_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btn_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btn_motorizados, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btn_cierres, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(750, 510));
        content.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setPreferredSize(new java.awt.Dimension(744, 150));
        header.setLayout(new java.awt.BorderLayout());

        tipoPedido.setPreferredSize(new java.awt.Dimension(750, 60));
        tipoPedido.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(header, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(149, 149, 149)))
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_principalActionPerformed
        try {
            mostrable(new Central(), new Header(), new Principal());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Principal " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_principalActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        try {
            mostrable(new Central(), new Header(), new Clientes());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Clientes " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_motorizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_motorizadosActionPerformed
        try {
            mostrable(new Central(), new Header(), new Motorizados());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Motorizados " + ex.getMessage());
        }

    }//GEN-LAST:event_btn_motorizadosActionPerformed

    private void btn_restaurantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restaurantesActionPerformed
        try {
            mostrable(new Central(), new Header(), new Restaurantes());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Restaurantes " + ex.getMessage());
        }

    }//GEN-LAST:event_btn_restaurantesActionPerformed

    private void btn_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidosActionPerformed
        try {
            mostrable(new Central(), new Header(), new Pedidos());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Pedidos " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_pedidosActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
        try {
            mostrable(new Central(), new Header(), new Reportes());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Reportes " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_cierresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cierresActionPerformed
        try {
            mostrable(new Central(), new Header(), new Cierres());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            System.out.println("Erro al mostrar los panales: Central, Header, Cierres " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_cierresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Dashboard().setVisible(true);
            } catch (Exception ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appName;
    private javax.swing.JButton btn_cierres;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_motorizados;
    private javax.swing.JButton btn_pedidos;
    private javax.swing.JButton btn_principal;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JButton btn_restaurantes;
    private static javax.swing.JPanel content;
    private static javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private static javax.swing.JPanel tipoPedido;
    // End of variables declaration//GEN-END:variables
}
