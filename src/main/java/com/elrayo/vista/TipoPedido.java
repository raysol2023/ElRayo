package com.elrayo.vista;

import com.elrayo.controlador.ControladorCliente;
import com.elrayo.entidad.Cliente;
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

public class TipoPedido extends javax.swing.JPanel {

    ControladorCliente objControladorCliente = new ControladorCliente();

    DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Dni", "Teléfono", "Dirección", "WhatsApp"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column != 3; // WhatsApp = columna 5 (index 5)
        }
    };

    public TipoPedido() throws Exception {
        initComponents();

        tbCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbCliente.setRowHeight(30);

        // Alinea los encabezados a la izquierda
        JTableHeader header = tbCliente.getTableHeader();
        DefaultTableCellRenderer leftRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        InitStyles();
        cargarTabla("");

        SwingUtilities.invokeLater(() -> ajustarColumnasPorPorcentaje());

        JScrollPane scrollPane = (JScrollPane) tbCliente.getParent().getParent();
        scrollPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ajustarColumnasPorPorcentaje();
            }
        });
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: light $h1.regular.font");
        title.setForeground(Color.black);
    }

    public void cargarTabla(String busqueda) throws Exception {
        List<Cliente> lista = objControladorCliente.mostrarClientes(busqueda);
        modelo.setRowCount(0); // Limpia la tabla

        for (Cliente m : lista) {
            Object[] fila = {
                m.getId(), // ID (oculto)
                m.getNombre(),
                m.getDni(),
                m.getTelefono(),
                m.getDireccion(),
                "Ver"
            };
            modelo.addRow(fila);
        }

        tbCliente.setModel(modelo);
        tbCliente.setRowHeight(30);

        // Ocultar la columna ID (index 0)
        tbCliente.getColumnModel().getColumn(0).setMinWidth(0);
        tbCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        tbCliente.getColumnModel().getColumn(0).setWidth(0);

        agregarBotonWhatsApp(tbCliente, 3, 5); // Teléfono está en columna 3, botón en columna 5
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

    public void ajustarColumnasPorPorcentaje() {
        int totalWidth = tbCliente.getParent().getWidth();
        if (totalWidth <= 0) {
            return;
        }

        // Omitimos la columna ID (columna 0)
        int[] porcentajes = {25, 10, 15, 35, 15}; // Para columnas 1 a 5

        for (int i = 0; i < porcentajes.length; i++) {
            int ancho = (totalWidth * porcentajes[i]) / 100;
            tbCliente.getColumnModel().getColumn(i + 1).setPreferredWidth(ancho); // desplazado por la columna 0
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        title.setText("Clientes");

        searchButton.setBackground(new java.awt.Color(18, 90, 173));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Buscar");
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        tbCliente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dni", "Telefono", "Direccion", "WhatsApp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbCliente.getTableHeader().setReorderingAllowed(false);
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        btnEliminar.setBackground(new java.awt.Color(18, 90, 173));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Borrar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(18, 90, 173));
        editButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Editar");
        editButton.setBorderPainted(false);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(18, 90, 173));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Nuevo");
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(txtBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(editButton)
                    .addComponent(addButton))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            cargarTabla(txtBusqueda.getText());
            System.out.println("Tabla cargada");
        } catch (Exception ex) {
            Logger.getLogger(TipoPedido.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la tabla: "+ex.getMessage());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void tbClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMousePressed

    }//GEN-LAST:event_tbClienteMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (tbCliente.getSelectedRows().length < 1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar uno o más clientes a eliminar.\n", "AVISO", JOptionPane.ERROR_MESSAGE);
        } else {
            // Recorre en orden descendente para evitar errores al eliminar filas mientras iteras
            int[] filas = tbCliente.getSelectedRows();
            Arrays.sort(filas);
            for (int j = filas.length - 1; j >= 0; j--) {
                int i = filas[j];
                int idCliente = (int) tbCliente.getValueAt(i, 0);

                try {
                    if (objControladorCliente.tieneComandas(idCliente)) {
                        JOptionPane.showMessageDialog(this, "No puedes eliminar al cliente con ID " + idCliente + " porque tiene comandas registradas.", "Aviso", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TipoPedido.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    objControladorCliente.eliminar(idCliente);
                    modelo.removeRow(i);
                } catch (Exception e) {
                    System.out.println("Error eliminando cliente: " + e.getMessage());
                }
            }

            try {
                cargarTabla("");
            } catch (Exception ex) {
                Logger.getLogger(TipoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        if (tbCliente.getSelectedRow() > -1) {
            try {
                int clienteId = (int) tbCliente.getValueAt(tbCliente.getSelectedRow(), 0);
                Dashboard.ShowJPanel(new ClientesUp(objControladorCliente.editarUnCliente(clienteId)));
//                System.out.println(clienteId);
//                System.out.println(objControladorCliente.editarUnCliente(clienteId).toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar el cliente a editar.\n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Dashboard.ShowJPanel(new ClientesUp());
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable tbCliente;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
