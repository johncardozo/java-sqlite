package netflix.business;

import java.util.ArrayList;

import netflix.data.PeliculaDAO;
import netflix.model.Pelicula;

public class PeliculaBO {

	/**
	 * Crea una pelicula en el sistema
	 * @param pelicula pelicula que será creada
	 */
	public void crearPelicula(Pelicula pelicula) {
		
		// Crea el objeto de base de datos
		PeliculaDAO dao = new PeliculaDAO();
		
		// Crea la pelicula en la base de datos
		dao.crearPelicula(pelicula);
		
	}

	/**
	 * Obtiene todas las peliculas del sistema
	 * @return lista de peliculas del sistema
	 */
	public ArrayList<Pelicula> obtenerTodas() {
		
		// Crea la lista de peliculas
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		
		// Crea el objeto de acceso a datos
		PeliculaDAO dao = new PeliculaDAO();
		
		// Obtiene las peliculas de la base de datos
		peliculas = dao.obtenerPeliculas();
		
		// Retorna la lista de peliculas
		return peliculas;
	}
	
}
