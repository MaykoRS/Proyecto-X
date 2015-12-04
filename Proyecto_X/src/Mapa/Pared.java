package Mapa;

import javax.swing.JLabel;

import Grafica.ParedGrafica;
import Personajes.*;

	/**Clase correspondiente a la implementación del módulo Pared
	 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
	 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
	 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
	 */
/**
 * @author AD
 *
 */
public abstract class Pared {
	
	protected Celda posicion;
	protected int Puntaje;
	
	protected ParedGrafica grafico;
	
	/**
	 * Crea un constructor con un único parámetro.
	 * @param pos Celda en donde se ubica el PowerUp
	 */
	protected Pared(Celda pos){
		this.posicion = pos;
		this.grafico = null;
		this.Puntaje = 10;
	}
	
	/**
	 * Comando abstracto que destruye la pared
	 * @return
	 */
	public abstract void destruir();
	
	/**
	 * Setea el grafico de la pared.
	 */
	public abstract void setGrafico1();
	
	/**
	 * Devuelve la posición de la pared.
	 * @return Posición de la pared a retornar.
	 */
	public Celda getPosicion(){
		return this.posicion;
	}
	
	/**
	 * Establece la posición de la pared.
	 * @param c Posición a establecer.
	 */
	public void setPosicion(Celda c){
		this.posicion = c;
	}
	
	
	/**
	 * Comando encargado de recibir al Bomberman
	 * @param b Bomberman
	 * @param dir dirección en la que quiere avanzar
	 */
	protected abstract void recibirBomberman(Bomberman b, int dir);
	
	/**
	 * Comando encargado de recibir al Enemigo
	 * @param e Enemigo
	 * @param dir dirección en la que quiere avanzar
	 */
	protected abstract void recibirEnemigo(Enemigo e, int dir);
	
	/**
	 * Devuelve el JLabel de la pared.
	 * @return JLabel a retornar.
	 */
	public JLabel getGrafico(){
		return  this.grafico.getGrafico();
	}
		
	/**
	 * @return puntaje de la pared.
	 */
	public int getPuntaje()
	{
		return Puntaje;
	}
}
