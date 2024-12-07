package Modelo;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
	
	public String codigo;
	public String nombre;
	public int cantidad;
	public double precio;
	public String categoria;
	public String imagen;
	
	public Producto(String codigo, String insumo, int cantidad, double unidad, String categoria) {
		super();
		this.codigo = codigo;
		this.nombre = insumo;
		this.cantidad = cantidad;
		this.precio = unidad;
		this.categoria = categoria;
	}
	public Producto(String codigo, String insumo, int cantidad, double unidad, String categoria, String imagen) {
		super();
		this.codigo = codigo;
		this.nombre = insumo;
		this.cantidad = cantidad;
		this.precio = unidad;
		this.categoria = categoria;
		this.setImagen(imagen);
	}
	
	public Producto() {
		super();
		this.codigo = null;
		this.nombre = null;
		this.cantidad = 0;
		this.precio = 0.0;
		this.categoria = null;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = Integer.valueOf(cantidad)  ;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setPrecio(String precio) {
		this.precio =  Double.valueOf(precio);
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDesplegar()
	{
		String cadena=this.getCodigo()+"\t\t"+this.getNombre()+"\t\t"+this.getCantidad()+"\t\t"+this.getPrecio()+"\t\t"+this.getCategoria();
		return cadena;
	}
	
	@Override
	public String toString() {
		return   this.getCodigo() + "," +  this.getNombre() + "," + this.getCantidad() + "," +
	             this.getPrecio() + "," + this.getCategoria() + "," + this.getImagen();
	}
	
	public String[]  toArray() 
	{
		String[] datos = {this.getCodigo(), this.getNombre(), String.valueOf( this.getCantidad() ), 
				          String.valueOf(this.getPrecio()) , this.getCategoria() , this.getImagen()           };
		return datos;
		
	}
	
	
}
