package Controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Lib.BaseDatos;
import Lib.ConexionBD;
import Modelo.ListaCategorias;
import Modelo.ListaProductos;
import Modelo.Producto;
import Vista.VProductosEnAlmacen;

public class CProductosEnAlmacen implements ActionListener, ListSelectionListener, MouseListener{

	VProductosEnAlmacen vista;
	
	ListaProductos listaProductos = new ListaProductos();
	ListaCategorias listaCategorias = new ListaCategorias();
	
	public CProductosEnAlmacen ()
	{
		
		
		vista = new VProductosEnAlmacen ();
		
		vista.Bagregar.addActionListener(this);
		vista.Beditar.addActionListener(this);
		vista.Beliminar.addActionListener(this);
		vista.Blimpiar.addActionListener(this);
		vista.Bimagen.addActionListener(this);
		vista.ProductoTabla.getSelectionModel().addListSelectionListener(this);
		
		vista.LCategorias.addMouseListener(this);
		vista.LReportes.addMouseListener(this);
		vista.LSalir.addMouseListener(this);
		vista.Lventas.addMouseListener(this);
		
		GetCat();
		cargarDatos();
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == vista.Bagregar)
		{
			  if (vista.TProId.getText().isEmpty() || vista.TProdNombre.getText().isEmpty() ||
					  vista.TProdCantidad.getText().isEmpty()|| vista.TProdPrecio.getText().isEmpty())
		        {
		            JOptionPane.showMessageDialog(vista, "Falta la Información");
		        }
		        else
		        {
		        	// Obtener datos de las cajas de texto
		            String codigo = vista.TProId.getText();
		            if (listaProductos.buscarProductoPorId(codigo) != null) 
		            {
		                JOptionPane.showMessageDialog(vista, "El prducto con el código " + codigo + " ya existe");
		            }
		            else
		            {
			            String nombre = vista.TProdNombre.getText();
			            int cantidad = Integer.valueOf(vista.TProdCantidad.getText());
			            double precio = Double.valueOf(vista.TProdPrecio.getText());
			            
			            String categoriaSeleccionada = "";
			            Object categoriaSeleccionadaObject = vista.CBCat.getSelectedItem();
			            if (categoriaSeleccionadaObject != null) {
			                categoriaSeleccionada = categoriaSeleccionadaObject.toString();
			            }
			            
			            
			            Producto nuevoProducto = new Producto(codigo, nombre, cantidad, precio, categoriaSeleccionada);
			            listaProductos.agregarProducto(nuevoProducto);
			            actualizarTabla();
			            guardarProductoEnBaseDeDatos(nuevoProducto);
			           
		            }
		        }
		}
		else if (e.getSource() == vista.Beditar)
		{
			 if (vista.TProId.getText().isEmpty()||vista.TProdNombre.getText().isEmpty()||
					 vista.TProdCantidad.getText().isEmpty()||vista.TProdPrecio.getText().isEmpty())
		        {
		            JOptionPane.showMessageDialog(vista, "Falta la Información");
		        }
		        else
		        {
		            String codigo = vista.TProId.getText();
		            Producto producto = listaProductos.buscarProductoPorId(codigo);
		            if (producto == null) 
		            {
		                JOptionPane.showMessageDialog(vista, "El producto con el código " + codigo + " no existe");
		            } else 
		            {
		                int respuesta = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea actualizar el producto " +  producto.getNombre() +"?", "Confirmar la actualización", JOptionPane.YES_NO_OPTION);
		                if (respuesta == JOptionPane.YES_OPTION)
		                {
		                    producto.setNombre(vista.TProdNombre.getText());
		                    producto.setCantidad(Integer.valueOf(vista.TProdCantidad.getText()));
		                    producto.setPrecio(Double.valueOf(vista.TProdPrecio.getText()));
		                    
		                    Object categoriaSeleccionadaObject = vista.CBCat.getSelectedItem();
		                    String categoriaSeleccionada = categoriaSeleccionadaObject != null ? categoriaSeleccionadaObject.toString() : null;
		                    producto.setCategoria(categoriaSeleccionada);
		                    
		                    
		                    // Actualizar la categoría en la tabla
		                    actualizarProductoEnTabla(producto);
		                    // Actualizar la categoría en la base de datos
		                    actualizarProductoEnBaseDeDatos(producto);
		                    
		                }
		            }
		        }
			
		}
		else if (e.getSource() == vista.Beliminar)
		{
			if (vista.TProId.getText().isEmpty())
	        {
	            JOptionPane.showMessageDialog(vista, "Introduzca el producto que se eliminara");
	        }
	        else
	        {
	            String codigo = vista.TProId.getText();
	            Producto producto = listaProductos.buscarProductoPorId(codigo);
	            if (producto == null) 
	            {
	                JOptionPane.showMessageDialog(vista, "El Producto con el código " + codigo + " no existe");
	            } else 
	            {
	                int respuesta = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar el producto " + producto.getNombre() + "?", "Confirmar la eliminación", JOptionPane.YES_NO_OPTION);
	                if (respuesta == JOptionPane.YES_OPTION) 
	                {
	                	listaProductos.eliminarProductoPorId(codigo);
	                    quitarProductoDeTabla(codigo);
	                    actualizarTabla();
	                    eliminarProductoDeBaseDeDatos(codigo);
	                  
	                }
	            }
	        }
			
		}
		else if (e.getSource() == vista.Blimpiar)
		{
			 vista.TProId.setText("");
			 vista.TProdNombre.setText("");
			 vista.TProdCantidad.setText("");
			 vista.TProdPrecio.setText("");
			 
			 vista.CBCat.setSelectedIndex(-1);
			
		}
		else if (e.getSource() == vista.Bimagen)
		{
			
			if (vista.TProId.getText().isEmpty())
	        {
	            JOptionPane.showMessageDialog(vista, "Introduzca el Codigo del Producto al que se le agregara la imagen");
	        }
	    	else
	    	{
	    		String codigoProducto = vista.TProId.getText();
	            Producto producto = listaProductos.buscarProductoPorId(codigoProducto);

	            if (producto == null) 
	            {
	                JOptionPane.showMessageDialog(vista, "El producto con el código " + codigoProducto + " no existe");
	            } else 
	            {
	            	
	            	JFileChooser fileChooser = new JFileChooser("Imagenes"); //Iniciar en la carpeta Imagenes
	                fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif"));

	                int result = fileChooser.showOpenDialog(vista);
	                if (result == JFileChooser.APPROVE_OPTION) 
	                {
	                    String direccion = fileChooser.getSelectedFile().getAbsolutePath();
	                    
	                    String rutaImagenRelativa = "Imagenes" + File.separator + fileChooser.getSelectedFile().getName();
	                    
	                    File destino = new File(rutaImagenRelativa);
	                    try 
	                    {
	                        Files.move(Paths.get(direccion), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
	                    } 
	                    catch (IOException ex) 
	                    {
	                        ex.printStackTrace();
	                    }
	                    
	                    producto.setImagen(rutaImagenRelativa);
	                    
	                    actualizarImagenProductoEnBaseDeDatos(producto);
	                }   
	            }
	    	}
		}
		
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {  //Cambios por la Seleccion en la tabla
		// TODO Auto-generated method stub
		
		
	
        TableModel model = vista.ProductoTabla.getModel();
        int Myindex = vista.ProductoTabla.getSelectedRow();
        if (Myindex != -1)
        {
        	
            vista.TProId.setText(model.getValueAt(Myindex, 0).toString());
            vista.TProdNombre.setText(model.getValueAt(Myindex, 1).toString());
            vista.TProdCantidad.setText(model.getValueAt(Myindex, 2).toString());
            vista.TProdPrecio.setText(model.getValueAt(Myindex, 3).toString());
            
//ComboBox *********************************************************************************            
            Object obj = model.getValueAt(Myindex, 4);
            
            if (obj != null) //Hay categoria en la tabla ?
            {
            	 String categoriaSeleccionada = obj.toString();
                 
                 DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) vista.CBCat.getModel();
                 //Buscar la categoria
                 boolean categoriaEncontrada = false;
                 for (int i = 0; i < comboBoxModel.getSize(); i++) 
                 {
                     String item = (String) comboBoxModel.getElementAt(i);
                     if (item.equals(categoriaSeleccionada)) 
                     {
                         
                         vista.CBCat.setSelectedIndex(i);
                         categoriaEncontrada = true;
                         break; 
                     }
                 }
                 if (!categoriaEncontrada) // Quitarles la categoria que ya no existe, ... Capaz ya no se ocupa todo este if
                 {
                 	ArrayList <Producto> productosModificar =  listaProductos.buscarProductosPorCategoria(categoriaSeleccionada);
                 	
                 	if (productosModificar != null)
                 	{
                 		for (Producto p : productosModificar) 
                     	{
                     		p.setCategoria(null);
                     	}
                 		actualizarColumnaTabla(4,categoriaSeleccionada, null); //Metodo Reemplazar nadamas en tabla
                     	try{
                     		ConexionBD conexion=new ConexionBD();
             				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
             				String[] nuevosValores = {null };
             				bd.modificar("productos", "categoria", categoriaSeleccionada, "categoria", nuevosValores );
                     	}
                     	catch (SQLException ex)
                     	{
                     		ex.printStackTrace();
                     	}
                 	}
                 }
            }
            
           
            
            
//IMAGEN **************************************************************************
            String directorioProyecto = System.getProperty("user.dir"); //Direccion proyecto
            Producto p = listaProductos.buscarProductoPorId(model.getValueAt(Myindex, 0).toString());
            String rutaImagen = directorioProyecto + File.separator + p.getImagen();
            if (rutaImagen != null && !rutaImagen.isEmpty()) 
            {
                ImageIcon imagen = new ImageIcon(rutaImagen);
                Image image = imagen.getImage().getScaledInstance(vista.Limagen.getWidth(), vista.Limagen.getHeight(), Image.SCALE_SMOOTH);
                vista.Limagen.setIcon(new ImageIcon(image));
            }
            else 
            {
                // Manejar caso donde no hay imagen asociada al producto seleccionado
                // Por ejemplo, limpiar el JLabel
                vista.Limagen.setIcon(null);
            }
            
        }
		
	}   
	
	
	  
