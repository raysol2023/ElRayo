package com.elrayo.vista;

import com.elrayo.controlador.ControladorCliente;
import com.elrayo.entidad.Cliente;
import com.elrayo.entidad.SesionComanda;
import com.elrayo.util.ButtonEditor;
import com.elrayo.util.ButtonRenderer;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;

public class ResumenPedidos extends javax.swing.JPanel {

    ControladorCliente objControladorCliente = new ControladorCliente();

    DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Dni", "Teléfono", "Dirección", "WhatsApp"}, 0
    ) {
        @Override   
        public boolean isCellEditable(int row, int column) {
            return column != 3; // WhatsApp = columna 5 (index 5)
        }
    };

    public ResumenPedidos() throws Exception {
        initComponents();
        InitStyles();
        String imprimir = SesionComanda.getComanda().toString();
        panelImprimir.setText(imprimir);
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: light $h1.regular.font");
        title.setForeground(Color.black);
    }


    public void agregarBotonWhatsApp(JTable tabla, int columnaTelefono, int columnaBoton) {
        tabla.getColumnModel().getColumn(columnaBoton).setCellRenderer(new ButtonRenderer("Ver"));

        tabla.getColumnModel().getColumn(columnaBoton).setCellEditor(new ButtonEditor(new JCheckBox(), e -> {
            int row = tabla.getSelectedRow();
            String telefono = tabla.getValueAt(row, columnaTelefono).toString().replaceAll("\\s+", "");

            //String textoPlano = "Hola enviando mensaje desde java";
            String textoPlano = "Software de central de atenciones de delivery: El rayo\n" +
"\n" +
"delivery tipo de pedido:\n" +
"- Restaurante\n" +
"- Cliente\n" +
"\n" +
"Calculo de tarifa:\n" +
"- Uso de Google maps para calcular distancia con un precio base de 6 soles y un adicional de 2 soles por kilómetro si es mas de 3 kilómetros.\n" +
"\n" +
"Caso restaurante:\n" +
"El restaurante contacta a Rayo para que le lleve un pedido al cliente, el restaurante debe proporcionar una copia de la comanda de compra y datos del cliente.\n" +
"\n" +
"Caso cliente:\n" +
"El cliente realiza un pedido de un x Restaurante donde; si el Restaurante tiene acuerdos con Rayo se aplica un cobro extra por servicio de compra por S/0 caso contrario se cobra 10 soles extra.\n" +
"Rayo debe solicitar al cliente sus datos de entrega, pedido, etc.\n" +
"\n" +
"gestión de motorizados:\n" +
"-Motorizados\n" +
"-Central\n" +
"\n" +
"Caso central:\n" +
"Un motorizado puede salir de la central con uno o múltiples pedidos, la central deberá entregarle una lista de pedidos y un orden de entrega mediante whatsapp.\n" +
"La central debe llevar un control de cuantos pedidos salió a entregar el motorizado y llevar una cuenta regresiva de entrega con base 30 minutos una vez finalizado los 30 minutos el sistema deberá emitir una alerta\n" +
"por pedido retrasado y contactar al motoriza y recalcular el tiempo de entra del pedido para posteriormente notificar al cliente mediante una disculpa y su nuevo tiempo de entrega estimada.\n" +
"Deberá tener una opción de marcar como pedido entregado(fuera de tiempo ó a tiempo)\n" +
"deberá tener un botón que notifique al cliente que el motorizado se dirige a su domicilio y que por favor se mantente atento a su llegada\n" +
"\n" +
"Caso motorizado:\n" +
"El motorizado recibe una lista de pedidos y una orden de entregas desde la central\n" +
"El motorizado deberá enviar un mensaje vía whatsapp a la central indicando que se encuentra a escasa distancia del cliente para que la central pueda notificar al cliente.\n" +
"El motorizado deberá enviar un mensaje vía whatsapp a la central indicando que el pedido con id:xxx ah sido recibido con éxito y pagado mediante efectivo, yape, etc\n" +
"El motorizado debería enviar un mensaje vía whatsapp a la central indicando que se dirige al siguiente pedido con id:xxx y que la central debe notificar al cliente\n" +
"\n" +
"métodos de pago:\n" +
"Yape, plin, cualquier app que permita a Rayo recibir el dinero directamente\n" +
"Efectivo, lo recibe solo el motorizado y lo guarda para dar cuenta al final del dia\n" +
"El cliente paga directamente al local y el local recién abona al final de dia\n" +
"\n" +
"Cierre de caja:\n" +
"-Restaurante\n" +
"-Central\n" +
"\n" +
"Caso restaurante:\n" +
"la central deberá emitir un reporte de deuda a cada restaurante y enviarle por whatsapp\n" +
"deberá permitir marcar al local como pago total o pago parcial\n" +
"\n" +
"Caso central:\n" +
"La central deberá emitir un reporte general y detallado de motorizados (Cuantos pedidos entrego, cuando dinero recibió en efectivo, yape y pago mediante Restaurant)\n" +
"El motorizado deberá entragar una lista de gastos posibles probablente gasolina, etc y deberá abonar a central el dinero que le sobro del efectivo que recibió y debería de coincidir con lo que reporta central\n" +
"central deberá poder marcar como dinero entrega y sin novedad al motorizado\n" +
"Finalmente central deberá emitir un reporte general de dinero y gastos del dia, un reporte de deudas de destaurantes y si algún motorizado no entrego dinero completo.";
            try {
                // Codifica el texto correctamente para URL
                String textoWhatsApp = URLEncoder.encode(textoPlano, StandardCharsets.UTF_8.toString()).replace("+", "%20");

                // Construir el enlace para abrir directamente WhatsApp
                String url = "whatsapp://send/?phone=" + telefono + "&text=" + textoWhatsApp;

                Desktop.getDesktop().browse(new URI(url));
                System.out.println(url);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }));
    }
    
    void enviarCliente(){
        String textoPlano = SesionComanda.getComanda().toString();
        String telefono = SesionComanda.getComanda().getIdCliente().getTelefono().replaceAll("\\s+", "");
        try {
                // Codifica el texto correctamente para URL
                String textoWhatsApp = URLEncoder.encode(textoPlano, StandardCharsets.UTF_8.toString()).replace("+", "%20");

                // Construir el enlace para abrir directamente WhatsApp
                String url = "whatsapp://send/?phone=" + telefono + "&text=" + textoWhatsApp;

                Desktop.getDesktop().browse(new URI(url));
                System.out.println(url);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
    
    void enviarMotorizado(){
        String textoPlano = SesionComanda.getComanda().toString();
        String telefono = SesionComanda.getComanda().getIdMotorizado().getTelefono().replaceAll("\\s+", "");
        try {
                // Codifica el texto correctamente para URL
                String textoWhatsApp = URLEncoder.encode(textoPlano, StandardCharsets.UTF_8.toString()).replace("+", "%20");

                // Construir el enlace para abrir directamente WhatsApp
                String url = "whatsapp://send/?phone=" + telefono + "&text=" + textoWhatsApp;

                Desktop.getDesktop().browse(new URI(url));
                System.out.println(url);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnWhastsAppCliente = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnWhatsAppMotorizado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelImprimir = new javax.swing.JEditorPane();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        title.setText("Resumen del pedido");

        btnWhastsAppCliente.setBackground(new java.awt.Color(18, 90, 173));
        btnWhastsAppCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnWhastsAppCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnWhastsAppCliente.setText("W. Cliente");
        btnWhastsAppCliente.setBorderPainted(false);
        btnWhastsAppCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnWhastsAppCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhastsAppClienteActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(18, 90, 173));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(18, 90, 173));
        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.setBorderPainted(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnWhatsAppMotorizado.setBackground(new java.awt.Color(18, 90, 173));
        btnWhatsAppMotorizado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnWhatsAppMotorizado.setForeground(new java.awt.Color(255, 255, 255));
        btnWhatsAppMotorizado.setText("W. Motorizado");
        btnWhatsAppMotorizado.setBorderPainted(false);
        btnWhatsAppMotorizado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnWhatsAppMotorizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhatsAppMotorizadoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(panelImprimir);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(300, 300, 300)
                        .addComponent(btnWhastsAppCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWhatsAppMotorizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWhastsAppCliente)
                    .addComponent(btnGuardar)
                    .addComponent(btnAtras)
                    .addComponent(btnWhatsAppMotorizado))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnWhastsAppClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhastsAppClienteActionPerformed
        enviarCliente();
    }//GEN-LAST:event_btnWhastsAppClienteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        try {
            Dashboard.ShowJPanelContent(new DatosPedido());
        } catch (Exception ex) {
            Logger.getLogger(ResumenPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnWhatsAppMotorizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhatsAppMotorizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWhatsAppMotorizadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnWhastsAppCliente;
    private javax.swing.JButton btnWhatsAppMotorizado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane panelImprimir;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
