package Grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase correspondiente a la implementación de la parte gráfica de la clase Bomba.
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 * 
 */
public class BombaGrafica {

	protected final int width = 32;
	protected final int height = 32;
	protected boolean exploto;
	protected JLabel grafico;
	protected Icon [] image;
	
	protected Point pos;
	
	public BombaGrafica(int x, int y){
		pos = new Point(x * width, y * height);
		exploto= false;
		this.image = new Icon[2];
		this.image[0] = new ImageIcon(this.getClass().getResource("/Bomberman/Bomba.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Bomberman/Explosion.gif"));
	    
	}
	
	/**
	 * Devuelve la posicion de la bomba.
	 * @return Posicion a devolver.
	 */
	public Point getPos()
	{
		return pos;
	}
	
	/**
	 * Devuelve el JLabel cuando explota la bomba.
	 * @return JLabel a devolver.
	 */
	public JLabel explotar()
	{
		if(this.grafico != null){
			this.grafico.setIcon(image[1]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		    exploto=true;  
		
		}
	
		return this.grafico;
	 
	}
	
	
		
	
	public boolean getExploto()
	{
		return exploto;
	}
	/** Devuelve el JLabel de Bomba.
	 * @return JLabel a retornar.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
}
