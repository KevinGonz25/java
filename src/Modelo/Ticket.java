package Modelo;

import java.text.DecimalFormat;

public class Ticket {
	
	private final double tasaIVA = 0.16;
	
private String idticket;
private String fecha,hora;
private String idproducto,producto;
private String precio,cantidad,iva,total;

public String getIdticket() {
	return idticket;
}
public void setIdticket(String idticket) {
	this.idticket = idticket;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public String getIdproducto() {
	return idproducto;
}
public void setIdproducto(String idproducto) {
	this.idproducto = idproducto;
}
public String getProducto() {
	return producto;
}
public void setProducto(String producto) {
	this.producto = producto;
}
public String getPrecio() {
	return precio;
}
public void setPrecio(String precio) {
	this.precio = precio;
}
public String getCantidad() {
	return this.cantidad;
}
public void setCantidad(String cantidad) {
	this.cantidad = cantidad;
}
public String getIva() {
	return this.iva;
}
public void setIva(String iva) {
	this.iva = iva;
}
public String getTotal() {
	return this.total;
}


public void setTotal(String total) {
	this.total = total;
}

public Ticket ()
{
	this.idticket = "";
	this.fecha    = "";
	this.hora     = "";
	this.idproducto = "";
	this.producto   = "";
	this.precio     = "";
	this.cantidad   = "";
	this.iva        = "";
	this.total      = "";
}

public Ticket (Producto pro, String cant)
{
	this.idticket = "";
	this.fecha    = "";
	this.hora     = "";
	this.idproducto = pro.getCodigo();
	this.producto   = pro.getNombre();
	this.precio     = pro.getPrecio() + "";
	this.cantidad   = cant;
	this.iva        = "";
	this.total      = "";
	
	this.calcular();
}



public Ticket(String idticket, String fecha, String hora, String idproducto, String producto, String precio,
		String cantidad, String iva, String total) {
	super();
	this.idticket = idticket;
	this.fecha = fecha;
	this.hora = hora;
	this.idproducto = idproducto;
	this.producto = producto;
	this.precio = precio;
	this.cantidad = cantidad;
	this.iva = iva;
	this.total = total;
}


public void calcular ()
{
	if (this.getPrecio()!= null && this.getCantidad() != null)
	{
		double iva =  Double.valueOf(this.getPrecio() ) * this.tasaIVA;
		
    	
    	DecimalFormat formato = new DecimalFormat("#.##");
		String valorFormateado = formato.format(iva);
		
		this.setIva(valorFormateado);
		
		double total = Double.valueOf(valorFormateado) * Integer.valueOf(this.getCantidad() );
		valorFormateado = formato.format(total);
		
		this.setTotal(valorFormateado);
		
		
	}
	
	
}

public String[] toArray() 
{
    String[] datos = {this.idticket, this.fecha, this.hora, this.idproducto, this.producto,
                      this.precio, this.cantidad, this.iva, this.total};
    return datos;
}










}
