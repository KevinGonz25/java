package Vista;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Lib.BaseDatos;
import Lib.ConexionBD;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VSesion extends JFrame {
	
	public JComboBox<String> CBrol;
    public JTextField Tnombre;
    public JButton Biniciar;
    public JButton Blimpiar;
    public JLabel jLabel12;
    public JLabel jLabel2;
    public JLabel jLabel4;
    public JLabel jLabel5;
    public JLabel jLabel6;
    public JPanel jPanel2;
    public JTextField Tcontraseña;
    private JButton btnNewButton;
    
    
	public VSesion() {
		getContentPane().setBackground(new Color(128, 128, 128));
		initComponents();
		this.setVisible(rootPaneCheckingEnabled);
	}
	
	private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(128, 128, 128));
        Tcontraseña = new javax.swing.JTextField();
        Tnombre = new javax.swing.JTextField();
        CBrol = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Biniciar = new javax.swing.JButton();
        Blimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame2");

        Tcontraseña.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tcontraseña.setForeground(new Color(0, 0, 0));

        Tnombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tnombre.setForeground(new Color(0, 0, 0));

        CBrol.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CBrol.setForeground(new Color(0, 0, 0));
        CBrol.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("USUARIO");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("CONTRASEÑA");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("ELEGIR ROLE");

        Biniciar.setBackground(new Color(255, 255, 255));
        Biniciar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Biniciar.setForeground(new Color(0, 0, 0));
        Biniciar.setText("Iniciar");
        Biniciar.setBorder(null);
        Biniciar.setBorderPainted(false);
       

        Blimpiar.setBackground(new Color(255, 255, 255));
        Blimpiar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Blimpiar.setForeground(new Color(0, 0, 0));
        Blimpiar.setText("Limpiar");
        Blimpiar.setBorder(null);

        jLabel2.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\ProyectoIntegradorSistema\\Imagenes\\70512368-ilustración-de-bolsa-de-compras-icono-naranja-con-una-etiqueta-engomada-de-sombra-plana.jpg")); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setText("Minisuper Castores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel4)
        				.addComponent(jLabel6)
        				.addComponent(jLabel5))
        			.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(Tnombre, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        				.addComponent(Tcontraseña)
        				.addComponent(CBrol, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(19))
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(38)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addGap(53)
        					.addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel2)
        					.addGap(122))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(Biniciar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addGap(26)
        					.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(144, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(48)
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(21)
        					.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
        			.addGap(2)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(CBrol, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(Tnombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Tcontraseña, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5))
        			.addGap(26)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Biniciar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Blimpiar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);
        
        btnNewButton = new JButton("New button");
        btnNewButton.setEnabled(false);
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\javie\\Downloads\\WhatsApp Image 2024-05-16 at 13.10.12.jpeg"));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
}
