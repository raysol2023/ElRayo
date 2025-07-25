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

public class Clientes extends javax.swing.JPanel {

    ControladorCliente objControladorCliente = new ControladorCliente();

    DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Dni", "Teléfono", "Dirección", "WhatsApp"}, 0
    ) {
        @Override   
        public boolean isCellEditable(int row, int column) {
            return column != 3; // WhatsApp = columna 5 (index 5)
        }
    };

    public Clientes() throws Exception {
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

            String textoPlano = "Hola enviando mensaje desde java";

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
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(750, 430));

        title.setText("Clientes");

        btnBuscar.setBackground(new java.awt.Color(18, 90, 173));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(18, 90, 173));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(18, 90, 173));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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
                        .addComponent(btnBuscar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            cargarTabla(txtBusqueda.getText());
            System.out.println("Tabla cargada");
        } catch (Exception ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar la tabla: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

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
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Dashboard.ShowJPanel(new ClientesUp());
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
