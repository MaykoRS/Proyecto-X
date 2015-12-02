package Grafica;

import javax.swing.ImageIcon;

/**
 *  Clase correspondiente a la implementación de la parte gráfica del Bomberman. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *
 */
public class BombermanGrafica extends PersonajeGrafica {

	public BombermanGrafica(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Bomberman/Bomberman_up.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Bomberman/Bomberman_down.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Bomberman/Bomberman_left.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Bomberman/Bomberman_right.gif"));
		this.image[4] = new ImageIcon(this.getClass().getResource("/Bomberman/Bomberman_death.png"));
	}
	
}
