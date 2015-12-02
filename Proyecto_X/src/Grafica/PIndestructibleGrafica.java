package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase correspondiente a la implementaci�n de la parte gr�fica de la clase pared Indestructible.
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *  
 */
public class PIndestructibleGrafica extends ParedGrafica {
	/**
	 * Crea un constructor de dos par�metros.
	 * @param x representa la coordenada x de su posici�n.
	 * @param y representa la coordenada y de su posici�n.
	 */
	public PIndestructibleGrafica(int x, int y) {
		super(x, y);
		
		this.image = new ImageIcon(this.getClass().getResource("/Bomberman/PIndestructible.png"));
	}

	

}
