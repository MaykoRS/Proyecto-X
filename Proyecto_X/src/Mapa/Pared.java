package Mapa;

import javax.swing.JLabel;

import Grafica.ParedGrafica;
import Personajes.*;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public abstract class Pared {
	
	protected Celda posicion;
	protected int Puntaje;
	
	protected ParedGrafica grafico;
	
	protected Pared(Celda pos){
		this.posicion = pos;
		this.grafico = null;
	}
	
	public abstract boolean destruir();
	
	/**
	 * Devuelve la posici�n de la pared.
	 * @return Posici�n de la pared a retornar.
	 */
	public Celda getPosicion(){
		return this.posicion;
	}
	
	/**
	 * Establece la posici�n de la pared.
	 * @param c Posici�n a establecer.
	 */
	public void setPosicion(Celda c){
		this.posicion = c;
	}
	
	
	protected abstract void recibirBomberman(Bomberman b, int dir);
	
	protected abstract void recibirEnemigo(Enemigo e, int dir);
	
	/**
	 * Devuelve el JLabel de la pared.
	 * @return JLabel a retornar.
	 */
	public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
		
	public int GetPuntaje()
	{
		return Puntaje;
	}
}
