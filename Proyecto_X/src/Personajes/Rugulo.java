package Personajes;

import java.util.Random;

import Grafica.RuguloGrafica;
import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU:106878
 */
public class Rugulo extends Enemigo {

	public Rugulo(Celda pos){
		super(pos);
		
		
		this.grafico = new RuguloGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	public Rugulo(int velocidad, Celda pos) {
		super(velocidad, pos);
		
		this.grafico = new RuguloGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	@Override
	public boolean soyDios() {
		return this.modoDios;
	}

	@Override
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
