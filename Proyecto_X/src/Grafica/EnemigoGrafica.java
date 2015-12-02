package Grafica;

/**
 * Clase correspondiente a la implementación de la parte gráfica de la clase Enemigo. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public abstract class EnemigoGrafica extends PersonajeGrafica{
	/**
	 * Crea un constructor con tres parámetros
	 * @param velocidad representa la velocidad del PersonajeGrafica.
	 * @param x representa la coordenada x de la posición en la que se encuentra.
	 * @param y representa la coordenada y de la posición en la que se encuentra.
	 */
	protected EnemigoGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);

	}

}
