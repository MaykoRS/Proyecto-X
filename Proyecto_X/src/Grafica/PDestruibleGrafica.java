package Grafica;

import javax.swing.ImageIcon;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class PDestruibleGrafica extends ParedGrafica {

	public PDestruibleGrafica(int x, int y) {
		super(x, y);
		
		this.image = new ImageIcon(this.getClass().getResource("/Bomberman/PDestruible.png"));
	}

}