	private void cargarDatos()
	{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productos.dat"))) 
        {
        	ConexionBD conexion=new ConexionBD();
			BaseDatos  bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
        	
            ArrayList <String [] > ProductosGuardados =  bd.consultar("productos", "codigo,nombre,cantidad,precio,categoria,imagen", null);
            
          
            
            listaProductos.cargarProductos(ProductosGuardados);
            actualizarTabla(); // Actualiza la tabla después de cargar los datos
            
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
     
        }
    }
	
	private void GetCat()
    {
    	try 
    	{
    		ConexionBD conexion=new ConexionBD();
    		BaseDatos bd=new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
    		ArrayList <String [] > categoriasGuardadas =  bd.consultar("categorias", "codigo,nombre,descripcion", null);
    		
    		 listaCategorias.cargarCategorias(categoriasGuardadas);
    		
    		listaCategorias.agregrarCategoriasAComboBox( vista.CBCat);
    		
    		
    		
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
	
	
	 
// Base datos y Tabla  ************************************************************************************
	 
	  private void actualizarTabla()
	  {
	    	DefaultTableModel model = (DefaultTableModel) vista.ProductoTabla.getModel();
	        for (Producto producto : listaProductos.productos) 
	        {
	            boolean productoPresente = false;
	            for (int i = 0; i < model.getRowCount(); i++) 
	            {
	            	Object valorCelda = model.getValueAt(i, 0);
	            	if (valorCelda != null && valorCelda.equals(producto.getCodigo())) 
	            	{
	                    productoPresente = true;
	                    break;
	                }
	            }
	            if (!productoPresente)
	            {
	                model.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getCantidad(), producto.getPrecio(), producto.getCategoria()});
	            }
	        }
	    }
	  
