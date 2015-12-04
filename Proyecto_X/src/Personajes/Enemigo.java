package Personajes;

import java.util.Random;

import Mapa.Celda;

/**
 * @author Rodr�guez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gast�n Federico, Alumno de Universidad Nacional del Sur, LU: 106878
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
	 * Mueve al enemigo con una direcci�n aleatoria.
	 */
	public abstract void mover();

	/**
	 * Mueve al enemigo a una direcci�n indicada por par�metro. Respetando si es o no modoDios.
	 * @param direccion Direcci�n a mover.
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
