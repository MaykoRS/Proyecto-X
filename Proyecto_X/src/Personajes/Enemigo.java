package Personajes;

import java.util.Random;

import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public abstract class Enemigo extends Personaje{

	protected int puntosPorMuerte;
	
	/**
	 * crea un enemigo en una celda pos ,con un puntaje establecido.
	 * @param pos celda a anadir.
	 */
	protected Enemigo(Celda pos) {
		
		super(pos);
		puntosPorMuerte=15;
	
	}
	
	
	/**
	 * @param velocidad a anadir.
	 * @param pos celda a anadir.
	 */
	protected Enemigo(int velocidad, Celda pos){
		super(velocidad,pos);
		puntosPorMuerte=20;
	}
	
	/**
	 * Mueve al enemigo con una dirección aleatoria.
	 */
	public abstract void mover();

	/**
	 * Mueve al enemigo a una dirección indicada por parámetro. Respetando si es o no modoDios.
	 * @param direccion Dirección a mover.
	 */
	public void moverAhora(int direccion){
		this.posicion.removeEnemigo(this);
		super.mover(direccion);
		this.posicion.agregarEnemigo(this);
	}
	

	/**
	 * @return puntosPorMuerte del enemigo.
	 */
	public int getPuntosPorMuerte() {
		// TODO Auto-generated method stub
		return this.puntosPorMuerte;
	}
}
