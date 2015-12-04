package Grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Clase correspondiente a la implementación de la parte gráfica de la clase pared.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public abstract class PowerUPGrafica {
	protected final int width = 32;
	protected final int height = 32;
	
	protected JLabel grafico;
	protected Icon image;
	
	protected Point pos;
	
	/**
	 * Crea un constructor de dos parámetros.
	 * @param x representa la coordenada x de la posición en la que se encuentra.
	 * @param y representa la coordenada y de la posición en la que se encuentra.
	 */
	protected PowerUPGrafica(int x, int y){
		pos = new Point(x * width, y * height);
	}
	
	/**
	 * Devuelve la posicion de la pared.
	 * @return Posicion a devolver.
	 */
	public Point getPos(){
		return pos;
	}
	
	/** Devuelve el JLabel de la pared.
	 * @return JLabel a retornar.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
	
	/**
	 * Retorna el valor del atributo image
	 * @return image 
	 */
	public Icon getImage(){
		return this.image;
	}

	
	
}
