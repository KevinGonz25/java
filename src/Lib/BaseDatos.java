package Lib;

import java.sql.*;
import java.util.ArrayList;


public class BaseDatos {

	

	private Connection conexion;

	public BaseDatos(Connection conexion) {
		this.conexion = conexion;
		}
	
	
	
//	ConexionBD conexion=new ConexionBD();
//	BaseDatos bd=new BaseDatos(conexion.conectarUCanAccess("BaseDatos.accdb"));

	public void insertar(String tabla, String campos, String[] valores)
	{
		String sql = "INSERT INTO " + tabla + " (";
		sql = sql + campos + " ";
		sql = sql.substring(0, sql.length() - 1) + ") VALUES (";
		
		for (int i = 0; i < valores.length; i++) 
		{
			if (i < (valores.length - 1))
				sql += "\"" + valores[i] + "\"" + ",";
			else
				sql += "\"" + valores[i] + "\")";
		}
		sql = sql.substring(0, sql.length() - 1) + ")";
		System.out.println(sql);
		
		try
		{
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Registro insertado correctamente.");
		} 
		catch (SQLException e)
		{
			System.err.println("Error al insertar el registro: " + e.getMessage());
		}
	}

	public void modificar(String tabla, String campocondicion, String valorCampo, String campo, String[] valorActualizar) 
	{
	    String sql = "UPDATE " + tabla + " SET ";
	    String[] listaCampos = campo.split(",");

	    for (int i = 0; i < valorActualizar.length; i++) 
	    {
	        // Agregar el valor del campo a actualizar y su valor correspondiente
	        sql += listaCampos[i] + "= ?";
	        if (i != valorActualizar.length - 1) 
	        {
	            sql += ", ";
	        }
	    }

	    // Agregar la condición WHERE
	    sql += " WHERE " + campocondicion + " = ?";

	    try
	    {
	        PreparedStatement ps = conexion.prepareStatement(sql);

	        // Establecer los valores de los campos a actualizar
	        for (int i = 0; i < valorActualizar.length; i++) 
	        {
	            ps.setString(i + 1, valorActualizar[i]); // El índice comienza en 1 en PreparedStatement
	        }

	        // Establecer el valor de la condición
	        ps.setString(valorActualizar.length + 1, valorCampo);

	        // Ejecutar la actualización
	        int filasActualizadas = ps.executeUpdate();
	        System.out.println(filasActualizadas + " registro(s) actualizado(s) correctamente.");
	    } 
	    catch (SQLException e) 
	    {
	        System.err.println("Error al actualizar el registro: " + e.getMessage());
	    }
	}
	
	
	
	public void eliminar(String tabla, String campo, String valor, String condicion) {
		String sql = "DELETE FROM " + tabla + " WHERE " + campo + " = ? " + condicion;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			pstmt.setString(1, valor);
			int resultado = pstmt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No se encontraron registros para eliminar.");
			} else {
				System.out.println("Registros eliminados correctamente: " + resultado);
			}
		} catch (SQLException e) {
			System.err.println("Error al eliminar los registros: " + e.getMessage());
		}
	}

	
	
	

	public ArrayList<String[]> consultar(String tabla, String campos, String condicion)
	{
		ArrayList<String[]> resultados = new ArrayList<String[]>();
		String sql = "SELECT " + campos + " FROM " + tabla;
		if (condicion != null && !condicion.isEmpty()) {
			sql += " WHERE " + condicion;
		}
		try
		{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumnas = rsmd.getColumnCount();
			while (rs.next()) 
			{
				String[] fila = new String[numColumnas];
				for (int i = 1; i <= numColumnas; i++) 
				{
					fila[i-1] = rs.getString(i);
				}
				resultados.add(fila);
			}
		}
		catch (SQLException e) 
		{
			System.err.println("Error al consultar los registros: " + e.getMessage());
		}
		return resultados;
	}

	public boolean existe(String tabla, String campo,String valor) {
		boolean enc=false;
		String sql = "SELECT * FROM " + tabla;
		sql += " WHERE " + campo +" = "+valor;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			enc= rs.next();
		} catch (SQLException e) {
			System.err.println("Error al consultar los registros: " + e.getMessage());
		}
		return enc;
	}
	

	public void modificar(String tabla, String campocondicion,String valorCampo,String campo, String valorActualizar) 
	{
		String sql = "UPDATE " + tabla + " SET " + campo + "= \""+valorActualizar+
				"\" WHERE "+ campocondicion+" = \""+valorCampo+"\"";
		try 
		{
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Registro(s) actualizado(s) correctamente.");
		} 
		catch (SQLException e) 
		{
			System.err.println("Error al actualizar el registro: " + e.getMessage());
		}
	}
	
	
	
}
