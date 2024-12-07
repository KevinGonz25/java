package Modelo;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import Lib.BaseDatos;
import Lib.ConexionBD;

public class ListaTickets implements Serializable{

	String id;
	String fecha ;
	String hora;
	
	public ArrayList<Ticket> tickets;
	
	public ListaTickets() 
	{
		tickets = new ArrayList<>();
		Fecha();
		ObtenerIdTicket();
	}
	
	public ListaTickets(String idTicket) 
	{
		tickets = new ArrayList<>();
		Fecha();
		this.id = idTicket;
	}


	public void agregarTicket(Ticket t) 
	{
		Ticket aux = buscarTicketPorIdProducto(t.getIdproducto())  ;
		if ( aux == null) 
		{
			t.setIdticket(this.id);
			t.setFecha(this.fecha);
			  obtenerHora();
//			  System.out.println("h: "+this.hora); //Quitar
			t.setHora(this.hora);
			tickets.add(t);
		}
		else 
		{
			int nuevacompra = Integer.valueOf(t.getCantidad() );
			
			int enticket = Integer.valueOf(aux.getCantidad() );
			int nuevototal = enticket + nuevacompra;
			
			aux.setCantidad(  String.valueOf( nuevototal ) );
			aux.calcular();
			
		}
	}
	
	public void eliminarTicketPorId(String id) 
	{
		Ticket t = buscarTicketPorId(id);
		if (t != null) {
			tickets.remove(t);
		}
	}
	public void eliminarTicketPorIdProducto(String id) //Usar solo en venta
	{
		Ticket t = buscarTicketPorIdProducto(id);
		if (t != null) {
			tickets.remove(t);
		}
	}

	public String toLinea() {
		String resultado = "";
		for (Ticket t : tickets) {
			resultado += t.toString() + "\n";
		}
		return resultado;
	}
	
	public Ticket buscarTicketPorIdProducto(String id)
	{
		for (Ticket t : tickets) 
		{
			if (t.getIdproducto().equals(id))
			{
				return t;
			}
		}
		return null;
	}
	
	public Ticket buscarTicketPorId(String id)
	{
		for (Ticket t : tickets) 
		{
			if (t.getIdticket().equals(id))
			{
				return t;
			}
		}
		return null;
	}
	
	
	public void cargarTickets(ArrayList<String[]> ticketsString)
	{
	    for (String[] datos : ticketsString) 
	    {
	        try 
	        {
	            String idTicket = datos[0]; 
	            String fecha = datos[1];
	            String hora = datos[2];
	            String codpro = datos[3];
	            String nompro = datos[4];
	            String precio = datos[5];
	            String cant = datos[6];
	            String iva = datos[7];
	            String total = datos[8];
	            
	            Ticket  t;
	          t = new Ticket(idTicket, fecha, hora, codpro, nompro,precio, cant, iva, total);
		            
	            
		            
	            
	           this.agregarTicket(t);
	        }
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	            System.err.println("Array incompleto, saltando...");
	        }
	    }
	}
	
	public ArrayList<Ticket> getProductos()
	{
        return tickets;
    }
	
	public void ObtenerIdTicket() {
	    try {
	        ConexionBD conexion = new ConexionBD();
	        BaseDatos bd = new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));
	        ArrayList<String[]> codigos = bd.consultar("tickets", "codigo", "");
	        
//	        System.out.println("Codigos recuperados de la base de datos:");
//	        for (String[] codigo : codigos) {
//	            System.out.println(Arrays.toString(codigo));
//	        }
	        
	        int proximoId = encontrarProximoIdDisponible(codigos);
	        String idFormateado = String.format("%02d", proximoId);

	        this.id = idFormateado;
	         // System.out.println("ID asignado: " + this.id);
	    }
	    catch (SQLException e) 
	    {
	        // Manejar la excepción adecuadamente
	        e.printStackTrace();
	    }
	}

	private int encontrarProximoIdDisponible(ArrayList<String[]> codigos)
	{
	    Set<Integer> ids = new HashSet<>();

	    // Convertir los códigos a números enteros y agregarlos al conjunto para eliminar duplicados
	    for (String[] codigo : codigos) {
	        int id = Integer.parseInt(codigo[0]);
	        ids.add(id);
	    }

	    // Convertir el conjunto nuevamente a una lista para poder ordenarla
	    List<Integer> uniqueIds = new ArrayList<>(ids);

	    // Ordenar los IDs únicos existentes
	    Collections.sort(uniqueIds);
	    
//	    System.out.println("IDs únicos existentes ordenados: \n" + uniqueIds);

	    // Encontrar el próximo número de ID disponible
	    int proximoId = 1;
	    for (int id : uniqueIds) 
	    {
	        if (id != proximoId) 
	        {
	            // Si encontramos un ID que no coincide con proximoId, hemos encontrado el próximo ID disponible
	            break;
	        }
	        proximoId++;
	    }
	   
	    return proximoId;
	}
	
	
	

	public void Fecha() {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = formatoFecha.format(fechaActual);
    }
	
	
	public void obtenerHora() {
		
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // Cambia "UTC" por la zona horaria deseada
		
        Date horaActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        this.hora = formatoHora.format(horaActual);
    }
	
	
	public double calcularTotal ()
	{
		double total = 0;
		
		for (Ticket  t : this.tickets)
		{
		   total += Double.valueOf(t.getTotal() );
		   
		}
		
		DecimalFormat formato = new DecimalFormat("#.##");
		String valorFormateado = formato.format(total);
		total = Double.valueOf(valorFormateado);
		
		return total;
		
	}
	
	
	
	public void vaciarLista ()
	{
		tickets.clear();
	}
	
	
	
	
}
