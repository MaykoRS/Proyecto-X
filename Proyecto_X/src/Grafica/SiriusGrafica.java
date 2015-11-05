package Grafica;

import javax.swing.ImageIcon;

/**
 * Clase correspondiente a la implementaci�n de la parte gr�fica del enemigo Sirius. 
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class SiriusGrafica extends EnemigoGrafica {

	public SiriusGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);

		this.image[0] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_down.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Bomberman/Sirius_right.png"));
		
	}

}
