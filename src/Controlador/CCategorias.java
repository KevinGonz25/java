package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Lib.BaseDatos;
import Lib.ConexionBD;
import Modelo.Categoria;
import Modelo.ListaCategorias;
import Vista.VCategorias;
import Vista.VReportes;

import java.awt.Color;
import java.awt.Font;

public class CCategorias implements ActionListener, ListSelectionListener, MouseListener {

	VCategorias vista;
	
	ListaCategorias listaCategorias = new ListaCategorias();
	public CCategorias ()
	{
		
		vista = new VCategorias ();
		vista.Lproductos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		vista.Lreportes.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		vista.Lventas.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		vista.Lsalir.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		vista.Lreportes.setForeground(Color.WHITE);
		vista.Lproductos.setForeground(Color.WHITE);
		
		vista.Bagregar.addActionListener(this);
		vista.Beditar.addActionListener(this);
		vista.Beliminar.addActionListener(this);
		vista.Blimpiar.addActionListener(this);
		vista.CategoriaTabla.getSelectionModel().addListSelectionListener(this);
		
		vista.Lproductos.addMouseListener(this);
		vista.Lreportes.addMouseListener(this);
		vista.Lsalir.addMouseListener(this);
		vista.Lventas.addMouseListener(this);
		
		cargarDatos();
		
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == vista.Bagregar)
		{
			if (vista.TCatId.getText().isEmpty() || vista.TCatNombre.getText().isEmpty() || vista.TCatDescripcion.getText().isEmpty())
	        {
	            JOptionPane.showMessageDialog(vista, "Falta la Información");
	        }
	        else
	        {
	        	// Obtener datos de las cajas de texto
	            String id = vista.TCatId.getText();
	            if (listaCategorias.buscarCategoriaPorId(id) != null) {
	                JOptionPane.showMessageDialog(vista, "La categoría con el código " + id + " ya existe");
	            }
	            else
	            {
		            String nombre = vista.TCatNombre.getText();
		            String descripcion = vista.TCatDescripcion.getText();
		            // Crear un objeto Categoria
		            Categoria nuevaCategoria = new Categoria(id, nombre, descripcion);
					// Agregar la nueva categoría a la lista
		            listaCategorias.agregarCategoria(nuevaCategoria);
		            // Actualizar la tabla en la interfaz gráfica
		            actualizarTabla();
		            // Guardar la nueva categoría en la base de datos
		            guardarCategoriaEnBaseDeDatos(nuevaCategoria);
	            }
	        }
			
			
			
		}
		else if (e.getSource() == vista.Beditar)
		{
			
			 if (vista.TCatId.getText().isEmpty()||vista.TCatNombre.getText().isEmpty()||vista.TCatDescripcion.getText().isEmpty())
		        {
		            JOptionPane.showMessageDialog(vista, "informacion faltante");
		        }
		        else
		        {
		        	// Obtener datos de las cajas de texto
		            String id = vista.TCatId.getText();
		            // Buscar la categoría por ID en la lista
		            Categoria categoria = listaCategorias.buscarCategoriaPorId(id);
		            if (categoria == null) 
		            {
		                JOptionPane.showMessageDialog(vista, "La categoría con el código " + id + " no existe");
		            } else 
		            {
		                // Confirmar la actualización con el usuario
		                int respuesta = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea actualizar la categoría " + categoria.getNombre() + " ?", "Confirmar la actualización", JOptionPane.YES_NO_OPTION);
		                if (respuesta == JOptionPane.YES_OPTION)
		                {
		                	String antiguoNombre = categoria.getNombre();
		                	
		                    // Actualizar la categoría en la lista
		                    categoria.setNombre(vista.TCatNombre.getText());
		                    categoria.setDescripcion(vista.TCatDescripcion.getText());
		                    
		                    // Actualizar la categoría en la tabla
		                    actualizarCategoriaEnTabla(categoria);
		                    // Actualizar la categoría en la base de datos
		                    actualizarCategoriaEnBaseDeDatos(categoria);
		                    
		                    try //Cambiar de nombre a Categoria en Productos
		                    {
		                    	ConexionBD conexion=new ConexionBD();
	             				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
	             				String[] nuevosValores = {categoria.getNombre() };
	             				bd.modificar("productos", "categoria", antiguoNombre, "categoria", nuevosValores );
		                    }
		                    catch (SQLException ex)
		                    {
		                    	
		                    }
		                    
		                    
		                    
		                }
		            }
		        }
			
		}
		else if (e.getSource() == vista.Beliminar)
		{
		
			 if (vista.TCatId.getText().isEmpty())
		        {
		            JOptionPane.showMessageDialog(vista, "Introduzca la Categoria que se eliminara");
		        }
		        else
		        {
		        	// Obtener el ID de la categoría seleccionada
		            String id = vista.TCatId.getText();
		            
		            // Buscar la categoría por ID en la lista
		            Categoria categoria = listaCategorias.buscarCategoriaPorId(id);
		            
		            if (categoria == null) 
		            {
		                JOptionPane.showMessageDialog(vista, "La categoría con el código " + id + " no existe");
		            }
		            else 
		            {
		                // Confirmar la eliminación con el usuario
		                int respuesta = JOptionPane.showConfirmDialog(vista, "¿Seguro que desea eliminar la categoría " + categoria.getNombre() + " ?", "Confirmar la eliminación", JOptionPane.YES_NO_OPTION);
		                if (respuesta == JOptionPane.YES_OPTION) 
		                {
		                    // Eliminar la categoría de la lista
		                    listaCategorias.eliminarCategoriaPorId(id);
		                    // Actualizar la tabla en la interfaz gráfica
		                    quitarCategoriaDeTabla(id);
		                    actualizarTabla();
		                    // Eliminar la categoría de la base de datos
		                    eliminarCategoriaDeBaseDeDatos(id);
		                }
		            }
		        }
		}
		else if (e.getSource() == vista.Blimpiar)
		{
			vista.TCatId.setText("");
	        vista.TCatNombre.setText("");
	        vista.TCatDescripcion.setText("");
		}
	}
	


	@Override
	public void valueChanged(ListSelectionEvent e) {  //Seleccion en tabla
		// TODO Auto-generated method stub
		
		
		
        TableModel model = vista.CategoriaTabla.getModel();
        int Myindex = vista.CategoriaTabla.getSelectedRow();
        
        if (Myindex != -1)
        {
        	if (model.getValueAt(Myindex, 0) != null)
                vista.TCatId.setText( model.getValueAt(Myindex, 0).toString());
            if (model.getValueAt(Myindex, 1) != null)
                vista.TCatNombre.setText(model.getValueAt(Myindex, 1).toString());
            if (model.getValueAt(Myindex, 2) != null)
                vista.TCatDescripcion.setText(model.getValueAt(Myindex, 2).toString());
        }
        
        
		
		
	}   
	
	
	private void cargarDatos()         
	{
        try 
        {
        	ConexionBD conexion=new ConexionBD();
			BaseDatos  bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
        	
            ArrayList <String [] > categoriasGuardadas =  bd.consultar("categorias", "codigo,nombre,descripcion", null);
            
            listaCategorias.cargarCategorias(categoriasGuardadas);
            actualizarTabla(); // Actualiza la tabla después de cargar los datos
        } 
        catch (SQLException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	
	private void guardarCategoriaEnBaseDeDatos(Categoria categoria)
    {
        try 
        {
        	ConexionBD conexion=new ConexionBD();
			BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
			
			
			bd.insertar("categorias", "codigo,nombre,descripcion", categoria.toArray());
        	
			
          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar en la base de datos");
        }
    }
	
	
	 private void actualizarTabla() 
	 {
	    	DefaultTableModel model = (DefaultTableModel) vista.CategoriaTabla.getModel();
	        for (Categoria categoria : listaCategorias.categorias) 
	        {
	            // Verificar si la categoría ya está presente en la tabla
	            boolean categoriaPresente = false;
	            for (int i = 0; i < model.getRowCount(); i++)
	            {
	            	Object valorCelda = model.getValueAt(i, 0);
	            	if (valorCelda != null && valorCelda.equals(categoria.getCodigo()))
	            	{
	                    categoriaPresente = true;
	                    break;
	                }
	            }
	            // Si la categoría no está presente, agregarla a la tabla
	            if (!categoriaPresente) 
	            {
	                model.addRow(new Object[]{categoria.getCodigo(), categoria.getNombre(), categoria.getDescripcion()});
	            }
	        }
	    }
	 
	 
	 private void actualizarCategoriaEnTabla(Categoria categoria) 
	 {
		    DefaultTableModel model = (DefaultTableModel) vista.CategoriaTabla.getModel();
		    // Buscar la fila correspondiente a la categoría y actualizarla
		    for (int i = 0; i < model.getRowCount(); i++) 
		    {
		        Object valorCodigo = model.getValueAt(i, 0);
		        if (valorCodigo != null && valorCodigo.equals(categoria.getCodigo())) 
		        {
		            model.setValueAt(categoria.getNombre(), i, 1);
		            model.setValueAt(categoria.getDescripcion(), i, 2);
		            break;
		        }
		    }
		}
	    
	    private void actualizarCategoriaEnBaseDeDatos(Categoria categoria) { //falta*********************
	        try 
	        {
	        	ConexionBD conexion=new ConexionBD();
				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				String [] nuevosValores = { categoria.getNombre(), categoria.getDescripcion() };
				bd.modificar("categorias", "codigo", categoria.getCodigo(), "nombre,descripcion", nuevosValores );
				
	        	
	        	
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(vista, "Error al actualizar la categoría en la base de datos");
	        }
	    }
	 
	    private void quitarCategoriaDeTabla(String id) 
	    {
	        DefaultTableModel model = (DefaultTableModel) vista.CategoriaTabla.getModel();
	        for (int i = 0; i < model.getRowCount(); i++) 
	        {
	            Object valor = model.getValueAt(i, 0);
	            if (valor != null && valor.equals(id)) 
	            {
	                model.removeRow(i);
	                break; // Salir del bucle después de encontrar y eliminar la categoría
	            }
	        }
	    }
	    
	    private void eliminarCategoriaDeBaseDeDatos(String id) //falta*********************
	    {
	        try 
	        {
	        	ConexionBD conexion=new ConexionBD();
				BaseDatos  bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				bd.eliminar("categorias","codigo", vista.TCatId.getText(), "");
	        	
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(vista, "Error al eliminar la categoría de la base de datos");
	        }
	    }






		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		
			if(e.getSource() == vista.Lproductos)
			{
				CProductosEnAlmacen ventana = new CProductosEnAlmacen();
				this.vista.dispose();
				
			}
			else if (e.getSource() == vista.Lreportes)
			{
				 // Crear una instancia del frame de reportes y abrirlo
			    VReportes ventanaReportes = new VReportes();
			    ventanaReportes.setVisible(true);
			    
			    // Opcional: cerrar la vista actual si es necesario
			    this.vista.dispose();
			}
			else if (e.getSource() == vista.Lventas)
			{
				new CVentas ("Administrador");
				
			}
			else if (e.getSource() == vista.Lsalir)
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
