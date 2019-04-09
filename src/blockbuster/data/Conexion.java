package blockbuster.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

	private static String url;
	
	/**
	 * Obtiene una conexion a la base de datos
	 * @return conexión a la base de datos
	 */
	public static Connection obtenerConexion() {

		try {
			// Crea el objeto de configuración
			Properties propiedades = new Properties();
			
			// Abre el archivo de configuración
			propiedades.load(new FileInputStream("blockbuster.properties"));
			
			// Obtiene la url de la base de datos del archivo de configuración
			url = propiedades.getProperty("urlbasedatos");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
        // SQLite connection string
        Connection conn = null;
        try {
        	// Ejecuta la conexion a la base de datos
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Retorna la conexión a la base de datos
        return conn;
    }	
	
}
