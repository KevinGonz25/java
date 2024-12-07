package Vista;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Ticket;
import java.awt.Color;
import java.awt.print.PrinterAbortException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.Date;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VVentas extends JFrame {
	
	public JButton Bañadir, Blimpiar, BGuardar, Btotal, Bquitar;
    public JTable ProductoTabla;
    
    public JTextField TNombre , TCantidad;
    
    public JComboBox<String> CatCb;
    
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    
	
    public  JLabel Lsalir, Ltotal, Lproductos, Lcategorias;
    public JTable TicketTabla;
    
    
	public VVentas() 
	{
		initComponents();
        this.setVisible(true);
	}
	
	
    
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TNombre = new javax.swing.JTextField();
        TCantidad = new javax.swing.JTextField();
        CatCb = new javax.swing.JComboBox<>();
        Bañadir = new javax.swing.JButton();
        Blimpiar = new javax.swing.JButton();
        Blimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductoTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Ltotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new Color(192, 192, 192));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new Color(255, 255, 255));

        jLabel5.setFont(new Font("Century Gothic", Font.BOLD, 20)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("NOMBRE");

        jLabel6.setFont(new Font("Century Gothic", Font.BOLD, 20)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 0));
        jLabel6.setText("CANTIDAD");

        TNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TNombre.setForeground(new Color(0, 0, 0));

        TCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TCantidad.setForeground(new Color(0, 0, 0));

        CatCb.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatCb.setForeground(new Color(0, 0, 0));
        CatCb.setToolTipText("");
        

        Bañadir.setBackground(new Color(192, 192, 192));
        Bañadir.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Bañadir.setForeground(new Color(0, 0, 0));
        Bañadir.setText("Añadir");
        Bañadir.setBorder(null);
        Bañadir.setBorderPainted(false);
        
        
        Blimpiar.setBackground(new Color(192, 192, 192));
        Blimpiar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Blimpiar.setForeground(new Color(0, 0, 0));
        Blimpiar.setText("Limpiar");
        Blimpiar.setBorder(null);
        Blimpiar.setBorderPainted(false);
       
       

        ProductoTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ProductoTabla.setModel(new javax.swing.table.DefaultTableModel
        ( 
        		null, new String [] { "ID", "NOMBRE", "CANTIDAD", "PRECIO", "CATEGORIA"}
        ));
        ProductoTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductoTabla.setRowHeight(25);
        ProductoTabla.setSelectionBackground(new Color(0, 0, 255));
        
        jScrollPane1.setViewportView(ProductoTabla);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 0));
        jLabel13.setText("LISTA PRODUCTOS");

        Ltotal.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        Ltotal.setForeground(new Color(0, 0, 0));
        Ltotal.setText("Rs");
        
        BGuardar = new JButton();
        BGuardar.setText("Confirmar Compra");
        BGuardar.setForeground(new Color(0, 0, 0));
        BGuardar.setFont(new Font("Century Gothic", Font.BOLD, 18));
        BGuardar.setBorderPainted(false);
        BGuardar.setBorder(null);
        BGuardar.setBackground(new Color(192, 192, 192));
        
         Btotal = new JButton();
        Btotal.setText("Calcular Total");
        Btotal.setForeground(new Color(0, 0, 0));
        Btotal.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Btotal.setBorderPainted(false);
        Btotal.setBorder(null);
        Btotal.setBackground(new Color(192, 192, 192));
        
        Bquitar = new JButton();
        Bquitar.setText("Quitar de compra");
        Bquitar.setForeground(new Color(0, 0, 0));
        Bquitar.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Bquitar.setBorderPainted(false);
        Bquitar.setBorder(null);
        Bquitar.setBackground(new Color(192, 192, 192));
        jLabel12 = new javax.swing.JLabel();
        
                jLabel12.setFont(new Font("Arial Narrow", Font.BOLD, 30)); // NOI18N
                jLabel12.setForeground(new Color(0, 0, 0));
                jLabel12.setText("Minisuper Catores");
       

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(370, Short.MAX_VALUE)
        			.addComponent(Btotal, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
        			.addGap(269)
        			.addComponent(Ltotal)
        			.addGap(97))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(575, Short.MAX_VALUE)
        			.addComponent(BGuardar, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
        			.addGap(182))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap(33, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel6)
        							.addGap(18)
        							.addComponent(TCantidad, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel5)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(TNombre, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        						.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(Bquitar, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(Bañadir, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        							.addGap(36)
        							.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
        					.addGap(32)))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel13)
        							.addGap(241))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE))
        							.addContainerGap())))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(96)
        					.addComponent(CatCb, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(69)
        					.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(39)
        					.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
        			.addGap(4)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(TNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(TCantidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addGap(38)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Bañadir, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(25)
        					.addComponent(CatCb, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(BGuardar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(18)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(Btotal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(Ltotal)))))
        				.addComponent(Bquitar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        
        TicketTabla = new JTable();
        
        TicketTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TicketTabla.setModel(new javax.swing.table.DefaultTableModel
        ( 
        		null, new String [] { "ID", "NOMBRE",  "PRECIO", "CANTIDAD", "IVA", "TOTAL"}
        ));
        TicketTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TicketTabla.setRowHeight(25);
        TicketTabla.setSelectionBackground(new Color(0, 0, 255));
        jScrollPane2.setViewportView(TicketTabla);
        
        
        
        
        jPanel1.setLayout(jPanel1Layout);
        
         Lcategorias = new JLabel();
         Lcategorias.setText("Categorias");
         Lcategorias.setForeground(Color.BLACK);
         Lcategorias.setFont(new Font("Arial", Font.BOLD, 18));
        
         Lproductos = new JLabel();
         Lproductos.setText("Productos");
         Lproductos.setForeground(Color.BLACK);
         Lproductos.setFont(new Font("Arial", Font.BOLD, 18));
        Lsalir = new javax.swing.JLabel();
        Lsalir.setBackground(Color.WHITE);
        
                Lsalir.setFont(new Font("Arial", Font.BOLD, 18)); // NOI18N
                Lsalir.setForeground(Color.BLACK);
                Lsalir.setText("Salir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(26)
        					.addComponent(Lcategorias, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(Lproductos, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addGap(36)
        					.addComponent(Lsalir)
        					.addGap(401)))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap(13, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Lcategorias, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Lsalir)
        				.addComponent(Lproductos, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
        			.addGap(27))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 952, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
}
