/*package Vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class PantallaCarga extends JFrame {
	
	public javax.swing.JProgressBar Myprogress;
    public javax.swing.JLabel Percentage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
	
	public PantallaCarga() {
		initComponents();
	}
	
	 
		
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Percentage = new javax.swing.JLabel();
        Myprogress = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        //jLabel2.setIcon(new ImageIcon("C:\\Users\\f_e_r\\Downloads\\PI\\java\\Imagenes\\Minisuper Castores.jpg"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new Color(207, 199, 188));

        Percentage.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Percentage.setForeground(Color.DARK_GRAY);
        Percentage.setText("%");

        Myprogress.setForeground(new Color(128, 64, 64));
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\f_e_r\\Downloads\\PI\\java\\Imagenes\\Minisuper Castores.jpg");
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(321, 219, Image.SCALE_SMOOTH);
        jLabel2.setIcon(new ImageIcon(imagenEscalada));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        // Ajustar tamaño de la imagen según el JLabel cuando cambia el tamaño
        jLabel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ajustarImagen();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(Myprogress, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(160)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(198, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(342)
        			.addComponent(Percentage)
        			.addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(71, Short.MAX_VALUE)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addComponent(Percentage)
        			.addGap(18)
        			.addComponent(Myprogress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setAutoCreateGaps(true);
        jPanel1Layout.setAutoCreateContainerGaps(true);
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
    private void ajustarImagen() {
        int width = jLabel2.getWidth();
        int height = jLabel2.getHeight();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\f_e_r\\Downloads\\PI\\java\\Imagenes\\Minisuper Castores.jpg");
        Image imagenEscalada = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        jLabel2.setIcon(new ImageIcon(imagenEscalada));
    }
}
*/
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class PantallaCarga extends JFrame {

    public javax.swing.JProgressBar Myprogress;
    public javax.swing.JLabel Percentage;
    private javax.swing.JPanel jPanel1;
    private Image backgroundImage;

    public PantallaCarga() {
        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon("C:/Users/Kevin%20Gonzalez/Downloads/PI/java/Imagenes/Minisuper%20Castores.jpg").getImage();
        initComponents();
    }

    private void initComponents() {
        // Crear un JPanel personalizado con la imagen de fondo
        jPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo escalada al tamaño del JPanel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(705, 404);
            }
        };

        Percentage = new javax.swing.JLabel();
        Myprogress = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new Color(207, 199, 188));

        Percentage.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Percentage.setForeground(Color.DARK_GRAY);
        Percentage.setText("%");

        Myprogress.setForeground(new Color(128, 64, 64));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
                .addComponent(Myprogress, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(342)
                    .addComponent(Percentage)
                    .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(300)
                    .addComponent(Percentage)
                    .addGap(18)
                    .addComponent(Myprogress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setAutoCreateGaps(true);
        jPanel1Layout.setAutoCreateContainerGaps(true);
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
}