package Grafica;

import javax.swing.ImageIcon;

	/**
	 * Clase correspondiente a la implementación de la parte gráfica del enemigo Altair.
	 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
	 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
	 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
	 * 
	 */
	public class SpeedUpGrafica extends PowerUPGrafica {

		/**
		 * Crea un constructor de dos parámetros.
		 * @param x representa la coordenada x de su posición.
		 * @param y representa la coordenada y de su posición.
		 */
		public SpeedUpGrafica(int x,int y) {
			super(x,y);
			
			this.image = new ImageIcon(this.getClass().getResource("/Bomberman/SpeedUp.png"));
			
		}
	}

	
