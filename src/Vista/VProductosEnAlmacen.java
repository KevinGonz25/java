package Vista;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Modelo.Categoria;
import Modelo.ListaCategorias;
import Modelo.ListaProductos;
import Modelo.Producto;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VProductosEnAlmacen extends JFrame {
	
	public JButton Bagregar, Beliminar, Beditar, Blimpiar, Bimagen;
    public JComboBox<String> CBCat;
    public JTextField TProdCantidad, TProId, TProdNombre, TProdPrecio;
    public JLabel LCategorias, Limagen,LReportes, LSalir, Lventas;
 
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    
    public JTable ProductoTabla;
    public Map<String, JLabel> mapaLabelProductos = new HashMap<>();
	
	public VProductosEnAlmacen() 
	{
		initComponents();
        this.setVisible(true);
	}
	
	
    
    
    
    
    
	
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TProId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TProdPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TProdNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TProdCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CBCat = new javax.swing.JComboBox<>();
        Bagregar = new javax.swing.JButton();
        Bagregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        Beditar = new javax.swing.JButton();
        Blimpiar = new javax.swing.JButton();
        Blimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        Beliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductoTabla = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame3"); // NOI18N

        jPanel2.setBackground(new Color(128, 128, 128));
        jPanel2.setName(""); // NOI18N

        jPanel1.setBackground(new Color(192, 192, 192));

        jLabel12.setFont(new Font("Century Schoolbook", Font.BOLD, 25)); // NOI18N
        jLabel12.setForeground(new Color(0, 0, 0));
        jLabel12.setText("Productos En Almacen");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("PRODUCTO");

        TProId.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TProId.setForeground(new Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("NOMBRE");

        TProdPrecio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TProdPrecio.setForeground(new Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("CANTIDAD");

        TProdNombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TProdNombre.setForeground(new Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setText("PRECIO");

        TProdCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TProdCantidad.setForeground(new Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("CATEGORIA");

        CBCat.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CBCat.setForeground(new Color(0, 0, 0));
        CBCat.setToolTipText("");

        Bagregar.setBackground(new Color(255, 255, 255));
        Bagregar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Bagregar.setForeground(new Color(0, 0, 0));
        Bagregar.setText("Agregar");
        Bagregar.setBorder(null);
        Bagregar.setBorderPainted(false);
        

        Beditar.setBackground(new Color(255, 255, 255));
        Beditar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Beditar.setForeground(new Color(0, 0, 0));
        Beditar.setText("Editar");
        Beditar.setBorder(null);
        Beditar.setBorderPainted(false);
       

        Blimpiar.setBackground(new Color(255, 255, 255));
        Blimpiar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Blimpiar.setForeground(new Color(0, 0, 0));
        Blimpiar.setText("Limpiar");
        Blimpiar.setBorder(null);
        Blimpiar.setBorderPainted(false);
        

        Beliminar.setBackground(new Color(255, 255, 255));
        Beliminar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Beliminar.setForeground(new Color(0, 0, 0));
        Beliminar.setText("Eliminar");
        Beliminar.setBorder(null);
        Beliminar.setBorderPainted(false);
        

        ProductoTabla.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
       ProductoTabla.setModel(new javax.swing.table.DefaultTableModel
        (
        		null, new String [] {"ID", "NOMBRE", "CANTIDAD", "PRECIO", "CATEGORIA"}
        ));
        ProductoTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductoTabla.setRowHeight(25);
        ProductoTabla.setSelectionBackground(new Color(0, 0, 255));
        
        jScrollPane1.setViewportView(ProductoTabla);

        jLabel13.setFont(new Font("Century Schoolbook", Font.BOLD, 30)); // NOI18N
        jLabel13.setForeground(new Color(0, 0, 0));
        jLabel13.setText("LISTA DE PRODUCTOS");
        
        Limagen = new JLabel("");
        Limagen.setBackground(Color.LIGHT_GRAY);
        Limagen.setHorizontalAlignment(SwingConstants.CENTER);
        
         Bimagen = new JButton();
         Bimagen.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         	}
         });
       
        Bimagen.setText("Imagen");
        Bimagen.setForeground(new Color(0, 0, 0));
        Bimagen.setFont(new Font("Century Gothic", Font.BOLD, 18));
        Bimagen.setBorderPainted(false);
        Bimagen.setBorder(null);
        Bimagen.setBackground(new Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(14)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(43)
        					.addComponent(Bagregar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(36)
        					.addComponent(Beditar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(69)
        					.addComponent(Beliminar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(55)
        					.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(48)
        					.addComponent(Limagen, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        					.addContainerGap(83, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel8)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(CBCat, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel4)
        								.addComponent(jLabel5))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(TProdNombre, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        								.addComponent(TProId, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
        					.addGap(53)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel13)
        							.addContainerGap())
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel7)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(TProdPrecio, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel6)
        									.addGap(18)
        									.addComponent(TProdCantidad, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
        							.addComponent(Bimagen, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        							.addGap(115))))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(351, Short.MAX_VALUE)
        			.addComponent(jLabel12)
        			.addGap(283))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel12)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(22)
        					.addComponent(Bimagen, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(Limagen, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(34)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(TProdCantidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(TProId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        								.addComponent(TProdNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel8)
        								.addComponent(CBCat, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addComponent(TProdPrecio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Beliminar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Beditar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Bagregar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
        			.addGap(18))
        );
        jPanel1.setLayout(jPanel1Layout);
        
        Lventas = new JLabel();
        Lventas.setText("Ventas");
        Lventas.setForeground(Color.WHITE);
        Lventas.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        LCategorias = new javax.swing.JLabel();
        
                LCategorias.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); // NOI18N
                LCategorias.setForeground(Color.WHITE);
                LCategorias.setText("Categorias");
        
         LReportes = new JLabel();
         LReportes.setText("Reportes");
         LReportes.setForeground(Color.WHITE);
         LReportes.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        LSalir = new javax.swing.JLabel();
        
                LSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); // NOI18N
                LSalir.setForeground(Color.WHITE);
                LSalir.setText("Salir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(26)
        					.addComponent(Lventas, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        					.addGap(31)
        					.addComponent(LCategorias, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        					.addGap(103)
        					.addComponent(LReportes, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        					.addGap(83)
        					.addComponent(LSalir)))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap(11, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Lventas)
        				.addComponent(LCategorias)
        				.addComponent(LReportes)
        				.addComponent(LSalir))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
    
   
  
        
                                     

   
    
   
    
   
    
     
   
   
    
   
    
    
    
    
    
    
    
    
    
   
}
