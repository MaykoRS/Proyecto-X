package Personajes;

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

}
