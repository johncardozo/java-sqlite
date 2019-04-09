package blockbuster.ui;

import java.util.ArrayList;
import java.util.Scanner;

import blockbuster.business.PeliculaBO;
import blockbuster.model.Pelicula;

public class Principal {

	private final static int CREAR_PELICULA = 1;
	private final static int LISTAR_PELICULAS = 2;
	private final static int SALIR = 3;
	
	public static void main(String[] args) {

		// Crea el objeto de negocio
		PeliculaBO bo = new PeliculaBO();
		
		int opcion = 0;
		while(opcion != SALIR) {
			
			// Muestra el menu al usuario
			opcion = menu();
			
			// Verifica la opcion digitada por el usuario
			switch (opcion) {
			case CREAR_PELICULA:
				
				// Crea el objeto pelicula
				Pelicula nuevaPelicula = new Pelicula();
				// Guarda los datos el objeto
				nuevaPelicula.setTitulo(pedirString("Digite el titulo de la pelicula"));
				nuevaPelicula.setAnio(pedirEntero("Digite el año de la pelicula"));
				
				// Guarda la pelicula en el sistema
				bo.crearPelicula(nuevaPelicula);				
				
				break;
			case LISTAR_PELICULAS:
				
				// Obtiene las peliculas del sistema
				ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
				peliculas = bo.obtenerTodas();
				
				// Imprime las peliculas
				for (Pelicula pelicula: peliculas) {
					System.out.println(pelicula);
				}
				
				break;
			case SALIR:				
				System.out.print("Hasta pronto!!!");
				
				break;

			default:
				System.err.println("La opcion digitada no es valida!!!");
				break;
			}
		}
	}
	
	/**
	 * Muestra el menú 
	 * @return opción digitada por el usuario
	 */
	private static int menu() {

		// Muestra el menu en consola
		System.out.println("\n -- BLOCKBUSTER --");
		System.out.println("1. Crear pelicula");
		System.out.println("2. Listar peliculas");
		System.out.println("3. Salir");
		
		// Obtiene la opcion digitada por el usuario 
		int opcion = pedirEntero("Digite su opción... ");
		
		// Retorna la opcion digitada
		return opcion;
	}	
	
	/**
	 * Pide al usuario un valor entero por consola
	 * @param mensaje mensaje a mostrar en la consola
	 * @return valor entero digitado por el usuario
	 */
	private static int pedirEntero(String mensaje) {
		// Muestra el mensaje en consola
		System.out.println(mensaje);				 

		// Construye el objeto para almacenar el dato digitado
		Scanner in = new Scanner(System.in);
		
		// Pide el dato al usuario
		String cadena = in.nextLine();
		
		// Transforma el dato en un valor entero
		int dato = 0;
		try {
			dato = Integer.parseInt(cadena);
		} catch (NumberFormatException e) {
		}
		
		// Retorna el dato
		return dato;
	}

	/**
	 * Solicita por consola un valor de tipo String al usuario 
	 * @param mensaje mensaje a mostrar en consola
	 * @return datos digitados por el usuario
	 */
	private static String pedirString(String mensaje) {
		
		// Muestra el mensaje en consola
		System.out.println(mensaje);				 

		// Construye el objeto para obtener el dato digitado por el usuario
		Scanner in = new Scanner(System.in);

		// Obtiene la cadena digitada por el usuario
		String cadena = in.nextLine();

		// Retorna la cadena
		return cadena;			
	}

}
