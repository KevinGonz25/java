package Lib;
import java.sql.*;

import net.ucanaccess.jdbc.UcanaccessDriver;


public class ConexionBD {
	
// Variables para la conexi�n a MySQL

	private static final String urlMySQL = "jdbc:mysql://" ;
	private static final String usuarioMySQL = "tu_usuario";
	private static final String passwordMySQL = "tu_contraseña";

// Variables para la conexi�n a Access utilizando UCanAccess
	private static final String urlAccess = "jdbc:ucanaccess://";

// Variables para la conexi�n a SQL Server Express
	private static final String urlSQLServer = "jdbc:sqlserver://";
	private static final String usuarioSQLServer = "tu_usuario";
	private static final String passwordSQLServer = "tu_contraseña";

// M�todo para conectar a SQL Server Express

	public static Connection conectarSQLServer(String[] parametros) throws SQLException {
		String cadenaconexion = urlSQLServer+parametros[0]+"\\SQLEXPRESS;databaseName="+parametros[1]+";";
		Connection conexion = DriverManager.getConnection(cadenaconexion,parametros[2], parametros[3]);
		return conexion;
	}

// M�todo para conectar a MySQL
	public static Connection conectarMySQL(String[] parametros) throws SQLException{
		String cadenaconexion = urlMySQL+parametros[0]+"/"+parametros[1];
		Connection conexion = DriverManager.getConnection(cadenaconexion,parametros[2], parametros[3]);
		return conexion;
	}

	
	
	public Connection conectarUCanAccess(String parametros) throws SQLException {
	    String cadenaconexion = urlAccess + parametros;
	    
	    try {
	        // Registrar el controlador JDBC de UCanAccess
	        UcanaccessDriver driver = new UcanaccessDriver();
	        DriverManager.registerDriver(driver);
	        
	        // Obtener la conexión
	        Connection conexion = DriverManager.getConnection(cadenaconexion, null, null);
	        return conexion;
	    } catch (SQLException e) {
	        System.err.println("Error al conectar a la base de datos de Access: " + e.getMessage());
	        throw e; // Lanzar la excepción nuevamente para que el código que llama a este método pueda manejarla
	    }
	}
	
	
	
	
	
	
	
	
	
}