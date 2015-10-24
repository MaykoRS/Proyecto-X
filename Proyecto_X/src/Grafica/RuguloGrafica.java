package Grafica;

import javax.swing.ImageIcon;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class RuguloGrafica extends EnemigoGrafica {

	public RuguloGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Bomberman/Rugulo_up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Bomberman/Rugulo_down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Bomberman/Rugulo_left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Bomberman/Rugulo_right.png"));
	}

}
