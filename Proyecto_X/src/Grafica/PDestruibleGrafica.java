package Grafica;

import javax.swing.ImageIcon;

/**
 * 
 * Clase correspondiente a la implementación de la parte gráfica de la clase Pared Destruible. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class PDestruibleGrafica extends ParedGrafica {
	/**
	 * Crea un constructor con dos parámetros.
	 * @param x coordenada x de la posición de la pared.
	 * @param y coordenada y de la posición de la pared.
	 */
	public PDestruibleGrafica(int x, int y) {
		super(x, y);
		
		this.image = new ImageIcon(this.getClass().getResource("/Bomberman/PDestruible.png"));
	
	
	}
	
	/**
	 * Comando encargado de setear el valor del JLabel al correspondiente después de la 
	 * destrucción de la pared --> celda transitable. 
	 */
	public void destruir() 
	{
		this.image= new ImageIcon(this.getClass().getResource("/Bomberman/celdaTransitable.png"));
	   
	}
}
