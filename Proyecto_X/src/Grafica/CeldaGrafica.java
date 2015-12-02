package Grafica;

import java.awt.Point;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Bomba;
import PowerUps.PowerUp;
/**
 *  Clase correspondiente a la implementación de la parte gráfica de la Celda. 
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *
 */
public class CeldaGrafica 
{
	protected final int width = 32;
	protected final int height = 32;
	protected JLabel grafico;
	protected PowerUPGrafica graficoP;
	protected Icon image,image2;
	protected Point pos;
	protected Bomba b;

	/**
	 * Crea un constructor con dos parámetros
	 * @param x corresponde a la coordenada x de su posición.
	 * @param y corresponde a la coordenada y de su posición.
	 */
	public CeldaGrafica(int x, int y)
	{
		pos = new Point(x * width, y * height);
		this.image = new ImageIcon(this.getClass().getResource("/Bomberman/celdaTransitable.png"));
	    b=null;
	}
	/**
	 * Consulta que retorna el atributo grafico
	 * @return grafico 
	 */
	public JLabel getGrafico(){
		if (b==null)
		{	if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		else {
			grafico = new JLabel(image2);	
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		}
			
			
		return this.grafico;
	}
	/**
	 * Método encargado de agregar una bomba a la celda.
	 * @param b  Bomba que recibe por parametro.
	 */
	public void agregarBomba(Bomba b) 
	{
	    this.b=b;
	    grafico.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/Bomba.png")));
		
		
	}
 
	 
	/**
	 * Comando que setea el atributo grafico	
	 * @param j JLabel
	 */
	public void setImagen(JLabel j)
	{
		grafico=j;
	}

	/**
	 * Comando encargado de setear el PowerUp a la celda
	 * @param p PowerUp
	 */
	public void agregarPowerUP(PowerUp p)
	{
		grafico.setIcon(p.getIcon());
	}
	
	/**
	 * Comando que setea el valor del grafico
	 */
	public void setGrafico() 
	{
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/celdaTransitable.png")));
		
		
	}

	/**
	 * Comando encargado de setear la imagen de la explosión.
	 */
	public void setExplosion() 
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Bomberman/Explosion.gif")));
		
	}

	
	
	

}