	  private void actualizarColumnaTabla(int columna, Object valorComparador, Object nuevoValor) 
	  {
		    DefaultTableModel model = (DefaultTableModel) vista.ProductoTabla.getModel();
		    int rowCount = model.getRowCount();
		    for (int i = 0; i < rowCount; i++) 
		    {
		        Object valorActualTabla = model.getValueAt(i, columna);

		        // Verificar si el valor en la tabla coincide con el valor comparador
		        if (Objects.equals(valorActualTabla, valorComparador)) 
		        {
		            model.setValueAt(nuevoValor, i, columna);
		        }
		    }
		}
	  
	  
	    
	    private void guardarProductoEnBaseDeDatos(Producto producto)
	    {
	        try 
	        {
	            

	        	ConexionBD conexion=new ConexionBD();
				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				
				bd.insertar("productos",  "codigo,nombre,cantidad,precio,categoria,imagen", producto.toArray() );
	        	System.out.println("si se pudo con productos");
	        	
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(vista, "Error al guardar en la base de datos");
	        }
	    }
	
	
	
	 private void actualizarProductoEnTabla(Producto producto) 
	 {
	        DefaultTableModel model = (DefaultTableModel) vista.ProductoTabla.getModel();
	        // Buscar la fila correspondiente a la categoría y actualizarla
	        for (int i = 0; i < model.getRowCount(); i++) 
	        {
	            if (model.getValueAt(i, 0).equals(producto.getCodigo())) 
	            {
	                model.setValueAt(producto.getNombre(), i, 1);
	                model.setValueAt(producto.getCantidad(), i, 2);
	                model.setValueAt(producto.getPrecio(), i, 3);
	                model.setValueAt(producto.getCategoria(), i, 4);
	                break;
	            }
	        }
	    }
	    
