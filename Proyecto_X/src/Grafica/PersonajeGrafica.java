package Grafica;

import java.awt.Point;

import javax.swing.*;

import Mapa.Celda;

/**
 * Clase correspondiente a la implementaci�n de la parte gr�fica de la clase Personaje.
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 *  
 */
public abstract class PersonajeGrafica {
	protected final int width = 32;
	protected final int height = 32;
	
	protected JLabel grafico;
	protected Icon image[];
	
	protected int velocidad;
	protected Point pos;
	
	/**
	 * Crea un constructor de tres par�metros.
	 * @param velocidad entero que representa la velocidad del grafico.
	 * @param x coordenada x de la posici�n en la que se encuentra.
	 * @param y coordenada y de la posici�n en la que se encuentra.
	 */
	protected PersonajeGrafica(int velocidad, int x, int y){
		pos = new Point(x * this.width, y * this.height);
		this.velocidad = velocidad;
		
		this.image = new Icon[5];
	}
	
	/**
	 * Devuelve la velocidad.
	 * @return Velocidad a devolver.
	 */
	public int getVelocidad(){
		return this.velocidad;
	}
	
	/**
	 * Devuelve la posici�n.
	 * @return Posici�n a devolver.
	 */
	public Point getPos(){
		return this.pos;
	}
	
	/**
	 * Establece el nuevo Icono con la direcci�n pasada por par�metro.
	 * @param dir Direcci�n a establecer.
	 */
	protected void changeIcon(int dir){
		int direccion = -1;
		switch(dir){
			case Celda.UP :
				direccion = 0;
				break;	
			case Celda.DOWN :
				direccion = 1;
				break;
			case Celda.LEFT :
				direccion = 2;
				break;
			case Celda.RIGHT :
				direccion = 3;
				break;	
		}
		this.grafico.setIcon(this.image[direccion]);
	}
	
	/**
	 * Mueve al personaje a una direcci�n pasada por par�metro.
	 * @param dir Direcci�n a establecer.
	 */
	public void mover(int dir) {
		if(this.grafico != null){
			this.changeIcon(dir);
			
			switch (dir){
				case Celda.UP :
					this.grafico.setBounds(this.pos.x, this.pos.y -= this.height, width, height);
					break;
				case Celda.DOWN :
					this.grafico.setBounds(this.pos.x, this.pos.y += this.height, width, height);
					break;
				case Celda.LEFT :
					this.grafico.setBounds(this.pos.x -= this.width, this.pos.y, width, height);
					break;
				case Celda.RIGHT : 
					this.grafico.setBounds(this.pos.x += this.width, this.pos.y, width, height);
					break;
			}
		}
	}
	
	/**
	 * Devuelve el JLabel cuando muere el personaje.
	 * @return JLabel a devolver.
	 */
	public JLabel morir(){
		if(this.grafico != null){
			this.grafico.setIcon(image[4]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
	
	/**
	 * Devuelve el JLabel del personaje al inicio del juego-
	 * @return JLabel a devolver.
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[3]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
}
