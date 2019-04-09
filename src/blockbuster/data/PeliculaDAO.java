package blockbuster.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blockbuster.model.Pelicula;

public class PeliculaDAO {
		
	/**
	 * Guarda una pelicula en la base de datos
	 * @param pelicula pelicula que será guardada
	 */
	public void crearPelicula(Pelicula pelicula) {
		
		// Construye la cadena SQL de inserción
        String sql = "INSERT INTO pelicula(titulo, anio) VALUES(?,?)";
        
        try {
        	// Obtiene la conexion a la base de datos
        	Connection conexion = Conexion.obtenerConexion();
            
        	// Crea la sentencia
        	PreparedStatement statement = conexion.prepareStatement(sql);
        	
        	// Agrega los parámetros de la sentencia
            statement.setString(1, pelicula.getTitulo());
            statement.setDouble(2, pelicula.getAnio());
            
            // Ejecuta la sentencia
            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }		
	}

	/**
	 * Obtiene todas las peliculas de la base de datos
	 * @return lista de peliculas
	 */
	public ArrayList<Pelicula> obtenerPeliculas() {
		
		// Construye la sentencia SQL
        String sql = "SELECT id, titulo, anio FROM pelicula order by anio ASC";
        
        // Crea la lista de peliculas
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        
        try {
        	// Obtiene la conexión a la base de datos
        	Connection conexion = Conexion.obtenerConexion();
        
        	// Crea la sentencia usando la coneion    	
            Statement sentencia  = conexion.createStatement();
             
            // Ejecuta la sentencia SQL 
            ResultSet resultado = sentencia.executeQuery(sql);
            
            // Recorre los registros obtenidos
            while (resultado.next()) {
            	
            	// Crea el objeto del modelo
            	Pelicula pelicula = new Pelicula();
            	pelicula.setId(resultado.getInt("id"));
            	pelicula.setTitulo(resultado.getString("titulo"));
            	pelicula.setAnio(resultado.getInt("anio"));
            	
            	// Agrega el objeto a la lista
            	peliculas.add(pelicula);            	
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        // Retorna la lista
        return peliculas;
	}	
}
