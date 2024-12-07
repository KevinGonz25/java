package Lib;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Modelo.ListaTickets;
import Modelo.Ticket;

public class CreadorTicket {

	ListaTickets lista;
	
	public CreadorTicket ()
	{
		lista = new ListaTickets();
	}
	
	public CreadorTicket (ListaTickets t)
	{
		lista = t;
	}
	
	String id ;
	String fecha;
	String hora;
	
	
	public String imprimir ()
	{
		
		if (lista.tickets.size() > 0)
		{
			String texto = "";
			
			texto += "Tienda : Smash " + "\n \n";
		    texto += "Idticket: " + lista.tickets.get(0).getIdticket() + "\nFecha: " + lista.tickets.get(0).getFecha() + " Hora: " + lista.tickets.get(0).getHora();
            texto += "\n \n";
		    
		    // Encabezado de las columnas
		    texto += String.format("%-5s %-20s %-10s %-10s %-10s %-10s\n", "ID", "PRODUCTO", "PRECIO", "CANTIDAD", "IVA", "TOTAL");

		    for (Ticket t : lista.tickets) {
		        // Datos de cada ticket
		        texto += String.format("%-5s %-20s %-10s %-10s %-10s %-10s\n",
		                t.getIdproducto(), t.getProducto(), t.getPrecio(), t.getCantidad(), t.getIva(), t.getTotal());
		    }

		    texto += "\n";
		    texto += "Total a pagar: $" + lista.calcularTotal();

		    return texto;

		}
		else
		{
			System.out.println("Esta vacio");
			return "";
		}
	}
	
	
	public  void escribirArchivo( String nombreArchivo) 
	{
        try 
        {
            FileWriter writer = new FileWriter(nombreArchivo, false); // El segundo parámetro indica que no se debe agregar contenido al final del archivo
            writer.write( this.imprimir()  );
            writer.close();
            System.out.println("Se ha reemplazado el contenido del archivo '" + nombreArchivo + "' exitosamente.");
        } 
        catch (IOException e) 
        {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
	
	
	

}





