package Modelo;

import java.io.Serializable;

public class Categoria implements Serializable {
	
	public String codigo;
	public String nombre;
	public String descripcion;
	
	public Categoria(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return   this.getCodigo() + "," +  this.getNombre() + "," + this.getDescripcion();
	}
	
	public String[]  toArray() 
	{
		String[] datos = {this.getCodigo(), this.getNombre(), this.getDescripcion()  };
		return datos;
		
	}
	
	
	
	
	
	
	
	
	
}
