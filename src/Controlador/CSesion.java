package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Lib.BaseDatos;
import Lib.ConexionBD;
import Vista.VProductosEnAlmacen;
import Vista.VSesion;
import Vista.VVentas;

public class CSesion implements ActionListener {

	
	VSesion vista;
	
	
	
	public CSesion ()
	{
		
		vista = new VSesion ();
		
		vista.Biniciar.addActionListener(this);
		vista.Blimpiar.addActionListener(this);
		
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if (e.getSource() == this.vista.Biniciar)
		{
			
			
			
			try 
			{
				ConexionBD conexion=new ConexionBD();
				BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
				
				//consultar(String tabla, String campos, String condicion)
		    	
		    	String rol   =      this.vista.CBrol.getSelectedItem().toString();
		    	String nombre=		this.vista.Tnombre.getText();
		    	String contra=		this.vista.Tcontraseña.getText() ;
		    	
		    	ArrayList <String []> usuarios =
		    	bd.consultar("usuarios", "rol,nombre,contraseña", "nombre = '" + nombre + "'");
		    	
		    	if (usuarios != null && !  usuarios.isEmpty())
		    	{
		    		boolean iniciar = false;
		    		
		    		for ( String [] ar : usuarios)
		    		{
		    			if (ar[0].compareTo(rol)==0 && ar[1].compareTo(nombre)==0 && ar[2].compareTo(contra)==0)
		    			iniciar = true;
		    		}
		    		
		    		if (iniciar)
		    		{
			    		System.out.println("Si se hayaron los datos ");
			    		
//			    		int bounds [] = new int [4];
//			    		bounds[0] = this.vista.getX();
//			    		bounds[1] = this.vista.getY();
//			    		bounds[2] = this.vista.getWidth();
//			    		bounds[3] = this.vista.getHeight();
//			    		
//			    		
//			    		
//			    				
//			    		CMenu m = new CMenu (bounds);
//			    		this.vista.dispose();

			    		new CVentas(usuarios.get(0)[0]  );
		    		}
		    	}
		    	else 
		    	{
		    		System.out.println("No se encontraron los datos ");
		    		
		    		
		    		
		    	}
		      	  
		    	
		            
		            
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    	
	            
			
		}
		else if ( e.getSource() == vista.Blimpiar)
		{
			vista.Tnombre.setText("");
			vista.Tcontraseña.setText("");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
