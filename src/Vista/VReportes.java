package Vista;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.ListaCategorias;
import Modelo.Ticket;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class VReportes extends JFrame {
    private javax.swing.JButton Buscarboton;
    private javax.swing.JTextField TicFecha;
    private javax.swing.JTable RegistroTabla;
    private javax.swing.JButton Eliminarboton;
    private javax.swing.JButton LimpiarBoton;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel Lproductos;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
	
	public VReportes() {
		initComponents();
	}
	
	Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
    
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TicFecha = new javax.swing.JTextField();
        Buscarboton = new javax.swing.JButton();
        LimpiarBoton = new javax.swing.JButton();
        Eliminarboton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RegistroTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        Lproductos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setBackground(new Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame5"); // NOI18N

        jPanel2.setBackground(new Color(128, 128, 128));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new Font("Century Gothic", Font.BOLD, 25)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 0));
        jLabel12.setText("Registro Tickets Ventas");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Escribe la Fecha par buscar Ticket");

        TicFecha.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TicFecha.setForeground(new Color(0, 0, 255));

        Buscarboton.setBackground(new Color(128, 128, 128));
        Buscarboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Buscarboton.setForeground(new Color(0, 0, 0));
        Buscarboton.setText("Buscar");
        Buscarboton.setBorder(null);
        Buscarboton.setBorderPainted(false);
        Buscarboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	BuscarBotonMouseClicked(evt);
            }
        });

        LimpiarBoton.setBackground(new Color(128, 128, 128));
        LimpiarBoton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LimpiarBoton.setForeground(new Color(0, 0, 0));
        LimpiarBoton.setText("Limpiar");
        LimpiarBoton.setBorder(null);
        LimpiarBoton.setBorderPainted(false);
        LimpiarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	LimpiarBotonMouseClicked(evt);
            }
        });

        Eliminarboton.setBackground(new Color(128, 128, 128));
        Eliminarboton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Eliminarboton.setForeground(new Color(0, 0, 0));
        Eliminarboton.setText("Eliminar");
        Eliminarboton.setBorder(null);
        Eliminarboton.setBorderPainted(false);
        Eliminarboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	EliminarBotonMouseClicked(evt);
            }
        });

        RegistroTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        RegistroTabla.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"Codigo", "Cantidad", "Total", "Fecha"
        	}
        ));
        RegistroTabla.getColumnModel().getColumn(0).setPreferredWidth(68);
        RegistroTabla.getColumnModel().getColumn(1).setPreferredWidth(90);
        RegistroTabla.getColumnModel().getColumn(2).setPreferredWidth(84);
        RegistroTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        RegistroTabla.setRowHeight(25);
        RegistroTabla.setSelectionBackground(new Color(0, 0, 255));
        RegistroTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RegistroTabla);

        jLabel13.setFont(new Font("Century Gothic", Font.BOLD, 22)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 0));
        jLabel13.setText("Lista De Los Tickets");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(77, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel4)
        									.addPreferredGap(ComponentPlacement.RELATED))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(Buscarboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        									.addGap(75)))
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGap(120)
        									.addComponent(TicFecha, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGap(5)
        									.addComponent(Eliminarboton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        									.addGap(93)
        									.addComponent(LimpiarBoton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
        							.addGap(100))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
        							.addGap(42)))
        					.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        						.addComponent(jLabel12)
        						.addGap(170)))
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel13)
        					.addGap(254))))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(28)
        			.addComponent(jLabel12)
        			.addGap(42)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(TicFecha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(38)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Buscarboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Eliminarboton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(LimpiarBoton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(33)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);
        

        Lproductos.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        Lproductos.setForeground(new Color(0, 0, 0));
        Lproductos.setText("Productos");
        Lproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new Font("Century Gothic", Font.ITALIC, 18)); // NOI18N
        jLabel7.setForeground(new Color(0, 0, 0));
        jLabel7.setText("Exit");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        
        JLabel lblCategorias = new JLabel();
        lblCategorias.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent evt) {
        		lblCategoriasMouseClicked(evt);
        	}
        });
        lblCategorias.setText("Categorias");
        lblCategorias.setForeground(new Color(0, 0, 0));
        lblCategorias.setFont(new Font("Century Gothic", Font.BOLD, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addContainerGap(16, Short.MAX_VALUE)
        						.addComponent(Lproductos)
        						.addPreferredGap(ComponentPlacement.UNRELATED))
        					.addGroup(jPanel2Layout.createSequentialGroup()
        						.addContainerGap()
        						.addComponent(lblCategorias)
        						.addPreferredGap(ComponentPlacement.RELATED)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(24)
        					.addComponent(jLabel7)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(76)
        					.addComponent(Lproductos)
        					.addGap(54)
        					.addComponent(lblCategorias, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel7)))
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void BuscarBotonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (TicFecha.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Buscando la Información");
        }
        else
        {
        	String fechaBuscada = TicFecha.getText();
            
            // Realizar la consulta a la base de datos y obtener los tickets para la fecha especificada
            List<Ticket> ticketsEncontrados = obtenerTicketsPorFecha(fechaBuscada);

            if (!ticketsEncontrados.isEmpty()) {
                // Si se encontraron tickets, actualizar la tabla con esa información
                actualizarTablaConTicketsEncontrados(ticketsEncontrados);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron tickets para la fecha especificada.");
                // Puedes agregar lógica adicional o limpiar la tabla si lo deseas.
            }
        }
    }
    
    private List<Ticket> obtenerTicketsPorFecha(String fecha) {
        List<Ticket> tickets = new ArrayList<>();

        try {
            // Establecer la conexión a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");

            // Preparar la consulta SQL para obtener los tickets por fecha
            String query = "SELECT * FROM reporte WHERE Fecha = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fecha);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Procesar los resultados y agregar los tickets a la lista
            while (resultSet.next()) 
            {
                String codigo = resultSet.getString("Codigo");
                int cantidad = resultSet.getInt("Cantidad");
                double total = resultSet.getDouble("Total");
                String fechaTicket = resultSet.getString("Fecha");

//                Ticket ticket = new Ticket();
//                tickets.add(ticket);
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener los tickets desde la base de datos.");
        }

        return tickets;
    }

    // Método para actualizar la tabla con los tickets encontrados
    private void actualizarTablaConTicketsEncontrados(List<Ticket> tickets) {
        DefaultTableModel model = (DefaultTableModel) RegistroTabla.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        for (Ticket ticket : tickets) {
            // Añadir cada ticket a la tabla
            model.addRow(new Object[] {ticket.getIdticket(), ticket.getCantidad(), ticket.getTotal(), ticket.getFecha()});
        }
    }
    
    private void LimpiarBotonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        TicFecha.setText("");
    }                                     

    private void CategoriaTablaMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	int index = RegistroTabla.getSelectedRow();
        TableModel model = RegistroTabla.getModel();

        // Verificar si el índice de la fila es válido y si la celda seleccionada no es nula
        if (index >= 0 && model.getValueAt(index, 0) != null) {
            String value = model.getValueAt(index, 0).toString(); // Cambia 0 por el índice de la columna que necesitas
            System.out.println(value);
            int Myindex = RegistroTabla.getSelectedRow();
            TicFecha.setText(model.getValueAt(Myindex, 0).toString());
        } else {
            // Manejar el caso en que el valor de la celda sea nulo
            System.out.println("La celda seleccionada está vacía o nula.");
        }
    }                                           

    private void EliminarBotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        if (TicFecha.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Introduzca la Categoria que se eliminara");
        }
        else
        {
        	String codigoTicket = TicFecha.getText();

            // Verificar si el Ticket existe mediante su código
            if (ticketExisteEnBaseDeDatos(codigoTicket)) {
                // Preguntar al usuario si realmente desea eliminar el Ticket
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este Ticket?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Eliminar el Ticket de la base de datos
                    eliminarTicketEnBaseDeDatos(codigoTicket);

                    // Quitar la fila correspondiente del modelo de la tabla
                    DefaultTableModel model = (DefaultTableModel) RegistroTabla.getModel();
                    int rowIndex = obtenerIndiceFilaPorCodigo(codigoTicket);
                    if (rowIndex != -1) {
                        model.removeRow(rowIndex);
                    }

                    JOptionPane.showMessageDialog(this, "Ticket eliminado correctamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Ticket con el código especificado no existe.");
            }
        }
    }
    
    private boolean ticketExisteEnBaseDeDatos(String codigoTicket) {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            String query = "SELECT COUNT(*) FROM reporte WHERE Codigo = ?";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, codigoTicket);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            Con.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes agregar mensajes o lógica de manejo de errores aquí
        }
        return false;
    }
    
    private void eliminarTicketEnBaseDeDatos(String codigoTicket) {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectointegradorsistema?serverTimezone=UTC", "root", "");
            String query = "DELETE FROM reporte WHERE Codigo = ?";
            PreparedStatement preparedStatement = Con.prepareStatement(query);
            preparedStatement.setString(1, codigoTicket);
            preparedStatement.executeUpdate();

            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes agregar mensajes o lógica de manejo de errores aquí
        }
    }
    
    private int obtenerIndiceFilaPorCodigo(String codigoTicket) {
        DefaultTableModel model = (DefaultTableModel) RegistroTabla.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).equals(codigoTicket)) {
                return i;
            }
        }
        return -1; // Si no se encuentra el código
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new VProductosEnAlmacen().setVisible(true);
        this.dispose();
    }                                    

                                    
    
    private void lblCategoriasMouseClicked(java.awt.event.MouseEvent evt)
    {
    	new VCategorias().setVisible(true);
        this.dispose();
    }
    
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {                                     
        new VSesion().setVisible(true);
        this.dispose();
    }
    
}
