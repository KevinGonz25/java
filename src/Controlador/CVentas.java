package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterAbortException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Lib.BaseDatos;
import Lib.ConexionBD;
import Lib.CreadorTicket;
import Modelo.ListaCategorias;
import Modelo.ListaProductos;
import Modelo.ListaTickets;
import Modelo.Producto;
import Modelo.Ticket;
import Vista.VVentas;

public class CVentas implements ActionListener, MouseListener, ItemListener{

	static final double iva = 0.16;
	static String fecha;
	
	VVentas vista;
	
	ListaProductos listaProductos   = new ListaProductos ()  ;
	ListaCategorias listaCategorias = new ListaCategorias();
	ListaTickets listaTickets = new ListaTickets();
	
	public CVentas (String rol)
	{
		vista = new VVentas ();
		
		vista.Bañadir.addActionListener(this);
		vista.Blimpiar.addActionListener(this);
		vista.Btotal.addActionListener(this);
		vista.BGuardar.addActionListener(this);
		vista.Bquitar.addActionListener(this);
		
		vista.Lsalir.addMouseListener(this);
		vista.Lproductos.addMouseListener(this);
		vista.Lcategorias.addMouseListener(this);
		
		vista.CatCb.addItemListener(this);
		vista.ProductoTabla.addMouseListener(this);
		
        GetCat();
		
        if (rol.compareTo("Administrador")==0)
        {
        	
        }
        else 
        {
        	vista.Lproductos.setVisible(false);
        	vista.Lproductos.setEnabled(false);
        	
        	vista.Lcategorias.setVisible(false);
        	vista.Lcategorias.setEnabled(false);
        }
		
		
		
		
	}
	