	    private void actualizarProductoEnBaseDeDatos(Producto producto) 
	    {
	        try 
	        {
	        	ConexionBD conexion=new ConexionBD();
				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				
		        
		        String[] nuevosValores = {
		            producto.getNombre(),
		            producto.getCantidad() + "",
		            producto.getPrecio() + "",
		            producto.getCategoria() // Aquí se maneja el posible valor nulo
		        };
				
				
				
				bd.modificar("productos", "codigo", this.vista.TProId.getText(), "nombre,cantidad,precio,categoria", nuevosValores );
	        	
				
				
	        	
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	           
	        }
	    }
	    private void actualizarImagenProductoEnBaseDeDatos(Producto producto) 
	    {
	        try 
	        {
	        	ConexionBD conexion=new ConexionBD();
				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				
		        
		        String[] nuevosValores = {
		            producto.getImagen()
		        };
				
				
				
				bd.modificar("productos", "codigo", this.vista.TProId.getText(), "imagen", nuevosValores );
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	           
	        }
	    }
	    
	
	 
	 private void quitarProductoDeTabla(String id)
	 {
	        DefaultTableModel model = (DefaultTableModel) vista.ProductoTabla.getModel();
	        for (int i = 0; i < model.getRowCount(); i++) 
	        {
	            if (model.getValueAt(i, 0).equals(id)) 
	            {
	                model.removeRow(i);
	                break;
	            }
	        }
	 }
	 
	 private void eliminarProductoDeBaseDeDatos(String id)
	 {
	        try 
	        {
	        	ConexionBD conexion=new ConexionBD();
				BaseDatos  bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				bd.eliminar("productos","codigo", vista.TProId.getText(), "");
	        	
	        	
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	            
	        }
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
// Metodos varios *******************************************************************************************	 
	
	 
	 
	  
	    @Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		
			if(e.getSource() == vista.LCategorias)
			{
				CCategorias ventana = new CCategorias();
				this.vista.dispose();
				
			}
			else if (e.getSource() == vista.Lventas)
			{
				new CVentas ("Administrador");
				vista.dispose();
				
			}
			else if (e.getSource() == vista.LReportes)
			{
				
			}
			else if (e.getSource() == vista.LSalir)
			{
				vista.dispose();
			}
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	 
	 
	 
	 
	 
	 
	 
	 
}
