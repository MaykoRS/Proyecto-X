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
	
	protected Enemigo(Celda pos) {
		super(pos);
	
	}
	
	protected Enemigo(int velocidad, Celda pos){
		super(velocidad,pos);
	}
	
	/**
	 * Mueve al enemigo con una dirección aleatoria.
	 */
	public void mover() {
		Random r = new Random();
		
		int dir = r.nextInt(4);
		
		int direccion = -1;
		switch (dir) {
			case 0 : //Arriba
				direccion = Celda.UP;
				break;
			case 1 : //Abajo
				direccion = Celda.DOWN;
				break;
			case 2 : //Izquierda
				direccion = Celda.LEFT;
				break;
			case 3 : //Derecha
				direccion = Celda.RIGHT;
				break;
		}
		Celda destino =  this.posicion.getVecina(direccion);
		
		destino.dejarPasar(this, direccion);
			
	}

	/**
	 * Mueve al enemigo a una dirección indicada por parámetro. Respetando si es o no modoDios.
	 * @param direccion Dirección a mover.
	 */
	public void moverAhora(int direccion){
		this.posicion.removeEnemigo(this);
		super.mover(direccion);
		this.posicion.agregarEnemigo(this);
	}
	

	public int getPuntosPorMuerte() {
		// TODO Auto-generated method stub
		return this.puntosPorMuerte;
	}
}
