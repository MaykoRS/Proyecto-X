package Personajes;

import java.util.Random;

import Grafica.AltairGrafica;
import Mapa.Celda;

/** Implementación del módulo Altair
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Altair extends Enemigo {

	 /**
	  * Crea un constructor con un parametro
	  * @param pos posición en donde se ubica el personaje
	  */
	public Altair(Celda pos) {
		super(pos);
		this.modoDios = true;
		this.grafico = new AltairGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
		puntosPorMuerte+=5;
		
	}
	
	/**
	 * Crea un constructor con dos parametros
	 * @param velocidad corresponde al atributo velocidad.
	 * @param pos corresponde al atributo posición en donde se ubica Altair.
	 */
	public Altair(int velocidad, Celda pos){
		super(velocidad,pos);
		this.modoDios = true;
		this.grafico = new AltairGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	/**
	 * Retorna el valor de verdad del atributo modoDios
	 * @return modoDios
	 */
	public boolean soyDios() {
		return modoDios;
	}

	/**
	 * Método encargado de matar al personaje Altair
	 */
	public void morir() {
		vive = false;
		getGrafico().setIcon(null);
	}

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
}
