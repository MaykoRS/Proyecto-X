package Personajes;

import Grafica.SiriusGrafica;
import Mapa.Celda;

/**
 * @author Rodríguez Samana Mayko , Alumno de Universidad Nacional del Sur, LU 109130
 * @author Escudero Johanna Valeria, Alumna de Universidad Nacional del Sur, LU 105868
 * @author Reyes Gastón Federico, Alumno de Universidad Nacional del Sur, LU: 106878
 */
public class Sirius extends Enemigo {

	public Sirius(Celda pos){
		super(pos);
		
		this.grafico = new SiriusGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
	}
	
	public Sirius(int velocidad, Celda pos) {
		super(velocidad, pos);
		
		this.grafico = new SiriusGrafica(this.velocidad, this.posicion.getX(), this.posicion.getY());
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
