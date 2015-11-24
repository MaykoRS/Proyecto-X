package Personajes;

import javax.swing.JLabel;

import Grafica.*;
import Mapa.*;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public abstract class Personaje {
	
	protected int velocidad;
	protected Celda posicion;
	protected boolean vive;
	protected boolean modoDios;
	
	protected PersonajeGrafica grafico;
	
	/**
	 * Crea constructor con 2 par�metros.
	 * @param velocidad Indica la velocidad de Bomberman.
	 * @param pos Indica la posicion de la celda.
	 */
	protected Personaje(int velocidad, Celda pos) {
		this.posicion = pos;
		this.velocidad = velocidad;	
		this.grafico = null;
		this.modoDios = false;
		this.vive=true;
	}
	
	/**
	 * Crea constructor con un par�metro.
	 * @param pos Indica la posicion de la celda.
	 */
	protected Personaje(Celda pos) {
		this.posicion = pos;
		this.grafico = null;
		this.modoDios = false;
	}
	
	public Celda getPosicion(){
		return this.posicion;
	}
	
	public boolean getVive(){
		return this.vive;
	} 
	
	/**
	 * Establece la nueva posici�n del personaje.
	 * @param pos Posic�n nueva a establecer.
	 */
	public void setPosicion(Celda pos){
		this.posicion = pos;
	}
	
	/**
	 * Mueve a los personaes a la direcci�n pasada por par�metro.
	 * @param dir Direcci�n a establecer.
	 */
	protected void mover(int dir){
		Celda next = this.posicion.getVecina(dir);
		if(next != null){
			this.posicion = next;
			this.grafico.mover(dir);
		}
	}
	
	/**
	 * Devuelve true si el personaje es modoDios, false en caso contrario.
	 * @return True si y s�lo si el personaje es modoDios.
	 */
	public abstract boolean soyDios();
	
	/**
	 * Muere el personaje.
	 */
	public abstract void morir();
	
	/**
	 * @return La velocidad del personaje.
	 */
	public int getVelocidad(){
		return this.velocidad;
	}
	
	/**
	 * @return JLabel del personaje.
	 */
	public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}

}
