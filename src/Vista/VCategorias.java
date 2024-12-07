package Vista;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import Modelo.Categoria;
import Modelo.ListaCategorias;
import Modelo.ListaProductos;

import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VCategorias extends JFrame {
	

    
 
    public JLabel  Lproductos, Lsalir, Lreportes,  Lventas;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    
    public JTextField  TCatId, TCatNombre, TCatDescripcion ;
    public JTable CategoriaTabla;
    public JButton Bagregar , Beditar, Beliminar ,Blimpiar;
   
    
	
    
    
	public VCategorias() {
		
		initComponents();
		this.setVisible(true);
	}
	

    
   
    
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TCatId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TCatNombre = new javax.swing.JTextField();
        TCatDescripcion = new javax.swing.JTextField();
        Bagregar = new javax.swing.JButton();
        Bagregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        Beditar = new javax.swing.JButton();
        Beditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        Blimpiar = new javax.swing.JButton();
        Beliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CategoriaTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame5"); // NOI18N

        jPanel2.setBackground(new Color(192, 192, 192));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new Font("Cascadia Code", Font.BOLD, 29)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 0));
        jLabel12.setText("CATEGORIAS");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("ID");

        TCatId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TCatId.setForeground(new Color(0, 0, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("NOMBRE");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 0));
        jLabel6.setText("DESCRIPCION");

        TCatNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TCatNombre.setForeground(new Color(0, 0, 255));

        TCatDescripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TCatDescripcion.setForeground(new Color(0, 0, 255));

        Bagregar.setBackground(new Color(192, 192, 192));
        Bagregar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Bagregar.setForeground(new Color(0, 0, 0));
        Bagregar.setText("Agregar");
        Bagregar.setBorder(null);
        Bagregar.setBorderPainted(false);
       

        Beditar.setBackground(new Color(192, 192, 192));
        Beditar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Beditar.setForeground(new Color(0, 0, 0));
        Beditar.setText("Editar");
        Beditar.setBorder(null);
        Beditar.setBorderPainted(false);
        

        Blimpiar.setBackground(new Color(192, 192, 192));
        Blimpiar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Blimpiar.setForeground(new Color(0, 0, 0));
        Blimpiar.setText("Limpiar");
        Blimpiar.setBorder(null);
        Blimpiar.setBorderPainted(false);
       

        Beliminar.setBackground(new Color(192, 192, 192));
        Beliminar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Beliminar.setForeground(new Color(0, 0, 0));
        Beliminar.setText("Eliminar");
        Beliminar.setBorder(null);
        Beliminar.setBorderPainted(false);
       

        CategoriaTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
       CategoriaTabla.setModel
        (new javax.swing.table.DefaultTableModel
        (
        	null,                          // No hay datos iniciales
            new String [] { "ID", "NOMBRE", "DESCRIPCIÓN" }
        ));
        CategoriaTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CategoriaTabla.setRowHeight(25);
        CategoriaTabla.setSelectionBackground(new Color(0, 0, 255));
        
        jScrollPane1.setViewportView(CategoriaTabla);

        jLabel13.setFont(new Font("Cascadia Code", Font.BOLD, 29)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 0));
        jLabel13.setText("LISTA DE CATEGORIAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(28)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel4)
        							.addGap(61)
        							.addComponent(TCatId, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        							.addGap(136)
        							.addComponent(jLabel5)
        							.addGap(49)
        							.addComponent(TCatNombre, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(Bagregar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGap(103)
        									.addComponent(jLabel13))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addGap(151)
        									.addComponent(Beditar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(Beliminar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel6)
        							.addGap(18)
        							.addComponent(TCatDescripcion, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        							.addGap(184)
        							.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap(103, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(417, Short.MAX_VALUE)
        			.addComponent(jLabel12)
        			.addGap(275))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel12)
        			.addGap(34)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(TCatId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(TCatNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(31)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(TCatDescripcion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(Bagregar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        								.addComponent(Beditar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        							.addGap(54))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(41)
        					.addComponent(Beliminar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);
        Lproductos = new javax.swing.JLabel();
        
                
                
        
                Lproductos.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
                Lproductos.setForeground(new Color(0, 0, 0));
                Lproductos.setText("Productos");
        
        Lventas = new JLabel();
        Lventas.setText("Ventas");
        Lventas.setForeground(new Color(0, 0, 0));
        Lventas.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        
         Lreportes = new JLabel();
         Lreportes.setText("Reportes");
         Lreportes.setForeground(new Color(0, 0, 0));
         Lreportes.setFont(new Font("Century Gothic", Font.BOLD, 20));
         Lsalir = new javax.swing.JLabel();


          Lsalir.setFont(new Font("Century Gothic", Font.BOLD, 20)); // NOI18N
          Lsalir.setForeground(new Color(0, 0, 0));
          Lsalir.setText("Exit");

          
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(35)
        			.addComponent(Lproductos)
        			.addGap(33)
        			.addComponent(Lventas, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(Lreportes, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 411, Short.MAX_VALUE)
        			.addComponent(Lsalir)
        			.addGap(30))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Lproductos)
        				.addComponent(Lventas)
        				.addComponent(Lreportes)
        				.addComponent(Lsalir))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
}