	// Variables que se ocupan a lo largo del codigo.
	String Prid;
    int newCantidad;
	int CantidadAlmacen;
	int FilaS ;
	int i=0;
	Double Uprice, ProdTotal=0.0, GrdTotal=0.0;
	
//ActionListener ****************************************************************************	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		if (e.getSource() == vista.Bañadir)
		{
			 
			  if (vista.TCantidad.getText().isEmpty()||vista.TNombre.getText().isEmpty())
		        {
		            JOptionPane.showMessageDialog(vista, "Falta de Informacion");
		        }
		        else 
		        {
		        	
		        	if (FilaS != -1) 
		        	{
		        	
		        		int cantidadComprar = Integer.valueOf(vista.TCantidad.getText() );
			        	
			        	 String cantidadA = vista.ProductoTabla.getModel().getValueAt(FilaS, 2).toString();
			                if (cantidadA != null && cantidadA.matches("\\d+")) 
			                {
			                    CantidadAlmacen = Integer.valueOf(cantidadA);
			                }
			        	
			        	if (CantidadAlmacen < cantidadComprar)
			            JOptionPane.showMessageDialog(vista, "No hay suficiente Stock");
			        	else
			        	{
			        		int nuevacantidad = CantidadAlmacen  - cantidadComprar;
			        		
							

							String id = vista.ProductoTabla.getModel().getValueAt(FilaS, 0).toString();
							Producto aux = listaProductos.buscarProductoPorId(id);
							aux.setCantidad(aux.getCantidad() - cantidadComprar);
							actualizarTablaProductos(); //Productos modificados
							
							
			        		
			    	        try 
			    	        {
			    	        	ConexionBD conexion = new ConexionBD();
								BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
								String [] nv = { String.valueOf(nuevacantidad) };
								bd.modificar("productos", "codigo",id , "cantidad",nv);
							} 
			    	        catch (SQLException e1) 
			    	        {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    	        
			    	        listaTickets.agregarTicket(new Ticket(aux, cantidadComprar + ""));
			        		
			        		actualizarTablaTickets();
			        		vista.Btotal.setBackground(Color.decode("#BF4E41"));
			        		
			        		
			        		
			        	}
		        	}
		        }
		        
		}
		else if (e.getSource() == vista.Btotal)
		{
			vista.Ltotal.setText(  listaTickets.calcularTotal() + "" );
			vista.Btotal.setBackground(Color.LIGHT_GRAY);
		}
		else if (e.getSource() == vista.Blimpiar)
		{
			 vista.TNombre.setText("");
		     vista.TCantidad.setText("");
		}
		else if (e.getSource() == vista.Bquitar)
		{
			 int fila = vista.TicketTabla.getSelectedRow();
			 
			 if (fila != -1 && fila < vista.TicketTabla.getRowCount())
			 {
				 Object obj = vista.TicketTabla.getValueAt(fila, 0);
				 String idProducto =   obj.toString();
				 
				 listaTickets.eliminarTicketPorIdProducto(idProducto);
				 
				 Producto aux =  listaProductos.buscarProductoPorId(idProducto);
				 if (aux != null)
				 {
					 
					 
					 obj  = vista.TicketTabla.getValueAt(fila, 3);
					 int cantDevuelta = Integer.valueOf( obj.toString() );
					// System.out.println("aux: " + aux.getCantidad() +  "  cantidad devuelta: " + cantDevuelta);
					 aux.setCantidad(   aux.getCantidad() + cantDevuelta);
					// System.out.println("nueva cantidad : "+ aux.getCantidad());
					 
					 try 
		    	        {
		    	        	ConexionBD conexion = new ConexionBD();
							BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
							String [] nv = { String.valueOf(aux.getCantidad() ) };
							bd.modificar("productos", "codigo",idProducto , "cantidad",nv);
						} 
		    	        catch (SQLException e1) 
		    	        {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
					 actualizarTablaTickets();
					 actualizarTablaProductos();
				 }
				 else //si no esta la lista correcta ahora mismo y por ende aux esta null
				 {
//					 obj  = vista.TicketTabla.getValueAt(fila, 3);
//					 int cantDevuelta = Integer.valueOf( obj.toString() );
//					 obj = vista.TicketTabla.getValueAt(fila, 0);
//					 String id = obj.toString();	
//					 
//						try 
//						{
//							ConexionBD conexion = new ConexionBD();
//							BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
//							
//							 String condicion = "id = '" + id + "'";
//							ArrayList <String []> ar=   bd.consultar("productos", "categoria", condicion);
//							String [] nv = { String.valueOf(ar.get(0)[0]  ) };
//							bd.modificar("productos", "codigo",id , "cantidad",nv);
//							
//							
//						}
//						catch (SQLException e1)
//						{
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
						
				 }
				 
				 
				 
				 
			 }
				
		}
		else if (e.getSource() == vista.BGuardar)
		{
			 
				try 
				{
					ConexionBD conexion = new ConexionBD();
					BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
					
					
					
					for (Ticket t : listaTickets.tickets)
					{
						
						
						bd.insertar("tickets","codigo,fecha,hora,codigoproducto,nombreproducto,"
								+ "precio,cantidad,iva,total ", t.toArray() );
					}
					
					CreadorTicket c = new CreadorTicket(listaTickets);
					c.escribirArchivo("ReporteTicket");
					
					
					listaTickets.vaciarLista();
					actualizarTablaTickets();
					listaTickets.ObtenerIdTicket();
					
					
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		
		
		
		
	}
//Metodos ******************************************************************************************************
	
	
	
	private void insertarTicketEnBaseDeDatos(String codigo, int cantidad, double total, String fecha) 
	{
        try 
        {
        	
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	

	
	
	

	 private boolean codigoExisteEnBaseDeDatos(String codigo) 
	 {
	        try 
	        {
	           boolean valor = false;
	           
	           ConexionBD conexion=new ConexionBD();
			   BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
			   
	           valor =  bd.existe("tickets", "codigo", codigo) ;
	        	
	           System.out.println("existe en la base de Tickets : " + valor);
	           
	            
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	            // Puedes agregar mensajes o lógica de manejo de errores aquí
	        }
	        return false;
	    }


	 private void GetCat() 
		{
			try 
			{
				ConexionBD conexion=new ConexionBD();
				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				
				listaCategorias.cargarCategorias( bd.consultar("categorias", "codigo,nombre,descripcion", "")  );
				listaCategorias.agregrarCategoriasAComboBox( vista.CatCb);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	 

		
	 
		public static String Fecha()
		{
				Date fecha=new Date();
				SimpleDateFormat formatodia=new SimpleDateFormat("dd-MM-yyyy");
				return formatodia.format(fecha);
		}
		
		private void actualizarTablaProductos()
		  {
		    	DefaultTableModel model = (DefaultTableModel) vista.ProductoTabla.getModel();
		    	vaciarTabla( model);
		    	
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
		            	double precioIva = producto.getPrecio() * CVentas.iva;
		            	
		            	DecimalFormat formato = new DecimalFormat("#.##");
		    			String precioFormateado = formato.format(precioIva);
		            	
		                model.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getCantidad(),precioFormateado , producto.getCategoria()});
		            }
		        }
		    }
		
		private void actualizarTablaTickets()
		  {
		    	DefaultTableModel model = (DefaultTableModel) vista.TicketTabla.getModel();
		    	vaciarTabla( model);
		    	
		        for (Ticket t : listaTickets.tickets) 
		        {
		            boolean TicketPresente = false;
		            
		            for (int i = 0; i < model.getRowCount(); i++) 
		            {
		            	Object valorCelda = model.getValueAt(i, 0);
		            	if (valorCelda != null && valorCelda.equals(t.getIdproducto() )) 
		            	{
		                    TicketPresente = true;
		                    break;
		                }
		            }
		            if (!TicketPresente)
		            {
		            	t.calcular();
		            	
		                model.addRow(new Object[]{t.getIdproducto(), t.getProducto(),t.getPrecio(), t.getCantidad(),t.getIva(), t.getTotal()});
		            }
		        }
		    }
		
		private void vaciarTabla(DefaultTableModel model) {
		    int rowCount = model.getRowCount();
		    for (int i = rowCount - 1; i >= 0; i--) {
		        model.removeRow(i);
		    }
		}


// MouseListener *********************************************************************************
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource() == vista.Lsalir)
		{
			
			CSesion ventana = new CSesion ();
					
			vista.dispose();
		}
		
		
		else if (e.getSource() == vista.ProductoTabla)
		{
			
			try 
			{
				FilaS = vista.ProductoTabla.getSelectedRow();

	    		if (FilaS != -1)
	    		{
	    			String idProducto = vista.ProductoTabla.getModel().getValueAt(FilaS, 0).toString();
		            String nombreCategoria = vista.ProductoTabla.getModel().getValueAt(FilaS, 1).toString();
		            
		            vista.TNombre.setText(vista.ProductoTabla.getModel().getValueAt(FilaS, 1).toString());
		            String upriceStr = vista.ProductoTabla.getModel().getValueAt(FilaS, 3).toString();
		            double Uprice = upriceStr.isEmpty() ? 0.0 : Double.valueOf(upriceStr);

	    		}

	            
	            
	        } catch (NumberFormatException ex)
			{
	            ex.printStackTrace();
	        } catch (Exception ex) 
			{
	            ex.printStackTrace();
	        }
		}
		else if (e.getSource() == vista.Lproductos)
		{
			new CProductosEnAlmacen();
			vista.dispose();
			
		}
		else if (e.getSource() == vista.Lcategorias)
		{
			new CCategorias ();
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



	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if (e.getSource() == vista.CatCb )
		{
			try 
	    	{
				vista.ProductoTabla.clearSelection()   ;
				FilaS = vista.ProductoTabla.getSelectedRow();
				
				
			  Object obj = vista.CatCb.getSelectedItem();
			  if (obj != null)
			  {
				  String categoria =  obj.toString() ;
				  ConexionBD conexion=new ConexionBD();
				  BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				  
				  listaProductos.vaciarLista();
				  listaProductos.cargarProductos
				  (bd.consultar("productos", "codigo,nombre,cantidad,precio,categoria,imagen" , "categoria = '" + categoria+ "'") );
				  
				  actualizarTablaProductos();
				  
				  
			  }
	          
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	        }
		}
		
	}           
	
//	private void UpdatebotonMouseClicked(java.awt.event.MouseEvent evt) {                                         
//        try {
//        	fecha = Fecha();
//            BillTxt.print();
//            String codigoTicket = "Tic" + i + "_" + fecha;
//            String nuevaFecha = Fecha();
//            
//            // Si la fecha es diferente, reiniciar el contador i
//            if (!nuevaFecha.equals(fecha)) {
//                fecha = nuevaFecha;
//                i = 1;
//            } else {
//            	// Comprobar si el código ya existe en la base de datos
//                codigoTicket = "Tic" + i + "_" + fecha;
//                while (codigoExisteEnBaseDeDatos(codigoTicket)) {
//                    i++;
//                    codigoTicket = "Tic" + i + "_" + fecha;
//                }
//                i++;
//            }
//            double totalVenta = GrdTotal;
//            // Calcular la cantidad de productos comprados
//            int cantidadProductos = 0;
//            
//            cantidadProductos += Integer.valueOf(ProdCantidad.getText());
//            // Crear un nuevo objeto Ticket
//            
//            insertarTicketEnBaseDeDatos(codigoTicket, cantidadProductos, totalVenta, fecha);
//            
//            System.out.println(codigoTicket + " , " + cantidadProductos + " , " + totalVenta + " , " + fecha);
//        }
//        catch (PrinterAbortException pae) {
//            pae.printStackTrace();
//            // Puedes agregar mensajes o lógica de manejo de errores aquí
//        }
//        catch (Exception e)
//        {
//        	e.printStackTrace();
//        }
//    }
	
	
	
	
}
