package Modelo;

import java.util.ArrayList;
import javax.swing.JComboBox;
import java.io.Serializable;

public class ListaProductos implements Serializable {
	
	public ArrayList<Producto> productos;

	public ListaProductos() {
		productos = new ArrayList<>();
	}

	public void agregarProducto(Producto producto) {
		if (buscarProductoPorId(producto.getCodigo()) == null) {
			productos.add(producto);
		}
	}

	public void eliminarProductoPorId(String id) {
		Producto producto = buscarProductoPorId(id);
		if (producto != null) {
			productos.remove(producto);
		}
	}

	public String toLinea() {
		String resultado = "";
		for (Producto producto : productos) {
			resultado += producto.toString() + "\n";
		}
		return resultado;
	}

	public Producto buscarProductoPorId(String id) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(id)) {
				return producto;
			}
		}
		return null;
	}
	public ArrayList <Producto> buscarProductosPorCategoria(String categoria) {
		
		ArrayList <Producto> productosMod = new ArrayList <Producto> ();
		
		for (Producto producto : productos ) 
		{
			boolean sepuede = true;
			try 
			{
				System.out.println(  producto.getCategoria().equals(categoria ) );
			}
			catch (NullPointerException e)
			{
				sepuede = false;
			}
			
			
			if (   sepuede &&     producto.getCategoria().equals(categoria ))
			{
				productosMod.add(producto);
			}
		}
		
		if (productos.size() > 0)
		{
			return productosMod;
		}
		else return null;
	}

	public String buscarCategoria(String id) {
		Producto producto = buscarProductoPorId(id);
		if (producto != null) {
			return producto.getNombre();
		}
		return null;
	}

	public void cargarProductos(ArrayList<String[]> productosString)
	{
	    for (String[] datos : productosString) {
	        try 
	        {
	            String idProducto = datos[0]; 
	            String nombreProducto = datos[1];
	            int cantidadProducto = Integer.valueOf(datos[2]);
	            double precioProducto = Double.valueOf(datos[3]);
	            String categoriaProducto = datos[4];
	            
	            Producto producto; 
	            if (datos.length == 6) //Con imagen
	            {
	            	String imagen = datos[5];
		            producto = new Producto(idProducto, nombreProducto, cantidadProducto, precioProducto, categoriaProducto, imagen);
		            
	            }
	            else //sin imagen
	            {
		            producto = new Producto(idProducto, nombreProducto, cantidadProducto, precioProducto, categoriaProducto);
	            }
	            
	            this.agregarProducto(producto);
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.err.println("Array incompleto, saltando...");
	        }
	    }
	}

//	public DefaultListModel<Producto> generarModeloProductos() {
//		DefaultListModel<Producto> modelo = new DefaultListModel<>();
//		for (Producto producto : productos) {
//			modelo.addElement(producto);
//		}
//		return modelo;
//	}
	
	public ArrayList<Producto> getProductos() {
        return productos;
    }
	
	public void vaciarLista() {
	    productos.clear();
	}
	
	
}
