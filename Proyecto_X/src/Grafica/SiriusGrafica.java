package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase correspondiente a la implementación de la parte gráfica del enemigo Sirius. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class SiriusGrafica extends EnemigoGrafica {

	/**
	 * Crea un constructor de tres parámetros.
	 * @param velocidad representa la velocidad del EnemigoGrafica.
	 * @param x representa la coordenada x de la posición en la que se encuentra.
	 * @param y representa la coordenada y de la posición en la que se encuentra.
	 */
	public SiriusGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);

		this.image[0] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_right.png"));
		
	}

}
