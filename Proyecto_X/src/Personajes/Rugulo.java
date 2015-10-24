package Personajes;

import Grafica.RuguloGrafica;
import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
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
		// TODO Auto-generated method stub
		
	}

}
