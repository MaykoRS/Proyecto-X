package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase correspondiente a la implementaci�n de la parte gr�fica del enemigo Altair.
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class AltairGrafica extends EnemigoGrafica {

	/**
	 * Crea un constructor con tres par�metros
	 * @param velocidad representa la velocidad del PersonajeGrafica
	 * @param x  representa la coordenada x de su posici�n
	 * @param y  representa la coordenada y de su posici�n
	 */
	public AltairGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Bomberman/Altair_up.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Bomberman/Altair_down.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Bomberman/Altair_left.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Bomberman/Altair_right.gif"));
	}
}
